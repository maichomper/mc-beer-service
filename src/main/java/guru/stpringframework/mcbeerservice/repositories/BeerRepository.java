package guru.stpringframework.mcbeerservice.repositories;

import guru.stpringframework.mcbeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
