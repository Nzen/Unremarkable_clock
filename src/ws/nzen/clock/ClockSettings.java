package ws.nzen.clock;

public class ClockSettings
{
	private Run channelUp;
	private int xPos;
	private int yPos;
	private int wid;
	private int high;
	private int frameWid;
	private int frameHigh;
	private boolean milit;
	private boolean hasSec;
	private int fontSize; // FOR DEMO cut

	public ClockSettings( Run parent )
	{
		channelUp = parent;
		xPos = 10;
		yPos = 10;
		wid = 100;
		high = 50;
		frameWid = 200;
		frameHigh = 80;
		milit = false;
		hasSec = true;
		fontSize = 12;
	}

	public ClockSettings( Run parent, int x, int y, int w, int h, int frW, int frH, boolean military, boolean seconds )
	{
		channelUp = parent;
		xPos = x;
		yPos = y;
		wid = w;
		high = h;
		frameWid = frW;
		frameHigh = frH;
		milit = military;
		hasSec = seconds;
		fontSize = 12;
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

	/* eventint holds a ref to the cView now, to call its stateChanged() when appropriate
	public void registerListener( ClockView theView )
	{
		fontSize.addChangeListener( theView );
	}*/

	public int getXpos()
	{	return xPos;	}

	public int getYpos()
	{	return yPos;	}

	public int getWidth()
	{	return wid;	}

	public int getHeight()
	{	return high;	}

	public int getFrameWidth()
	{	return frameWid;	}

	public int getFrameHigh()
	{	return frameHigh;	}

	public boolean get12hour()
	{	return milit;	}

	public boolean getSecPref()
	{	return hasSec;	}

	public int getFontSize()
	{	return fontSize;	}

	public void setXpos( int newX )
	{	
		xPos = newX;
		channelUp.receiveToViewEv( new EventMd_Vw(newX, FlagModel.frameXchange) );
	}

	public void setYpos( int newY ) // sanity checks on any of these? responsibility is here
	{	
		yPos = newY;
		channelUp.receiveToViewEv( new EventMd_Vw(newY, FlagModel.frameYchange) );
	}

	public void setWidth( int newW )
	{	
		wid = newW;
		channelUp.receiveToViewEv( new EventMd_Vw(newW, FlagModel.clockWchange) );
	}

	public void setHeight( int newH )
	{	
		high = newH;
		channelUp.receiveToViewEv( new EventMd_Vw(newH, FlagModel.clockHchange) );
	}

	public void setFrameWidth( int newFrWi )
	{	
		frameWid = newFrWi;
		channelUp.receiveToViewEv( new EventMd_Vw(newFrWi, FlagModel.frameWchange) );
	}

	public void setFrameHeight( int newFrHi )
	{	
		frameHigh = newFrHi;
		channelUp.receiveToViewEv( new EventMd_Vw(newFrHi, FlagModel.frameHchange) );
	}

	public void set12hour( boolean whether )
	{	
		milit = whether;
	}

	public void setFontSize( int nSize )
	{
		// sanity check
		if ( nSize < 0 )
			return;
		else
		{
			fontSize = nSize;
			channelUp.receiveToViewEv( new EventMd_Vw(nSize, FlagModel.fontChange) );
			// this may be questionable, as it means I'm setting to a stale value sometimes.
		}
	}
}













