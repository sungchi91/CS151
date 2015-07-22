import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.List;
/**
 * GUI for MancalaGame
 * Acts as a Controller in MVC Pattern
 * Sets the board, starts game, and  handles actions.
 * @author Sung Chi, Hoai Nguyen, Zhining Qi
 */
public class MancalaGUI  extends JFrame implements MouseListener,
ChangeListener, ActionListener {
	private MancalaGame game;
	private Board board;
	private JLabel player;
	private JButton undoButton;
	private static final int WIDTH = 750;
	private static final int HEIGHT = 430;
	private static final int BOARD_WIDTH = 551;
	private static final int BOARD_HEIGHT = 335;
	
	/**
	 * The view and frame that shows the mancala game visually
	 */
	public MancalaGUI(BoardLayout[] layouts)
	{
		makeDialog(layouts);
	}

	/**
	 * Initalize the data model and start the mancala game
	 * @param stones the initial stone count
	 * @param layout the layout for the board to use
	 */
	public void start(int stones, BoardLayout layout)
	{
		game = new MancalaGame(stones);
		board = new Board(layout);
		game.addChangeListener(this);
		
		setSize(WIDTH,HEIGHT);
		board.setBoardSize(BOARD_WIDTH,BOARD_HEIGHT);
		
		// Displays the active player
      player = new JLabel(game.getPlayer());
      player.setPreferredSize(new Dimension(550,10));
      
      // Displays the undo count 
		undoButton = new JButton("Undo: "+game.getUndoCount());
		undoButton.addActionListener(this);
		

		// Add Board's mouseListener
		board.addMouseListener(this);
		
		setLayout(new FlowLayout());
		add(board);
		add(player);
      add(undoButton);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      setResizable(false);
	}
	
	/**
	 * Checks to see if the player made a valid move
	 * if yes then the board will be updated
	 * if no then an warning message will be displayed
	 */
	public void mousePressed(MouseEvent e)
	{
		if (game.isGameOver())
			return;
		Rectangle2D.Double[][] rects = board.getPitRectangles();

		for (int row = 0; row < rects.length; row++)
			for (int col = 0; col < rects[row].length; col++)
				if (rects[row][col].contains(e.getPoint()))
					try
					{
						game.move(row,col);
						player.setText(game.getPlayer());
						undoButton.setText("Undo: "+ game.getUndoCount());
					}
					catch (IllegalArgumentException ex)
					{
						JOptionPane.showMessageDialog(this, ex.getMessage(),
								"Invalid Move", JOptionPane.WARNING_MESSAGE);
					}
	}

	/**
	 * When a change has been made in the data, then the board
	 * will be updated and repainted. If the game has ended
	 * a dialog will state the winner and freeze any moves
	 */
	public void stateChanged(ChangeEvent event)
	{
		board.setData(game.getPits(), game.getMancalas());
		board.repaint();
		if (game.isGameOver())
			if (game.getActive() < 0)
				JOptionPane.showMessageDialog(this, "The game ended in a draw",
						"Game Over", JOptionPane.INFORMATION_MESSAGE);
			else 
				JOptionPane.showMessageDialog(this, "Player "+(game.getActive()+1) +
					" is the winner!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
	}

	private void makeDialog(BoardLayout[] layouts)
	{
		MancalaDialog popup = new MancalaDialog(this, layouts);
		popup.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		popup.showDialog();
		start(popup.stoneNumber(), popup.getSelectedLayout());
	}

	/**
	 * A listener to undo the last move made 
	 */
	public void actionPerformed(ActionEvent event)
	{
		game.undo();
		player.setText(game.getPlayer());
		undoButton.setText("Undo: "+game.getUndoCount());
 	}

	public void mouseEntered(MouseEvent e) { }

	public void mouseExited(MouseEvent e) { }

	public void mouseClicked(MouseEvent e) { }

	public void mouseReleased(MouseEvent e) { }

}
