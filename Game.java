/**
 * The Game class serves as a singleton-like container for the game's core components.
 * There will only ever be one Board, Graphics, Controls, and Laser instance active at a time hence why they are static.
 */

public class Game {
    private static Board gameBoard;
    private static GameGraphics graphics;
    private static Controls controls;
    private static Laser laser;

    public Game(){
        controls = new Controls();
        laser = new Laser(0, 5, 0);
        gameBoard = new Board();
        graphics = new GameGraphics();
        graphics.addMouseListener(controls);

    }
    public static Board getGameBoard(){
        return gameBoard;
    }

    public static GameGraphics getGraphics() {
        return graphics;
    }

    public static Laser getLaser() {
        return laser;
    }
}
