package aeshliman.structure;

public class CPU implements Device
{
	// Instance Variables
	private static int count = 0;
	private int id;
	private CustomProcess process;
	
	// Constructors
	public CPU()
	{
		this.id = count++;
		this.process = null;
	}
	
	// Getters and Setters
	public CustomProcess getProcess() { return this.process; }
	public void setProcess(CustomProcess process) { this.process = process; }
	
	// Operations
	public boolean isEmpty()
	{
		return process==null;
	}
	
	// toString
	public String toString()
	{
		return "CPU " + id + ": " + this.process.toString();
	}
}
