package br.com.clientes.service;

import br.com.clientes.model.entity.Tarefa;
import br.com.clientes.model.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    public Tarefa salvar(Tarefa tarefa) {
        return repository.save(tarefa);
    }
}
