package quiz.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "submissions")
public class Submission {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer submission_Id;

    @Column(name = "FIRST_NAME")
    private String first_name;

    @Column(name = "LAST_NAME")
    private String last_name;

    @OneToMany(mappedBy = "submissionId")
    private List<Answer> answerValues;

    public Submission() {
    }

    public Submission(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Integer getSubmission_Id() {
        return submission_Id;
    }

    public void setSubmission_Id(Integer submission_Id) {
        this.submission_Id = submission_Id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Submission{" +
                "submission_Id=" + submission_Id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
