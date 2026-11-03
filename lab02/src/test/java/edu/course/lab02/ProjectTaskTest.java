package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectTaskTest {

    @Test
    public void testCreateValidTask() {
        ProjectTask task = new ProjectTask("T-1", "Write report", 5);
        assertEquals("T-1", task.getId());
        assertEquals("Write report", task.getTitle());
        assertEquals(TaskStatus.NOT_STARTED, task.getStatus());
        assertEquals(5, task.getEstimatedHours());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testNullId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask(null, "Title", 5));
    }

    @Test
    public void testBlankId() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("  ", "Title", 5));
    }

    @Test
    public void testNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", null, 5));
    }

    @Test
    public void testEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "", 5));
    }

    @Test
    public void testZeroEstimatedHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "Title", 0));
    }

    @Test
    public void testNegativeEstimatedHours() {
        assertThrows(IllegalArgumentException.class, () -> new ProjectTask("T-1", "Title", -3));
    }

    @Test
    public void testChangeStatus() {
        ProjectTask task = new ProjectTask("T-1", "Title", 5);
        task.changeStatus(TaskStatus.IN_PROGRESS);
        assertEquals(TaskStatus.IN_PROGRESS, task.getStatus());
        assertFalse(task.isCompleted());
    }

    @Test
    public void testCompleteTask() {
        ProjectTask task = new ProjectTask("T-1", "Title", 5);
        task.changeStatus(TaskStatus.COMPLETED);
        assertTrue(task.isCompleted());
    }

    @Test
    public void testChangeStatusToNull() {
        ProjectTask task = new ProjectTask("T-1", "Title", 5);
        assertThrows(IllegalArgumentException.class, () -> task.changeStatus(null));
        assertEquals(TaskStatus.NOT_STARTED, task.getStatus());
    }

    @Test
    public void testIncreaseEstimate() {
        ProjectTask task = new ProjectTask("T-1", "Title", 5);
        task.increaseEstimate(3);
        assertEquals(8, task.getEstimatedHours());
    }

    @Test
    public void testIncreaseEstimateByZero() {
        ProjectTask task = new ProjectTask("T-1", "Title", 5);
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(0));
        assertEquals(5, task.getEstimatedHours());
    }

    @Test
    public void testIncreaseEstimateByNegative() {
        ProjectTask task = new ProjectTask("T-1", "Title", 5);
        assertThrows(IllegalArgumentException.class, () -> task.increaseEstimate(-2));
        assertEquals(5, task.getEstimatedHours());
    }
}
