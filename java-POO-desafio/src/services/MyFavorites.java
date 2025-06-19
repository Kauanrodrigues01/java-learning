package services;

import models.Audio;

import java.util.ArrayList;
import java.util.List;

public class MyFavorites {
    private final List<Audio> favorites = new ArrayList<>();

    public void add(Audio audio) {
        if (!favorites.contains(audio)) {
            favorites.add(audio);
            System.out.println("Adicionado aos favoritos!");
        } else {
            System.out.println("Isto já está favoritado");
        }
    }

    public void remove(Audio audio) {
        favorites.remove(audio);
        System.out.println("Removido dos favoritos");
    }

    public void list() {
        for (Audio audio : favorites) {
            audio.displayInfo();
        }
    }
}