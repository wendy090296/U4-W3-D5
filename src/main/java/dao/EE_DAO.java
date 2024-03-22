package dao;

import entities.ElementoEditoriale;
import entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;

public class EE_DAO {
    private final EntityManager em;

    public EE_DAO(EntityManager em) {
        this.em = em;
    }

    public void save(ElementoEditoriale elementoEditoriale){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin(); //inizio transazione
            em.persist(elementoEditoriale); //SALVATAGGIO NEL PERS. CONTEXT
            transaction.commit(); // AGGIUNTA AL P.C.
            System.out.println("Elemento salvato!");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }



    public ElementoEditoriale findByISBN(long ISBN){
        return em.find(ElementoEditoriale.class, ISBN);
    }
    public void deleteByISBN(long ISBN){
        try {
            EntityTransaction tx = em.getTransaction();
            ElementoEditoriale found = em.find(ElementoEditoriale.class, ISBN);
            if (found != null) {
                tx.begin();
                em.remove(found);
                tx.commit();
                System.out.println("Elemento eliminato");
            } else System.out.println("Elemento non trovato");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<ElementoEditoriale> findByYear (int anno){
        TypedQuery<ElementoEditoriale> query = em.createNamedQuery("findByYear", ElementoEditoriale.class);
        query.setParameter("annoPubblicazione",anno);
        return query.getResultList();
    }

    public List<ElementoEditoriale> findByAuthor(String autore){
        TypedQuery<ElementoEditoriale> query = em.createNamedQuery("findByAuthor", ElementoEditoriale.class);
        query.setParameter("autore", autore);
        return  query.getResultList();
    }
public List<ElementoEditoriale> findBYTitle(String titolo){
        TypedQuery<ElementoEditoriale> query= em.createNamedQuery("findByTitle", ElementoEditoriale.class);
                query.setParameter("titolo",titolo);
        return query.getResultList();
}

}


