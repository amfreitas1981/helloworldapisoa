package br.com.alexandrefreitas.helloworldapisoa;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloWorldApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void mainMethodTest() {
		// Teste para cobrir o método main
		HelloWorldApplication.main(new String[] {});
	}
}
