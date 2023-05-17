package guru.springframework.spring6restmvc.controllers;

import guru.springframework.spring6restmvc.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@AllArgsConstructor // Allows to avoid writing constructor for BeerService e.g.
@Controller
public class BeerController {
    private final BeerService beerService;
}
