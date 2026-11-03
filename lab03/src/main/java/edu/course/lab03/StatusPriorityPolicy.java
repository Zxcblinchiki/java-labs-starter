package edu.course.lab03;

public class StatusPriorityPolicy implements PriorityPolicy {
    @Override
    public int calculatePriority(ProjectTask task) {
        switch (task.getStatus()) {
            case IN_PROGRESS:
                return 2;
            case NOT_STARTED:
                return 1;
            case COMPLETED:
                return 0;
            default:
                throw new IllegalArgumentException("Unknown task status");
        }
    }
}