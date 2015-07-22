import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/**
 * An abstract class for Classic Layout and Custom Layout.
 * It holds the basic structure
 * @author Sung Chi, Hoai Nguyen, Zhining Qi
 *
 */
public abstract class BoardLayout {

	protected Rectangle2D.Double[][] pitRects;
	protected int width;
	protected int height;
	/**
	 * Constructor that creates the layout of the game
	 * @param nPlayers the number of players
	 * @param boardLength the number of pits
	 */
	public BoardLayout(int nPlayers, int boardLength)
	{
		pitRects = new Rectangle2D.Double[nPlayers][boardLength];
	}

	/**
	 * Abstract method that redraws the board
	 * @param g Graphics element
	 * @param b the board object for drawing images
	 * @param pits the pits
	 * @param mancalas the mancalas
	 */
	public abstract void redraw(Graphics g, Board b, int[][] pits,
			int[] mancalas);

	/**
	 * Abstract method to get the Layout name
	 * @return The string to use as the name
	 */
	public abstract String getName();

	/**
	 * Gets the bounding boxes for the pits
	 * @return the name of the layout
	 */
	public Rectangle2D.Double[][] getPitRects() { return pitRects; }

	/**
	 * Sets the size of the board
	 * @param w the width
	 * @param h the height
	 */
	public void setSize(int w, int h)
	{
		width = w;
		height = h;
	}

}
