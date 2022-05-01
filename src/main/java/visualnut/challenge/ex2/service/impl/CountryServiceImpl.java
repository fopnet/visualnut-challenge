package visualnut.challenge.ex2.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import visualnut.challenge.ex2.model.entity.Country;
import visualnut.challenge.ex2.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

    private List<Country> countries;

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public List<Country> findAll() {
        return Collections.unmodifiableList(countries);
    }

    @Override
    public Country findMostOfficialLanguage(String lang) {
        return this.countries.stream().filter(c -> c.getLanguages().indexOf(lang) >= 0)
                .max(Comparator.comparingInt(c -> c.getLanguages().size())).orElse(null);
    }

    @Override
    public Integer countsAllOfficialLanguagesSpoken() {
        return this.countries.stream().flatMap(c -> c.getLanguages().stream())
                .collect(Collectors.toSet()).size();
    }

    @Override
    public Country findCountryHighestNumberOfficialLanguages() {
        return countries.stream().max(Comparator.comparingInt(c -> c.getLanguages().size())).orElse(null);
    }

    @Override
    public List<String> findTheMostCommonOfficialLanguageInTheWorld() {
        Map<String, Long> occurs = countries
                .stream()
                .flatMap(c -> c.getLanguages().stream())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Long max = Collections.max(occurs.values());

        return occurs.entrySet().stream().filter(es -> max.equals(es.getValue())).map(Entry::getKey)
                .collect(Collectors.toList());

    }

}
