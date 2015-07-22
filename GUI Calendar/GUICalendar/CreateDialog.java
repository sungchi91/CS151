

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.TextListener;
import java.awt.event.TextEvent;
/**
 * JDialog to create new event.
 * @author sung
 *
 */
public class CreateDialog extends JDialog{
	private Container frame;
	private String title = "Untitled Event";
	private String date;
	private String startingTime= "00:00";
	private String endingTime = "N";
	private EventManager eventManager;
	private DayPanel dayPanel; 

	/**
	 * Create the dialog.
	 */
	public CreateDialog(Calendar calendar, DayPanel dayPanel, EventManager eventManager) {
		setResizable(false);
		this.eventManager = eventManager;
		this.dayPanel = dayPanel;
		getContentPane().setLayout(new BorderLayout(0, 0));
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    int Month = calendar.get(Calendar.MONTH)+1;
		int Date = calendar.get(Calendar.DAY_OF_MONTH);
		int Year= calendar.get(Calendar.YEAR);

		date =String.format("%02d",Month)+"/"+String.format("%02d",Date)+"/"+Year;
		setSize(new Dimension(381, 153));
		setBounds(100, 100, 450, 225);
		frame = getContentPane();
		getContentPane().setLayout(new BorderLayout());
		{
			Panel panel = new Panel();
			getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				TextField textField = new TextField();
				textField.addTextListener(new TextListener() {
					public void textValueChanged(TextEvent arg0) {
						title = textField.getText();
					}
				});
				textField.setText("Untitled Event");
				textField.setPreferredSize(new Dimension(400, 20));
				textField.setLocation(new Point(50, 20));
				panel.add(textField);
			}
			{
				TextField textField = new TextField(Month+"/"+Date+"/"+Year);
				textField.setEditable(false);
				textField.setPreferredSize(new Dimension(75, 20));
				panel.add(textField);
			}
			{
				TextField textField1 = new TextField("00:00");
				textField1.addTextListener(new TextListener() {
					public void textValueChanged(TextEvent e) {
						startingTime = textField1.getText();
					}
				});
				textField1.setPreferredSize(new Dimension(75, 20));
				panel.add(textField1);
			}
			{
				Label label = new Label("to");
				panel.add(label);
			}
			{
				TextField textField2 = new TextField("00:00");
				textField2.addTextListener(new TextListener() {
					public void textValueChanged(TextEvent e) {
						if(textField2.getText()!="00:00"){
						endingTime = textField2.getText();
						}
						else endingTime = "N";
					}
				});
				textField2.setPreferredSize(new Dimension(75, 20));
				panel.add(textField2);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton saveButton = new JButton("SAVE");
				saveButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try
						{
							Event newEvent = new Event(title, date, startingTime, endingTime);
							eventManager.createEvent(newEvent);
							String date = String.format("%02d",eventManager.getCalendar().get(Calendar.MONTH)+1)+"/"+String.format("%02d",eventManager.getCalendar().get(Calendar.DAY_OF_MONTH))+"/"+eventManager.getCalendar().get(Calendar.YEAR);
							ArrayList<String> eventList= eventManager.eventPrinter(date);
							dayPanel.setData(eventManager.getCalendar(),eventList);
							frame.setVisible(false);
						    dispose();
						}
						catch (IllegalArgumentException ex)
						{
							JOptionPane.showInternalMessageDialog(frame, ex.getMessage(),
									"Time conflict", JOptionPane.WARNING_MESSAGE);
						}

					}
				});
				saveButton.setActionCommand("SAVE");
				buttonPane.add(saveButton);
				getRootPane().setDefaultButton(saveButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(false);
					    dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}


}
