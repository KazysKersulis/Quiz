package quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import quiz.controller.dto.QuestionDTO;
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
    public String newQuestion(HttpServletRequest request){
        request.setAttribute("mode", "MODE_NEW");
        return "index";
    }

    @PostMapping(value = "/save-question")
    public String saveQuestion(@RequestBody QuestionDTO questionDTO, HttpServletRequest request){

        questionService.createQuestion(questionDTO.getText(), questionDTO.getType(), questionDTO.getDtos()
        .stream()
        .map(value -> value.getText())
        .collect(toList()));

        request.setAttribute("questions", questionService.getAllQuestions());
        request.setAttribute("mode", "MODE_QUESTIONS");
        return "index";
    }

}
