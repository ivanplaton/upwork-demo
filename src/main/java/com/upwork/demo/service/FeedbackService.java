package com.upwork.demo.service;

import com.upwork.demo.model.request.Feedback;
import com.upwork.demo.entity.FeedbackEntity;
import com.upwork.demo.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public String saveFeedback(Feedback feedback) {
        FeedbackEntity entity = new FeedbackEntity();
        entity.setMessage(feedback.getMessage());

        feedbackRepository.save(entity);

        return "Thank you for your feedback!";
    }

}
