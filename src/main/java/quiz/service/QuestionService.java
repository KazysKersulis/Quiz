package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.controller.dto.QuizElementDTO;
import quiz.model.Question;
import quiz.repository.QuestionRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService implements Serializable{

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional(readOnly = true)
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<Question>();
        for (Question question : questionRepository.findAll()){
            questions.add(question);
        }
        return questions;
    }

    public void save(QuizElementDTO quizElementDTO) {
        questionRepository.save(quizElementDTO);
    }

    public void delete(int id) {
        questionRepository.delete(id);
    }
}
