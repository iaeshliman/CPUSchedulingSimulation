package aeshliman.events;

public abstract class Event implements Comparable<Event>
{
	private int time;
	
	public Event(int time)
	{
		this.time = time;
	}
	
	public int getTime() { return this.time; }
	
	public abstract int resolve();
	
	public int compareTo(Event event)
	{
		return this.time - event.getTime();
	}
}
