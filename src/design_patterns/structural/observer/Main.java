package design_patterns.structural.observer;

public class Main {
    public static void main(String[] args) {
        DeedsServiceImp deedsService = new DeedsServiceImp();

        DeedsObserver emailNotifier = new EmailNotifier();
        DeedsObserver auditLogger = new AuditLogger();

        deedsService.subscribe(emailNotifier);
        deedsService.subscribe(auditLogger);

        deedsService.notifyObservers("Deed completed: Donated books to the library");

        deedsService.unsubscribe(auditLogger);

        deedsService.notifyObservers("Deed completed: Volunteered at the shelter");
    }
}