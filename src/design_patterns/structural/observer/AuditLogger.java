package design_patterns.structural.observer;

public class AuditLogger implements DeedsObserver {

    @Override
    public void update(String status) {
        System.out.println("Audit log entry recorded: " + status);
    }
}