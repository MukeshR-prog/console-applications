import java.util.*;

class Theatre {
    private String name;
    private List<Screen> screens;

    public Theatre(String name) {
        this.name = name;
        this.screens = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addScreen(Screen screen) {
        screens.add(screen);
    }

    public List<Screen> getScreens() {
        return screens;
    }
}