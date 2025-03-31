package fi.haagahelia.kudjoibookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fi.haagahelia.kudjoibookstore.controller.BookController;


@SpringBootTest
public class KudjoibookstoreApplicationTests {

	@Autowired
	private BookController controller;

	@Autowired
	public KudjoibookstoreApplicationTests (BookController controller) {
		this.controller = controller;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void controllerLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
