package aeshliman.enumerators;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import aeshliman.comparators.SortByBurstTime;
import aeshliman.comparators.SortByPriority;
import aeshliman.events.CPUEvent;
import aeshliman.events.Event;
import aeshliman.events.IOEvent;
import aeshliman.structure.CustomProcess;
import aeshliman.structure.Device;
import aeshliman.structure.IO;
import aeshliman.structure.Simulation;

public enum Algorithm
{
	FCFS // First-Come First-Serve
	{
		// Standard queue
		public Queue<CustomProcess> getQueue() { return new LinkedList<CustomProcess>(); }
		
		// Duration of next burst
		public void algorithm(Simulation sim, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process); // Places process into device
				Event event;
				// If device is IO creates IOEvent else CPU event
				if(device instanceof IO) event = new IOEvent(sim.getTime()+process.peekBurstTime(),sim.getEvents(),sim.getIO(),sim.getCPUScheduler(),sim.getIOScheduler());
				else event = new CPUEvent(sim.getTime()+process.peekBurstTime(),sim.getEvents(),sim.getCPU(),sim.getCPUScheduler(),sim.getIOScheduler());
				sim.getEvents().add(event); // Adds event to priority queue
			}
		}
	},
	RR // Round Robin
	{
		// Standard queue
		public Queue<CustomProcess> getQueue() { return new LinkedList<CustomProcess>(); }
		
		// Minimum between duration of next burst and quantum time slice
		public void algorithm(Simulation sim, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process); // Places process into device
				Event event;
				// If device is IO creates IOEvent else CPU event
				if(device instanceof IO) event = new IOEvent(sim.getTime()+Math.min(process.peekBurstTime(),sim.getQuantum()),sim.getEvents(),sim.getIO(),sim.getCPUScheduler(),sim.getIOScheduler());
				else event = new CPUEvent(sim.getTime()+Math.min(process.peekBurstTime(),sim.getQuantum()),sim.getEvents(),sim.getCPU(),sim.getCPUScheduler(),sim.getIOScheduler());
				sim.getEvents().add(event); // Adds event to priority queue
			}
		}
	},
	SJF // Shortest Job First
	{
		// Sorted by shortest burst times
		public Queue<CustomProcess> getQueue() { return new PriorityQueue<CustomProcess>(new SortByBurstTime()); }
		
		// Duration of next burst 
		public void algorithm(Simulation sim, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process); // Places process into device
				Event event;
				// If device is IO creates IOEvent else CPU event
				if(device instanceof IO) event = new IOEvent(sim.getTime()+process.peekBurstTime(),sim.getEvents(),sim.getIO(),sim.getCPUScheduler(),sim.getIOScheduler());
				else event = new CPUEvent(sim.getTime()+process.peekBurstTime(),sim.getEvents(),sim.getCPU(),sim.getCPUScheduler(),sim.getIOScheduler());
				sim.getEvents().add(event); // Adds event to priority queue
			}
		}
	},
	PS // Priority Scheduling
	{
		// Sorted by highest to lowest priority (0 being high and 9 being low)
		public Queue<CustomProcess> getQueue() { return new PriorityQueue<CustomProcess>(new SortByPriority()); }
		
		// Duration of next burst
		public void algorithm(Simulation sim, Device device, Queue<CustomProcess> queue)
		{
			CustomProcess process = queue.poll();
			if(process!=null)
			{
				device.setProcess(process); // Places process into device
				Event event;
				// If device is IO creates IOEvent else CPU event
				if(device instanceof IO) event = new IOEvent(sim.getTime()+process.peekBurstTime(),sim.getEvents(),sim.getIO(),sim.getCPUScheduler(),sim.getIOScheduler());
				else event = new CPUEvent(sim.getTime()+process.peekBurstTime(),sim.getEvents(),sim.getCPU(),sim.getCPUScheduler(),sim.getIOScheduler());
				sim.getEvents().add(event); // Adds event to priority queue
			}
		}
	};
	
	// Methods
	public abstract Queue<CustomProcess> getQueue(); // Returns correct type of queue depending on algorithm
	public abstract void algorithm(Simulation sim, Device device, Queue<CustomProcess> queue); // Selects correct process based on algorithm
}
