package ws.nzen.clock;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// I see that AbstractButton handles addActionListener, until I find a similar wrapper, I'll do this. sigh

// I think that the model should handle propertychanges, rather than the properties handle it
public class EventInt
{
	int val;
	ChangeListener target;

	public EventInt( int nn )
	{
		val = nn;
	}

	public void set( int nn )
	{
		val = nn;
		// oh man SANITY CHECK ! that changelistener isn't null
		fireItemStateChanged();
	}

	public int is()
	{
		return val;
	}

	public void addChangeListener( ChangeListener instant )
	{
		target = instant;
	}

	private void fireItemStateChanged()
	{
		target.stateChanged( new ChangeEvent( this ) ); // constructor is (Object source)
	}
}