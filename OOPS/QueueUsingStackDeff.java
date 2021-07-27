package OOPS;

public class QueueUsingStackDeff {
	private DynamicStack prim = new DynamicStack();
	public void enqueue(int val) throws Exception
	{ 
	  try {	
		DynamicStack help = new DynamicStack();
		while(prim.size()!=0)
		{
			int temp = prim.pop();
			help.push(temp);
		}
		prim.push(val);
		while(help.size()!=0)
		{
			int temp = help.pop();
			prim.push(temp);
		}
	  }
	  catch(Exception e)
	  {
		  throw new Exception("Queue is Full");
	  }
	}
	public int dequeue() throws Exception
	{
		try
		{
			return prim.pop();
		}
		catch (Exception e) {
			throw new Exception("Queue Underflow");
		}
		
	}
	public void display()
	{
		prim.display();
	}

}
