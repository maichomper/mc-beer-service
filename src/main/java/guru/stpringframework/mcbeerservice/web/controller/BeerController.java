package guru.stpringframework.mcbeerservice.web.controller;

import guru.stpringframework.mcbeerservice.services.BeerService;
import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import guru.stpringframework.mcbeerservice.web.model.BeerPagedList;
import guru.stpringframework.mcbeerservice.web.model.BeerStyleEnum;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/")
@RestController
public class BeerController {

    private static final Integer DEFAULT_PAGE_NUMBER = 0;
    private static final Integer DEFAULT_PAGE_SIZE = 25;

    private final BeerService beerService;

    @GetMapping(produces={"application/json"}, path = "beer")
    public ResponseEntity<BeerPagedList> listBeers(@RequestParam(value="pageNumber", required = false) Integer pageNumber,
                                                   @RequestParam(value="pageSize", required = false) Integer pageSize,
                                                   @RequestParam(value="beerName", required = false) String beerName,
                                                   @RequestParam(value="beerStyle", required = false) BeerStyleEnum beerStyle,
                                                   @RequestParam(value="showInventoryOnHand", required = false) Boolean showInventoryOnHand){

        if(showInventoryOnHand == null){
            showInventoryOnHand = false;
        }
        if(pageNumber == null || pageNumber < 0){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if(pageSize == null || pageSize < 0){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        BeerPagedList beerList = beerService.listBeers(beerName, beerStyle, PageRequest.of(pageNumber, pageSize), showInventoryOnHand);
        return new ResponseEntity<>(beerList, HttpStatus.OK);
    }

    @GetMapping("beer/{id}")
    ResponseEntity<BeerDto> getById(@PathVariable("id") UUID id,
                                    @RequestParam(value="showInventoryOnHand", required = false) Boolean showInventoryOnHand){
        if(showInventoryOnHand == null){
            showInventoryOnHand = false;
        }

        return new ResponseEntity<>(beerService.getById(id, showInventoryOnHand), HttpStatus.OK);
    }

    @PostMapping(path = "beer")
    public ResponseEntity create(@RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("beer/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeer(id, beerDto), HttpStatus.NO_CONTENT);
    }

    @GetMapping("beerUpc/{upc}")
    ResponseEntity<BeerDto> getByUpc(@PathVariable("upc") String upc,
                                    @RequestParam(value="showInventoryOnHand", required = false) Boolean showInventoryOnHand){
        if(showInventoryOnHand == null){
            showInventoryOnHand = false;
        }

        return new ResponseEntity<>(beerService.getByUpc(upc, showInventoryOnHand), HttpStatus.OK);
    }
}
