import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.awt.geom.*;
import java.util.*;


/**
 * Concrete class of BoardLayout
 * @author Sung Chi, Hoai Nguyen, Zhining Qi
 */
public class ClassicLayout extends BoardLayout
{
	private Rectangle2D.Double[] mRects;
	private int nPlayers;
	private int boardLength;
	private Image bg;
	private Image pit;
	private Image stone;
	private Image mancala;
	private static Random rand = new Random();
	/**
	 * Constructor that creates the layout of the game
	 * @param nPlayers the number of players
	 * @param boardLength the number of pits
	 */
	public ClassicLayout(int nPlayers, int boardLength)
	{
		super(nPlayers, boardLength);
		this.nPlayers = nPlayers;
		this.boardLength = boardLength;
		mRects = new Rectangle2D.Double[nPlayers];
		try
		{
			bg = ImageIO.read(new File("resources/classic_bg.png"));
			stone = ImageIO.read(new File("resources/classic_stone.png"));
		}
		catch (Exception e) { bg = null; }
	}

	/**
	 * Redraw using Image files.
	 * See BoardLayout class
	 */
	@Override
	public void redraw(Graphics g, Board b, int[][] pits, int[] mancalas)
	{
		//g.drawImage(bg, 0, 0, 455, 325, b);

		g.drawRoundRect(0, 0,550, 325, 50, 50);
		

		Graphics2D g2 = (Graphics2D) g;

		// Draw the stones.
		for (int r = 0; r < pits.length; r++)
			for (int c = 0; c < pits[r].length; c++)
				for (int s = 0; s < pits[r][c]; s++)
					drawStone(pitRects[r][c], g, b, s);
		for (int m = 0; m < mRects.length; m++)
			for(int s = 0; s < mancalas[m]; s++)
					drawStone(mRects[m], g, b, s);
		drawMancala(g);
	}

	/**
	 * Sets the size of the board and all the internals.
	 * See BoardLayout class
	 */
	@Override
	public void setSize(int w, int h)
	{
		int m = 15; // margin
		int mW = 55; // Mancala Width
		int mH = 225; // Mancala Height
		int mY = 55; // Mancala Y value
		int pD = 50; // Pit Width and Height
		int pTop = 75; // Pit Y value
		int pBottom = 190; // Pit Y value
		super.setSize(w,h);
		
		mRects[0] = new Rectangle2D.Double(width - m - mW, mY, mW, mH);
		mRects[1] = new Rectangle2D.Double(m, mY, mW, mH);

		int s = boardLength - 1; /* Hack var to reverse direction */
		for (int c = 0; c < boardLength; c++)
		{
			pitRects[0][c] = new Rectangle2D.Double(m + mW + m * (c + 1) + pD * c,
					pBottom, pD, 60);
			pitRects[1][c] = new Rectangle2D.Double(m + mW + m * (s + 1) + pD * s,
					pTop, pD, 60);
			--s;
		}
	}

	@Override
	public String getName() { return "Classic Layout"; }

	/**
	 * Creates an ellipse to use as a stone.
	 * @param r the bounding box to draw into
	 * @param g the graphics context to draw into
	 * @param b the board to use for as component to draw to
	 * @param n an integer to aid in seeding the random number generator
	 */
	private void drawStone(Rectangle2D.Double r, Graphics g, Board b, int n)
	{
		rand.setSeed((int)r.getX() * n +  (int)r.getY() * n + n * n);
		int x = rand.nextInt((int)r.getWidth() - stone.getWidth(b));
		int y = rand.nextInt((int)r.getHeight() - stone.getHeight(b));
		g.setColor(Color.black);
		g.drawOval((int)r.getX() + x, (int)r.getY() + y, stone.getWidth(b),
				stone.getHeight(b));
		g.setColor(Color.red);
		g.fillOval((int)r.getX() + x, (int)r.getY() + y, stone.getWidth(b),
				stone.getHeight(b));
		g.setColor(Color.black);
	
		
	}
	private void drawMancala(Graphics g)
	{
		int m = 15; // margin
		int mW = 55; // Mancala Width
		int mH = 225; // Mancala Height
		int mY = 55; // Mancala Y value
		int pD = 50; // Pit Width and Height
		int pTop = 75; // Pit Y value
		int pBottom = 190; // Pit Y value
		g.drawRoundRect(m, mY, mW, mH, 50, 50);
		g.drawRoundRect(width - m - mW, mY, mW, mH, 50, 50);
		
		int s = boardLength - 1; /* Hack var to reverse direction */
		for (int c = 0; c < boardLength; c++)
		{
			g.drawRect(m + mW + m * (c + 1) + pD * c,
					pBottom, pD, 60);
			g.drawRect(m + mW + m * (s + 1) + pD * s,
					pTop, pD, 60);
			--s;
		}
		

	}
	
}