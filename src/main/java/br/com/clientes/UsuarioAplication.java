package br.com.clientes;

import br.com.clientes.model.entity.Usuario;
import br.com.clientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsuarioAplication {

    @Bean
    public CommandLineRunner run(@Autowired UsuarioRepository repository){
        return args -> {
            Usuario usuario1 = Usuario.builder().cpf("54189819514").nome("Fulano").build();
            Usuario usuario2 = Usuario.builder().cpf("23638636151").nome("Ciclano Freitas").build();
            Usuario usuario3 = Usuario.builder().cpf("48799040905").nome("David Santana").build();
            repository.save(usuario1);
            repository.save(usuario2);
            repository.save(usuario3);
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(UsuarioAplication.class, args);
    }
}
