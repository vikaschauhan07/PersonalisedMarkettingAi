package PersonalisedMarketting.PersonalisedMarketting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.annotations.OpenAPI30;

@SpringBootApplication
@OpenAPIDefinition
@OpenAPI30
public class PersonalisedMarkettingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalisedMarkettingApplication.class, args);
	}

}
