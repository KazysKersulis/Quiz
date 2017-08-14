package quiz.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    private int id;

    @Column(name = "QUESTION")
    private String questionText;

    @Column(name = "TYPE")
    private String type;

    public Question() {
    }

    public Question(String questionText, String type) {
        this.questionText = questionText;
        this.type = type;
    }

    @OneToMany(mappedBy = "questionId")
    List<Answer> answer = new ArrayList<Answer>();

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Answer> getAnswers() {
        return answer;
    }

    public void setAnswers(List<Answer> answer) {
        this.answer = answer;
    }

}
