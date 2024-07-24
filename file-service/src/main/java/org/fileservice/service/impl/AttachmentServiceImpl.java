package org.fileservice.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.fileservice.model.entity.Attachment;
import org.fileservice.service.base.AttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.fileservice.repository.AttachmentRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {

    private static final Logger log = LoggerFactory.getLogger(AttachmentServiceImpl.class);

    @Value("${file.base.url}")
    private String BASE_FILE_URL;
    private final AttachmentRepository attachmentRepository;

    @Override
    public Long upload(MultipartFile file) {
        Attachment attachment = uploadAttachmentToDb(file);
        uploadToStorage(file, attachment);

        return attachment.getId();
    }

    @Override
    public List<Long> upload(List<MultipartFile> files) {
        List<Long> ids = new LinkedList<>();

        for (MultipartFile file : files) {
            Attachment attachment = uploadAttachmentToDb(file);
            uploadToStorage(file, attachment);
            ids.add(attachment.getId());
        }

        return ids;
    }

    @Override
    public void deleteById(UUID attachmentId) {

    }


    @SneakyThrows
    private void uploadToStorage(MultipartFile file, Attachment attachment) {
        Path path = Paths.get(attachment.getUrl());

        Files.write(path, file.getBytes());
    }

    private Attachment uploadAttachmentToDb(MultipartFile file) {

        log.info(BASE_FILE_URL);

        Attachment attachment = new Attachment();
        attachment.setContentType(file.getContentType());
        attachment.setName(file.getOriginalFilename());

        String fileName = UUID.randomUUID() + "." +
                getExtension(Objects.requireNonNull(file.getOriginalFilename()));
        attachment.setUrl(BASE_FILE_URL + "/pictures/" + fileName);

        attachmentRepository.save(attachment);
        return attachment;
    }

    private String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".");
        if (index > 0)
            return fileName.substring(index + 1);

        return null;
    }
}