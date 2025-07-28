/**
 * How the laser works:
 * Step 1: The Laser pointer will have a starting point. Each time the laser will hop on a section and check if it had landed on a piece.
 * Step 2: It will check that piece's rotation and set the hop x and y direction accordingly.
 * Step 3: Once we either hop off from the grid or onto the finish line, we will use all the angles to draw specific laser sections and images.
 */
import java.awt.Point;
public class Laser {
    private int hopX, hopY;

    private int startX, startY, startDirection;
    private int direction, oldDirection; //No setters or getters, it is the previous hop direction.

    public Laser(int x, int y, int direction){
        hopX = startX = x;
        hopY = startY = y;
        this.direction = startDirection = direction;
    }

    public int getStartY() {
        return startY;
    }

    public int getStartX() {
        return startX;
    }

    public void reset(){
        hopX = startX;
        hopY = startY;
        direction = oldDirection = startDirection;
    }

    private void hop() {
        double angleRad = Math.toRadians(direction);
        hopX += (int) Math.round(Math.cos(angleRad));
        hopY += (int) Math.round(Math.sin(angleRad));
    }

    public int getOldXHop(){
        double angleRad = Math.toRadians(oldDirection);
        return (int) Math.round(Math.cos(angleRad));
    }

    public int getOldYHop(){
        double angleRad = Math.toRadians(oldDirection);
        return (int) Math.round(Math.sin(angleRad));
    }

    // Optional getters
    public int getX() { return hopX; }
    public int getY() { return hopY; }

    public int getDirection() {
        return direction;
    }

    private Piece getPieceAt(int x, int y) {
        return Game.getGameBoard().getPieces().get(new Point(x, y));
    }

    public boolean isTouchingPiece(){
        return getPieceAt(hopX, hopY) != null;
    }

    public void moveLaserHopForward(){
        oldDirection = direction;
        hop();
        Piece p = getPieceAt(hopX, hopY);
        if (p != null) {
            direction = (2 * p.getRotation() - direction + 360) % 360;
        }
    }

    /**
     * Checks if the current laser position is within the bounds of the board.
     * @return true if in bounds, false otherwise.
     */
    public boolean isInBounds() {
        return hopX >= 0 && hopX < Board.getSize() && hopY >= 0 && hopY < Board.getSize();
    }
}
