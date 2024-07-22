package org.fileservice.controller;

import lombok.RequiredArgsConstructor;
import org.fileservice.service.base.AttachmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/attachment")
public class AttachmentController {
    private static final Logger log = LoggerFactory.getLogger(AttachmentController.class);
    private final AttachmentService attachmentService;

    @PostMapping( consumes = "multipart/form-data", produces = "application/json")
    public Long uploadFile(@RequestPart("file") MultipartFile file) {
        log.info("Inside uploadFile");
        return attachmentService.upload(file);
    }

    @PostMapping("/list")
    public List<Long> uploadFiles(@RequestBody List<MultipartFile> files) {
        return attachmentService.upload(files);
    }

    @DeleteMapping("/{attachmentId}")
    public void deleteFile(@PathVariable("attachmentId") UUID attachmentId) {
        attachmentService.deleteById(attachmentId);
    }
}