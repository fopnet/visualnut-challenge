package visualnut.challenge.ex2Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import visualnut.challenge.ex2Application.model.Country;
import visualnut.challenge.ex2Application.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private ResponseHelper restHelper;

    @GetMapping
    public ResponseEntity<List<Country>> countries() {
        return restHelper.ok(countryService.findAll());
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> count() {
        return restHelper.ok(countryService.count());
    }

    @GetMapping("/languages/{lang}/most-official")
    public ResponseEntity<Country> findMostOfficialLanguage(@PathVariable String lang) {
        return restHelper.okOrNotFound(countryService.findMostOfficialLanguage(lang));
    }

    @GetMapping("/languages/count")
    public ResponseEntity<Integer> countsAllOfficialLanguagesSpoken() {
        return restHelper.ok(countryService.countsAllOfficialLanguagesSpoken());
    }

    @GetMapping("/highest-number-official-languages")
    public ResponseEntity<Country> findCountryHighestNumberOfficialLanguages() {
        return restHelper.okOrNotFound(countryService.findCountryHighestNumberOfficialLanguages());
    }

    @GetMapping("/the-most-common-official-languages")
    public ResponseEntity<List<String>> findTheMostCommonOfficialLanguageInTheWorld() {
        return restHelper.ok(countryService.findTheMostCommonOfficialLanguageInTheWorld());
    }

}