package visualnut.challenge.apps;

import java.util.stream.IntStream;

import visualnut.challenge.ex1.DividedChain;
import visualnut.challenge.ex1.Evaluator;

public class Ex1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Please, inform a maximum number");
            return;
        }

        Evaluator eval = new DividedChain().chain();
        int max = Integer.parseInt(args[0]);
        IntStream.range(1, max + 1).forEach(num -> {
            System.out.printf("%s: %s\n", String.format("%" + 3 + "s", num), eval.print(num));
        });

    }

}