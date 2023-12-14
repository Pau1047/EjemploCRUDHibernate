package com.example.ejemplocrudhibernate.models.dao;

import com.example.ejemplocrudhibernate.models.entity.Nadador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class NadadorDAOImpl implements NadadorDAO{

    private EntityManager entityManager;

    @Autowired
    public NadadorDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Transactional
    @Override
    public void save(Nadador theNadador) {
        entityManager.persist(theNadador);
    }



    @Transactional
    @Override
    public void delete(int id) {
        entityManager.remove(findbyid(id));
    }
    @Transactional
    @Override
    public void update(Nadador theNadador) {
        entityManager.merge(theNadador);
    }

    @Override
    public Nadador findbyid(int id) {
        return entityManager.find(Nadador.class, id);
    }

    @Override
    public List<Nadador> findAll(){
        TypedQuery<Nadador> theQuery = entityManager.createQuery("FROM Nadador", Nadador.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Nadador> findByEmail(String email){
        TypedQuery<Nadador> theQuery = entityManager.createQuery("FROM Nadador where email=:thedata", Nadador.class);
        theQuery.setParameter("thedata",email);
        return theQuery.getResultList();
    }

    @Transactional
    @Override
    public void deleteAll(){
         entityManager.createQuery("DELETE FROM Nadador ").executeUpdate();
    }

}
