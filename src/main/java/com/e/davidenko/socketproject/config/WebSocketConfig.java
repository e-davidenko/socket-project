package com.e.davidenko.socketproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * @author e-davidenko
 * @since 17.04.2025
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // Включаем простой брокер сообщений для очередей (queue) и тем (topic)
        registry.enableSimpleBroker("/queue", "/topic");
        // Префикс для сообщений приложения
        registry.setApplicationDestinationPrefixes("/app");
        // Префикс для пользовательских сообщений
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Настройка SockJS для WebSocket
        registry.addEndpoint("/ws");
    }
}
