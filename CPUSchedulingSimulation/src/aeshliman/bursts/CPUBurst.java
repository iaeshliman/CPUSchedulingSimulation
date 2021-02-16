package aeshliman.bursts;

public class CPUBurst extends Burst
{
	public CPUBurst(int time)
	{
		super(time);
	}
	
	public String toString()
	{
		return "CPU Burst " + this.getTime();
	}
}
