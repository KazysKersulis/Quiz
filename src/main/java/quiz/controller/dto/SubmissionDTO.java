package quiz.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;
import quiz.model.AnswerType;
import quiz.model.QuestionValue;

import java.util.ArrayList;
import java.util.List;

public class SubmissionDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private String answer;

    private List<AnswerValueDTO> dtos;

    public SubmissionDTO() {
    }

    public SubmissionDTO(String firstName, String lastName, List<AnswerValueDTO> dtos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dtos = dtos;
    }

    public List<String> getAnswerValues() {
        List<String> answerValues = new ArrayList<>();
        for (AnswerValueDTO answerValueDTO : dtos) {
            answerValues.add(answerValueDTO.getText());
        }
        return answerValues;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<AnswerValueDTO> getDtos() {
        return dtos;
    }

    public void setDtos(List<AnswerValueDTO> dtos) {
        this.dtos = dtos;
    }
}
