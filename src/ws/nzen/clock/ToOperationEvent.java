package ws.nzen.clock;

public class ToOperationEvent
{
	Object value;
	ViewEvent why;

	public ToOperationEvent( Object val, ViewEvent reason )
	{
		value = val;
		why = reason;
	}

	public Object val()
	{
		return value;
	}

	public ViewEvent why()
	{
		return why;
	}
}
