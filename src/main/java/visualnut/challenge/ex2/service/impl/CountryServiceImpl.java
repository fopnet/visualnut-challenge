package visualnut.challenge.ex2.service.impl;

import java.util.Collections;
import java.util.List;

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

}
