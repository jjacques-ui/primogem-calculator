package app;

import app.menu.Menu;
import app.model.Game;

public class Main {
    public static void main(String[] args) {
        Game genshin = new Game("Genshin Impact");
        Menu menu = new Menu(genshin);

        menu.start();
    }
}
