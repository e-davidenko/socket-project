package com.e.davidenko.socketproject.dto;

import java.time.LocalDateTime;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
public record MessageDto(String id,
                         String sender,
                         String recipient,
                         String content,
                         boolean delivered,
                         LocalDateTime timestamp) {
}
