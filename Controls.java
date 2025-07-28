import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;

/**
 * The Controls class stores all the logic required to control the game using the mouse.
 * Since all the controls are mouse-based, all method parameters require java.awt.Graphics.
 * You can click on a mirror on the grid to rotate it.
 */

@RequireMouse
public class Controls implements MouseListener {

    private int mouseGridX(MouseEvent e){return (int)Math.floor(e.getX() / Board.getSpacing());}
    private int mouseGridY(MouseEvent e){return (int)Math.floor(e.getY() / Board.getSpacing()-1);}


    private Piece getTargetPiece(MouseEvent e){
        return Game.getGameBoard().getPieces().get(new Point(mouseGridX(e), mouseGridY(e)));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(getTargetPiece(e)==null)return; //prevent null
        getTargetPiece(e).rotateRight();
        Game.getGraphics().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
