package ws.nzen.clock;

public class ViewRoot
{
	private ClockView mainUi;
	private SettingsView configUi;

	// start clockview
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
		configUi = new SettingsView();
	}

	public SettingsView getCSview()
	{
		return configUi;
	}
}
