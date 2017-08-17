package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.controller.dto.AnswerValueDTO;
import quiz.model.Answer;
import quiz.repository.AnswerRepository;

import java.util.List;

@Service
public class AnswerValueService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerValueService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswerValue(List<String> answerValues, Integer submission_id) {

        for (String answerValue : answerValues) {

            // String question, String answer, Integer submissionId
            Answer newAnswer = new Answer("asd", answerValue, submission_id);

            answerRepository.save(newAnswer);
        }
    }
}
