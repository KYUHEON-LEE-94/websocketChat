package com.study.websocketchat.controller;

import com.study.websocketchat.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * packageName    : com.study.websocketchat.controller
 * fileName       : ChatController
 * author         : LEE KYUHEON
 * date           : 2024-02-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-04        LEE KYUHEON       최초 생성
 */
@Controller
public class ChatController {

    /*특정 주제(topic)으로 메시지 전송 가능*/
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    /** endpoint: /app/message
     * config에서 /app을 message Send 기본 endpoint로 설정함 **/
    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    private Message receivePublicMessage(@Payload Message message){
        return message;
    }

    @MessageMapping("/private-message")
    public Message receivePrivateMessage(@Payload Message message){

        /**각 인자를 endpoint로 만들어서 받음
         * 특정 사용자의 사적인 주제.
         * config의 /user 설정 + message의 수신자 + /private
         * /user/david/private
         * **/
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(), "/private", message);
        return message;
    }
}
