package entities;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table( name = "prestiti")
public class Prestito {
    //ATTRIBUTI
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // PK
    @ManyToOne // + prestiti possono essere erogati ad 1 utente;
    @JoinColumn(name ="utente")
    private Utente utente;
    @OneToOne
    private ElementoEditoriale elementoEditoriale;
    @Column(name = "inizio_prestito")
    private LocalDate dataInizioPrestito;
    @Column(name = "prevista_restituzione")
    private LocalDate dataPrevistaRest;
    @Column(name = "effettiva_restituzione")
    private LocalDate dataEffettivaRest;


    //COSTRUTTORE

    public Prestito(Utente utente, ElementoEditoriale elementoEditoriale, LocalDate dataInizioPrestito, LocalDate dataPrevistaRest, LocalDate dataEffettivaRest) {
        this.utente = utente;
        this.elementoEditoriale = elementoEditoriale;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataPrevistaRest = dataPrevistaRest.plusDays(30);
        this.dataEffettivaRest = dataEffettivaRest;
    }

    //GETTERS E SETTERS


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public ElementoEditoriale getElementoEditoriale() {
        return elementoEditoriale;
    }

    public void setElementoPrestato(ElementoEditoriale elementoEditoriale) {
        this.elementoEditoriale = elementoEditoriale;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataPrevistaRest() {
        return dataPrevistaRest;
    }

    public void setDataPrevistaRest(LocalDate dataPrevistaRest) {
        this.dataPrevistaRest = dataPrevistaRest;
    }

    public LocalDate getDataEffettivaRest() {
        return dataEffettivaRest;
    }

    public void setDataEffettivaRest(LocalDate dataEffettivaRest) {
        this.dataEffettivaRest = dataEffettivaRest;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoEditoriale +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataPrevistaRest=" + dataPrevistaRest +
                ", dataEffettivaRest=" + dataEffettivaRest +

                '}';
    }
}
