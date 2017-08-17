package quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.model.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
