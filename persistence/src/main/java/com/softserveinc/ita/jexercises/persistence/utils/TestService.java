package com.softserveinc.ita.jexercises.persistence.utils;

import com.softserveinc.ita.jexercises.common.entity.Test;
import java.util.List;

public interface TestService {

    void createTest(Test test);

    Test updateTest(Test test);

    void deleteTest (Test test);

    void deleteTestById(Long id);

    Test findTestById(Long id);

    List<Test> findAllTests();

    List<Test> findAllTestsByQuestionId(Long questionId);
}
