package edu.course.lab03;

public class TaskPrioritizer {
    private final PriorityPolicy policy;

    public TaskPrioritizer(PriorityPolicy policy) {
        if (policy == null) {
            throw new IllegalArgumentException("Policy must not be null");
        }
        this.policy = policy;
    }

    public ProjectTask choose(ProjectTask first, ProjectTask second) {
        if (policy.calculatePriority(first) >= policy.calculatePriority(second)) {
            return first;
        }
        return second;
    }
}