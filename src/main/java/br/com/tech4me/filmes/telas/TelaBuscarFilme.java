package br.com.tech4me.filmes.telas;

import java.util.List;
import java.util.Scanner;

import org.springframework.data.repository.Repository;

import br.com.tech4me.filmes.model.Filme;
import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public class TelaBuscarFilme implements Tela<Filme, Integer> {

    @Override
    public void executar(Scanner entrada, Repository<Filme, Integer> repositorio) {
        System.out.println("\n**************");
        System.out.println("Busca de filme");
        System.out.println("**************");

        System.out.print("Título a procurar: ");
        String busca = entrada.nextLine();

        List<Filme> resultado = ((FilmeRepositorio)repositorio).findByTituloContainsIgnoreCaseOrderByTituloAsc(busca);

        if(resultado.isEmpty()) {
            System.out.println("\nNão foram encontrados filmes com o parâmetro informado.");
            return;
        }

        System.out.println("\nResultado da busca:");
        System.out.println("-------------------");
        resultado.forEach(System.out::println);
        System.out.printf("\n%d filme(s) encontrado(s).\n", resultado.size());
    }
    
}