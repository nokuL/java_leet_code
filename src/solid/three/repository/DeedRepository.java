package solid.three.repository;

import solid.three.model.Deed;

import java.util.ArrayList;
import java.util.List;

public class DeedRepository {

    public Deed findDeedById(String deedId){

        List<Deed> deedRepository  = new ArrayList<>(); // simulating a data source

        // 1. Fetch deed from in-memory list
        Deed deed = deedRepository.stream()
                .filter(d -> d.getDeedNumber().equals(deedId))
                .findFirst()
                .orElse(null);
        return  deed;
    }
}
