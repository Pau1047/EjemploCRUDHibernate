package com.example.ejemplocrudhibernate;

import com.example.ejemplocrudhibernate.models.dao.NadadorDAO;
import com.example.ejemplocrudhibernate.models.entity.Nadador;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjemploCrudHibernateApplication {

    @Bean
    public CommandLineRunner commandLineRunner(NadadorDAO nadadorDAO) {
        return runner -> {
            Nadador nadador = new Nadador("Juan",1234,23,"juan@juan");
            createNadador(nadadorDAO,nadador);

            findidNadador(nadadorDAO,nadador);
            updateNadador(nadadorDAO,nadador);

        };
    }

    public static void main(String[] args) {

        SpringApplication.run(EjemploCrudHibernateApplication.class, args);
    }
    private void createNadador(NadadorDAO nadadorDAO, Nadador nadador) {
        System.out.println("Creando un nuevo nadador...");
        nadadorDAO.save(nadador);

    }

    private void findidNadador(NadadorDAO nadadorDAO, Nadador nadador){
        System.out.println("Id: " + nadador.getId());
    }
    private void deleteNadador(NadadorDAO nadadorDAO, Nadador nadador){
        System.out.println("Borrando Nadador...");
        nadadorDAO.delete(nadador.getId());
    }

    private void updateNadador(NadadorDAO nadadorDAO, Nadador nadador){
        nadador.setNombre("pau");
        nadadorDAO.update(nadador);
    }
}
