package visualnut.challenge.ex1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import visualnut.challenge.apps.Ex1;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex1.class)
public class DividedBy3UnitTest {

    @InjectMocks
    private DividedBy3 dividedBy3;

    @Test
    public void isDividedBy3() {
        Assertions.assertTrue(dividedBy3.isDivided(9));
    }

    @Test
    public void isDividedBy5() {
        Assertions.assertFalse(dividedBy3.isDivided(10));
    }

    @Test
    public void isDividedBy15() {
        Assertions.assertTrue(dividedBy3.isDivided(30));
    }

    @Test
    public void isDividedByOther() {
        Assertions.assertFalse(dividedBy3.isDivided(4));
    }

    @Test
    public void getContent() {
        Assertions.assertEquals("Visual", dividedBy3.getContent(9));
    }
}
