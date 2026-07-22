package design_patterns.structural.observer;

public interface DeedsSubject {

    public void subscribe(DeedsObserver observer);
    public  void unsubscribe(DeedsObserver observer);
    public  void notifyObservers(String status);
}

