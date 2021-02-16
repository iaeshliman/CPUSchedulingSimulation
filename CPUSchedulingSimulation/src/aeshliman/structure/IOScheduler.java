package aeshliman.structure;

import java.util.Queue;

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
		this.waitingQueue = this.algorithm.getQueue();
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
	
	// toString
	public String toString()
	{
		String toString = "Algorithm: " + algorithm + "\tQuantum Slice: " + quantum + io.toString();
		for(CustomProcess process : waitingQueue) toString += "\n" + process.toString();
		return toString;
	}
}
