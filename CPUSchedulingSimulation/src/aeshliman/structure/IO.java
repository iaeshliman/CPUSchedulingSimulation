package aeshliman.structure;

public class IO implements Device
{
	private CustomProcess process;
	
	public IO()
	{
		this.process = null;
	}
	
	public CustomProcess getProcess() { return this.process; }
	public void setProcess(CustomProcess process) { this.process = process; }
	
	public boolean isEmpty()
	{
		return false;
	}
}
