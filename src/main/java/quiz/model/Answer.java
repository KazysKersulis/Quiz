package quiz.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Table
@Entity(name = "ANSWERS")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "QUESTION")
    private String question;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "SUBMISSION_ID")
    private Integer submissionId;

    public Answer() {
    }

    public Answer(String question, String answer, Integer submissionId) {
        this.question = question;
        this.answer = answer;
        this.submissionId = submissionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
    }
}

