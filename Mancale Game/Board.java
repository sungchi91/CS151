import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * A component that holds board layout
 * @author Sung Chi, Hoai Nguyen, Zhining Qi
 *
 */
public class Board extends JComponent{

	private int[][] pits;
	private int[] mancalas;
	private BoardLayout layout;
	/**
	 * Constructor that sets the layout of the board
	 * @param layout a layout to be used for the mancala game
	 */
	public Board(BoardLayout layout)
	{
		this.layout = layout;
	}

	/**
	 * Gets the rectangular pits 
	 * @return the rectangular pits
	 */
	public Rectangle2D.Double[][] getPitRectangles()
	{
		return layout.getPitRects();
	}

	/**
	 * Sets the size of the board
	 * @param w the width
	 * @param h the height
	 */
	public void setBoardSize(int w, int h)
	{
		setPreferredSize(new Dimension(w,h));
		layout.setSize(w,h);
	}

	/**
	 * Draws the components of the board
	 */
	public void paintComponent(Graphics g)
	{
		layout.redraw(g, this, pits, mancalas);
	}

	/**
	 * Assigns the stones to pits and mancalas
	 * @param pits the pits
	 * @param mancalas the mancalas
	 */
	public void setData(int[][] pits, int[] mancalas)
	{
		this.pits = pits;
		this.mancalas = mancalas;
	}

}
