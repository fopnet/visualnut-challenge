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
public class DividedBy1UnitTest {

    @InjectMocks
    private DividedBy1 dividedBy1;

    @Test
    public void isDividedBy3() {
        Assertions.assertTrue(dividedBy1.isDivided(9));
    }

    @Test
    public void isDividedBy5() {
        Assertions.assertTrue(dividedBy1.isDivided(10));
    }

    @Test
    public void isDividedBy15() {
        Assertions.assertTrue(dividedBy1.isDivided(30));
    }

    @Test
    public void isDividedByOther() {
        Assertions.assertTrue(dividedBy1.isDivided(4));
    }

    @Test
    public void getContent() {
        Assertions.assertEquals(dividedBy1.getContent(4), Integer.valueOf(4).toString());
    }

}
