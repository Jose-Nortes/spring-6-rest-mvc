package guru.springframework.spring6restmvc;

import guru.springframework.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
