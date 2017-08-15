package quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import quiz.controller.dto.QuizElementDTO;
import quiz.model.Answer;
import quiz.model.Question;
import quiz.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    public QuestionService questionService;

    @GetMapping("/")
    public String home(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping("/quiz")
    public String allQuestions(HttpServletRequest request){

        List<QuizElementDTO> elements = new ArrayList<QuizElementDTO>();

//        for(Question question : questionService.getAllQuestions()) {
//
//            List<String> answerTexts = new ArrayList<String>();
//            for (Answer answer : question.getQuestionValues()) {
//                answerTexts.add(answer.getAnswerText());
//            }
//            elements.add(new QuizElementDTO(question, answerTexts));
//        }

        request.setAttribute("questions", elements);
        request.setAttribute("mode", "MODE_QUESTIONS");

        return "index";
    }

//    @GetMapping("/new-question")
//    public String newQuestion(HttpServletRequest request){
//        request.setAttribute("mode", "MODE_NEW");
//        return "index";
//    }
//
//    @PostMapping("/save-question")
//    public String saveQuestion(@ModelAttribute Question question, BindingResult bindingResult, HttpServletRequest request){
//
////        QuizElementDTO quizElementDTO = new QuizElementDTO();
//
//        List<String> answerTexts = new ArrayList<String>();
//
//        request.setAttribute("questions", questionService.getAllQuestions());
//        request.setAttribute("mode", "MODE_QUESTIONS");
//        return "index";
//    }

}
