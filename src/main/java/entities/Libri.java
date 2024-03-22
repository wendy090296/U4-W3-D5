package entities;


    public class Libri extends Biblioteca {
        //ATTRIBUTI
        private String autore;
        private String genere;

        //COSTRUTTORE
        public Libri(long ISBN, String titolo, int annoPubblicazione, int numeroPagine, String genere,String autore) {
            super(ISBN, titolo, annoPubblicazione, numeroPagine);
            this.autore = autore;
            this.genere = genere;
        }

        // GETTERS


        public String getAutore() {
            return autore;
        }

        public String getGenere() {
            return genere;
        }


        @Override
        public String toString() {
            return "entities.Libri{" +
                    "autore='" + autore + '\'' +
                    ", genere='" + genere + '\'' +
                    ", ISBN=" + ISBN +
                    ", titolo='" + titolo + '\'' +
                    ", annoPubblicazione=" + annoPubblicazione +
                    ", numeroPagine=" + numeroPagine +
                    '}';
        }
    }

