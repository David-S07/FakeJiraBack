package br.com.clientes.rest.exception;

public class UsuarioCadastradoException extends RuntimeException {

    public UsuarioCadastradoException(String cpf) {
        super("CPF " + cpf + " já cadastrado ! ");
    }
}
