package com.e.davidenko.socketproject.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectedEvent;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class PresenceEventListener {


    @EventListener
    public void onConnect(SessionConnectedEvent sessionConnectedEvent) {
        log.info("Connected");
    }
}
