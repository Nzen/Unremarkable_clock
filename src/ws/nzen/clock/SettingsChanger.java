package ws.nzen.clock;

public class SettingsChanger
{
	private ClockSettings model;

	public SettingsChanger( ClockSettings toChange )
	{
		model = toChange;
	}

	public void processMessage( EventVw_Op fromConfig )
	{
		switch ( fromConfig.why() )
		{
		case biggerFont:
		case smallerFont:
		{
			changeFont( fromConfig );
			break;
		}
		case frameX:
		{
			changeFrameX( fromConfig );
			break;
		}
		case frameY:
		{
			changeFrameY( fromConfig );
			break;
		}
                case frameW:
                {
                    changeFrameWid( fromConfig );
			break;
		}
                case frameH:
                {
                    changeFrameHi( fromConfig );
			break;
		}
                case clockW:
                {
                    changeClockWid( fromConfig );
			break;
		}
                case clockH:
                {
                    changeClockHi( fromConfig );
                }
		default:
			System.out.print( fromConfig );
		}
	}

	private void changeFrameY( EventVw_Op fromConfig )
	{
		model.setYpos( (Integer)fromConfig.val() );
	}

	private void changeFrameX( EventVw_Op fromConfig )
	{
		model.setXpos( (Integer)fromConfig.val() );
	}

	public void changeFont( EventVw_Op fromConfig )
	{
		if ( fromConfig.why() == FlagView.biggerFont )
			model.setFontSize( model.getFontSize() + (Integer)fromConfig.val() );
		else
			model.setFontSize( model.getFontSize() - (Integer)fromConfig.val() );
	}

	private void changeFrameWid( EventVw_Op fromConfig )
	{
		model.setFrameWidth( (Integer)fromConfig.val() );
	}

	private void changeFrameHi( EventVw_Op fromConfig )
	{
		model.setFrameHeight( (Integer)fromConfig.val() );
	}
   
	private void changeClockWid( EventVw_Op fromConfig )
        {
		model.setWidth( (Integer)fromConfig.val() );
        }
   
	private void changeClockHi( EventVw_Op fromConfig )
        {
		model.setHeight( (Integer)fromConfig.val() );
        }
}
