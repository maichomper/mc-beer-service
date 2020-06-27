package guru.stpringframework.mcbeerservice.bootstrap;

import guru.stpringframework.mcbeerservice.domain.Beer;
import guru.stpringframework.mcbeerservice.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if (beerRepository.count() == 0) {

            beerRepository.save(Beer.builder()
                    .beerName("Colimita")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(3370000001L)
                    .price(new BigDecimal(85))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("PALE ALE")
                    .quantityToBrew(200)
                    .upc(3370000002L)
                    .price(new BigDecimal(85))
                    .build());
        }
    }

}
