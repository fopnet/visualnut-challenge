package visualnut.challenge.ex1;

public class DividedBy1 extends AbstractEvaluator implements Evaluator {

    @Override
    public boolean isDivided(int dividend) {
        return dividedBy(dividend, 1);
    }

    @Override
    public String getContent(int dividend) {
        return String.valueOf(dividend);
    }

}
