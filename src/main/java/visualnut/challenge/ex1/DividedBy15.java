package visualnut.challenge.ex1;

public class DividedBy15 extends AbstractEvaluator implements Evaluator {

    @Override
    public boolean isDivided(int dividend) {
        return dividedBy(dividend, 15);
    }

    @Override
    public String getContent(int dividend) {
        return "Visual Nuts";
    }

}
