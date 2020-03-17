package com.example.dicerollerapp.MenuItem;

public class ItemMenu {

    String titulo;
    int imagem;
    Class activityDestination;

    public ItemMenu(String titulo, int imagem, Class activityDestination) {
        this.titulo = titulo;
        this.imagem = imagem;
        this.activityDestination = activityDestination;
    }
}
