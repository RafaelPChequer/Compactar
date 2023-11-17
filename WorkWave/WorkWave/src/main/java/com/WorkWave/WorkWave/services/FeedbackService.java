package com.WorkWave.WorkWave.services;

import com.WorkWave.WorkWave.models.Anuncio;
import com.WorkWave.WorkWave.models.Feedback;
import com.WorkWave.WorkWave.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;
@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback findFeedbackById(Long id) {
        Optional<Feedback> feedback = this.feedbackRepository.findById(id);
        return feedback.orElseThrow(() ->new RuntimeException("Feedback não encontrado!"));
    }

    public List<Feedback> getAllFeedbacks() {
        List<Feedback> listaFeedbacks = new ArrayList<>();
        for(long i = 0; findFeedbackById(i) != null; i++) {
            listaFeedbacks.add(findFeedbackById(i));
        }
        return listaFeedbacks;
    }

    public Feedback updateFeedback(long id, Feedback updatedFeedback) {
        Feedback existingFeedback = findFeedbackById(id);
        return feedbackRepository.save(existingFeedback);
    }

    public void deletarFeedback(Long id) {
        Feedback existingFeedback = findFeedbackById(id);
        feedbackRepository.delete(existingFeedback);
    }
}
