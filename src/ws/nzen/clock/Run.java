package ws.nzen.clock;

public class Run
{
	public static void main( String[] args )
	{
		Run everything = new Run();
		RunClock mainOp = new RunClock();
		ViewRoot holdsGuis = new ViewRoot();
		holdsGuis.genClockView( mainOp.upSettings() );
		mainOp.getVparent( holdsGuis ); // CUT and move to here
		mainOp.receiveClockV( holdsGuis.getCview() );
		mainOp.launchClock();
		// le sigh
		//mainOp.channelUp( everything );
	}

	/*
	public Run()
	{
		RunClock mainOp = new RunClock();
		ViewRoot holdsGuis = new ViewRoot();
		holdsGuis.genClockView( mainOp.upSettings() );
		mainOp.receiveClockV( holdsGuis.getCview() );
		//mainOp.channelUp( everything );
		mainOp.launchClock();
	}
	*/
}
