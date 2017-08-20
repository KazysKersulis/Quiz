package quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "questions_values")
public class QuestionValue {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "QUESTION_ID")
    private Integer questionID;

    public QuestionValue(String text, Integer questionID) {
        this.text = text;
        this.questionID = questionID;
    }

    public QuestionValue(String text) {
        this.text = text;
    }

    public QuestionValue() {
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public int getQuestionID() {
        return questionID;
    }

    public boolean isTextNull() {
        return (text.isEmpty());
    }
}
