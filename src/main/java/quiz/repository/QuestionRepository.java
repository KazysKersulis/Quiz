package quiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import quiz.controller.dto.QuizElementDTO;
import quiz.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
