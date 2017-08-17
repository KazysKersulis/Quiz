package quiz.controller.dto;

import quiz.model.AnswerType;

import java.util.ArrayList;
import java.util.List;

public class QuestionDTO {

    private String text;
    private AnswerType type;
    private List<QuestionValueDTO> dtos;

    public QuestionDTO() {
    }

    public QuestionDTO(String text, AnswerType type, List<QuestionValueDTO> dtos) {
        this.text = text;
        this.type = type;
        this.dtos = dtos;
    }

    public String getText() {
        return text;
    }

    public AnswerType getType() {
        return type;
    }

    public List<QuestionValueDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<QuestionValueDTO> dtos) {
        this.dtos = dtos;
    }

    public List<String> getQuestionValues() {
        List<String> questionValues = new ArrayList<>();
        for (QuestionValueDTO questionValueDTO : dtos) {
            questionValues.add(questionValueDTO.getText());
        }
        return questionValues;
    }
}
