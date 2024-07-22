package org.fileservice.repository;

import org.fileservice.model.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
}
