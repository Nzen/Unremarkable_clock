package ws.nzen.clock;

public class EventMd_Vw extends ClockSysEvent
{
	private FlagModel why;

	public EventMd_Vw( Object val, FlagModel reason )
	{
		super( val );
		why = reason;
	}

	public FlagModel why()
	{
		return why;
	}
}
