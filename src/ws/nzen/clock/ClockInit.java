package ws.nzen.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ClockInit implements ActionListener
{
	ClockConfig clockfile;
	ClockView face;

	public ClockInit()
	{
		// perhaps I get info from a file or db or the user, I don't know.
		clockfile = new ClockConfig();
		face = new ClockView( clockfile );
		registerListener();
	}

	public void launchClock()
	{
		final int delay = 500;
		Timer renew = new Timer( delay, new ActionListener() { // half second update
	        public void actionPerformed(ActionEvent evt) {
	            face.updateTime( delay );
	        }
	    } );
		renew.start();
	}

	private void registerListener()
	{
		face.addListener( this );
	}

	public void actionPerformed( ActionEvent bigFonter )
	{
		clockfile.setFontSize( clockfile.getFontSize() + 10 );
		System.out.println( "Cross listening worked" );
	}
}
