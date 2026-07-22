package design_patterns.structural.observer;

import java.util.ArrayList;
import java.util.List;

public class DeedsServiceImp implements  DeedsSubject{

    public String name;
    public List<DeedsObserver>deedsObservers = new ArrayList<>();

    @Override
    public void subscribe(DeedsObserver observer) {
        deedsObservers.add(observer);

    }

    @Override
    public void unsubscribe(DeedsObserver observer) {
        deedsObservers.remove(observer);

    }

    @Override
    public void notifyObservers(String newStatus) {
        for(DeedsObserver deedsObserver : deedsObservers){
            deedsObserver.update(newStatus);
        }


    }
}
