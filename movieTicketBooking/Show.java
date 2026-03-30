class Show {
    private Movie movie;
    private Screen screen;
    private String time;
    private Seat[][] seats;

    public Show(Movie movie, Screen screen, String time) {
        this.movie = movie;
        this.screen = screen;
        this.time = time;

        seats = new Seat[screen.getRows()][screen.getCols()];

        for (int i = 0; i < screen.getRows(); i++) {
            for (int j = 0; j < screen.getCols(); j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }

    public Movie getMovie() { return movie; }
    public String getTime() { return time; }

    public Seat getSeat(int r, int c) {
        return seats[r][c];
    }

    public boolean isValidSeat(int r, int c) {
        return r >= 0 && r < seats.length && c >= 0 && c < seats[0].length;
    }

    public void displaySeats() {
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                System.out.print(
                    seats[i][j].getStatus() == SeatStatus.AVAILABLE ? "A " : "X "
                );
            }
            System.out.println();
        }
    }
}