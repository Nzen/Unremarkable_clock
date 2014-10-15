package ws.nzen.clock;

public class ViewRoot
{
	private Run channelUp;
	private ClockView mainUi;
	private SettingsView configUi;

	public ViewRoot( Run parent )
	{
		channelUp = parent;
	}

	// start clockview, when the settings are ready
	// listen for config thing
	public void genClockView( ClockSettings settings )
	{
		mainUi = new ClockView( this, settings );
	}

	public void genSettingsView( ClockSettings settings )
	{
		configUi = new SettingsView( this, settings );
	}

	public ClockView getCview()
	{
		return mainUi;
	}

	public void receiveMessage( EventVw_Op fromBelow )
	{
		channelUp.receiveToOpEv( fromBelow );
	}

	public void routeMessage( EventMd_Vw fromAbove )
	{
		/*FlagModel why = fromAbove.why();
		if ( why == FlagModel.fontChange || why == FlagModel.frameXchange || why == FlagModel.frameYchange )
		{
			mainUi.processMessage( fromAbove );
		}
		// appropriate when SettingsView ever expects a message, or a switch if there is a good split
		*/
		mainUi.processMessage( fromAbove );
	}
}














