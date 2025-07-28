
public class Piece {
    private final int x;
    private final int y;
    private int rotation;

    public Piece(int x, int y, int rotation) {
        this.x = x;
        this.y = y;
        setRotation(rotation); // Apply rotation validation
    }
    public void setRotation(int rotation) {
        if (rotation % 45 != 0) throw new IllegalArgumentException("The Argument rotation must be a multiple of 45"); // Only allow valid multiples
        this.rotation = rotation;
    }

    public void rotateRight(){
        this.rotation = (this.rotation + 45) % 360;
    }

    public int getRotation() {
        return rotation;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Piece)) return false;
        Piece piece = (Piece) o;
        return x == piece.x &&
                y == piece.y;
    }

    public boolean equals(int x, int y){
        return this.x == x && this.y == y;
    }


    /**
     * I used a prime number that the multiplication operation can be bit-shifted.
     * This encourages even distribution in the HashMap preventing collisions.
     * A classic hash function for two integers. Objects.hash(x, y) is overkill for
     * primitive data types.
     * @return
     */
    @Override
    public int hashCode() {
        return 31 * x + y;
    }


}
