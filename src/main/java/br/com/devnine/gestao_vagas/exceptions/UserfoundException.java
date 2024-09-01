package br.com.devnine.gestao_vagas.exceptions;

public class UserfoundException extends RuntimeException {
    public UserfoundException() {
        super("Username or email already exists");
    }
}
