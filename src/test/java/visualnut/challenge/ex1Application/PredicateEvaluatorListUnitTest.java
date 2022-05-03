package visualnut.challenge.ex1Application;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import visualnut.challenge.apps.Ex1Application;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex1Application.class)
public class PredicateEvaluatorListUnitTest {

    private static final String EXPECTED_RESULT_BY_3 = "Visual";
    private static final String EXPECTED_RESULT_BY_5 = "Nuts";
    private static final String EXPECTED_RESULT_BY_3_5 = "Visual Nuts";
    @Autowired
    private PredicateEvaludatorList predicateEvaludatorList;

    @ParameterizedTest
    @ValueSource(ints = { 15, 30, 45, 60, 75 }) // multilple only by 3 and 5
    public void dividedBy5And3(int value) throws Exception {

        Assertions.assertNotNull(predicateEvaludatorList);
        Assertions.assertEquals(EXPECTED_RESULT_BY_3_5, predicateEvaludatorList.getContent(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 9, 12, 18, 21, 24, 27 }) // multilple only by 3
    public void dividedByOnly3(int value) throws Exception {

        Assertions.assertNotNull(predicateEvaludatorList);
        Assertions.assertEquals(EXPECTED_RESULT_BY_3, predicateEvaludatorList.getContent(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 5, 10, 20, 25, 35, 40, 50, 55, 65, 70, 80, 85, 95 }) // multilple only by 5
    public void dividedByOnly5(int value) throws Exception {

        Assertions.assertNotNull(predicateEvaludatorList);
        Assertions.assertEquals(EXPECTED_RESULT_BY_5, predicateEvaludatorList.getContent(value));
    }

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 4, 7, 8, 11, 13, 14, 17, 19, 22, 23, 26, 28, 29, 31, 32, 34, 37 }) // not multilple by 3 or 5
    public void notDividedBy3or5(int value) throws Exception {

        Assertions.assertNotNull(predicateEvaludatorList);
        Assertions.assertEquals(String.valueOf(value), predicateEvaludatorList.getContent(value));
    }

}