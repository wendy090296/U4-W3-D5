package entities;


import enumerated.Periodicità;
import jakarta.persistence.*;

@Entity
@Table(name = "riviste")
public class Rivista extends ElementoEditoriale {
    //ATTRIBUTI

    @Enumerated(EnumType.STRING)
        private Periodicità periodicità;

    //COSTRUTTORI

public Rivista(){}


    public Rivista(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
            super(ISBN,titolo, annoPubblicazione, numeroPagine);
            this.periodicità=periodicità;

        }

        @Override
        public String toString() {
            return "Rivista{" +
                    "periodicità=" + periodicità +
                    ", ISBN=" + ISBN +
                    ", titolo='" + titolo + '\'' +
                    ", annoPubblicazione=" + annoPubblicazione +
                    ", numeroPagine=" + numeroPagine +
                    '}';
        }
    }

