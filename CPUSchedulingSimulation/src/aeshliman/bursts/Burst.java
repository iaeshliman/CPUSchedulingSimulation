package aeshliman.bursts;

public abstract class Burst
{
	private int time;
	
	public Burst(int time)
	{
		this.time = time;
	}
	
	public int getTime() { return this.time; }
	public void setTime(int time) { this.time = time; }
}
