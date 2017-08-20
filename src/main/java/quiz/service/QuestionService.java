package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.controller.dto.QuestionDTO;
import quiz.controller.dto.QuizElementDTO;
import quiz.model.AnswerType;
import quiz.model.Question;
import quiz.repository.QuestionRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService implements Serializable{

    private QuestionRepository questionRepository;
    private QuestionValueService questionValueService;

    @Autowired
    public QuestionService(QuestionRepository questionRepository, QuestionValueService questionValueService) {
        this.questionRepository = questionRepository;
        this.questionValueService = questionValueService;
    }

    @Transactional(readOnly = true)
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<Question>();
        for (Question question : questionRepository.findAll()){
            questions.add(question);
        }
        return questions;
    }

    @Transactional
    public void createQuestion(QuestionDTO questionDTO, List<String> answerValues) {
        Question newQuestion = new Question(questionDTO.getText(), questionDTO.getType());
        questionRepository.saveAndFlush(newQuestion);
        questionValueService.createQuestionValue(answerValues, newQuestion.getId());
    }

    public void delete(int id) {
        questionRepository.delete(id);
    }
}
