package guru.stpringframework.mcbeerservice.services;

import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID id, BeerDto beerDto);
}
