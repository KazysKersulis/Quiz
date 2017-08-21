package quiz.controller.dto;

import quiz.model.AnswerType;

public class AnswerValueDTO {

    private String text;

    public AnswerValueDTO() {
    }

    public AnswerValueDTO(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
