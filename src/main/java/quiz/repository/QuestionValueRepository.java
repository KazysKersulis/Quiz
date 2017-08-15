package quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import quiz.model.QuestionValue;

public interface QuestionValueRepository extends JpaRepository<QuestionValue, Integer> {
}
