package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatusPriorityPolicyTest {
    @Test
    public void inProgressHasPriorityTwo() {
        ProjectTask task = new ProjectTask("T-1", "Fix bug", 3);
        task.changeStatus(TaskStatus.IN_PROGRESS);

        StatusPriorityPolicy policy = new StatusPriorityPolicy();

        assertEquals(2, policy.calculatePriority(task));
    }

    @Test
    public void notStartedHasPriorityOne() {
        ProjectTask task = new ProjectTask("T-2", "Add feature", 5);
        StatusPriorityPolicy policy = new StatusPriorityPolicy();

        assertEquals(1, policy.calculatePriority(task));
    }

    @Test
    public void completedHasPriorityZero() {
        ProjectTask task = new ProjectTask("T-3", "Write tests", 2);
        task.changeStatus(TaskStatus.COMPLETED);

        StatusPriorityPolicy policy = new StatusPriorityPolicy();

        assertEquals(0, policy.calculatePriority(task));
    }
}