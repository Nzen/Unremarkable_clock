package ws.nzen.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class RunClock implements ActionListener
{
	ClockSettings clockfile;
	ClockView face;
	ViewRoot vParent;
	UpdatesSettings justFont;

	public RunClock()
	{
		// perhaps I get info from a file or db or the user, I don't know.
		clockfile = new ClockSettings();
	}

	public void receiveClockV( ClockView fromGuis )
	{
		face = fromGuis;
		registerListener();
	}

	// give cview a ref of self to call when button actionPerformed
	private void registerListener()
	{
		face.addListener( this );
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

	public void getVparent( ViewRoot vp ) // CUT and move to Run instead
	{
		vParent = vp;
	}

	public void actionPerformed( ActionEvent launchEditor )
	{
		//clockfile.setFontSize( clockfile.getFontSize() + 10 );
		//SettingsView editV = new SettingsView(); // FIX by sending to parent or viewroot
		// harvest the stuff? or wait for events?
		//System.out.println( "inter object communication" );
		justFont = new UpdatesSettings( clockfile );
		vParent.genSettingsView();
		justFont.receiveSettingsView( vParent.getCSview() );
	}

	public ClockSettings upSettings()
	{
		return clockfile;
	}
}
