package visualnut.challenge.apps;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import visualnut.challenge.ex1Application.PredicateEvaluator;

@SpringBootApplication(scanBasePackages = { "visualnut.challenge.apps.ex1Application" })
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args).close();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			System.out.println("Running Ex1Application using new algorithm... ");

			if (args.length == 0) {
				System.err.println("Please, inform a maximum number");
				return;
			}

			PredicateEvaluator eval15 = new PredicateEvaluator(15, "Visual Nuts");
			PredicateEvaluator eval3 = new PredicateEvaluator(3, "Visual");
			PredicateEvaluator eval5 = new PredicateEvaluator(5, "Nuts");
			PredicateEvaluator eval1 = new PredicateEvaluator(1, "") {
				@Override
				public String getContent(int divident) {
					return String.valueOf(divident);
				}
			};

			List<PredicateEvaluator> evaluators = Arrays.asList(eval15, eval3, eval5, eval1);

			int max = Integer.parseInt(args[0]);
			IntStream.range(1, max + 1).forEach(num -> {

				String content = evaluators.stream().filter(e -> e.test(num)).findFirst().map(e -> e.getContent(num))
						.orElse("");

				System.out.printf("%s: %s\n", String.format("%" + 3 + "s", num), content);
			});


		};
	}
}
