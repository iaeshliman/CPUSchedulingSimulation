package aeshliman.bursts;

public class CPUBurst extends Burst
{
	// Constructors
	public CPUBurst(int time)
	{
		super(time);
	}
	
	// toString
	public String toString()
	{
		return "CPU Burst " + this.getTime();
	}
}
