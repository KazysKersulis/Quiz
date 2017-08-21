package quiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import quiz.model.Question;
import quiz.model.Submission;
import quiz.repository.SubmissionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubmissionService {

    private SubmissionRepository submissionRepository;

    @Autowired
    public SubmissionService(SubmissionRepository submissionRepository) {
        this.submissionRepository = submissionRepository;
    }

    @Transactional(readOnly = true)
    public List<Submission> getAllSubmissions() {
        List<Submission> submissions = new ArrayList<Submission>();
        for (Submission submission : submissionRepository.findAll()){
            submissions.add(submission);
        }
        return submissions;
    }
}
