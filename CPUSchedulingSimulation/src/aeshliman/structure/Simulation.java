package aeshliman.structure;

import java.util.LinkedList;
import java.util.PriorityQueue;

import aeshliman.enumerators.Algorithm;
import aeshliman.events.Event;

public class Simulation
{
	private LinkedList<CustomProcess> processes;
	private CPU cpu;
	private IO io;
	private CPUScheduler cpuScheduler;
	private IOScheduler ioScheduler;
	private PriorityQueue<Event> events;
	private int quatum;
	private int time;
	
	public Simulation(Algorithm algorithm, int quantum)
	{
		this.processes = new LinkedList<CustomProcess>();
		this.cpu = new CPU();
		this.io = new IO();
		this.cpuScheduler = new CPUScheduler(this,algorithm,cpu,quantum);
		this.ioScheduler = new IOScheduler(this,algorithm,io,quantum);
		this.events = new PriorityQueue<Event>();
		this.quatum = quantum;
		this.time = 0;
	}
	
	public LinkedList<CustomProcess> getProcesses() { return this.processes; }
	public CPUScheduler getCPUScheduler() { return this.cpuScheduler; }
	public IOScheduler getIOScheduler() { return this.ioScheduler; }
	public PriorityQueue<Event> getEvents() { return this.events; }
	public int getQuantum() { return this.quatum; }
	public int getTime() { return this.time; }
	
	public void addEvent(Event event)
	{
		events.add(event);
	}
	
	public void run()
	{
		while(true)
		{
			Event event = events.poll();
			if(events!=null)
			{
				event.resolve();
			}
		}
	}
}
