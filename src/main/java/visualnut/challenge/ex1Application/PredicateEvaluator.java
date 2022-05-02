package visualnut.challenge.ex1Application;

import java.util.function.IntPredicate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class PredicateEvaluator implements IntPredicate {

    private int divisor;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String content;

    public String getContent(int dividend) {
        return content;
    }

    @Override
    public boolean test(int dividend) {
        return dividend % divisor == 0;
    }
}
