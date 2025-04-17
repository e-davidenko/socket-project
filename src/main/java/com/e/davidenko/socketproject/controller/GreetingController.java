package com.e.davidenko.socketproject.controller;

import com.e.davidenko.socketproject.dto.MessageDto;
import com.e.davidenko.socketproject.mappers.MessageMapper;
import com.e.davidenko.socketproject.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;
    private final MessageMapper mapper;

    @MessageMapping("/send")
    @SendToUser("/queue/messages")
    public String sendMessage(@Payload MessageDto message, Principal user) {
        System.out.println("user = " + user);
        //fixme временно
        var recipient = message.recipient() == null ? "user" : message.recipient();

        messagingTemplate.convertAndSendToUser(recipient, "/queue/messages", message);
        return ("Message Delivered!");
    }


}