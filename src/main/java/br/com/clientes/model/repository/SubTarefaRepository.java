package br.com.clientes.model.repository;

import br.com.clientes.model.entity.SubTarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTarefaRepository extends JpaRepository<SubTarefa, Integer> {
}
