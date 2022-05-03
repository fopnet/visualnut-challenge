package visualnut.challenge.apps.ex2.model;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import visualnut.challenge.apps.Ex2Application;
import visualnut.challenge.ex2.model.entity.Country;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex2Application.class)
public class CountryUnitTest {

    private Country ES;

    @BeforeEach
    public void setup() {

        ES = Country.builder().country("ES").languages(Arrays.asList("es")).build();
    }

    @Test
    public void equality() {
        Assertions.assertEquals(Country.builder().country("ES").build(), ES);
    }

    @Test
    public void equalityCountryCaseSensitive() {
        Assertions.assertNotEquals(Country.builder().country("eS").build(), ES);
    }

    @Test
    public void equalityCountryNull() {
        Assertions.assertNotEquals(Country.builder().build(), ES);
    }

}
