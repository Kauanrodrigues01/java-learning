package models;

public class Music extends Audio {
    private String album;
    private String artist;
    private String genero;

    public Music(String title, String album, String artist, String genero) {
        super(title);
        this.album = album;
        this.artist = artist;
        this.genero = genero;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public void displayInfo() {
        System.out.println("Título: " + getTitle());
        System.out.println("Álbum: " + album);
        System.out.println("Artista: " + artist);
        System.out.println("Gênero: " + genero);
        System.out.println("Classificação: " + getClassification());
        System.out.println("Total de execuções: " + getTotalReproductions());
        System.out.println("Total de likes: " + getTotalLikes());
        System.out.println("--------------------------");
    }
}