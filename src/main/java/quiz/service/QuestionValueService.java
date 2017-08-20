package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import quiz.model.QuestionValue;
import quiz.repository.QuestionValueRepository;

import java.util.List;

@Component
public class QuestionValueService {

    private QuestionValueRepository questionValueRepository;

    @Autowired
    public QuestionValueService(QuestionValueRepository questionValueRepository) {
        this.questionValueRepository = questionValueRepository;
    }

    @Transactional
    public void createQuestionValue(List<String> answerValues, Integer questionID) {
        for (String answerValue : answerValues) {
            QuestionValue questionValue = new QuestionValue(answerValue, questionID);
            if (!questionValue.isTextNull()) {
                questionValueRepository.save(questionValue);
            } else {
                System.out.println("Text was null");
            }
        }
    }

}
