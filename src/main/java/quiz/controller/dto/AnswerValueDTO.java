package quiz.controller.dto;

import quiz.model.AnswerType;

public class AnswerValueDTO {

//    private AnswerType type;

    private String text;

    public AnswerValueDTO() {
    }

    public AnswerValueDTO(String text) {
        this.text = text;
//        this.type = type;
    }

    public String getText() {
        return text;
    }

//    public AnswerType getType() {
//        return type;
//    }
}
