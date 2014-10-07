package ws.nzen.clock;

public class ClockInit
{
	ClockMod clockfile;
	ClockView face;

	public ClockInit()
	{
		clockfile = new ClockMod();
		face = new ClockView();
	}
	// perhaps I get info from a file or db or the user, I don't know.
	public void stubstubmockmock()
	{
		int nn = clockfile.getHeight();
		face.changeLabel( new Integer(nn).toString() );
	}
}
