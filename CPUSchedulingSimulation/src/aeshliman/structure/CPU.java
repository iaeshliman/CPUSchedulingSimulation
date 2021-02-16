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
	
	public CustomProcess removeProcess() // Returns the current process and empties the CPU
	{
		CustomProcess temp = this.process;
		this.process = null;
		return temp;
	}
	
	// toString
	public String toString()
	{
		return "CPU " + id + ":\n" + this.process;
	}
}
