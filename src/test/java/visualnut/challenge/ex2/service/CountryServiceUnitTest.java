package visualnut.challenge.ex2.service;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import visualnut.challenge.apps.Ex2Application;
import visualnut.challenge.ex2.model.Country;
import visualnut.challenge.ex2.service.impl.CountryServiceImpl;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex2Application.class)
public class CountryServiceUnitTest {

    @InjectMocks
    private CountryServiceImpl countryService;

    @Mock
    private List<Country> countries;

    private Country US;
    private Country BE;
    private Country DE;
    private Country NL;
    private Country ES;

    @BeforeEach
    public void setup() {

        US = Country.builder().country("US").languages(asList("en")).build();
        BE = Country.builder().country("BE").languages(asList("nl", "fr", "de")).build();
        NL = Country.builder().country("NL").languages(asList("nl", "fy")).build();
        DE = Country.builder().country("DE").languages(asList("nl")).build();
        ES = Country.builder().country("ES").languages(asList("es")).build();
    }

    @Test
    public void countries() throws Exception {

        countries = asList(US, ES, NL);

        countryService.setCountries(countries);

        List<Country> expected = countryService.findAll();

        assertThat(expected, Matchers.containsInAnyOrder(countries.toArray()));

    }

    @Test
    public void countriesCount() throws Exception {

        countries = asList(US, ES, NL);

        countryService.setCountries(countries);

        int expected = countryService.count();

        Assertions.assertEquals(expected, countries.size());

    }

    @Test
    public void findMostOfficialLanguage() throws Exception {

        countries = asList(US, DE, NL);

        countryService.setCountries(countries);

        Country expected = countryService.findMostOfficialLanguage("nl");

        Assertions.assertEquals(expected, NL);

    }

    @Test
    public void findMostOfficialLanguageNotMatchCaseSensitive() throws Exception {

        countries = asList(US, DE, NL);

        countryService.setCountries(countries);

        Country expected = countryService.findMostOfficialLanguage("NL");

        Assertions.assertNull(expected);

    }

    @Test
    public void countsAllOfficialLanguagesSpoken() throws Exception {

        countries = asList(BE, DE, NL);

        countryService.setCountries(countries);

        Integer expected = countryService.countsAllOfficialLanguagesSpoken();

        Assertions.assertEquals(expected, Integer.valueOf(4));

    }

    @Test
    public void findCountryHighestNumberOfficialLanguages() throws Exception {

        countries = asList(BE, NL);

        countryService.setCountries(countries);

        Country expected = countryService.findCountryHighestNumberOfficialLanguages();

        Assertions.assertEquals(expected, BE);

    }

    @Test
    public void findTheMostCommonOfficialLanguageInTheWorld() throws Exception {

        countries = asList(BE, DE, NL);

        countryService.setCountries(countries);

        List<String> expected = countryService.findTheMostCommonOfficialLanguageInTheWorld();

        assertThat(expected, Matchers.containsInAnyOrder("nl"));

    }
}