package com.e.davidenko.socketproject.controller;

import com.e.davidenko.socketproject.dto.MessageDto;
import com.e.davidenko.socketproject.dto.MessageStatus;
import com.e.davidenko.socketproject.mappers.MessageMapper;
import com.e.davidenko.socketproject.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

import static com.e.davidenko.socketproject.model.WebSocketConstants.MESSAGES_NOTIFICATION_PATH;
import static com.e.davidenko.socketproject.model.WebSocketConstants.MESSAGES_PATH;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageMapper mapper;

    @MessageMapping("/send")
    @SendToUser(MESSAGES_NOTIFICATION_PATH)
    public MessageStatus sendMessage(@Payload MessageDto message, Principal user) {
        System.out.println("user = " + user);
        //fixme временно
        var recipient = message.recipient() == null ? "user" : message.recipient();

        messagingTemplate.convertAndSendToUser(recipient, MESSAGES_PATH, message);
        return new MessageStatus(1L, true, message.content());
    }


}