package com.e.davidenko.socketproject.dto;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
public record MessageDto(Long id, String content, Boolean isOwner, Long senderId) {
}
