package br.com.tech4me.filmes.telas;

import java.util.List;
import java.util.Scanner;

import br.com.tech4me.filmes.model.Filme;
import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public class TelaListarFilmes implements Tela {
    @Override
    public void executar(Scanner entrada, FilmeRepositorio repositorio) {
        List<Filme> filmes = repositorio.findByOrderByTituloAsc();

        if(filmes.isEmpty()) {
            System.out.println("\nNão há filmes cadastrados.");
            return;
        }

        System.out.println("\n***************************");
        System.out.println("Lista de filmes cadastrados");
        System.out.println("***************************");
        filmes.forEach(System.out::println);
    }
    
}