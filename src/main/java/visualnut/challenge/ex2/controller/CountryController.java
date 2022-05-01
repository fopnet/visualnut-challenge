package visualnut.challenge.ex2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import visualnut.challenge.ex2.model.entity.Country;
import visualnut.challenge.ex2.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private RestHelper restHelper;

    @GetMapping
    public ResponseEntity<List<Country>> countries() {
        return restHelper.ok(countryService.findAll());
    }

}