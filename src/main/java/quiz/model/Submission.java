package quiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "submissions")
public class Submission {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer submissionId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @OneToMany(mappedBy = "submissionId")
    private List<Answer> answerValues;

    public Submission() {
    }

    public Submission(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Submission(String firstName, String lastName, List<Answer> answerValues) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.answerValues = answerValues;
    }

    public Integer getSubmissionId() {
        return submissionId;
    }

    public void setSubmissionId(Integer submissionId) {
        this.submissionId = submissionId;
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

    public List<Answer> getAnswerValues() {
        return answerValues;
    }

    public void setAnswerValues(List<Answer> answerValues) {
        this.answerValues = answerValues;
    }
}
