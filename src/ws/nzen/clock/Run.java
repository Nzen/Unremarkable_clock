package ws.nzen.clock;

public class Run
{
	private ClockRunner mainOp;
	private SettingsChanger configger;
	//
	private ViewRoot holdsGuis;
	private ClockSettings clockSpec;

	public static void main( String[] args )
	{
		Run everything = new Run();
	}

	public Run()
	{
		mainOp = new ClockRunner( this );
		holdsGuis = new ViewRoot( this );
		// fill clockspec
		clockSpec = new ClockSettings( this );
		holdsGuis.genClockView( clockSpec );
		mainOp.receiveClockV( holdsGuis.getCview() );
		mainOp.runClock();
	}

	// public Run( ClockSettings forValidation )
	// public Run( file forLoading )
	// public Run( dbo handleForQuerying )

	public void receiveToOpEv( EventVw_Op fromConfigView )
	{
		switch ( fromConfigView.why() )
		{
		case showSettings:
		{
			configger = new SettingsChanger( clockSpec );
			holdsGuis.genSettingsView( clockSpec );
			break;
		}
		case biggerFont:
		case smallerFont:
		case frameX:
		case frameY:
		{
			configger.processMessage( fromConfigView );
			break;
		}
		default:
			System.out.print( fromConfigView );
		}
	}

	public void receiveToViewEv( EventMd_Vw fromSettings )
	{
		switch( fromSettings.why() )
		{
		case fontChange:
		case frameXchange:
		case frameYchange:
		{
			holdsGuis.routeMessage( fromSettings );
			break;
		}
		default:
			System.out.println( "hmm?" );
		}
	}
}











