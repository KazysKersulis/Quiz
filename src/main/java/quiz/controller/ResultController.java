package quiz.controller;

import com.sun.imageio.plugins.common.SubImageInputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import quiz.controller.dto.AnswerValueDTO;
import quiz.controller.dto.QuizElementDTO;
import quiz.controller.dto.ResultElementDTO;
import quiz.model.Answer;
import quiz.model.Question;
import quiz.model.QuestionValue;
import quiz.model.Submission;
import quiz.service.AnswerService;
import quiz.service.SubmissionService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ResultController {

    @Autowired
    private SubmissionService submissionService;

    @GetMapping(value = "/result")
    public String getResults(Model model) {

        List<ResultElementDTO> resultElementDTOS = new ArrayList<ResultElementDTO>();

        for (Submission submission : submissionService.getAllSubmissions()) {

            List<String> submissionTexts = new ArrayList<String>();
            for (Answer answer : submission.getAnswerValues()) {
                submissionTexts.add(answer.getAnswer());
            }

            resultElementDTOS.add(new ResultElementDTO(submission.getFirstName(),
                    submission.getLastName(), submissionTexts));
        }

        model.addAttribute("resultDTO", resultElementDTOS);
        model.addAttribute("mode", "MODE_RESULTS");

        return "index";
    }


}
