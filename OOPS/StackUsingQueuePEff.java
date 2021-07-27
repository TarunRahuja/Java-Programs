package OOPS;

public class StackUsingQueuePEff {
	private DyanmicQueue sq = new DyanmicQueue();
	public void push(int val) throws Exception
	{
		try
		{
			actualreverse(sq);
			sq.enqueue(val);
			actualreverse(sq);
		}
		catch(Exception e)
		{
			System.out.println("Stack Overflow");
		}
	}
	public int pop() throws Exception
	{
		try 
		{
			return sq.dequeue();
		}
		catch (Exception e) 
		{
			System.out.println("Stack Underflow");
		}
		return 0;
		
	}
	private void actualreverse(DyanmicQueue dq) throws Exception
	{
		if(dq.isEmpty())
		{
			return;
		}
		int val = dq.dequeue();
		actualreverse(dq);
		dq.enqueue(val);
	}

}
