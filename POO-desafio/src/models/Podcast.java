package models;

public class Podcast extends Audio {
    private String host;
    private String description;

    public Podcast(String title, String host, String description) {
        super(title);
        this.host = host;
        this.description = description;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void displayInfo() {
        System.out.println("Título: " + getTitle());
        System.out.println("Descrição: " + description);
        System.out.println("Host: " + host);
        System.out.println("Classificação: " + getClassification());
        System.out.println("Total de execuções: " + getTotalReproductions());
        System.out.println("Total de likes: " + getTotalLikes());
        System.out.println("--------------------------");
    }
}