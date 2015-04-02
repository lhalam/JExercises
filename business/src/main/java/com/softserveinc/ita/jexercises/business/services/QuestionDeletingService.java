package com.softserveinc.ita.jexercises.business.services;

/**
 * Service that handles question deleting process.
 * 
 * @author Kucheryavenko Dmytro
 *
 * @version 1.0
 */
public interface QuestionDeletingService {
    /**
     * Provides deleting of question.
     * 
     * @param questionId
     *            ID of question.
     */
    void deleteCurrentQuestion(Long questionId);
}
