package br.com.contact.exception;

public class EntidadeNaoEncontradaException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String message){
        super(message);
    }
}
