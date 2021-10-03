package br.com.lirvraira.springbootapi;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.lirvraira.springbootapi.model.Livro;
import br.com.lirvraira.springbootapi.repository.LivroRepository;

@SpringBootApplication
public class SpringbootApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApiApplication.class, args);
	}
	@Bean
	CommandLineRunner init(LivroRepository repository) {
		return args->{
			Livro l = new Livro();
			l.setAutor("Autor Genérico");
			l.setGenero("Terror");
			l.setNome("Carmila");
			l.setSinopse("Livro de vampiro gótico do século retrasado");
			repository.save(l);


		};

	}

}
