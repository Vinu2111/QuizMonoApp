package com.vinu.Quiz_Application.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response {

    private Long questionId;   // The ID of the question answered
    private String selectedOption;  // The option chosen by the player
    public String getAnswer() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAnswer'");
    }
}
