/**
 * Main method to run the program
 * @author Sung Chi, Hoai Nguyen, Zhining Qi
 */
public class MancalaTest {

	public static void main(String[] args) {


			BoardLayout[] layouts = {
				new ClassicLayout(MancalaGame.N_PLAYERS, MancalaGame.BOARD_LENGTH),
		 		new CustomLayout(MancalaGame.N_PLAYERS, MancalaGame.BOARD_LENGTH),
			};

			MancalaGUI gui = new MancalaGUI(layouts);
		}	

}
