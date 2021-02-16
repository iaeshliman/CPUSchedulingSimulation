package aeshliman.structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import aeshliman.bursts.*;
import aeshliman.enumerators.Algorithm;
import aeshliman.events.Event;
import aeshliman.events.NewProcessEvent;

public class Simulation
{
	// Instance Variables
	private LinkedList<CustomProcess> processes;
	private CPU cpu;
	private IO io;
	private CPUScheduler cpuScheduler;
	private IOScheduler ioScheduler;
	private PriorityQueue<Event> events;
	private int quatum;
	private int time;
	
	// Constructors
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
	
	// Getters
	public LinkedList<CustomProcess> getProcesses() { return this.processes; }
	public CPU getCPU() { return this.cpu; }
	public IO getIO() { return this.io; }
	public CPUScheduler getCPUScheduler() { return this.cpuScheduler; }
	public IOScheduler getIOScheduler() { return this.ioScheduler; }
	public PriorityQueue<Event> getEvents() { return this.events; }
	public int getQuantum() { return this.quatum; }
	public int getTime() { return this.time; }
	
	// Operations
	public void run()
	{
		while(true) // Loops until events queue is empty
		{
			Event event = events.poll();
			if(events!=null)
			{
				time = event.resolve();
				// Debugging purposes
				System.out.println("#####Resolved " + event.getClass().getSimpleName() + " at time " + time + "#####");
			}
			else break;
		}
	}
	
	// Initializes simulation according to data in scenario file
	public void loadScenario(String path)
	{
		try(Scanner scan = new Scanner(new File(path));)
		{
			while(scan.hasNext())
			{
				String[] line = scan.nextLine().split(" ");
				Queue<Burst> bursts = new LinkedList<Burst>();
				for(int i=3;i<line.length;i++)
				{
					// Ever even number after the 2rd indexed number references an IO burst, odd references a CPU burst
					if(i%2==0) bursts.add(new IOBurst(Integer.parseInt(line[i])));
					else bursts.add(new CPUBurst(Integer.parseInt(line[i])));
				}
				// Creates the process, adds it to the list of processes, and adds a NewProcessEvent to the events queue
				CustomProcess process = new CustomProcess(line[0],Integer.parseInt(line[1]),Integer.parseInt(line[2]),bursts);
				processes.add(process);
				events.add(new NewProcessEvent(Integer.parseInt(line[1]),events,process,cpuScheduler,ioScheduler));
			}
		}
		catch(FileNotFoundException e) { e.printStackTrace(); }
	}
	
	// toString
	public String toString()
	{
		return null;
	}
}
