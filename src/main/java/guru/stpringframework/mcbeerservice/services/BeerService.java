package guru.stpringframework.mcbeerservice.services;

import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import guru.stpringframework.mcbeerservice.web.model.BeerPagedList;
import guru.stpringframework.mcbeerservice.web.model.BeerStyleEnum;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BeerService {
    BeerDto getById(UUID id);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID id, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);
}
