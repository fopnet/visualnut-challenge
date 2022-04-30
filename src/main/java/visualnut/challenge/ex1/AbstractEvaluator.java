package visualnut.challenge.ex1;

public abstract class AbstractEvaluator {
    private Evaluator evaluator;

    public Evaluator getNext() {
        return this.evaluator;
    }

    public void setNext(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

}
