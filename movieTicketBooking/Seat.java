enum SeatStatus {
    AVAILABLE,
    RESERVED,
    BOOKED
}

enum BookingStatus {
    CREATED,
    CONFIRMED,
    CANCELLED
}

class Seat {
    private int row;
    private int col;
    private SeatStatus status;

    public Seat(int row, int col) {
        this.row = row;
        this.col = col;
        this.status = SeatStatus.AVAILABLE;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    public SeatStatus getStatus() { return status; }

    public void reserve() { status = SeatStatus.RESERVED; }
    public void book() { status = SeatStatus.BOOKED; }
    public void release() { status = SeatStatus.AVAILABLE; }
}