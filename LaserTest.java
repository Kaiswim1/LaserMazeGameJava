import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LaserTest {

    private Laser laser;

    @BeforeEach
    public void setup() {
        // Clear pieces and initialize laser before each test
        new Game();
        Game.getGameBoard().getPieces().clear();
        laser = new Laser(0, 0, 0); // start at (0,0), facing right (0°)
    }

    @Test
    public void testReset() {
        laser.moveLaserHopForward();
        laser.reset();

        assertEquals(0, laser.getX(), "X after reset should be initial X");
        assertEquals(0, laser.getY(), "Y after reset should be initial Y");
        assertEquals(0, laser.getDirection(), "Direction after reset should be initial direction");
    }

    @Test
    public void testHopRight() {
        laser = new Laser(0, 0, 0);
        laser.moveLaserHopForward();
        assertEquals(1, laser.getX(), "Laser should move right by 1");
        assertEquals(0, laser.getY(), "Laser Y should not change when moving right");
        laser.moveLaserHopForward();
        assertEquals(2, laser.getX(), "Laser should move right by 1");
        assertEquals(0, laser.getY(), "Laser Y should not change when moving right");
    }

    @Test
    public void testHopLeft() {
        laser = new Laser(6, 0, 180);
        laser.moveLaserHopForward();
        assertEquals(5, laser.getX(), "Laser should move right by 1");
        assertEquals(0, laser.getY(), "Laser Y should not change when moving right");
        laser.moveLaserHopForward();
        assertEquals(4, laser.getX(), "Laser should move right by 1");
        assertEquals(0, laser.getY(), "Laser Y should not change when moving right");
    }

    @Test
    public void testHopDown() {
        laser = new Laser(5, 5, 90);
        laser.moveLaserHopForward();
        assertEquals(5, laser.getX(), "Laser X should not change when moving down");
        assertEquals(6, laser.getY(), "Laser should move down by 1");
        laser.moveLaserHopForward();
        assertEquals(5, laser.getX(), "Laser X should not change when moving down");
        assertEquals(7, laser.getY(), "Laser should move down by 1");
    }

    @Test
    public void testHopUp() {
        laser = new Laser(5, 5, -90);
        laser.moveLaserHopForward();
        assertEquals(5, laser.getX(), "Laser X should not change when moving down");
        assertEquals(4, laser.getY(), "Laser should move down by 1");
    }



    @Test
    public void testIsInBounds() {
        assertTrue(laser.isInBounds(), "Laser should start in bounds");

        laser = new Laser(-1, 0, 0);
        assertFalse(laser.isInBounds(), "Laser with negative X is out of bounds");

        laser = new Laser(Board.getSize(), 0, 0);
        assertFalse(laser.isInBounds(), "Laser beyond board size is out of bounds");
    }
}
