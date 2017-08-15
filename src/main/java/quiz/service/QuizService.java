package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import quiz.repository.SubmissionRepository;

@Component
public class QuizService {
    private SubmissionRepository submissionRepository;

    @Autowired
    public QuizService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }


}
