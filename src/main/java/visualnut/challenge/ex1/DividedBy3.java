package visualnut.challenge.ex1;

public class DividedBy3 extends AbstractEvaluator implements Evaluator {

    @Override
    public boolean isDivided(int dividend) {
        return dividedBy(dividend, 3);
    }

    @Override
    public String getContent(int dividend) {
        return "Visual";
    }

}
