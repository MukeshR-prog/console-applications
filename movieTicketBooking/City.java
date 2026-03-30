import java.util.*;

class City {
    private String name;
    private List<Theatre> theatres;

    public City(String name) {
        this.name = name;
        this.theatres = new ArrayList<>();
    }

    public String getName() { return name; }

    public void addTheatre(Theatre theatre) {
        theatres.add(theatre);
    }

    public List<Theatre> getTheatres() {
        return theatres;
    }
}