package entities;

import jakarta.persistence.*;


    public abstract class Biblioteca {
    // ATTRIBUTI

        protected long ISBN;
        protected  String titolo;
        protected int annoPubblicazione;
        protected int numeroPagine;


        // COSTRUTTORE


        public Biblioteca(String titolo, int annoPubblicazione, int numeroPagine){
            this.titolo=titolo;
            this.annoPubblicazione=annoPubblicazione;
            this.numeroPagine=numeroPagine;


        }

// GETTERS E SETTERS


        public long getISBN() {
            return ISBN;
        }

        public String getTitolo() {
            return titolo;
        }

        public int getAnnoPubblicazione() {
            return annoPubblicazione;
        }

        public int getNumeroPagine() {
            return numeroPagine;
        }

        @Override
        public String toString() {
            return "entities.Biblioteca{" +
                    "ISBN=" + ISBN +
                    ", titolo='" + titolo + '\'' +
                    ", annoPubblicazione=" + annoPubblicazione +
                    ", numeroPagine=" + numeroPagine +
                    '}';
        }
    }

