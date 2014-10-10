package ws.nzen.clock;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ClockView implements ChangeListener
{
	private JFrame frame;
	private JLabel label;
	private Date now;
	private JButton bigFonter;
	private SimpleDateFormat digits;
	//private ClockConfig model;

	public ClockView( ClockConfig fromInit ) // FIX model
	{
		//model = fromInit;
		guiPart(fromInit );
		clockPart(fromInit );
		// frame.pack(); // appropriate once the w/h refers to the component not the frame
		frame.setVisible(true);
	}

	protected void guiPart( ClockConfig model ) // FIX model
	{
		frame = new JFrame( "Clock : Nzen" );
		frame.setLocation( model.getXpos(), model.getYpos() );
		frame.setSize( model.getWidth(), model.getHeight() );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		label = new JLabel();
		bigFonter = new JButton( "bigger font" );
		frame.getContentPane().add(label);
		frame.getContentPane().add(bigFonter);

		awaitFontChange( model );
	}

	protected void clockPart( ClockConfig model )
	{
		now = new Date(); // if I can get a new Long representing the current milliseconds, then I can update it :/
		// however, if the thread ends up waiting, then this clock will run 'fast'
		digits = new SimpleDateFormat( model.getDateFormat() );
		label.setText( digits.format(now) );
	}

	public void addListener( ClockInit handler )
	{
		bigFonter.addActionListener( handler );
	}

	public void awaitFontChange( ClockConfig fromInit )
	{
		fromInit.registerListener( this );
	}

	public void updateTime( int delay )
	{
		now.setTime( now.getTime() + delay );
		label.setText( digits.format(new Date()) );
	}

	public void stateChanged( ChangeEvent ev ) // from config
	{
		EventInt nn = (EventInt)ev.getSource();
		int nSize = nn.is();
		label.setFont( new Font( "Serif", Font.PLAIN, nSize ) ); // and then get the value from the valuechanged event
		// or, dump model and do ClockConfig model = ev.getSource()
		// l.set( n F("" f.f, model.getfontsize() ); // except this might actually surrender the EventFiringInteger that changed, not the parent. hmm
	}
}
