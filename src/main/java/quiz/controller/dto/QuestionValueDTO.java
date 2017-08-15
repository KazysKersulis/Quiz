package quiz.controller.dto;

public class QuestionValueDTO {

    private String text;

    public QuestionValueDTO() {
    }

    public QuestionValueDTO(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
