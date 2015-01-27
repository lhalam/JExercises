package com.softserveinc.ita.jexercises.persistence.utils;

import com.softserveinc.ita.jexercises.common.entity.Question;

import java.util.List;

public interface QuestionService {

    void createQuestion(Question question);

    Question updateQuestion(Question question);

    void deleteQuestion (Question question);

    void deleteQuestionById(Long id);

    Question findQuestionById(Long id);

    List<Question> findAllQuestions();

    List<Question> findAllQuestionsByTestId(Long testId);











}
