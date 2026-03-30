class Screen {
    private String name;
    private int rows;
    private int cols;

    public Screen(String name, int rows, int cols) {
        this.name = name;
        this.rows = rows;
        this.cols = cols;
    }

    public String getName() { return name; }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}