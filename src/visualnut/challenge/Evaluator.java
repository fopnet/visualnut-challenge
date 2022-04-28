package visualnut.challenge;

public abstract interface Evaluator {
    default boolean dividedBy(int dividend, int divisor) {
        return dividend % divisor == 0;
    }

    default Evaluator chain (Evaluator evaluator) {
        setNext(evaluator);
        return evaluator;
    }

    void setNext(Evaluator evaluator);
    
    Evaluator getNext();

    boolean isDivided(int dividend);

    String getContent(int dividend);

    default String print(int dividend) {
        if (isDivided(dividend)) {
           return getContent(dividend);
        } else if (getNext() != null) {
            return getNext().print(dividend);
        }
        return "";
    }



}