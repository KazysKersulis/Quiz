package quiz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWER")
public class Answer {

    @Id
    private int id;

    @Column(name = "ANSWER")
    public String answerText;

    @Column(name = "QUESTION_TYPE")
    private int questionId;

    public Answer() {
    }

    public Answer(String answerText, int questionId) {
        this.answerText = answerText;
        this.questionId = questionId;
    }

    public int getId() {
        return id;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public int getAnswerTypeId() {
        return questionId;
    }

    public void setType(int typeId) {
        this.questionId = typeId;
    }

}
