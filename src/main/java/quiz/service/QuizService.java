package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import quiz.controller.dto.SubmissionDTO;
import quiz.model.Submission;
import quiz.repository.SubmissionRepository;

import java.util.List;

@Component
public class QuizService {

    private SubmissionRepository submissionRepository;
    private AnswerService answerService;

    @Autowired
    public QuizService(SubmissionRepository submissionRepository, AnswerService answerService) {
        this.submissionRepository = submissionRepository;
        this.answerService = answerService;
    }

    @Transactional
    public void submitQuiz(SubmissionDTO submission, List<String> answerValues) {

        Submission newSubmission = new Submission(submission.getFirstName(), submission.getLastName());

        submissionRepository.saveAndFlush(newSubmission);

        answerService.createAnswerValue(answerValues, newSubmission.getSubmissionId());

    }

    public void submitQuiz(SubmissionDTO submissionDTO) {

        Submission newSubmission = new Submission(submissionDTO.getFirstName(), submissionDTO.getLastName());

        submissionRepository.saveAndFlush(newSubmission);

    }
}
