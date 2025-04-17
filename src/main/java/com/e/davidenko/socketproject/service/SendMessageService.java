package com.e.davidenko.socketproject.service;

import com.e.davidenko.socketproject.model.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
@Service
@RequiredArgsConstructor
public class SendMessageService {

    private final SimpMessagingTemplate messagingTemplate;

    public void sendToChat(Message message, Principal user) {
        messagingTemplate.convertAndSendToUser(user.getName(), "/queue/messages", message);
    }
}
