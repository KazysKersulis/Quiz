package quiz.repository;

import org.springframework.data.repository.CrudRepository;
import quiz.model.Answer;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

}
