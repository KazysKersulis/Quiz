package quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import quiz.controller.dto.AnswerDTO;
import quiz.controller.dto.QuizElementDTO;
import quiz.controller.dto.SubmissionDTO;
import quiz.model.Question;
import quiz.model.QuestionValue;
import quiz.model.Submission;
import quiz.service.QuestionService;
import quiz.service.QuizService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuizController {

    @Autowired
    public QuestionService questionService;

    @Autowired
    public QuizService quizService;

    @GetMapping("/")
    public String home(HttpServletRequest request){
        request.setAttribute("mode", "MODE_HOME");
        return "index";
    }

    @GetMapping(value = "/quiz")
    public String allQuestions(Model model){

        List<QuizElementDTO> elements = new ArrayList<QuizElementDTO>();

        for(Question question : questionService.getAllQuestions()) {

            List<String> answerTexts = new ArrayList<String>();
            for (QuestionValue questionValue : question.getQuestionValues()) {
                answerTexts.add(questionValue.getText());
            }
            elements.add(new QuizElementDTO(question, answerTexts));
        }
        model.addAttribute("submissionDTO", new SubmissionDTO());
        model.addAttribute("elements", elements);
        model.addAttribute("mode", "MODE_QESTIONS");


        return "index";
    }

//    @PostMapping(value = "/quiz")
//    public String doQuiz(@RequestBody SubmissionDTO submissionDTO, HttpServletRequest request){
//
//        quizService.submitQuiz(submissionDTO, submissionDTO.getAnswerValues());
//
//        request.setAttribute("mode", "MODE_QUESTIONS");
//
//        return "index";
//    }


    @PostMapping(value = "/quiz")
    public String doQuiz(@ModelAttribute("submissionDTO")SubmissionDTO submissionDTO,
                         BindingResult result, ModelMap model) {

        model.addAttribute("firstName", submissionDTO.getFirstName());
        model.addAttribute("lastName", submissionDTO.getLastName());
//        model.addAttribute("answers", submissionDTO.getAnswerValues());

        quizService.submitQuiz(submissionDTO);

        quizService.submitQuiz(submissionDTO, submissionDTO.getAnswerValues());

        model.addAttribute("mode", "MODE_SUCCESS");

        return "index";
    }


}
