package quiz.controller.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class ResultElementDTO {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    private List<String> answers;

    public ResultElementDTO() {
    }

    public ResultElementDTO(String firstName, String lastName, List<String> answers) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.answers = answers;
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

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
