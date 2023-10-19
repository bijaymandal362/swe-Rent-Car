package edu.miu.cs425.CarRental.service;



import edu.miu.cs425.CarRental.dto.FeedbackRequest;
import edu.miu.cs425.CarRental.model.Feedback;

import java.util.List;

public interface FeedbackService {
    public Feedback createFeedback(FeedbackRequest newFeedbackRequest);
    public List<Feedback> getAllFeedbacks();

    public List<Feedback> getFeedbackByCustomerId(Long customerId) throws NoSuchFieldException, IllegalAccessException;

}
