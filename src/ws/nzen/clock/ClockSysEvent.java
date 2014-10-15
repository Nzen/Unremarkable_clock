package ws.nzen.clock;

public abstract class ClockSysEvent
{
	Object value;

	public ClockSysEvent( Object val )
	{
		value = val;
	}

	public Object val()
	{
		return value;
	}
}
