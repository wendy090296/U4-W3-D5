package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "findByYear", query = "SELECT el FROM ElementoBibliografico el WHERE EXTRACT(YEAR FROM el.anno_pubblicazione) = :anno")
@NamedQuery(name = "findByAuthor", query = "SELECT el FROM Libro el WHERE LOWER(el.autore) LIKE LOWER(CONCAT('%', :autore, '%' ")
@NamedQuery(name = "findByTitle", query = "SELECT el FROM ElementoEditoriale el  WHERE LOWER(el.titolo) LIKE LOWER(CONCAT('%', :titolo, '%'))")
public  class ElementoEditoriale {
    // ATTRIBUTI


    @Id
    protected long ISBN;
    protected  String titolo;
    protected int annoPubblicazione;
    protected int numeroPagine;


    // COSTRUTTORE

    public ElementoEditoriale(){}

    public ElementoEditoriale(long ISBN, String titolo, int annoPubblicazione, int numeroPagine){
        this.ISBN=ISBN;
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
        return "ElementoEditoriale{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
