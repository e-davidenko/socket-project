package com.e.davidenko.socketproject.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
@Document("messages")
@Data
public class Message {

    @Id
    private String id;

    private String sender;
    private String recipient;
    private String content;
    private boolean delivered = false;
    private LocalDateTime timestamp = LocalDateTime.now();

}
