package ws.nzen.clock;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class ClockRunner
{
	private Run channelUp;
	private ClockView face;

	public ClockRunner( Run mainMainOp )
	{
		channelUp = mainMainOp;
	}

	public void receiveClockV( ClockView fromGuis )
	{
		face = fromGuis;
	}

	public void runClock()
	{
		final int delay = 500;
		Timer renew = new Timer( delay, new ActionListener() { // half second update
	        public void actionPerformed(ActionEvent evt) {
	            face.updateTime( delay );
	        }
	    } );
		renew.start();
	}
}
