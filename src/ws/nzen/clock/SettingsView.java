package ws.nzen.clock;

import java.awt.FlowLayout;

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

	public SettingsView()
	{
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
		frame.setVisible(true);
	}

	public void receiveUpdateListener( UpdatesSettings us )
	{
		//listener = us;
		bigFonter.addActionListener( us );
		smallFonter.addActionListener( us );
	}
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