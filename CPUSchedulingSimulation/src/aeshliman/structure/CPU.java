package aeshliman.structure;

public class CPU implements Device
{
	private CustomProcess process;
	
	public CPU()
	{
		this.process = null;
	}
	
	public CustomProcess getProcess() { return this.process; }
	public void setProcess(CustomProcess process) { this.process = process; }
	
	public boolean isEmpty()
	{
		return process==null;
	}
}
