package com.e.davidenko.socketproject.repository;

import com.e.davidenko.socketproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
public interface MessageRepository extends MongoRepository<Message, Long> {
    List<Message> findByRecipientAndDeliveredFalse(String recipient);
}
