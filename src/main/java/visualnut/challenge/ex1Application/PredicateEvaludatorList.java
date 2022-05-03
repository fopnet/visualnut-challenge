package visualnut.challenge.ex1Application;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PredicateEvaludatorList {
    private List<PredicateEvaluator> evaluators;

    public PredicateEvaludatorList() {
        PredicateEvaluator eval15 = new PredicateEvaluator(15, "Visual Nuts");
        PredicateEvaluator eval3 = new PredicateEvaluator(3, "Visual");
        PredicateEvaluator eval5 = new PredicateEvaluator(5, "Nuts");
        PredicateEvaluator eval1 = new PredicateEvaluator(1, "") {
            @Override
            public String getContent(int divident) {
                return String.valueOf(divident);
            }
        };

        evaluators = Arrays.asList(eval15, eval3, eval5, eval1);
    }

    public String getContent(int dividend) {
        return evaluators.stream().filter(e -> e.test(dividend)).findFirst().map(e -> e.getContent(dividend))
                .orElse("");

    }

}
