package aeshliman.structure;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import aeshliman.comparators.SortByBurstTime;
import aeshliman.comparators.SortByPriority;
import aeshliman.enumerators.Algorithm;

public class IOScheduler
{
	// Instance Variables
	private Simulation simulation;
	private Algorithm algorithm;
	private IO io;
	private int quantum;
	private Queue<CustomProcess> waitingQueue;
	
	// Constructors
	public IOScheduler(Simulation simulation, Algorithm algorithm, IO io, int quantum)
	{
		this.simulation = simulation;
		this.algorithm = algorithm;
		this.io = io;
		this.quantum = quantum;
		if(algorithm==Algorithm.SJF) this.waitingQueue = new PriorityQueue<CustomProcess>(new SortByBurstTime());
		else if(algorithm==Algorithm.PS) this.waitingQueue = new PriorityQueue<CustomProcess>(new SortByPriority());
		else this.waitingQueue = new LinkedList<CustomProcess>();
	}
	
	// Getters
	public Simulation getSimulation() { return this.simulation; }
	public Algorithm getAlgorithm() { return this.algorithm; }
	public IO getIO() { return this.io; }
	public int getQuantum() { return this.quantum; }
	public Queue<CustomProcess> getWaitingQueue() { return this.waitingQueue; }
	
	// Operations
	public void resolveWaitingQueueEvent()
	{
		algorithm.algorithm(simulation,io,waitingQueue);
	}
}
