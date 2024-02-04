package com.study.websocketchat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * packageName    : com.study.websocketchat.config
 * fileName       : WebSocketConfig
 * author         : LEE KYUHEON
 * date           : 2024-02-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-04        LEE KYUHEON       최초 생성
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //메세지를 보낼때 사용할 prefix
        registry.setApplicationDestinationPrefixes("/app");
        //브로커가 감시하는 대상 토픽
        registry.enableSimpleBroker("/chatroom", "/user");
        //개별 사용자에게 메시지를 보낼 때 사용되는 prefix
        registry.setUserDestinationPrefix("/user");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*") //모두 허용
                .withSockJS();
    }
}
