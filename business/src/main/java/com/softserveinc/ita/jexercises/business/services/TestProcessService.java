package com.softserveinc.ita.jexercises.business.services;

import com.softserveinc.ita.jexercises.common.dto.QuestionRequestDto;
import com.softserveinc.ita.jexercises.common.dto.QuestionResponseDto;
import com.softserveinc.ita.jexercises.common.dto.TestStartDto;

/**
 * Service that makes TestProcess.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
public interface TestProcessService {

    /**
     * Gives information about questions in test.
     *
     * @param testId Test Id.
     * @return TestStart DTO object.
     */
    TestStartDto getInformationAboutTestQuestions(Long testId);

    /**
     * Gives information about next or previous question.
     *
     * @param questionRequestDto QuestionRequest DTO object.
     * @return QuestionResponse DTO object.
     */
    QuestionResponseDto getQuestion(QuestionRequestDto questionRequestDto);

    /**
     * Check user answers.
     *
     * @param questionRequestDto QuestionRequest DTO object.
     */
    void submitTest(QuestionRequestDto questionRequestDto);
   
}
