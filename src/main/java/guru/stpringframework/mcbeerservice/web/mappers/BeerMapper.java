package guru.stpringframework.mcbeerservice.web.mappers;

import guru.stpringframework.mcbeerservice.domain.Beer;
import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto BeerToBeerDto(Beer beer);
    Beer BeerDtoToBeer(BeerDto dto);
}
