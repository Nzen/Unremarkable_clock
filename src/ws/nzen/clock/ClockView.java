package ws.nzen.clock;

import java.awt.FlowLayout;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClockView
{
	private JFrame frame;
	private JLabel label;
	private Date now;
	private SimpleDateFormat digits;
	//private ClockConfig model;

	public ClockView( ClockConfig fromInit )
	{
		//model = fromInit;
		guiPart( fromInit );
		clockPart( fromInit );
		// frame.pack(); // appropriate once the w/h refers to the component not the frame
		frame.setVisible(true);
	}

	protected void guiPart( ClockConfig fromInit )
	{
		frame = new JFrame( "Clock : Nzen" );
		label = new JLabel();
		frame.setLocation( fromInit.getXpos(), fromInit.getYpos() );
		frame.setSize( fromInit.getWidth(), fromInit.getHeight() );
		frame.setLayout(new FlowLayout());
		frame.getContentPane().add(label);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	protected void clockPart( ClockConfig fromInit )
	{
		now = new Date(); // if I can get a new Long representing the current milliseconds, then I can update it :/
		digits = new SimpleDateFormat( fromInit.getDateFormat() );
		label.setText( digits.format(now) );
	}

	public void updateTime( int delay )
	{
		now.setTime( now.getTime() + delay );
		label.setText( digits.format(new Date()) );
	}
}
