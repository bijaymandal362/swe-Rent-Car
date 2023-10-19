package edu.miu.cs425.CarRental.controller;

import edu.miu.cs425.CarRental.dto.FeedbackRequest;
import edu.miu.cs425.CarRental.model.Feedback;
import edu.miu.cs425.CarRental.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = {"/api/car-rental/feedbacks"})
public class FeedBackController {

    @Autowired
    FeedbackService feedBackService;

    @PostMapping()
    public Feedback createNewFeedbacks(@RequestBody FeedbackRequest newFeedBackRequest){
        return feedBackService.createFeedback(newFeedBackRequest);
    }

    @GetMapping()
    public List<Feedback> getAllFeedbacks(){
        return feedBackService.getAllFeedbacks();
    }

    @GetMapping("/getByCustomer/{customerId}")
    public List<Feedback> getFeedbacksByCustomerId(@PathVariable Long customerId) throws NoSuchFieldException, IllegalAccessException {
        return feedBackService.getFeedbackByCustomerId(customerId);
    }


}

