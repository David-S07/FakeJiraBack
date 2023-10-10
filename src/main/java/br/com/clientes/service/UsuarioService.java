package br.com.clientes.service;

import br.com.clientes.model.entity.Usuario;
import br.com.clientes.model.repository.UsuarioRepository;
import br.com.clientes.rest.exception.UsuarioCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        Boolean exists = repository.existsByCpf(usuario.getCpf());
        if (exists && usuario.getCpf() != null) {
            throw new UsuarioCadastradoException(usuario.getCpf());
        }
        return repository.save(usuario);
    }
}
