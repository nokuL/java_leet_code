package design_patterns.structural.observer;

public class EmailNotifier implements DeedsObserver {

    @Override
    public void update(String status) {
        System.out.println("Email notification sent: " + status);
    }
}