package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.controller.dto.AnswerValueDTO;
import quiz.model.Answer;
import quiz.model.Question;
import quiz.repository.AnswerRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void createAnswerValue(List<String> answerValues, Integer submission_id) {

        for (String answerValue : answerValues) {

            Answer newAnswer = new Answer(answerValue, submission_id);

            answerRepository.save(newAnswer);
        }
    }

    @Transactional(readOnly = true)
    public List<Answer> getAllAnswers() {
        List<Answer> answers = new ArrayList<Answer>();
        for (Answer answer : answerRepository.findAll()){
            answers.add(answer);
        }
        return answers;
    }

}
