package ws.nzen.clock;

public class EventVw_Op extends ClockSysEvent
{
	private FlagView why;

	public EventVw_Op( Object val, FlagView reason )
	{
		super( val );
		why = reason;
	}

	public FlagView why()
	{
		return why;
	}
}
