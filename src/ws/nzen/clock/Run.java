package ws.nzen.clock;

public class Run
{
	private RunClock mainOp;
	private UpdatesSettings configger;
	private ViewRoot holdsGuis;

	public static void main( String[] args )
	{
		Run everything = new Run();
		/*RunClock mainOp = new RunClock();
		ViewRoot holdsGuis = new ViewRoot();
		holdsGuis.genClockView( mainOp.upSettings() );
		mainOp.getVparent( holdsGuis ); // CUT and move to here
		mainOp.receiveClockV( holdsGuis.getCview() );
		mainOp.launchClock();
		// le sigh
		//mainOp.channelUp( everything );
		*/
	}

	public Run()
	{
		mainOp = new RunClock( this );
		holdsGuis = new ViewRoot( this );
		holdsGuis.genClockView( mainOp.upSettings() );
		mainOp.getVparent( holdsGuis );
		mainOp.receiveClockV( holdsGuis.getCview() );
		//mainOp.channelUp( everything );
		mainOp.launchClock();
	}

	// public Run( ClockSettings forValidation )
	// public Run( file forLoading )
	// public Run( dbo handleForQuerying )

	public void receiveToOpEv( ToOperationEvent fromConfigView )
	{
		switch ( fromConfigView.why() )
		{
		case biggerFont:
		case smallerFont:
			configger.changeFont( fromConfigView );
		default:
			System.out.print( fromConfigView );
		}
	}

	public void getUSet( UpdatesSettings fromRunClock )
	{
		configger = fromRunClock;
	}
}
