package quiz.repository;

import org.springframework.data.repository.CrudRepository;
import quiz.controller.dto.QuizElementDTO;
import quiz.model.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
