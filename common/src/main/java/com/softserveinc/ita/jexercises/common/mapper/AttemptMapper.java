package com.softserveinc.ita.jexercises.common.mapper;

import com.softserveinc.ita.jexercises.common.entity.Attempt;
import com.softserveinc.ita.jexercises.common.entity.Test;
import com.softserveinc.ita.jexercises.common.entity.User;
import org.springframework.stereotype.Component;

/**
 * Represents entity mapping tool.
 *
 * @author Volodymyr Yakymiv
 * @version 1.0
 */
@Component
public class AttemptMapper {
    /**
     * Sets Attempt Entity object.
     *
     * @param test Test object.
     * @param user User object.
     * @return Attempt.
     */
    public Attempt toEntity(Test test, User user) {
        Attempt attempt = new Attempt();
        attempt.setTest(test);
        attempt.setUser(user);
        return attempt;
    }
}
