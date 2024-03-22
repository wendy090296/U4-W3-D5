package dao;

import entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class Prestito_DAO {
    private final EntityManager em;
    public Prestito_DAO(EntityManager em){
        this.em=em;
    }
    public void save(Prestito prestito) {
        try{
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(prestito);
            tx.commit();
            System.out.println(prestito.getElementoEditoriale().getTitolo() + " salvato!");
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Prestito getById(int id) {
        return em.find(Prestito.class, id);
    }

    public void delete(Prestito prestito) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.remove(prestito);
        tx.commit();
        System.out.println(prestito.getElementoEditoriale() + " é stato eliminato!");
    }

    public List<Prestito> findLoanByCardNumUser(int numeroTessera){
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera", Prestito.class);
                query.setParameter("numeroTessera",numeroTessera);
        return query.getResultList();
    }

    public List<Prestito> expiredLoans (LocalDate localDate){
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM p WHERE p.dataEffettivaRest IS NULL",Prestito.class);
        query.setParameter("LocalDate",localDate);
        return query.getResultList();
    }

}
