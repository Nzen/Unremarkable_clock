package ws.nzen.clock;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingsView
{
	private JFrame frame;
	private JButton bigFonter;
	private JButton smallFonter;
	//private UpdatesSettings listener;
	private ViewRoot channelUp; // for event passing only

	public SettingsView( ViewRoot parent )// implements ActionListener
	{
		channelUp = parent;
		frame = new JFrame( "Configuration" );
		frame.setLocation( 100, 100 ); // should user edit the configs for this too? not generally, but this is a component. eh
		JPanel bounds = new JPanel();
		bounds.setLayout(new FlowLayout()); // needs constraint things
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MAYBE tell viewroot to null this
		//label = new JLabel();
		bigFonter = new JButton( "bigger" );
		smallFonter = new JButton( "smaller" );
		bounds.add(smallFonter);
		bounds.add(bigFonter);
		frame.getContentPane().add( bounds );
		frame.pack();
		wireEvents();
		frame.setVisible(true);
	}

	public void wireEvents() // Sorry for the dissonant code style.
	{
		bigFonter.addActionListener(
			new ActionListener() {
				public void actionPerformed( ActionEvent buttonPress ) {
					channelUp.receiveMessage( new ToOperationEvent( new Integer(5), ViewEvent.biggerFont ) );
			}	}
		);

		smallFonter.addActionListener(
			new ActionListener() {
				public void actionPerformed( ActionEvent buttonPress ) {
					channelUp.receiveMessage( new ToOperationEvent( new Integer(5), ViewEvent.smallerFont ) );
			}	}
		);
	}

	/*public void receiveUpdateListener( UpdatesSettings us )
	{
		//listener = us;
		bigFonter.addActionListener( us );
		smallFonter.addActionListener( us );
	}*/

	/*@Override
	public void actionPerformed( ActionEvent arg0 )
	{
		JButton nn = (JButton) arg0.getSource(); // FIX to more robust caller identification
		String name = nn.getText();
		if ( name.equals( "bigger" ) ) 
			model.setFontSize( model.getFontSize() + 10 );
		else
			model.setFontSize( model.getFontSize() - 10 );
	}*/
}
/*
	private int xPos;
	private int yPos;
	private int wid;
	private int high;
	private boolean milit;
	private boolean hasSec;
	private EventInt fontSize;
 */