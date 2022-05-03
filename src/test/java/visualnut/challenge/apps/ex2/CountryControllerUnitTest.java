package visualnut.challenge.apps.ex2;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.servlet.http.HttpServletResponse;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import visualnut.challenge.apps.Ex2Application;
import visualnut.challenge.ex2.model.entity.Country;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CountryControllerUnitTest {

    @Autowired
    protected RestTemplate template;

    @LocalServerPort
    private int serverPort;

    private String baseUrl;

    private Country US;
    private Country BE;
    private Country DE;
    private Country NL;
    private Country ES;

    @BeforeEach
    public void setup() {
        baseUrl = "http://localhost:" + serverPort + "/countries/";

        US = Country.builder().country("US").languages(asList("en")).build();
        BE = Country.builder().country("BE").languages(asList("nl", "fr", "de")).build();
        NL = Country.builder().country("NL").languages(asList("nl", "fy")).build();
        DE = Country.builder().country("DE").languages(asList("de")).build();
        ES = Country.builder().country("ES").languages(asList("es")).build();
    }

    @Test
    public void countries() throws Exception {

        ResponseEntity<Country[]> result = template.getForEntity(baseUrl, Country[].class);

        Assertions.assertEquals(HttpServletResponse.SC_OK, result.getStatusCodeValue());
        assertThat(asList(result.getBody()), Matchers.containsInAnyOrder(US, BE, NL, DE, ES));

        /*
        mockMvc.perform(get("/countries")
                .contentType((MediaType.APPLICATION_JSON_VALUE)))
                // .content(convertObjectToJsonBytes(edicaoProcesso)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id", is("5989e8c0010ca4216c31d81d")));
        */
    }

    @Test
    public void countriesCount() throws Exception {

        baseUrl += "/count";
        ResponseEntity<Integer> result = template.getForEntity(baseUrl, Integer.class);

        Assertions.assertEquals(HttpServletResponse.SC_OK, result.getStatusCodeValue());
        Assertions.assertEquals(result.getBody(), Integer.valueOf(5));
    }

    @Test
    public void findMostOfficialLanguage() throws Exception {

        baseUrl += "/languages/de/most-official";
        ResponseEntity<Country> result = template.getForEntity(baseUrl, Country.class);

        Assertions.assertEquals(HttpServletResponse.SC_OK, result.getStatusCodeValue());
        Assertions.assertEquals(result.getBody(), BE);
    }

    @Test
    public void countsAllOfficialLanguagesSpoken() throws Exception {

        baseUrl += "/languages/count";
        ResponseEntity<Integer> result = template.getForEntity(baseUrl, Integer.class);

        Assertions.assertEquals(HttpServletResponse.SC_OK, result.getStatusCodeValue());
        Assertions.assertEquals(result.getBody(), Integer.valueOf(6));
    }

    @Test
    public void findCountryHighestNumberOfficialLanguages() throws Exception {

        baseUrl += "/highest-number-official-languages";
        ResponseEntity<Country> result = template.getForEntity(baseUrl, Country.class);

        Assertions.assertEquals(HttpServletResponse.SC_OK, result.getStatusCodeValue());
        Assertions.assertEquals(result.getBody(), BE);
    }

    @Test
    public void findTheMostCommonOfficialLanguageInTheWorld() throws Exception {

        baseUrl += "/the-most-common-official-languages";
        ResponseEntity<String[]> result = template.getForEntity(baseUrl, String[].class);

        Assertions.assertEquals(HttpServletResponse.SC_OK, result.getStatusCodeValue());
        assertThat(asList(result.getBody()), Matchers.containsInAnyOrder("de", "nl"));

    }
}
