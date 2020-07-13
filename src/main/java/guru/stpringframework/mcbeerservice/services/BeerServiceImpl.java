package guru.stpringframework.mcbeerservice.services;

import guru.stpringframework.mcbeerservice.domain.Beer;
import guru.stpringframework.mcbeerservice.repositories.BeerRepository;
import guru.stpringframework.mcbeerservice.web.controller.NotFoundException;
import guru.stpringframework.mcbeerservice.web.mappers.BeerMapper;
import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {
    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Override
    public BeerDto getById(UUID id) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(id).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeer(UUID id, BeerDto beerDto) {
        Beer beer = beerRepository.findById(id).orElseThrow(NotFoundException::new);

        beer.setBeerName((beerDto.getBeerName()));
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer)) ;
    }
}
