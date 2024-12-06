import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	
	SimpleDateFormat timeformat;
	SimpleDateFormat dayformat;
	SimpleDateFormat dateformat;
	JLabel timelabel;
	JLabel daylabel;
	JLabel datelabel;
	String time;
	String day;
	String date;

	ClockFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Clock");
		this.setLayout(new FlowLayout());
		this.setSize(350, 200);
		this.setResizable(false);

		timeformat = new SimpleDateFormat("hh:mm:ss a");
		dayformat = new SimpleDateFormat("EEEE");
		dateformat = new SimpleDateFormat("MMMMM dd, yyyy");

		timelabel = new JLabel();
		timelabel.setFont(new Font("Verdana",Font.PLAIN,40));
		//timelabel.setForeground(new Color(0x00FF00));
		timelabel.setBackground(Color.BLACK);
		//timelabel.setOpaque(true);
		
		daylabel = new JLabel();
		daylabel.setFont(new Font("Ink Free",Font.PLAIN,35));
		daylabel.setForeground(new Color(0x691c99));
		
		datelabel = new JLabel();
		datelabel.setFont(new Font("Ink Free",Font.PLAIN,30));
		datelabel.setForeground(new Color(0x580100));

		time = timeformat.format(Calendar.getInstance().getTime());

		timelabel.setText(time);

		this.add(timelabel);
		this.add(daylabel);
		this.add(datelabel);
		this.setVisible(true);

		setTime();
	}

	public void setTime() {
		while(true) {
			time = timeformat.format(Calendar.getInstance().getTime());
			timelabel.setText(time);
			
			day = dayformat.format(Calendar.getInstance().getTime());
			daylabel.setText(day);
			
			date = dateformat.format(Calendar.getInstance().getTime());
			datelabel.setText(date);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
