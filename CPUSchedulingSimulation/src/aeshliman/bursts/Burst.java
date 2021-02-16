package aeshliman.bursts;

public abstract class Burst
{
	// Instance Variables
	private int time;
	
	// Constructors
	public Burst(int time)
	{
		this.time = time;
	}
	
	// Getters and Setters
	public int getTime() { return this.time; }
	public void setTime(int time) { this.time = time; }
}
