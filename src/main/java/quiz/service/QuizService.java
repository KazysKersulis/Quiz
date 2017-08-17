package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import quiz.controller.dto.SubmissionDTO;
import quiz.model.Submission;
import quiz.repository.AnswerRepository;
import quiz.repository.SubmissionRepository;

import java.util.List;

@Component
public class QuizService {

    private SubmissionRepository submissionRepository;
    private AnswerValueService answerValueService;

    @Autowired
    public QuizService(SubmissionRepository submissionRepository, AnswerValueService answerValueService) {
        this.submissionRepository = submissionRepository;
        this.answerValueService = answerValueService;
    }

    @Transactional
    public void submitQuiz(SubmissionDTO submission, List<String> answerValues) {

        Submission newSubmission = new Submission(submission.getFirstName(), submission.getLastName());

        submissionRepository.saveAndFlush(newSubmission);

        answerValueService.createAnswerValue(answerValues, newSubmission.getSubmission_Id());

    }

    public void submitQuiz(SubmissionDTO submissionDTO) {

        Submission newSubmission = new Submission(submissionDTO.getFirstName(), submissionDTO.getLastName());

        submissionRepository.saveAndFlush(newSubmission);

    }
}
