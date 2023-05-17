package guru.springframework.spring6restmvc;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBears();

    Beer getBeerById(UUID id);
}
