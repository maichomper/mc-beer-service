package guru.stpringframework.mcbeerservice.web.controller;

import guru.stpringframework.mcbeerservice.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    @GetMapping("/{id}")
    ResponseEntity<BeerDto> getById(@PathVariable("id") UUID id){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(@RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable("id") UUID id, @RequestBody @Validated BeerDto beerDto){
        return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.NO_CONTENT);
    }
}
