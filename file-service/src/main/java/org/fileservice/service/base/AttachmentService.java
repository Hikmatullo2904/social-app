package org.fileservice.service.base;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface AttachmentService {
    Long upload(MultipartFile file);
    List<Long> upload(List<MultipartFile> files);
    void deleteById(UUID attachmentId);
}