package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EffortPriorityPolicyTest {
    @Test
    public void returnsNegativeEstimatedHours() {
        ProjectTask task = new ProjectTask("T-1", "Fix bug", 3);
        EffortPriorityPolicy policy = new EffortPriorityPolicy();

        assertEquals(-3, policy.calculatePriority(task));
    }

    @Test
    public void shorterTaskHasHigherPriority() {
        ProjectTask shortTask = new ProjectTask("T-1", "Fix bug", 2);
        ProjectTask longTask = new ProjectTask("T-2", "Add feature", 8);
        EffortPriorityPolicy policy = new EffortPriorityPolicy();

        assertTrue(
            policy.calculatePriority(shortTask) > policy.calculatePriority(longTask)
        );
    }
}