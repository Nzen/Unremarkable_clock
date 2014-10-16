package ws.nzen.clock;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SettingsView
{
	private JFrame frame;
	private JButton bigFonter;
	private JButton smallFonter;
	private JSpinner xXpos;
	private JSpinner yYpos;
	private JSpinner frameWidth;
	private JSpinner frameHeight;
	private JSpinner clockWidth;
	private JSpinner clockHeight;
	private ViewRoot channelUp; // for event passing only

	public SettingsView( ViewRoot parent, ClockSettings initialVals )// implements ActionListener
	{
		channelUp = parent;
		frame = new JFrame( "Configuration" );
		frame.setLocation( 100, 100 ); // should user edit the configs for this too? not generally, but this is a component. eh
		JPanel bounds = new JPanel();
		bounds.setLayout(new GridBagLayout()); // needs constraint things
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // MAYBE tell viewRoot to null this
		bigFonter = new JButton( "bigger font" );
		bounds.add( bigFonter, defaultConstraints(0, 0) );
		smallFonter = new JButton( "smaller font" );
		bounds.add( smallFonter, defaultConstraints(1, 0) );
		bounds.add( new JLabel( "Frame X" ), defaultConstraints(0, 1) ); // column, row
		xXpos = new JSpinner( new SpinnerNumberModel(initialVals.getXpos(), 0, 5000, 25) );
		bounds.add( xXpos, defaultConstraints(1, 1) );
		bounds.add( new JLabel( "Frame Y" ), defaultConstraints(0, 2) );
		yYpos = new JSpinner( new SpinnerNumberModel(initialVals.getYpos(), 0, 5000, 25) );
		bounds.add( yYpos, defaultConstraints(1, 2) );
		bounds.add( new JLabel( "Frame W" ), defaultConstraints(2, 1) );
		frameWidth = new JSpinner( new SpinnerNumberModel(initialVals.getFrameWidth(), 30, 5000, 10) );
		bounds.add( frameWidth, defaultConstraints(3, 1) );
		bounds.add( new JLabel( "Frame H" ), defaultConstraints(2, 2) );
		frameHeight = new JSpinner( new SpinnerNumberModel(initialVals.getFrameHigh(), 30, 5000, 10) );
		bounds.add( frameHeight, defaultConstraints(3, 2) );
		bounds.add( new JLabel( "Clock W" ), defaultConstraints(0, 3) );
		clockWidth = new JSpinner( new SpinnerNumberModel(initialVals.getFrameWidth(), 30, 5000, 10) );
		bounds.add( clockWidth, defaultConstraints(1, 3) );
		bounds.add( new JLabel( "Clock H" ), defaultConstraints(0, 4) );
		clockHeight = new JSpinner( new SpinnerNumberModel(initialVals.getFrameHigh(), 30, 5000, 10) );
		bounds.add( clockHeight, defaultConstraints(1, 4) );

		frame.getContentPane().add( bounds );
		frame.pack();
		wireEvents();
		frame.setVisible(true);
	}

	private void wireEvents() // Sorry for the dissonant code style.
	{
		bigFonter.addActionListener(
			new ActionListener() { @Override
				public void actionPerformed( ActionEvent buttonPress ) {
					channelUp.receiveMessage( new EventVw_Op( new Integer(5), FlagView.biggerFont ) );
			}	}
		);
		smallFonter.addActionListener(
			new ActionListener() { @Override
				public void actionPerformed( ActionEvent buttonPress ) {
					channelUp.receiveMessage( new EventVw_Op( new Integer(5), FlagView.smallerFont ) );
			}	}
		);
		xXpos.addChangeListener(
			new ChangeListener() { @Override
				public void stateChanged( ChangeEvent spinnerSpun ) {
					channelUp.receiveMessage( new EventVw_Op( (Integer)xXpos.getValue(), FlagView.frameX ) );	
			}	}
		);
		yYpos.addChangeListener(
				new ChangeListener() { @Override
					public void stateChanged( ChangeEvent spinnerSpun ) {
						channelUp.receiveMessage( new EventVw_Op( (Integer)yYpos.getValue(), FlagView.frameY ) );	
				}	}
			);
		frameWidth.addChangeListener(
				new ChangeListener() { @Override
					public void stateChanged( ChangeEvent spinnerSpun ) {
						channelUp.receiveMessage( new EventVw_Op( (Integer)frameWidth.getValue(), FlagView.frameW ) );	
				}	}
			);
		frameHeight.addChangeListener(
				new ChangeListener() { @Override
					public void stateChanged( ChangeEvent spinnerSpun ) {
						channelUp.receiveMessage( new EventVw_Op( (Integer)frameHeight.getValue(), FlagView.frameH ) );	
				}	}
			);
		clockWidth.addChangeListener(
				new ChangeListener() { @Override
					public void stateChanged( ChangeEvent spinnerSpun ) {
						channelUp.receiveMessage( new EventVw_Op( (Integer)clockWidth.getValue(), FlagView.clockW ) );	
				}	}
			);
		clockHeight.addChangeListener(
				new ChangeListener() { @Override
					public void stateChanged( ChangeEvent spinnerSpun ) {
						channelUp.receiveMessage( new EventVw_Op( (Integer)clockHeight.getValue(), FlagView.clockH ) );	
				}	}
			);
	}

	private GridBagConstraints defaultConstraints( int column, int row )
	{
		return new GridBagConstraints(column, row, 1, 1, 1.0, 1.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(1,1,1,1), 0, 0 );
		//							gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady
	}
}
/*
	private int wid;
	private int high;
	private boolean milit;
	private boolean hasSec;
	private EventInt fontSize;
 */









