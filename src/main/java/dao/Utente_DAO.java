package dao;

import entities.Prestito;
import entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class Utente_DAO {
    private final EntityManager em;
    public Utente_DAO(EntityManager em){
        this.em=em;
    }
    public void save(Utente utente) {
        try{
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(utente);
            tx.commit();
            System.out.println(utente.getCognome() + utente.getNome() + " salvato!");
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Utente getById(int id) {
        return em.find(Utente.class, id);
    }

    public void delete(Utente utente) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(utente);
        tx.commit();
        System.out.println(utente.getCognome() + utente.getNome()+  " é stato eliminato!");
    }



}

