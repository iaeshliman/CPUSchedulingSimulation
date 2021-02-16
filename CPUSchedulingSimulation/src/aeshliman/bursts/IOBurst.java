package aeshliman.bursts;

public class IOBurst extends Burst
{
	public IOBurst(int time)
	{
		super(time);
	}
	
	public String toString()
	{
		return "IO Burst " + this.getTime();
	}
}
