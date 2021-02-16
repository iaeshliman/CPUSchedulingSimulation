package aeshliman.bursts;

public class IOBurst extends Burst
{
	// Constructors
	public IOBurst(int time)
	{
		super(time);
	}
	
	// toString
	public String toString()
	{
		return "IO Burst " + this.getTime();
	}
}
