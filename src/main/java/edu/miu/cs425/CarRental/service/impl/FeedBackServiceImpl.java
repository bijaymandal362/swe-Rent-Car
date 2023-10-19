package edu.miu.cs425.CarRental.service.impl;

import edu.miu.cs425.CarRental.dto.FeedbackRequest;
import edu.miu.cs425.CarRental.model.Customer;
import edu.miu.cs425.CarRental.model.Feedback;
import edu.miu.cs425.CarRental.repository.CustomerRepository;
import edu.miu.cs425.CarRental.repository.FeedbackRepository;
import edu.miu.cs425.CarRental.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedBackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedBackRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Feedback createFeedback(FeedbackRequest newFeedbackRequest){
        Optional<Customer> customer = this.customerRepository.findById(newFeedbackRequest.getCustomerId());
//        Feedback feedbackRequest= new Feedback(null, newFeedbackRequest.getRating(),newFeedbackRequest.getComment(),
//                customer.get());
        return feedBackRepository.save(null);
    }

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedBackRepository.findAll();
    }

    @Override
    public List<Feedback> getFeedbackByCustomerId(Long customerId) {
    return null;
    }
}
