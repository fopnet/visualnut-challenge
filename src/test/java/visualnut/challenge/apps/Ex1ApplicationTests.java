package visualnut.challenge.apps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import visualnut.challenge.ex1Application.PredicateEvaludatorList;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex1Application.class)
public class Ex1ApplicationTests {
	@Autowired
	private PredicateEvaludatorList predicateEvaludatorList;

	@Test
	public void contextLoads() throws Exception {
		Assertions.assertNotNull(predicateEvaludatorList);
	}

}
