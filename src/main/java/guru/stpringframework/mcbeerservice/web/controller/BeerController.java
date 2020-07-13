package guru.stpringframework.mcbeerservice.web.controller;

import guru.stpringframework.mcbeerservice.services.BeerService;
import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{id}")
    ResponseEntity<BeerDto> getById(@PathVariable("id") UUID id){
        return new ResponseEntity<>(beerService.getById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(beerService.saveNewBeer(beerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(beerService.updateBeer(id, beerDto), HttpStatus.NO_CONTENT);
    }
}
