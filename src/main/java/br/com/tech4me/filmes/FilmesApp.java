package br.com.tech4me.filmes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.tech4me.filmes.telas.LoopPrincipal;

@SpringBootApplication
public class FilmesApp implements CommandLineRunner {
	@Autowired
	private LoopPrincipal loopPrincipal;

	public static void main(String[] args) {
		SpringApplication.run(FilmesApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loopPrincipal.loop();
		System.exit(0);
	}
}