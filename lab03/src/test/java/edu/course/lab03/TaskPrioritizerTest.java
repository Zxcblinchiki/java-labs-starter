package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

public class TaskPrioritizerTest {
    @Test
    public void choosesShorterTask() {
        ProjectTask longTask = new ProjectTask("T-1", "Add feature", 8);
        ProjectTask shortTask = new ProjectTask("T-2", "Fix bug", 2);

        TaskPrioritizer prioritizer = new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(shortTask, prioritizer.choose(longTask, shortTask));
    }

    @Test
    public void choosesFirstTaskWhenPrioritiesAreEqual() {
        ProjectTask first = new ProjectTask("T-1", "Write tests", 3);
        ProjectTask second = new ProjectTask("T-2", "Fix bug", 3);

        TaskPrioritizer prioritizer =
                new TaskPrioritizer(new EffortPriorityPolicy());

        assertSame(first, prioritizer.choose(first, second));
    }

    @Test
    public void changingPolicyChangesChoice() {
        ProjectTask shortTask = new ProjectTask("T-1", "Fix bug", 2);
        ProjectTask longTask = new ProjectTask("T-2", "Add feature", 8);
        longTask.changeStatus(TaskStatus.IN_PROGRESS);

        TaskPrioritizer byEffort = new TaskPrioritizer(new EffortPriorityPolicy());
        TaskPrioritizer byStatus = new TaskPrioritizer(new StatusPriorityPolicy());

        assertSame(shortTask, byEffort.choose(shortTask, longTask));
        assertSame(longTask, byStatus.choose(shortTask, longTask));
    }
}