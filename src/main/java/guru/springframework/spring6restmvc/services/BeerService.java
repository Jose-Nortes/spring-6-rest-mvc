package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<BeerDTO> listBears();

    BeerDTO getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    BeerDTO updateBearById(UUID beerId, BeerDTO beer);


}
