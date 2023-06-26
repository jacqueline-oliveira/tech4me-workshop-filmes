package br.com.tech4me.filmes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.tech4me.filmes.model.Filme;

public interface FilmeRepositorio extends JpaRepository<Filme, Integer> {
    List<Filme> findByOrderByTituloAsc();
	List<Filme> findByTituloContainsIgnoreCaseOrderByTituloAsc(String titulo);
}