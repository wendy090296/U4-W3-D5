package entities;

import dao.EE_DAO;
import dao.Prestito_DAO;
import dao.Utente_DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
   public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4w3d5");
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        EE_DAO eedao = new EE_DAO(em);
        Prestito_DAO pdao = new Prestito_DAO(em);
        Utente_DAO udao = new Utente_DAO(em);

        //********************* CREAZIONE E SALVATAGGIO LIBRI E RIVISTE AL CATALOGO ******************

        Libro libro1 = new Libro(1226644890, "Guerra e Pace", 1869, 1415, "Lev Nikolaevic Tolstoj", "romanzo storico");
        Libro libro2 = new Libro(705558812, "Cent'anni di solitudine", 1967, 384, "Gabriel Garcia Marquez", "narrativa epica");
        Libro libro3 = new Libro(978178166, "Dr. Jekyll and Mr.Hyde", 1948, 128, "Robert Louis Stevenson", "fantasy");
        Libro libro4 = new Libro(384459253, "Il Barone Rampante", 1957, 312, "Italo Calvino", "narrativa");



        Rivista rivista1 = new Rivista(426589016, "Internazionale", 1993, 67, Periodicità.SETTIMANALE);
        Rivista rivista2 = new Rivista(900102331, "Focus", 1992, 100, Periodicità.MENSILE);
        Rivista rivista3 = new Rivista(786002054, "Donna Moderna", 1988, 87, Periodicità.SETTIMANALE);
        Rivista rivista4 = new Rivista(673111790, "Undici", 2000, 40, Periodicità.SETTIMANALE);

        // AGGIUNTA AL CATALOGO DEGLI ELEMENTI

//        eedao.save(libro1);
//        eedao.save(libro2);
//        eedao.save(libro3);
//        eedao.save(libro4);
//        eedao.save(rivista1);
//        eedao.save(rivista2);
//        eedao.save(rivista3);
//        eedao.save(rivista4);

        //****************************** CREAZIONE E SALVATAGGIO UTENTI E PRESTITI *******************************

        Utente utente1 = new Utente("Monica","Bellucci", LocalDate.of(1964,9,24),1234567890);
        Utente utente2 = new Utente("Vanessa","Incontrada", LocalDate.of(1978,11,24),764321679);
        Utente utente3 = new Utente("Paola","Cortellesi", LocalDate.of(1973,5,11),446809111);
        Utente utente4 = new Utente("Raoul","Bova", LocalDate.of(1971,8,14),779024315);
        udao.save(utente1);
        udao.save(utente2);
        udao.save(utente3);
        udao.save(utente4);

        Prestito p1 = new Prestito(utente1,libro1,LocalDate.of(2024,1,1),LocalDate.of(2024,6,1),LocalDate.of(2024,9,30));
        Prestito p2 = new Prestito(utente2,libro2,LocalDate.of(2023,3,9),LocalDate.of(2024,1,31),LocalDate.of(2024,5,30));
        Prestito p3 = new Prestito(utente3,libro3,LocalDate.of(2022,2,1),LocalDate.of(2024,2,1),LocalDate.of(2024,1,25));
        pdao.save(p1);
        pdao.save(p2);
        pdao.save(p3);




        // RICERCA PER ISBN
        System.out.println(eedao.findByISBN(673111790));

        // RIMOZIONE PER ISBN
       eedao.deleteByISBN(384459253);

        // RICERCA PER ANNO
        System.out.println(eedao.findByYear(2000));


        //.. PER AUTORE
        System.out.println(eedao.findByAuthor("Italo Calvino"));


        //..PER TITOLO
        System.out.println(eedao.findBYTitle("Cent'anni di solitudine"));

        // RICERCA ELEMENTI IN PRESTITO CON NUMERO TESSERA

        System.out.println(pdao.findLoanByCardNumUser(779024315));

        // RICERCA PRESTITI SCADUTI E NON RESTITUITI
        System.out.println(pdao.expiredLoans(LocalDate.of(2024,9,30)));



        em.close();
        emf.close();



    }
}
