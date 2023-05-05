package io.github.curso.msavaliadorcredito.application.ex;

public class ErroSolicitacaoCartaoException extends RuntimeException{
    public ErroSolicitacaoCartaoException(String msg) {
        super(msg);
    }
}