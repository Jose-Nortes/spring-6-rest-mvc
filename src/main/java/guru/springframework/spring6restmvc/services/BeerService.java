package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.model.Customer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBears();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    Beer updateBearById(UUID beerId, Beer beer);


    void deleteBearById(UUID beerId);
    

    void updateBearPatchById(UUID beerId, Beer beer);
}
