package aeshliman.structure;

public class IO implements Device
{
	// Instance Variables
	private static int count = 0;
	private int id;
	private CustomProcess process;
	
	// Constructors
	public IO()
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
		return false;
	}
	
	// toString
	public String toString()
	{
		return "IO " + id + ": " + this.process.toString();
	}
}
