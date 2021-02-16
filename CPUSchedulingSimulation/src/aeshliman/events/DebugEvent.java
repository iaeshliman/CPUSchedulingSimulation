package aeshliman.events;

import java.util.PriorityQueue;

import javax.swing.JOptionPane;

import aeshliman.structure.CustomProcess;
import aeshliman.structure.Simulation;

public class DebugEvent extends Event
{
	// Instance Variables
	private final int step = 5; // Default step value between debug events
	private Simulation sim;
	
	// Constructor
	public DebugEvent(int time, PriorityQueue<Event> events, Simulation sim)
	{
		super(time,events);
		this.sim = sim;
	}
	
	// Operations
	public int resolve()
	{
		// Prints values of all parts of the simulations including:
		// CPU and ReadyQueue
		// IO and WaitingQueue
		// Processes
		// Events
		System.out.print("#####Debug Event Triggered at Time " + this.getTime() + "#####");
		String debug = "\n===============================\n";
		debug += "CPU Status\n-------------------------------\n";
		debug += sim.getCPU();
		debug += "\n***\n^^^^^^^^^^^^^^^^\nReady Queue\n";
		for(CustomProcess process : sim.getCPUScheduler().getReadyQueue()) debug += process.getName() + "\n";
		debug += "^^^^^^^^^^^^^^^^\nIO Status\n-------------------------------\n";
		debug += sim.getIO();
		debug += "\n***\n^^^^^^^^^^^^^^^^\nWaiting Queue\n";
		for(CustomProcess process : sim.getIOScheduler().getWaitingQueue()) debug += process.getName() + "\n";
		debug += "^^^^^^^^^^^^^^^^\nProcess Status\n-------------------------------\n";
		for(CustomProcess process : sim.getProcesses()) debug += process + "\n***\n";
		debug += "Events Queue\n---------------------------------\n";
		for(Event event : sim.getEvents()) debug += event + "\n";
		debug += "===============================";
		System.out.println(debug);
		JOptionPane.showMessageDialog(null,"Confirm Before Continuing");
		sim.getEvents().add(new DebugEvent(this.getTime()+step,this.getEvents(),sim));
		return this.getTime();
	}
}
