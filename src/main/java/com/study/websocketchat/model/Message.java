package com.study.websocketchat.model;

import lombok.*;

/**
 * packageName    : com.study.websocketchat.controller.model
 * fileName       : Message
 * author         : LEE KYUHEON
 * date           : 2024-02-04
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-02-04        LEE KYUHEON       최초 생성
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Message {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private Status status;
}
