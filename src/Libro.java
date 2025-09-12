public class Libro {
        private int ID;
        private String titulo;
        private String autor;
        private int añopublic;
        private String genero;
        private boolean disponible;

        public Libro(int ID, String titulo, String autor, int añopublic, String genero) {
            this.ID =ID;
            this.titulo = titulo;
            this.autor = autor;
            this.añopublic = añopublic;
            this.genero = genero;
            this.disponible = true;
        }

        // Getters
        public int getId() {
            return ID;
        }

        public String getTitulo() {
            return titulo;
        }

        public String getAutor() {
            return autor;
        }

        public int getAñopublic() {
            return añopublic;
        }

        public String getGenero() {
            return genero;
        }

        public boolean isDisponible() {
            return disponible;
        }

        // Setters
        public void setDisponible(boolean disponible) {
            this.disponible = disponible;
        }

        @Override
        public String toString() {
            return "Libro" + "ID:" + ID + ", Titulo:'" + titulo + '\'' + ", autor:'" + autor + '\'' + ", Año de publicación:" + añopublic + ", Genero:'" + genero + '\'' + ", Disponible:" + (disponible ? "Sí" : "No") + '}';
        }
    }


