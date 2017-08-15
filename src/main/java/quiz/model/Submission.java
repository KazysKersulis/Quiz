package quiz.model;

import javax.persistence.*;

@Entity
@Table(name = "submission")
public class Submission {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer id;

    private Integer submissionId;


}
