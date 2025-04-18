package com.e.davidenko.socketproject.dto;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
public record MessageStatus(
        Long messageId,
        Boolean delivered,
        String message
) {

}
