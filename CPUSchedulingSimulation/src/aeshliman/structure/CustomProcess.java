package aeshliman.structure;

import java.util.Queue;
import aeshliman.bursts.Burst;
import aeshliman.enumerators.State;

public class CustomProcess
{
	// Instance Variables
	private static int count = 0;
	private int pid;
	private String name;
	private State state;
	private int priority;
	private int arrivalTime;
	private int finishTime;
	private int turnaroundTime;
	private Queue<Burst> bursts;
	
	// Constructors
	public CustomProcess(String name, int priority, int arrivalTime, Queue<Burst> bursts)
	{
		this.pid = count++;
		this.name = name;
		this.state = State.NEW;
		this.priority = priority;
		this.arrivalTime = arrivalTime;
		this.finishTime = -1;
		this.turnaroundTime = -1;
		this.bursts = bursts;
	}
	
	// Getters
	public int getPID() { return this.pid; }
	public String getName() { return this.name; }
	public State getState() { return this.state; }
	public int getPriority() { return this.priority; }
	public int getArrivalTime() { return this.arrivalTime; }
	public int getFinishTime() { return this.finishTime; }
	public int getTuraroundTime() { return this.turnaroundTime; }
	public Queue<Burst> getBursts() { return this.bursts; }
	
	// Setters
	public void setFinishTime(int finishTime) { this.finishTime = finishTime; }
	public void setTurnaroundTime(int turnaroundTime) { this.turnaroundTime = turnaroundTime; }
	
	// Operations
	public int peekBurstTime()
	{
		return bursts.peek().getTime();
	}
	
	// toString
	public String toString()
	{
		String toString = "Name: " + name + " PID: " + pid + " State: " + state + " Priority: " + priority
				+ "\n\tArrival Time: " + arrivalTime + " Finish Time: " + finishTime + " Turnaround Time: " + turnaroundTime;
		for(Burst burst : bursts) toString += "\n\t" + burst.toString();
		return toString;
	}
}
