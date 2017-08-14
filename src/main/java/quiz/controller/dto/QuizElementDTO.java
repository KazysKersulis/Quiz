package quiz.controller.dto;


import quiz.model.Question;

import java.util.List;

public class QuizElementDTO {

    private  Question question;
    private List<String> answers;

    public QuizElementDTO(Question question, List<String> answers) {
        this.question = question;
        this.answers = answers;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
