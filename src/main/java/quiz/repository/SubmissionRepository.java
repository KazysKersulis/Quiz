package quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.model.Submission;

public interface SubmissionRepository extends JpaRepository<Submission, Integer> {
}
