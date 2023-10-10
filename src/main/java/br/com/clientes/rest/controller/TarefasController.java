package br.com.clientes.rest.controller;

import br.com.clientes.model.entity.Tarefa;
import br.com.clientes.model.repository.TarefaRepository;
import br.com.clientes.rest.exception.UsuarioCadastradoException;
import br.com.clientes.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin("http://localhost:4200")
public class TarefasController {

    private final TarefaRepository repository;
    private final TarefaService service;


    @Autowired
    public TarefasController(TarefaRepository repository, TarefaService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<Tarefa> obterTodos() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa salvar(@RequestBody @Valid Tarefa tarefa) {
        try {
            return service.salvar(tarefa);
        } catch (UsuarioCadastradoException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("{id}")
    public Tarefa acharPorId(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        repository.findById(id).
                map(tarefa -> {
                    repository.delete(tarefa);
                    return Void.TYPE;
                }).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody Tarefa tarefaAtualizada) {
        repository.findById(id).
                map(tarefa -> {
                    tarefa.setNomeTarefa(tarefaAtualizada.getNomeTarefa());
                    tarefa.setUsuario(tarefaAtualizada.getUsuario());
                    tarefa.setDataInicio(tarefaAtualizada.getDataInicio());
                    tarefa.setDataFim(tarefaAtualizada.getDataFim());
                    tarefa.setStatusTarefa(tarefaAtualizada.getStatusTarefa());
                    return repository.save(tarefa);
                }).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrado"));
    }
}
