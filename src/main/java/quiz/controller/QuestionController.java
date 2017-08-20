package quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import quiz.controller.dto.QuestionDTO;
import quiz.controller.dto.QuestionValueDTO;
import quiz.model.Question;
import quiz.service.QuestionService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Controller
public class QuestionController {

    @Autowired
    public QuestionService questionService;

    @GetMapping("/new-question")
    public String newQuestion(ModelMap model){
        model.addAttribute("questionDTO", new QuestionDTO());
        model.addAttribute("mode", "MODE_NEW");

        return "index";
    }

    @PostMapping(value = "/save-question")
    public String saveQuestion(@ModelAttribute("questionDTO") QuestionDTO questionDTO, BindingResult result, ModelMap model){

        questionService.createQuestion(questionDTO, questionDTO.getQuestionValues());

        model.addAttribute("questions", questionService.getAllQuestions());
        model.addAttribute("mode", "MODE_NEW_QUESTION_SUCCESS");
        return "index";
    }

}
