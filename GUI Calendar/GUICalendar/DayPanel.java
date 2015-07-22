import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Label;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;

import java.awt.Font;

/**
 * DayPanel
 * Viewer in MVC Pattern
 * displays day view of calendar.
 * @author Sung Chi
 *
 */
public class DayPanel extends JPanel {

	private Calendar initCalendar;
	private Label label;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public DayPanel(Calendar initCalendar,ArrayList<String> eventList) {
		this.initCalendar = initCalendar;
		setLayout(new BorderLayout(0, 0));
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    int Month = this.initCalendar.get(Calendar.MONTH)+1;
		int Date = this.initCalendar.get(Calendar.DAY_OF_MONTH);
		int Year= this.initCalendar.get(Calendar.YEAR);
		
		label = new Label(Month+"/"+Date+"/"+Year);
		label.setAlignment(Label.CENTER);
		add(label, BorderLayout.NORTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextArea();
		textArea.setText(eventList.get(0));
		for (int i =1 ; i< eventList.size(); i++){
			textArea.append("\n"+eventList.get(i));
		}
		textArea.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);	
	}
	public void setData(Calendar newCalendar, ArrayList<String> eventList){
		this.initCalendar = newCalendar;
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    int Month = this.initCalendar.get(Calendar.MONTH)+1;
		int Date = this.initCalendar.get(Calendar.DAY_OF_MONTH);
		int Year= this.initCalendar.get(Calendar.YEAR);
		label.setText(Month+"/"+Date+"/"+Year);
		textArea.setText(eventList.get(0));
		for (int i =1 ; i< eventList.size(); i++){
			textArea.append("\n"+eventList.get(i));
		}
		

		
	}

}
