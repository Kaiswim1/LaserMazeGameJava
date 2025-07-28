import java.awt.*;
import java.util.HashMap;
import java.util.Random;
public class Board {

    /**
     * Previously, a HashSet was used to store mirrors, which guaranteed uniqueness but required
     * a linear search to find a mirror at a specific (x, y) coordinate. As a result, every click
     * involved an O(n) operation to locate the correct mirror.
     *
     * This implementation replaces the HashSet with a HashMap, using the mirror's (x, y) coordinates
     * as the key. This allows for O(1) average-time complexity when adding or retrieving mirrors,
     * while still ensuring uniqueness.
     *
     * With a well-implemented hashCode in the Piece class, over 99% of operations remain O(1).
     * However, due to Java's use of hash buckets, there is a small chance of a performance
     * degradation to O(log n) if too many entries collide into a single bucket. In such cases,
     * the internal structure of that bucket is upgraded from a linked list to a balanced
     * Red-Black tree.
     */

    public static class PieceMap extends HashMap<Point, Piece> {
        public void putPiece(Piece piece) {
            this.put(new Point(piece.getX(), piece.getY()), piece);
        }
    }
    private PieceMap pieces;
    private static final int size = 10; //Amount of rows and cols for the grid
    private static final int spacing = 35;

    private Random random;

    public Board(){
        this.pieces = new PieceMap();
        this.random = new Random();
        addPieces();
    }

    /**
     * Generates 45 mirrors at a random location with a random angle in multiples of 45 degrees.
     */
    public void addPieces(){
        while (pieces.size()<=45) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            //Makes sure the piece doesn't spawn on the
            if(x == Game.getLaser().getStartX() && y == Game.getLaser().getStartY()) continue;
            Piece p = new Piece(x, y, random.nextInt(8) * 45);
            pieces.putPiece(p);
        }
    }

    public static int getSpacing() {
        return spacing;
    }

    public PieceMap getPieces() {
        return pieces;
    }

    public static int getSize() {
        return size;
    }
}
