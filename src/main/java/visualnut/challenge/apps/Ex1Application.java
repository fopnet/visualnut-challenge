package visualnut.challenge.apps;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import visualnut.challenge.ex1Application.PredicateEvaludatorList;

@Configuration
@SpringBootApplication(scanBasePackageClasses = {
		Ex1Application.class }, scanBasePackages = "visualnut.challenge.ex1Application")
@Slf4j
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args).close();
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			log.info("\nRunning Ex1Application using new algorithm... \n");

			if (args.length == 0) {
				log.error("Please, inform a maximum number \n");
				return;
			}

			int max = Integer.parseInt(args[0]);
			// List<String> beans = Arrays.stream(ctx.getBeanDefinitionNames())
			// 		.sorted(Comparator.naturalOrder())
			// 		.collect(Collectors.toList());

			// beans.forEach(System.out::println);

			PredicateEvaludatorList bean = ctx.getBean(PredicateEvaludatorList.class);

			IntStream.range(1, max + 1).forEach(num -> {

				String content = bean.getContent(num);

				log.trace(String.format("%" + 3 + "s: %s%n", num, content));
			});

		};
	}
}
