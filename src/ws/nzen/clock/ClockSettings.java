package ws.nzen.clock;

public class ClockSettings
{
	private int xPos;
	private int yPos;
	private int wid;
	private int high;
	private boolean milit;
	private boolean hasSec;
	private EventInt fontSize; // FOR DEMO cut
	// probably won't keep the Date here, given it updates so quickly.

	public ClockSettings()
	{
		xPos = 10;
		yPos = 10;
		wid = 250;
		high = 70;
		milit = false;
		hasSec = true;
		fontSize = new EventInt(12);
	}

	public ClockSettings( int x, int y, int w, int h )
	{
		xPos = x;
		yPos = y;
		wid = w;
		high = h;
		milit = false;
		hasSec = false;
		fontSize = new EventInt(12);
	}

	public ClockSettings( int x, int y, int w, int h, boolean military, boolean seconds )
	{
		xPos = x;
		yPos = y;
		wid = w;
		high = h;
		milit = military;
		hasSec = seconds;
		fontSize = new EventInt(12);
	}

	public String getDateFormat()
	{
		if ( hasSec )
		{
			return "hh:mm:ss";
		}
		// else if ( specified d format )
		//		return that
		else
		{
			return "hh:mm";
		}
	}

	// eventint holds a ref to the cView now, to call its stateChanged() when appropriate
	public void registerListener( ClockView theView )
	{
		fontSize.addChangeListener( theView );
	}

	public int getXpos()
	{	return xPos;	}

	public int getYpos()
	{	return yPos;	}

	public int getWidth()
	{	return wid;	}

	public int getHeight()
	{	return high;	}

	public boolean get12hour()
	{	return milit;	}

	public boolean getSecPref()
	{	return hasSec;	}

	public int getFontSize()
	{	return fontSize.is();	}

	public void setXpos( int newX )
	{	xPos = newX;	}

	public void setYpos( int newY ) // sanity checks on any of these? responsibility is here
	{	yPos = newY;	}

	public void setWidth( int newW )
	{	wid = newW;	}

	public void setHeight( int newH )
	{	high = newH;	}

	public void set12hour( boolean whether )
	{	milit = whether;	}

	public void setFontSize( int nSize )
	{
		// sanity check
		if ( nSize < 0 )
			return;
		else
			fontSize.set( nSize );
	}
}
