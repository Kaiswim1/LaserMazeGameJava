import javax.swing.*;
import java.awt.*;

/**
 * @annotation: RequireGraphics forces all methods in the class to contain a java.awt.Graphics parameter.
 */
@RequireGraphics
public class GameGraphics extends JFrame {

    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;
    private static final int LASER_STEPS = 100; // Number of laser hops to draw
    private static final int LASER_STEP_INCREMENT = 5; // Step size for laser drawing
    private static final int PIECE_LINE_LENGTH = 30;
    private static final float PIECE_LINE_THICKNESS = 7f;
    private static final int LASER_POINT_SIZE = 5;

    public GameGraphics() {
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
        setFocusable(true);
        setVisible(true);

        // Create and add a custom JPanel for all drawing operations
        add(new GamePanel());
    }

    // Extracted JPanel subclass for better readability and maintainability
    private class GamePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.BLACK);
            drawGrid(g, Board.getSize(), Board.getSpacing());

            drawAllPieces(g, Game.getGameBoard());

            g.setColor(Color.RED);
            Game.getLaser().reset();

            // Draw the laser path step-by-step
            for (int i = 0; i < LASER_STEPS; i++) {
                drawLaserPoint(g, Game.getLaser());
                drawEntireLaser(g, Game.getLaser());
                Game.getLaser().moveLaserHopForward();
            }
        }
    }

    /**
     * Draws the grid lines for the board.
     *
     * @param g       The graphics context
     * @param amount  Number of grid cells (rows/columns)
     * @param spacing Distance between grid lines in pixels
     */
    private void drawGrid(Graphics g, int amount, int spacing) {
        for (int i = 0; i < amount + 1; i++) {
            g.drawLine(i * spacing, 0, i * spacing, spacing * amount);      // Vertical lines
            g.drawLine(0, i * spacing, spacing * amount, i * spacing);      // Horizontal lines
        }
    }

    /**
     * Draws a line centered at (centerX, centerY) with specified angle, length, and thickness.
     *
     * @param g              Graphics context
     * @param angleInDegrees Angle of the line in degrees
     * @param centerX        X coordinate of line center
     * @param centerY        Y coordinate of line center
     * @param length         Length of the line
     * @param thickness      Thickness of the line stroke
     */
    private void drawLineAtAngle(Graphics g, int angleInDegrees, int centerX, int centerY, int length, float thickness) {
        Graphics2D g2d = (Graphics2D) g.create(); // Create copy to not affect original graphics
        g2d.setStroke(new BasicStroke(thickness)); // Set stroke thickness

        double angleRad = Math.toRadians(angleInDegrees);
        int halfLength = length / 2;

        // Calculate start and end points so the line is centered at (centerX, centerY)
        int offsetX = (int) (halfLength * Math.cos(angleRad));
        int offsetY = (int) (halfLength * Math.sin(angleRad));
        int startX = centerX - offsetX;
        int startY = centerY - offsetY;
        int endX = centerX + offsetX;
        int endY = centerY + offsetY;

        g2d.drawLine(startX, startY, endX, endY);
        g2d.dispose(); // Dispose the copy to free resources
    }


    /**
     * Draws all pieces on the board.
     *
     * @param g Graphics context
     * @param b The game board containing pieces
     */
    private void drawAllPieces(Graphics g, Board b) {
        int offset = Board.getSpacing() / 2; // Center pieces in grid cell

        for (Piece p : b.getPieces().values()) {
            int x = p.getX() * Board.getSpacing() + offset;
            int y = p.getY() * Board.getSpacing() + offset;

            // Draw a thick line representing the piece's rotation
            drawLineAtAngle(g, p.getRotation(), x, y, PIECE_LINE_LENGTH, PIECE_LINE_THICKNESS);
        }
    }

    /**
     * Draws a small square representing the laser's current position.
     *
     * @param g Graphics context
     * @param l The laser object with current position
     */
    private void drawLaserPoint(Graphics g, Laser l) {
        int offset = Board.getSpacing() / 2;
        int x = l.getX() * Board.getSpacing() + offset;
        int y = l.getY() * Board.getSpacing() + offset;

        g.fillRect(x, y, LASER_POINT_SIZE, LASER_POINT_SIZE);
    }

    /**
     * Draws the laser trail behind the current laser position.
     * Note: This uses a fixed pattern for simplicity.
     *
     * @param g Graphics context
     * @param l The laser object
     */
    private void drawEntireLaser(Graphics g, Laser l) {
        int offset = Board.getSpacing() / 2;
        int x = l.getX() * Board.getSpacing() + offset;
        int y = l.getY() * Board.getSpacing() + offset;

        // Draw laser trail segments behind laser position in x and y directions
        for (int i = 1; i < 35; i += LASER_STEP_INCREMENT) {
            g.fillRect(x - (i * l.getOldXHop()), y, LASER_POINT_SIZE, LASER_POINT_SIZE);
            g.fillRect(x, y - (i * l.getOldYHop()), LASER_POINT_SIZE, LASER_POINT_SIZE);
        }
    }
}
