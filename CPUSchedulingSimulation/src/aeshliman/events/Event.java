package aeshliman.events;

import java.util.PriorityQueue;

/*
 * Description: An event is a time based series of actions that occur.
 * 		Each event has a time of activation (used for sorting inside
 * 		a priority queue) and a triggering circumstance. The trigger
 * 		causes the event to be added to the priority queue and the event
 * 		is resolved when the queue reaches the event. Some events are
 * 		resolved immediately after being triggered.
 */

public abstract class Event implements Comparable<Event>
{
	// Instance Variables
	private static int count = 0;
	private int id;
	private int time;
	private PriorityQueue<Event> events;
	
	// Constructors
	public Event(int time,  PriorityQueue<Event> events)
	{
		this.id = count++;
		this.time = time;
		this.events = events;
	}
	
	// Getters
	public int getTime() { return this.time; }
	public  PriorityQueue<Event> getEvents() { return this.events; }
	
	// Operations
	public abstract int resolve();
	
	// Comparable interface methods
	public int compareTo(Event event)
	{
		if(this.time!=event.time) return this.time - event.time;
		return this.id - event.id; // If both events share the same time sort by event creation order
	}
	
	// toString
	public String toString()
	{
		return "Event " + this.id + "  Event Type: " + this.getClass().getSimpleName() + "  Time: " + this.time;
	}
}
