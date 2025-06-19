import models.*;
import services.MyFavorites;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando músicas
        Music song1 = new Music("Música1", "Orochi", "Orochi", "Trap");
        Music song2 = new Music("Música2", "Don L", "Don L", "Rap");

        // Criando podcasts
        Podcast podcast1 = new Podcast("Flow Podcast", "Igor", "Entrevistas com personalidades brasileiras");
        Podcast podcast2 = new Podcast("DevCast", "João Dev", "Tecnologia e programação");

        // Simulando execuções e curtidas
        simulateAudio(song1, 100);
        simulateAudio(song2, 70);
        simulateAudio(podcast1, 80);
        simulateAudio(podcast2, 40);

        // Exibindo todas as mídias
        List<Audio> catalog = List.of(song1, song2, podcast1, podcast2);
        System.out.println("==== CATÁLOGO COMPLETO ====");
        catalog.forEach(Audio::displayInfo);

        // Gerenciando favoritos
        MyFavorites favorites = new MyFavorites();
        System.out.println("\n==== FAVORITANDO CONTEÚDOS ====");
        favorites.add(song1);
        favorites.add(podcast2);
        favorites.add(song1);  // teste: já está favoritado

        // Listando favoritos
        System.out.println("\n==== LISTA DE FAVORITOS ====");
        favorites.list();
    }

    private static void simulateAudio(Audio audio, int times) {
        for (int i = 0; i < times; i++) {
            audio.reproduce();
            if (i % 3 == 0) {  // 1/3 das execuções recebem likes
                audio.like();
            }
        }
    }
}

