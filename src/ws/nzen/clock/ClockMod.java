package ws.nzen.clock;

public class ClockMod
{
	private int xPos;
	private int yPos;
	private int wid;
	private int high;
	private boolean milit;
	private boolean hasSec;
	// probably won't keep the Date here, given it updates so quickly.

	public ClockMod()
	{
		xPos = 10;
		yPos = 10;
		wid = 200;
		high = 200;
	}

	public ClockMod( int x, int y, int w, int h )
	{
		xPos = x;
		yPos = y;
		wid = w;
		high = h;
	}

	public ClockMod( int x, int y, int w, int h, boolean military, int nn )
	{
		xPos = x;
		yPos = y;
		wid = w;
		high = h;
		milit = military;
	}

	public int getXpos()
	{	return xPos;	}

	public int getYpos()
	{	return yPos;	}

	public int getWidth()
	{	return wid;	}

	public int getHeight()
	{	return high;	}

	public void setXpos( int newX )
	{	xPos = newX;	}

	public void setYpos( int newY )
	{	yPos = newY;	}

	public void setWidth( int newW )
	{	wid = newW;	}

	public void setHeight( int newH )
	{	high = newH;	}

	public void set12hour( boolean whether )
	{	milit = whether;	}
}
