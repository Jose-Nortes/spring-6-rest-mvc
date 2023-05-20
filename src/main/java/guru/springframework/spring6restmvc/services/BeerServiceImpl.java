package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.model.BeerStyleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j //logging property
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beer1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyleDTO.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beer2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyleDTO.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beer3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyleDTO.IPA)
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
    public List<BeerDTO> listBears() {
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public BeerDTO getBeerById(UUID id) {

        log.debug("Get Beer Id - in service, Id: " + id.toString());

        return beerMap.get(id);
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beer) {
        BeerDTO beerSaved = BeerDTO.builder()
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
    public BeerDTO updateBearById(UUID beerId, BeerDTO beer) {
        BeerDTO updatedBeer = beerMap.get(beerId);
        updatedBeer.setBeerName(beer.getBeerName());
        updatedBeer.setBeerStyle(beer.getBeerStyle());
        updatedBeer.setVersion(beer.getVersion());
        updatedBeer.setUpc(beer.getUpc());
        updatedBeer.setPrice(beer.getPrice());

        beerMap.put(updatedBeer.getId(), updatedBeer);

        return updatedBeer;
    }
}
