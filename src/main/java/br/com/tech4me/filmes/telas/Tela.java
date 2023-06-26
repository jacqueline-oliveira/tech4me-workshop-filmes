package br.com.tech4me.filmes.telas;

import java.util.Scanner;

import br.com.tech4me.filmes.repositorios.FilmeRepositorio;

public interface Tela {
    void executar(Scanner entrada, FilmeRepositorio repositorio);
}

