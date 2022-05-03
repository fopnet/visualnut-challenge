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
public class DividedBy5UnitTest {

    @InjectMocks
    private DividedBy5 dividedBy5;

    @Test
    public void isDividedBy3() {
        Assertions.assertFalse(dividedBy5.isDivided(9));
    }

    @Test
    public void isDividedBy5() {
        Assertions.assertTrue(dividedBy5.isDivided(10));
    }

    @Test
    public void isDividedBy15() {
        Assertions.assertTrue(dividedBy5.isDivided(30));
    }

    @Test
    public void isDividedByOther() {
        Assertions.assertFalse(dividedBy5.isDivided(4));
    }

    @Test
    public void getContent() {
        Assertions.assertEquals("Nuts", dividedBy5.getContent(10));
    }
}
