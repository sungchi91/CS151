import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Label;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Font;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * GUICalendar
 * Controller of MVC Pattern
 * controlls interations between the model(My Calendar) and viewers(MonthPanel and DayPanel)
 * @author Sung Chi
 *
 */
public class GUICalendar extends JFrame implements MouseListener,
ChangeListener, ActionListener{

	private JPanel contentPane;
	private DayPanel dayPanel;
	private MonthPanel monthPanel;
	private Calendar initCalendar;
	private static EventManager eventManager;
	private Label label;
	private MONTHS[] arrayOfMonths= MONTHS.values();
    DAYS[] arrayOfDays = DAYS.values();
    MONTHS Month;
	int Date;
	int Year;
	
	
	
	/**
	 * Create the frame.
	 */
	public GUICalendar() {
		setResizable(false);
		eventManager = new EventManager();
		
		this.initCalendar= eventManager.getCalendar();
		eventManager.addChangeListener(this);
		
		//load event.txt by default.
		try {
			load();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//eventManager.eventList();
		
	    Month = arrayOfMonths[initCalendar.get(Calendar.MONTH)];
		Date = initCalendar.get(Calendar.DAY_OF_MONTH);
		Year= initCalendar.get(Calendar.YEAR);
		
		//puts dates of this month into the array
		GregorianCalendar temp = new GregorianCalendar(initCalendar.get(Calendar.YEAR), initCalendar.get(Calendar.MONTH), 1);
		int[]arr = new int[42];
		
		int firstDayOfWeek=temp.get(Calendar.DAY_OF_WEEK)-1;
		int lastDayOfMonth= temp.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=0; i<arr.length; i++){
			arr[i]= i+1+(firstDayOfWeek*-1);
		}
	    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton button = new JButton("<");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventManager.setCalendar(-1);
				//System.out.print(eventManager.getCalendar().get(Calendar.DAY_OF_MONTH));
			}
		});
		panel.add(button);
		
		JButton button_1 = new JButton(">");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eventManager.setCalendar(1);
				//System.out.print(eventManager.getCalendar().get(Calendar.DAY_OF_MONTH));
			}
		});
		panel.add(button_1);
		
		JButton btnQuit = new JButton("QUIT");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					quit();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		btnQuit.setFont(new Font("SansSerif", Font.PLAIN, 11));
		panel.add(btnQuit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton = new JButton("CREATE");
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setPreferredSize(new Dimension(71, 30));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				CreateDialog dialog = new CreateDialog(eventManager.getCalendar(),dayPanel,eventManager);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(220, 20, 60));
		panel_1.add(btnNewButton, BorderLayout.NORTH);
		
		label = new Label(Month+" "+Year);
		label.setAlignment(Label.CENTER);
		panel_1.add(label, BorderLayout.CENTER);
		
		
		monthPanel = new MonthPanel(initCalendar,eventManager);
		panel_1.add(monthPanel,BorderLayout.SOUTH);
		
		String date = String.format("%02d",initCalendar.get(Calendar.MONTH)+1)+"/"+String.format("%02d",initCalendar.get(Calendar.DAY_OF_MONTH))+"/"+initCalendar.get(Calendar.YEAR);
		ArrayList<String> eventList= eventManager.eventPrinter(date);
		dayPanel = new DayPanel(initCalendar, eventList);
		dayPanel.setBackground(new Color(255, 255, 255));
		dayPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(dayPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public void load() throws IOException{
		eventManager.loadCalendar();
	}
	
	   /**
	    * Initiate quiting service
	    * @throws IOException
	    */
	public void quit() throws IOException{
		eventManager.updateFile();
		System.out.println("Saving Data...events.txt");
		setVisible(false);
		dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent event) {
		monthPanel.setData(eventManager.getCalendar());
		label.setText(arrayOfMonths[eventManager.getCalendar().get(Calendar.MONTH)]+" "+eventManager.getCalendar().get(Calendar.YEAR));

		String date = String.format("%02d",eventManager.getCalendar().get(Calendar.MONTH)+1)+"/"+String.format("%02d",eventManager.getCalendar().get(Calendar.DAY_OF_MONTH))+"/"+eventManager.getCalendar().get(Calendar.YEAR);
		ArrayList<String> eventList= eventManager.eventPrinter(date);
		dayPanel.setData(eventManager.getCalendar(),eventList);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
