package entities;

import java.time.LocalDate;

public class Prestito {
    //ATTRIBUTI
    private Utente utente;
    private Biblioteca elementoPrestato;
    private LocalDate dataInizioPrestito;
    private LocalDate dataPrevistaRest;
    private LocalDate dataEffettivaRest;

    //COSTRUTTORE


    public Prestito(Utente utente, Biblioteca elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataPrevistaRest, LocalDate dataEffettivaRest) {
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataPrevistaRest = dataPrevistaRest;
        this.dataEffettivaRest = dataEffettivaRest;
    }

    //GETTERS E SETTERS


    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Biblioteca getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(Biblioteca elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
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
}
