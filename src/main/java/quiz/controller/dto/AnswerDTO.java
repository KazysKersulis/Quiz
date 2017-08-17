package quiz.controller.dto;

import quiz.model.AnswerType;

import java.util.ArrayList;
import java.util.List;

public class AnswerDTO {

    private int questionId;
    private List<AnswerValueDTO> dtos;

    public List<String> getAnswerValues() {
        List<String> answerValues = new ArrayList<>();
        for (AnswerValueDTO answerValueDTO : dtos) {
            answerValues.add(answerValueDTO.getText());
        }
        return answerValues;
    }

    public AnswerDTO() {
    }

    public AnswerDTO(int questionId, List<AnswerValueDTO> dtos) {
        this.questionId = questionId;
        this.dtos = dtos;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public List<AnswerValueDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<AnswerValueDTO> dtos) {
        this.dtos = dtos;
    }
}
