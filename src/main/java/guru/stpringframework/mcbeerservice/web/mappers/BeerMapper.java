package guru.stpringframework.mcbeerservice.web.mappers;

import guru.stpringframework.mcbeerservice.domain.Beer;
import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
@DecoratedWith(BeerMapperDecorator.class)
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDto dto);
    BeerDto beerToBeerDto(Beer beer);
    BeerDto beerToBeerDtoWithInventory(Beer beer);
}
