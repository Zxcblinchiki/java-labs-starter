package edu.course.lab03;

public class ProjectTask {
    private final String id;
    private final String title;
    private TaskStatus status;
    private int estimatedHours;

    public ProjectTask(String id, String title, int estimatedHours) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Task id must not be null or blank");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Task title must not be null or blank");
        }
        if (estimatedHours <= 0) {
            throw new IllegalArgumentException("Estimated hours must be positive");
        }
        this.id = id;
        this.title = title;
        this.status = TaskStatus.NOT_STARTED;
        this.estimatedHours = estimatedHours;
    }

    public void changeStatus(TaskStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Status must not be null");
        }
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return this.status == TaskStatus.COMPLETED;
    }

    public void increaseEstimate(int hours) {
        if (hours <= 0) {
            throw new IllegalArgumentException("Additional hours must be positive");
        }
        this.estimatedHours += hours;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public TaskStatus getStatus() {
        return this.status;
    }

    public int getEstimatedHours() {
        return this.estimatedHours;
    }
}