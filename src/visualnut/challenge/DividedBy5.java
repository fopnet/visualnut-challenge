package visualnut.challenge;

public class DividedBy5  extends AbstractEvaluator implements Evaluator {

    @Override
    public boolean isDivided(int dividend) {
        return dividedBy(dividend, 5);
    }
 
    @Override
    public String getContent(int dividend) {
        return "Nuts";
    }
}
