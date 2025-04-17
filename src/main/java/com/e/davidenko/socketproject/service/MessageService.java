package com.e.davidenko.socketproject.service;

import com.e.davidenko.socketproject.model.Message;
import com.e.davidenko.socketproject.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;
    private final SendMessageService sendMessageService;


    public Message sendMessage(Message message, Principal user) {
        sendMessageService.sendToChat(message, user);
        return messageRepository.save(message);
    }

}
