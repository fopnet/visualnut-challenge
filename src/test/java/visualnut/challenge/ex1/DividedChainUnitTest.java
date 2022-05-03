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
public class DividedChainUnitTest {

    @InjectMocks
    private DividedChain dividedChain;

    @Test
    public void isDividedBy15() {
        Evaluator first = dividedChain.chain();

        Assertions.assertTrue(first.isDivided(15));
        Assertions.assertEquals("Visual Nuts", first.getContent(15));
    }

    @Test
    public void isDividedBy3() {
        Evaluator second = dividedChain.chain().getNext();

        Assertions.assertTrue(second.isDivided(9));
        Assertions.assertEquals("Visual", second.getContent(9));
    }

    @Test
    public void isDividedBy5() {
        Evaluator third = dividedChain.chain().getNext().getNext();

        Assertions.assertTrue(third.isDivided(5));
        Assertions.assertEquals("Nuts", third.getContent(5));
    }

    @Test
    public void isDividedByOther() {
        Evaluator last = dividedChain.chain().getNext().getNext().getNext();

        Assertions.assertTrue(last.isDivided(4));
        Assertions.assertEquals("4", last.getContent(4));
    }
}
