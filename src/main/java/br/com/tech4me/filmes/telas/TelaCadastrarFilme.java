package br.com.tech4me.filmes.telas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.data.repository.Repository;

import br.com.tech4me.filmes.model.Filme;
import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public class TelaCadastrarFilme implements Tela<Filme, Integer> {

    @Override
    public void executar(Scanner entrada, Repository<Filme, Integer> repositorio) {
        Filme f = new Filme();

        System.out.println("\n*****************");
        System.out.println("Cadastro de filme");
        System.out.println("*****************");

        System.out.print("Título: ");
        f.setTitulo(entrada.nextLine());
        System.out.print("Idioma: ");
        f.setIdioma(entrada.nextLine());
        System.out.print("País de lançamento (sigla): ");
        f.setPaisLancamento(entrada.nextLine());
        System.out.print("Data de lançamento: ");
        f.setDataLancamento(LocalDate.parse(entrada.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.print("Ano de produção: ");
        f.setAno(entrada.nextInt());
        System.out.print("Duração (em minutos): ");
        f.setDuracao(entrada.nextInt());

        entrada.nextLine();// Tira o ENTER

        ((FilmeRepositorio)repositorio).save(f);
        System.out.println("\nFilme cadastrado com sucesso.");
    }
    
}