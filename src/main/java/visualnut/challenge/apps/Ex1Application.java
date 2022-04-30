package visualnut.challenge.apps;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import visualnut.challenge.ex1.DividedChain;
import visualnut.challenge.ex1.Evaluator;

@SpringBootApplication
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			if (args.length == 0) {
				System.err.println("Please, inform a maximum number");
				return;
			}

			Evaluator eval = new DividedChain().chain();
			int max = Integer.parseInt(args[0]);
			IntStream.range(1, max + 1).forEach(num -> {
				System.out.printf("%s: %s\n", String.format("%" + 3 + "s", num), eval.print(num));
			});

		};
	}
}
