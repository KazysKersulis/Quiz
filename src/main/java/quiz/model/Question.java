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

    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE")
    private AnswerType type;

    @OneToMany(mappedBy = "questionID")
    private List<QuestionValue> questionValues;

    public Question() {
    }

    public Question(String questionText, AnswerType type) {
        this.questionText = questionText;
        this.type = type;
    }

    public Question(String questionText, AnswerType type, List<QuestionValue> questionValues) {
        this.questionText  = questionText;
        this.type = type;
        this.questionValues = questionValues;
    }

    public int getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public AnswerType getType() {
        return type;
    }

    public List<QuestionValue> getQuestionValues() {
        return questionValues;
    }
}
