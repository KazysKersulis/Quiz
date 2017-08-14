package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.model.Answer;
import quiz.repository.AnswerRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerService implements Serializable {

    private AnswerRepository answerRepository;

    @Autowired
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Transactional(readOnly = true)
    public List<Answer> getAllAnswers() {
        List<Answer> answers = new ArrayList<Answer>();
        for (Answer answer : answerRepository.findAll()){
            answers.add(answer);
        }
        return answers;
    }

    public void save(Answer answer) {
        answerRepository.save(answer);
    }
}
