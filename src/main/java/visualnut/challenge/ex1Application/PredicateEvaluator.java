package visualnut.challenge.ex1Application;

import java.util.function.Predicate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Data
public class PredicateEvaluator implements Predicate<Integer> {

    private int divisor;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String content;

    public String getContent(int dividend) {
        return content;
    }

    public boolean test(Integer dividend) {
        return dividend % divisor == 0;
    }
}
