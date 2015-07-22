import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import java.awt.Font;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * MonthPanel
 * viewer of MVC Pattern
 * Displays month view of the My Calendar
 * @author Sung Chi
 *
 */
public class MonthPanel extends JPanel {
	private Calendar initCalendar;	
	private int date;
	private EventManager eventManager;
	public static String datePrinter (int n, int lastDayOfMonth, int today){
		if(n== today){
			return "["+n+"]";
		}
		else if(n<=0){
			return " ";
		}

		else if (n>lastDayOfMonth){
			return " ";
		}
		else{			
			return String.valueOf(n);
		}
	}
	/**
	 * Create the panel.
	 */
	public MonthPanel(Calendar initCalendar, EventManager eventManager) {
		this.initCalendar = initCalendar;
		this.eventManager = eventManager;
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    
		MONTHS Month = arrayOfMonths[initCalendar.get(Calendar.MONTH)];
		int Date = initCalendar.get(Calendar.DAY_OF_MONTH);
		int Year= initCalendar.get(Calendar.YEAR);
		
		//puts dates of this month into the array
		GregorianCalendar temp = new GregorianCalendar(initCalendar.get(Calendar.YEAR), initCalendar.get(Calendar.MONTH), 1);
		int[]arr = new int[42];
		
		int firstDayOfWeek=temp.get(Calendar.DAY_OF_WEEK)-1;
		int lastDayOfMonth= temp.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=0; i<arr.length; i++){
			arr[i]= i+1+(firstDayOfWeek*-1);
		}
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		Button btnS = new Button("S");
		btnS.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnS.setForeground(new Color(0, 0, 0));
		btnS.setEnabled(false);
		btnS.setBackground(new Color(65, 105, 225));
		btnS.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnS = new GridBagConstraints();
		gbc_btnS.gridx = 0;
		gbc_btnS.gridy = 0;
		add(btnS, gbc_btnS);
		
		Button btnM = new Button("M");
		btnM.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnM.setForeground(new Color(0, 0, 0));
		btnM.setEnabled(false);
		btnM.setBackground(new Color(65, 105, 225));
		btnM.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnM = new GridBagConstraints();
		gbc_btnM.gridx = 1;
		gbc_btnM.gridy = 0;
		add(btnM, gbc_btnM);
		
		Button btnT = new Button("T");
		btnT.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnT.setForeground(new Color(0, 0, 0));
		btnT.setEnabled(false);
		btnT.setBackground(new Color(65, 105, 225));
		btnT.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnT = new GridBagConstraints();	
		gbc_btnT.gridx = 2;
		gbc_btnT.gridy = 0;
		add(btnT, gbc_btnT);
		
		Button btnW = new Button("W");
		btnW.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnW.setForeground(new Color(0, 0, 0));
		btnW.setEnabled(false);
		btnW.setBackground(new Color(65, 105, 225));
		btnW.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnW = new GridBagConstraints();	
		gbc_btnW.gridx = 3;
		gbc_btnW.gridy = 0;
		add(btnW, gbc_btnW);
		
		Button btnT_1 = new Button("T");
		btnT_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnT_1.setForeground(new Color(0, 0, 0));
		btnT_1.setEnabled(false);
		btnT_1.setBackground(new Color(65, 105, 225));
		btnT_1.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnT_1 = new GridBagConstraints();	
		gbc_btnT_1.gridx = 4;
		gbc_btnT_1.gridy = 0;
		add(btnT_1, gbc_btnT_1);
		
		Button btnF = new Button("F");
		btnF.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnF.setForeground(new Color(0, 0, 0));
		btnF.setEnabled(false);
		btnF.setBackground(new Color(65, 105, 225));
		btnF.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnF = new GridBagConstraints();	
		gbc_btnF.gridx = 5;
		gbc_btnF.gridy = 0;
		add(btnF, gbc_btnF);
		
		Button btnS_1 = new Button("S");
		btnS_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btnS_1.setForeground(new Color(0, 0, 0));
		btnS_1.setEnabled(false);
		btnS_1.setBackground(new Color(65, 105, 225));
		btnS_1.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btnS_1 = new GridBagConstraints();	
		gbc_btnS_1.gridx = 6;
		gbc_btnS_1.gridy = 0;
		add(btnS_1, gbc_btnS_1);

		btn = new Button(datePrinter((arr[0]),lastDayOfMonth,Date));
		if (btn.getLabel().equals(" ")){
			btn.setEnabled(false);
		}
		else btn.setEnabled(true);
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn.getLabel());
				eventManager.setDate(date);
			}
		});
		btn.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn.setBackground(Color.WHITE);
		btn.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn = new GridBagConstraints();
		gbc_btn.gridx = 0;
		gbc_btn.gridy = 1;
		add(btn, gbc_btn);
		
		btn_1 = new Button(datePrinter((arr[1]),lastDayOfMonth,Date));
		if (btn_1.getLabel().equals(" ")){
			btn_1.setEnabled(false);
		}
		else btn_1.setEnabled(true);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_1.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_1.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_1.setBackground(Color.WHITE);
		btn_1.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_1 = new GridBagConstraints();
		gbc_btn_1.gridx = 1;
		gbc_btn_1.gridy = 1;
		add(btn_1, gbc_btn_1);
		
		btn_2 = new Button(datePrinter((arr[2]),lastDayOfMonth,Date));
		if (btn_2.getLabel().equals(" ")){
			btn_2.setEnabled(false);
		}
		else btn_2.setEnabled(true);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_2.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_2.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_2.setBackground(Color.WHITE);
		btn_2.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_2 = new GridBagConstraints();
		gbc_btn_2.gridx = 2;
		gbc_btn_2.gridy = 1;
		add(btn_2, gbc_btn_2);
		
		btn_3 = new Button(datePrinter((arr[3]),lastDayOfMonth,Date));
		if (btn_3.getLabel().equals(" ")){
			btn_3.setEnabled(false);
		}
		else btn_3.setEnabled(true);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_3.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_3.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_3.setBackground(Color.WHITE);
		btn_3.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_3 = new GridBagConstraints();
		gbc_btn_3.gridx = 3;
		gbc_btn_3.gridy = 1;
		add(btn_3, gbc_btn_3);
		
		btn_4 = new Button(datePrinter((arr[4]),lastDayOfMonth,Date));
		if (btn_4.getLabel().equals(" ")){
			btn_4.setEnabled(false);
		}
		else btn_4.setEnabled(true);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_4.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_4.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_4.setBackground(Color.WHITE);
		btn_4.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_4 = new GridBagConstraints();
		gbc_btn_4.gridx = 4;
		gbc_btn_4.gridy = 1;
		add(btn_4, gbc_btn_4);
		
		btn_5 = new Button(datePrinter((arr[5]),lastDayOfMonth,Date));
		if (btn_5.getLabel().equals(" ")){
			btn_5.setEnabled(false);
		}
		else btn_5.setEnabled(true);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_5.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_5.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_5.setBackground(Color.WHITE);
		btn_5.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_5 = new GridBagConstraints();
		gbc_btn_5.gridx = 5;
		gbc_btn_5.gridy = 1;
		add(btn_5, gbc_btn_5);
		
		btn_6 = new Button(datePrinter((arr[6]),lastDayOfMonth,Date));
		if (btn_6.getLabel().equals(" ")){
			btn_6.setEnabled(false);
		}
		else btn_6.setEnabled(true);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_6.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_6.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_6.setBackground(Color.WHITE);
		btn_6.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_6 = new GridBagConstraints();
		gbc_btn_6.gridx = 6;
		gbc_btn_6.gridy = 1;
		add(btn_6, gbc_btn_6);
		
		btn_7 = new Button(datePrinter((arr[7]),lastDayOfMonth,Date));
		if (btn_7.getLabel().equals(" ")){
			btn_7.setEnabled(false);
		}
		else btn_7.setEnabled(true);
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_7.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_7.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_7.setBackground(Color.WHITE);
		btn_7.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_7 = new GridBagConstraints();
		gbc_btn_7.gridx = 0;
		gbc_btn_7.gridy = 2;
		add(btn_7, gbc_btn_7);
		
		btn_8 = new Button(datePrinter((arr[8]),lastDayOfMonth,Date));
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_8.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_8.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_8.setBackground(Color.WHITE);
		btn_8.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_8 = new GridBagConstraints();
		gbc_btn_8.gridx = 1;
		gbc_btn_8.gridy = 2;
		add(btn_8, gbc_btn_8);
		
		btn_9 = new Button(datePrinter((arr[9]),lastDayOfMonth,Date));
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_9.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_9.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_9.setBackground(Color.WHITE);
		btn_9.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_9 = new GridBagConstraints();
		gbc_btn_9.gridx = 2;
		gbc_btn_9.gridy = 2;
		add(btn_9, gbc_btn_9);
		
		btn_10 = new Button(datePrinter((arr[10]),lastDayOfMonth,Date));
		btn_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_10.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_10.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_10.setBackground(Color.WHITE);
		btn_10.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_10 = new GridBagConstraints();
		gbc_btn_10.gridx = 3;
		gbc_btn_10.gridy = 2;
		add(btn_10, gbc_btn_10);
		
		btn_11 = new Button(datePrinter((arr[11]),lastDayOfMonth,Date));
		btn_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_11.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_11.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_11.setBackground(Color.WHITE);
		btn_11.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_11 = new GridBagConstraints();
		gbc_btn_11.gridx = 4;
		gbc_btn_11.gridy = 2;
		add(btn_11, gbc_btn_11);
		
		btn_12 = new Button(datePrinter((arr[12]),lastDayOfMonth,Date));
		btn_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_12.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_12.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_12.setBackground(Color.WHITE);
		btn_12.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_12 = new GridBagConstraints();
		gbc_btn_12.gridx = 5;
		gbc_btn_12.gridy = 2;
		add(btn_12, gbc_btn_12);
		
		btn_13 = new Button(datePrinter((arr[13]),lastDayOfMonth,Date));
		btn_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_13.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_13.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_13.setBackground(Color.WHITE);
		btn_13.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_13 = new GridBagConstraints();
		gbc_btn_13.gridx = 6;
		gbc_btn_13.gridy = 2;
		add(btn_13, gbc_btn_13);
		
		btn_14 = new Button(datePrinter((arr[14]),lastDayOfMonth,Date));
		btn_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_14.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_14.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_14.setBackground(Color.WHITE);
		btn_14.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_14 = new GridBagConstraints();
		gbc_btn_14.gridx = 0;
		gbc_btn_14.gridy = 3;
		add(btn_14, gbc_btn_14);
		
		btn_15 = new Button(datePrinter((arr[15]),lastDayOfMonth,Date));
		btn_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_15.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_15.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_15.setBackground(Color.WHITE);
		btn_15.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_15 = new GridBagConstraints();
		gbc_btn_15.gridx = 1;
		gbc_btn_15.gridy = 3;
		add(btn_15, gbc_btn_15);
		
		btn_16 = new Button(datePrinter((arr[16]),lastDayOfMonth,Date));
		btn_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_16.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_16.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_16.setBackground(Color.WHITE);
		btn_16.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_16 = new GridBagConstraints();
		gbc_btn_16.gridx = 2;
		gbc_btn_16.gridy = 3;
		add(btn_16, gbc_btn_16);
		
		btn_17 = new Button(datePrinter((arr[17]),lastDayOfMonth,Date));
		btn_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_17.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_17.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_17.setBackground(Color.WHITE);
		btn_17.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_17 = new GridBagConstraints();
		gbc_btn_17.gridx = 3;
		gbc_btn_17.gridy = 3;
		add(btn_17, gbc_btn_17);
		
		btn_18 = new Button(datePrinter((arr[18]),lastDayOfMonth,Date));
		btn_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_18.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_18.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_18.setBackground(Color.WHITE);
		btn_18.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_18 = new GridBagConstraints();
		gbc_btn_18.gridx = 4;
		gbc_btn_18.gridy = 3;
		add(btn_18, gbc_btn_18);
		
		btn_19 = new Button(datePrinter((arr[19]),lastDayOfMonth,Date));
		btn_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_19.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_19.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_19.setBackground(Color.WHITE);
		btn_19.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_19 = new GridBagConstraints();
		gbc_btn_19.gridx = 5;
		gbc_btn_19.gridy = 3;
		add(btn_19, gbc_btn_19);
		
		btn_20 = new Button(datePrinter((arr[20]),lastDayOfMonth,Date));
		btn_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_20.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_20.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_20.setBackground(Color.WHITE);
		btn_20.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_20 = new GridBagConstraints();
		gbc_btn_20.gridx = 6;
		gbc_btn_20.gridy = 3;
		add(btn_20, gbc_btn_20);
		
		btn_21 = new Button(datePrinter((arr[21]),lastDayOfMonth,Date));
		btn_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_21.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_21.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_21.setBackground(Color.WHITE);
		btn_21.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_21 = new GridBagConstraints();
		gbc_btn_21.gridx = 0;
		gbc_btn_21.gridy = 4;
		add(btn_21, gbc_btn_21);
		
		btn_22 = new Button(datePrinter((arr[22]),lastDayOfMonth,Date));
		btn_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_22.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_22.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_22.setBackground(Color.WHITE);
		btn_22.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_22 = new GridBagConstraints();
		gbc_btn_22.gridx = 1;
		gbc_btn_22.gridy = 4;
		add(btn_22, gbc_btn_22);
		
		btn_23 = new Button(datePrinter((arr[23]),lastDayOfMonth,Date));
		btn_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_23.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_23.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_23.setBackground(Color.WHITE);
		btn_23.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_23 = new GridBagConstraints();
		gbc_btn_23.gridx = 2;
		gbc_btn_23.gridy = 4;
		add(btn_23, gbc_btn_23);
		
		btn_24 = new Button(datePrinter((arr[24]),lastDayOfMonth,Date));
		btn_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_24.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_24.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_24.setBackground(Color.WHITE);
		btn_24.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_24 = new GridBagConstraints();
		gbc_btn_24.gridx = 3;
		gbc_btn_24.gridy = 4;
		add(btn_24, gbc_btn_24);
		
		btn_25 = new Button(datePrinter((arr[25]),lastDayOfMonth,Date));
		btn_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_25.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_25.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_25.setBackground(Color.WHITE);
		btn_25.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_25 = new GridBagConstraints();
		gbc_btn_25.gridx = 4;
		gbc_btn_25.gridy = 4;
		add(btn_25, gbc_btn_25);
		
		
		btn_26 = new Button(datePrinter((arr[26]),lastDayOfMonth,Date));
		btn_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_26.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_26.setFont(new Font("SansSerif", Font.PLAIN, 11));		
		btn_26.setBackground(Color.WHITE);
		btn_26.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_26 = new GridBagConstraints();
		gbc_btn_26.gridx = 5;
		gbc_btn_26.gridy = 4;
		add(btn_26, gbc_btn_26);
		
		btn_27 = new Button(datePrinter((arr[27]),lastDayOfMonth,Date));
		btn_27.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_27.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_27.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_27.setBackground(Color.WHITE);
		btn_27.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_27 = new GridBagConstraints();
		gbc_btn_27.gridx = 6;
		gbc_btn_27.gridy = 4;
		add(btn_27, gbc_btn_27);
		
		btn_28 = new Button(datePrinter((arr[28]),lastDayOfMonth,Date));
		if (btn_28.getLabel().equals(" ")){
			btn_28.setEnabled(false);
		}
		else btn_28.setEnabled(true);
		btn_28.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_28.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_28.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_28.setBackground(Color.WHITE);
		btn_28.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_28 = new GridBagConstraints();
		gbc_btn_28.gridx = 0;
		gbc_btn_28.gridy = 5;
		add(btn_28, gbc_btn_28);
		
		btn_29 = new Button(datePrinter((arr[29]),lastDayOfMonth,Date));
		if (btn_29.getLabel().equals(" ")){
			btn_29.setEnabled(false);
		}
		else btn_29.setEnabled(true);
		btn_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_29.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_29.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_29.setBackground(Color.WHITE);
		btn_29.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_29 = new GridBagConstraints();
		gbc_btn_29.gridx = 1;
		gbc_btn_29.gridy = 5;
		add(btn_29, gbc_btn_29);
		
		btn_30 = new Button(datePrinter((arr[30]),lastDayOfMonth,Date));
		if (btn_30.getLabel().equals(" ")){
			btn_30.setEnabled(false);
		}
		else btn_30.setEnabled(true);
		btn_30.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_30.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_30.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_30.setBackground(Color.WHITE);
		btn_30.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_30 = new GridBagConstraints();
		gbc_btn_30.gridx = 2;
		gbc_btn_30.gridy = 5;
		add(btn_30, gbc_btn_30);
		
		btn_31 = new Button(datePrinter((arr[31]),lastDayOfMonth,Date));
		if (btn_31.getLabel().equals(" ")){
			btn_31.setEnabled(false);
		}
		else btn_31.setEnabled(true);
		btn_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_31.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_31.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_31.setBackground(Color.WHITE);
		btn_31.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_31 = new GridBagConstraints();
		gbc_btn_31.gridx = 3;
		gbc_btn_31.gridy = 5;
		add(btn_31, gbc_btn_31);
		
		btn_32 = new Button(datePrinter((arr[32]),lastDayOfMonth,Date));
		if (btn_32.getLabel().equals(" ")){
			btn_32.setEnabled(false);
		}
		else btn_32.setEnabled(true);
		btn_32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_32.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_32.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_32.setBackground(Color.WHITE);
		btn_32.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_32 = new GridBagConstraints();
		gbc_btn_32.gridx = 4;
		gbc_btn_32.gridy = 5;
		add(btn_32, gbc_btn_32);
		
		btn_33 = new Button(datePrinter((arr[33]),lastDayOfMonth,Date));
		if (btn_33.getLabel().equals(" ")){
			btn_33.setEnabled(false);
		}
		else btn_33.setEnabled(true);
		btn_33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_33.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_33.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_33.setBackground(Color.WHITE);
		btn_33.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_33 = new GridBagConstraints();
		gbc_btn_33.gridx = 5;
		gbc_btn_33.gridy = 5;
		add(btn_33, gbc_btn_33);
		
		btn_34 = new Button(datePrinter((arr[34]),lastDayOfMonth,Date));
		if (btn_34.getLabel().equals(" ")){
			btn_34.setEnabled(false);
		}
		else btn_34.setEnabled(true);
		btn_34.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_34.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_34.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_34.setBackground(Color.WHITE);
		btn_34.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_34 = new GridBagConstraints();
		gbc_btn_34.gridx = 6;
		gbc_btn_34.gridy = 5;
		add(btn_34, gbc_btn_34);
		
		btn_35 = new Button(datePrinter((arr[35]),lastDayOfMonth,Date));
		if (btn_35.getLabel().equals(" ")){
			btn_35.setEnabled(false);
		}
		else btn_35.setEnabled(true);
		btn_35.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_35.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_35.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_35.setBackground(Color.WHITE);
		btn_35.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_35 = new GridBagConstraints();
		gbc_btn_35.gridx = 0;
		gbc_btn_35.gridy = 6;
		add(btn_35, gbc_btn_35);
		
		btn_36 = new Button(datePrinter((arr[36]),lastDayOfMonth,Date));
		if (btn_36.getLabel().equals(" ")){
			btn_36.setEnabled(false);
		}
		else btn_36.setEnabled(true);
		btn_36.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_36.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_36.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_36.setBackground(Color.WHITE);
		btn_36.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_36 = new GridBagConstraints();
		gbc_btn_36.gridx = 1;
		gbc_btn_36.gridy = 6;
		add(btn_36, gbc_btn_36);
		
		btn_37 = new Button(datePrinter((arr[37]),lastDayOfMonth,Date));
		if (btn_37.getLabel().equals(" ")){
			btn_37.setEnabled(false);
		}
		else btn_37.setEnabled(true);
		btn_37.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_37.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_37.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_37.setBackground(Color.WHITE);
		btn_37.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_37 = new GridBagConstraints();
		gbc_btn_37.gridx = 2;
		gbc_btn_37.gridy = 6;
		add(btn_37, gbc_btn_37);
		
		btn_38 = new Button(datePrinter((arr[38]),lastDayOfMonth,Date));
		if (btn_38.getLabel().equals(" ")){
			btn_38.setEnabled(false);
		}
		else btn_38.setEnabled(true);
		btn_38.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_38.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_38.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_38.setBackground(Color.WHITE);
		btn_38.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_38 = new GridBagConstraints();
		gbc_btn_38.gridx = 3;
		gbc_btn_38.gridy = 6;
		add(btn_38, gbc_btn_38);
		
		btn_39 = new Button(datePrinter((arr[39]),lastDayOfMonth,Date));
		if (btn_39.getLabel().equals(" ")){
			btn_39.setEnabled(false);
		}
		else btn_39.setEnabled(true);
		btn_39.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_39.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_39.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_39.setBackground(Color.WHITE);
		btn_39.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_39 = new GridBagConstraints();
		gbc_btn_39.gridx = 4;
		gbc_btn_39.gridy = 6;
		add(btn_39, gbc_btn_39);
		
		btn_40 = new Button(datePrinter((arr[40]),lastDayOfMonth,Date));
		if (btn_40.getLabel().equals(" ")){
			btn_40.setEnabled(false);
		}
		else btn_40.setEnabled(true);
		btn_40.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_40.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_40.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_40.setBackground(Color.WHITE);
		btn_40.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_40 = new GridBagConstraints();
		gbc_btn_40.gridx = 5;
		gbc_btn_40.gridy = 6;
		add(btn_40, gbc_btn_40);
		
		btn_41 = new Button(datePrinter((arr[41]),lastDayOfMonth,Date));
		if (btn_41.getLabel().equals(" ")){
			btn_41.setEnabled(false);
		}
		else btn_41.setEnabled(true);
		btn_41.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date = dateParser(btn_41.getLabel());
				eventManager.setDate(date);
			}
		});
		btn_41.setFont(new Font("SansSerif", Font.PLAIN, 11));
		btn_41.setBackground(Color.WHITE);
		btn_41.setPreferredSize(new Dimension(25, 25));
		GridBagConstraints gbc_btn_41 = new GridBagConstraints();
		gbc_btn_41.gridx = 6;
		gbc_btn_41.gridy = 6;
		add(btn_41, gbc_btn_41);

	}

	public void setData(Calendar newCalendar){
		initCalendar = newCalendar;
		MONTHS[] arrayOfMonths = MONTHS.values();
	    DAYS[] arrayOfDays = DAYS.values();
	    
		MONTHS Month = arrayOfMonths[initCalendar.get(Calendar.MONTH)];
		int Date = initCalendar.get(Calendar.DAY_OF_MONTH);
		int Year= initCalendar.get(Calendar.YEAR);

		//puts dates of this month into the array
		GregorianCalendar temp = new GregorianCalendar(initCalendar.get(Calendar.YEAR), initCalendar.get(Calendar.MONTH), 1);
		int[]arr = new int[42];
		
		int firstDayOfWeek=temp.get(Calendar.DAY_OF_WEEK)-1;
		int lastDayOfMonth= temp.getActualMaximum(Calendar.DAY_OF_MONTH);
		for(int i=0; i<arr.length; i++){
			arr[i]= i+1+(firstDayOfWeek*-1);
		}
		btn.setLabel(datePrinter((arr[0]),lastDayOfMonth,Date));
		if (btn.getLabel().equals(" ")){
			btn.setEnabled(false);
		}
		else btn.setEnabled(true);
		
		btn_1.setLabel(datePrinter((arr[1]),lastDayOfMonth,Date));
		if (btn_1.getLabel().equals(" ")){
			btn_1.setEnabled(false);
		}
		else btn_1.setEnabled(true);
		btn_2.setLabel(datePrinter((arr[2]),lastDayOfMonth,Date));
		if (btn_2.getLabel().equals(" ")){
			btn_2.setEnabled(false);
		}
		else btn_2.setEnabled(true);
		btn_3.setLabel(datePrinter((arr[3]),lastDayOfMonth,Date));
		if (btn_3.getLabel().equals(" ")){
			btn_3.setEnabled(false);
		}
		else btn_3.setEnabled(true);
		btn_4.setLabel(datePrinter((arr[4]),lastDayOfMonth,Date));
		if (btn_4.getLabel().equals(" ")){
			btn_4.setEnabled(false);
		}
		else btn_4.setEnabled(true);
		btn_5.setLabel(datePrinter((arr[5]),lastDayOfMonth,Date));
		if (btn_5.getLabel().equals(" ")){
			btn_5.setEnabled(false);
		}
		else btn_5.setEnabled(true);
		btn_6.setLabel(datePrinter((arr[6]),lastDayOfMonth,Date));
		if (btn_6.getLabel().equals(" ")){
			btn_6.setEnabled(false);
		}
		else btn_6.setEnabled(true);
		btn_7.setLabel(datePrinter((arr[7]),lastDayOfMonth,Date));
		if (btn_7.getLabel().equals(" ")){
			btn_7.setEnabled(false);
		}
		else btn_7.setEnabled(true);
		btn_8.setLabel(datePrinter((arr[8]),lastDayOfMonth,Date));
		if (btn_8.getLabel().equals(" ")){
			btn_8.setEnabled(false);
		}
		else btn_8.setEnabled(true);
		btn_9.setLabel(datePrinter((arr[9]),lastDayOfMonth,Date));
		if (btn_9.getLabel().equals(" ")){
			btn_9.setEnabled(false);
		}
		else btn_9.setEnabled(true);
		btn_10.setLabel(datePrinter((arr[10]),lastDayOfMonth,Date));
		if (btn_10.getLabel().equals(" ")){
			btn_10.setEnabled(false);
		}
		else btn_10.setEnabled(true);
		btn_11.setLabel(datePrinter((arr[11]),lastDayOfMonth,Date));
		if (btn_11.getLabel().equals(" ")){
			btn_11.setEnabled(false);
		}
		else btn_11.setEnabled(true);
		btn_12.setLabel(datePrinter((arr[12]),lastDayOfMonth,Date));
		if (btn_12.getLabel().equals(" ")){
			btn_12.setEnabled(false);
		}
		else btn_12.setEnabled(true);
		btn_13.setLabel(datePrinter((arr[13]),lastDayOfMonth,Date));
		if (btn_13.getLabel().equals(" ")){
			btn_13.setEnabled(false);
		}
		else btn_13.setEnabled(true);
		btn_14.setLabel(datePrinter((arr[14]),lastDayOfMonth,Date));
		if (btn_14.getLabel().equals(" ")){
			btn_14.setEnabled(false);
		}
		else btn_14.setEnabled(true);
		btn_15.setLabel(datePrinter((arr[15]),lastDayOfMonth,Date));
		if (btn_15.getLabel().equals(" ")){
			btn_15.setEnabled(false);
		}
		else btn_15.setEnabled(true);
		btn_16.setLabel(datePrinter((arr[16]),lastDayOfMonth,Date));
		if (btn_16.getLabel().equals(" ")){
			btn_16.setEnabled(false);
		}
		else btn_16.setEnabled(true);
		btn_17.setLabel(datePrinter((arr[17]),lastDayOfMonth,Date));
		if (btn_17.getLabel().equals(" ")){
			btn_17.setEnabled(false);
		}
		else btn_17.setEnabled(true);
		btn_18.setLabel(datePrinter((arr[18]),lastDayOfMonth,Date));
		if (btn_18.getLabel().equals(" ")){
			btn_18.setEnabled(false);
		}
		else btn_18.setEnabled(true);
		btn_19.setLabel(datePrinter((arr[19]),lastDayOfMonth,Date));
		if (btn_19.getLabel().equals(" ")){
			btn_19.setEnabled(false);
		}
		else btn_19.setEnabled(true);
		btn_20.setLabel(datePrinter((arr[20]),lastDayOfMonth,Date));
		if (btn_20.getLabel().equals(" ")){
			btn_20.setEnabled(false);
		}
		else btn_20.setEnabled(true);
		btn_21.setLabel(datePrinter((arr[21]),lastDayOfMonth,Date));
		if (btn_21.getLabel().equals(" ")){
			btn_21.setEnabled(false);
		}
		else btn_21.setEnabled(true);
		btn_22.setLabel(datePrinter((arr[22]),lastDayOfMonth,Date));
		if (btn_22.getLabel().equals(" ")){
			btn_22.setEnabled(false);
		}
		else btn_22.setEnabled(true);
		btn_23.setLabel(datePrinter((arr[23]),lastDayOfMonth,Date));
		if (btn_23.getLabel().equals(" ")){
			btn_23.setEnabled(false);
		}
		else btn_23.setEnabled(true);
		btn_24.setLabel(datePrinter((arr[24]),lastDayOfMonth,Date));
		if (btn_24.getLabel().equals(" ")){
			btn_24.setEnabled(false);
		}
		else btn_24.setEnabled(true);
		btn_25.setLabel(datePrinter((arr[25]),lastDayOfMonth,Date));
		if (btn_25.getLabel().equals(" ")){
			btn_25.setEnabled(false);
		}
		else btn_25.setEnabled(true);
		btn_26.setLabel(datePrinter((arr[26]),lastDayOfMonth,Date));
		if (btn_26.getLabel().equals(" ")){
			btn_26.setEnabled(false);
		}
		else btn_26.setEnabled(true);
		btn_27.setLabel(datePrinter((arr[27]),lastDayOfMonth,Date));
		if (btn_27.getLabel().equals(" ")){
			btn_27.setEnabled(false);
		}
		else btn_27.setEnabled(true);
		btn_28.setLabel(datePrinter((arr[28]),lastDayOfMonth,Date));
		if (btn_28.getLabel().equals(" ")){
			btn_28.setEnabled(false);
		}
		else btn_28.setEnabled(true);
		btn_29.setLabel(datePrinter((arr[29]),lastDayOfMonth,Date));
		if (btn_29.getLabel().equals(" ")){
			btn_29.setEnabled(false);
		}
		else btn_29.setEnabled(true);
		btn_30.setLabel(datePrinter((arr[30]),lastDayOfMonth,Date));
		if (btn_30.getLabel().equals(" ")){
			btn_30.setEnabled(false);
		}
		else btn_30.setEnabled(true);
		btn_31.setLabel(datePrinter((arr[31]),lastDayOfMonth,Date));
		if (btn_31.getLabel().equals(" ")){
			btn_31.setEnabled(false);
		}
		else btn_31.setEnabled(true);
		btn_32.setLabel(datePrinter((arr[32]),lastDayOfMonth,Date));
		if (btn_32.getLabel().equals(" ")){
			btn_32.setEnabled(false);
		}
		else btn_32.setEnabled(true);
		btn_33.setLabel(datePrinter((arr[33]),lastDayOfMonth,Date));
		if (btn_33.getLabel().equals(" ")){
			btn_33.setEnabled(false);
		}
		else btn_33.setEnabled(true);
		btn_34.setLabel(datePrinter((arr[34]),lastDayOfMonth,Date));
		if (btn_34.getLabel().equals(" ")){
			btn_34.setEnabled(false);
		}
		else btn_34.setEnabled(true);
		btn_35.setLabel(datePrinter((arr[35]),lastDayOfMonth,Date));
		if (btn_35.getLabel().equals(" ")){
			btn_35.setEnabled(false);
		}
		else btn_35.setEnabled(true);
		btn_36.setLabel(datePrinter((arr[36]),lastDayOfMonth,Date));
		if (btn_36.getLabel().equals(" ")){
			btn_36.setEnabled(false);
		}
		else btn_36.setEnabled(true);
		btn_37.setLabel(datePrinter((arr[37]),lastDayOfMonth,Date));
		if (btn_37.getLabel().equals(" ")){
			btn_37.setEnabled(false);
		}
		else btn_37.setEnabled(true);
		btn_38.setLabel(datePrinter((arr[38]),lastDayOfMonth,Date));
		if (btn_38.getLabel().equals(" ")){
			btn_38.setEnabled(false);
		}
		else btn_38.setEnabled(true);
		btn_39.setLabel(datePrinter((arr[39]),lastDayOfMonth,Date));
		if (btn_39.getLabel().equals(" ")){
			btn_39.setEnabled(false);
		}
		else btn_39.setEnabled(true);
		btn_40.setLabel(datePrinter((arr[40]),lastDayOfMonth,Date));
		if (btn_40.getLabel().equals(" ")){
			btn_40.setEnabled(false);
		}
		else btn_40.setEnabled(true);
		btn_41.setLabel(datePrinter((arr[41]),lastDayOfMonth,Date));		
		if (btn_41.getLabel().equals(" ")){
			btn_41.setEnabled(false);
		}
		else btn_41.setEnabled(true);
	}
	public int dateParser(String label){
		if (label.charAt(0)=='['){
			int n = label.indexOf("]");
			return Integer.valueOf(label.substring(1, n));

		
		}
		else return Integer.valueOf(label);
	}
	private Button btn;	
	private Button btn_1;
	private Button btn_2;
	private Button btn_3;
	private Button btn_4;
	private Button btn_5;
	private Button btn_6;
	private Button btn_7;
	private Button btn_8;
	private Button btn_9;
	private Button btn_10;
	private Button btn_11;
	private Button btn_12;
	private Button btn_13;
	private Button btn_14;
	private Button btn_15;
	private Button btn_16;	
	private Button btn_17;
	private Button btn_18;
	private Button btn_19;
	private Button btn_20;
	private Button btn_21;
	private Button btn_22;
	private Button btn_23;
	private Button btn_24;
	private Button btn_25;
	private Button btn_26;
	private Button btn_27;
	private Button btn_28;
	private Button btn_29;
	private Button btn_30;
	private Button btn_31;
	private Button btn_32;
	private Button btn_33;
	private Button btn_34;
	private Button btn_35;
	private Button btn_36;
	private Button btn_37;
	private Button btn_38;
	private Button btn_39;
	private Button btn_40;
	private Button btn_41;
}
