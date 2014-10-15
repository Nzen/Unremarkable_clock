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
		mainUi = new ClockView( settings );
	}

	public ClockView getCview()
	{
		return mainUi;
	}

	public void genSettingsView()
	{
		configUi = new SettingsView( this );
	}

	public SettingsView getCSview()
	{
		return configUi;
	}

	public void receiveMessage( ToOperationEvent fromBelow )
	{
		channelUp.receiveToOpEv( fromBelow );
	}
}
