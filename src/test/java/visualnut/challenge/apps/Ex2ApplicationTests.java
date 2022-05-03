package visualnut.challenge.apps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import visualnut.challenge.ex2Application.config.SwaggerConfig;
import visualnut.challenge.ex2Application.config.WebConfig;
import visualnut.challenge.ex2Application.controller.CountryController;
import visualnut.challenge.ex2Application.controller.ResponseHelper;
import visualnut.challenge.ex2Application.service.CountryService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Ex2Application.class)
public class Ex2ApplicationTests {
	@Autowired
	private CountryController controller;
	@Autowired
	private ResponseHelper helper;
	@Autowired
	private SwaggerConfig swaggerConfig;
	@Autowired
	private WebConfig webConfig;
	@Autowired
	private CountryService countryService;

	@Test
	public void contextLoads() throws Exception {
		Assertions.assertNotNull(controller);
		Assertions.assertNotNull(helper);
		Assertions.assertNotNull(swaggerConfig);
		Assertions.assertNotNull(webConfig);
		Assertions.assertNotNull(countryService);
	}

}
