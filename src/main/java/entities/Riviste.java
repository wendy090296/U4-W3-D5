package entities;


import enumerated.Periodicità;

public class Riviste extends Biblioteca {
        private Periodicità periodicità;

        public Riviste(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
            super(ISBN, titolo, annoPubblicazione, numeroPagine);
            this.periodicità=periodicità;

        }

        @Override
        public String toString() {
            return "entities.Riviste{" +
                    "periodicità=" + periodicità +
                    ", ISBN=" + ISBN +
                    ", titolo='" + titolo + '\'' +
                    ", annoPubblicazione=" + annoPubblicazione +
                    ", numeroPagine=" + numeroPagine +
                    '}';
        }
    }

