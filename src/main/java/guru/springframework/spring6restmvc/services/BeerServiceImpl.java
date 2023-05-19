package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Beer;
import guru.springframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j //logging property
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, Beer> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<Beer> listBears() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {

        log.debug("Get Beer Id - in service, Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer beerSaved = Beer.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName((beer.getBeerName()))
                .beerStyle(beer.getBeerStyle())
                .quantityOnHand(beer.getQuantityOnHand())
                .price(beer.getPrice())
                .upc("123545")
                .version(beer.getVersion())
                .build();

        beerMap.put(beerSaved.getId(), beerSaved);

        return beerSaved;

    }

    @Override
    public Beer updateBearById(UUID beerId, Beer beer) {
        Beer updatedBeer = beerMap.get(beerId);
        updatedBeer.setBeerName(beer.getBeerName());
        updatedBeer.setBeerStyle(beer.getBeerStyle());
        updatedBeer.setVersion(beer.getVersion());
        updatedBeer.setQuantityOnHand(beer.getQuantityOnHand());
        updatedBeer.setUpc(beer.getUpc());
        updatedBeer.setPrice(beer.getPrice());

        beerMap.put(updatedBeer.getId(), updatedBeer);

        return updatedBeer;
    }

    @Override
    public void deleteBearById(UUID beerId) {
        beerMap.remove(beerId);
    }

    @Override
    public void updateBearPatchById(UUID beerId, Beer beer) {
        Beer updatedPatchBeer = beerMap.get(beerId);
        if (updatedPatchBeer.getBeerName() != null) {
            updatedPatchBeer.setBeerName(beer.getBeerName());
        }

        if (updatedPatchBeer.getBeerStyle() != null) {
            updatedPatchBeer.setBeerStyle(beer.getBeerStyle());
        }

        if (updatedPatchBeer.getVersion() != null) {
            updatedPatchBeer.setVersion(beer.getVersion());
        }

        if (updatedPatchBeer.getPrice() != null) {
            updatedPatchBeer.setPrice(beer.getPrice());
        }

        if (updatedPatchBeer.getQuantityOnHand() != null) {
            updatedPatchBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (updatedPatchBeer.getUpc() != null) {
            updatedPatchBeer.setUpc(beer.getUpc());
        }
    }
}
