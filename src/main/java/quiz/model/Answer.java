package quiz.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Table
@Entity(name = "ANSWERS")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "ANSWER")
    private String answer;

    @Column(name = "SUBMISSION_ID")
    private Integer submissionId;

    public Answer() {
    }

    public Answer(String answer, Integer submissionId) {
        this.answer = answer;
        this.submissionId = submissionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

