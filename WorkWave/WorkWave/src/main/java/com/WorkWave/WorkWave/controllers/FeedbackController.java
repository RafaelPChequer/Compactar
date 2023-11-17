package com.WorkWave.WorkWave.controllers;

import com.WorkWave.WorkWave.models.Feedback;
import com.WorkWave.WorkWave.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable Long id) {
        Feedback feedback = feedbackService.findFeedbackById(id);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = feedbackService.getAllFeedbacks();
        return new ResponseEntity<>(feedbacks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback) {
        feedback.setIdFeedback(null);
        Feedback createdFeedback = feedbackService.updateFeedback(feedback.getIdFeedback(), feedback);
        return new ResponseEntity<>(createdFeedback, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable Long id, @RequestBody Feedback updatedFeedback) {
        Feedback feedback = feedbackService.updateFeedback(id, updatedFeedback);
        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable Long id) {
        feedbackService.deletarFeedback(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
