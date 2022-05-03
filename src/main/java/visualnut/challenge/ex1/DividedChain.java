package visualnut.challenge.ex1;

public class DividedChain {

    public Evaluator chain() {
        Evaluator parent = new DividedBy15();
        parent
                .chain(new DividedBy3())
                .chain(new DividedBy5())
                .chain(new DividedBy1());
        return parent;
    }

}