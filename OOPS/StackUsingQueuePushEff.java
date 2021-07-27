package OOPS;

public class StackUsingQueuePushEff {
	private DyanmicQueue sq = new DyanmicQueue();
	public void push(int val) throws Exception
	{
		try 
		{
			sq.enqueue(val);
		}
		catch(Exception e)
		{
			System.out.println("Stack OverFlow");
		}
	}
	public int pop() throws Exception
	{
		try 
		{
			actualreverse(sq);
			int val = sq.dequeue();
			actualreverse(sq);
			return val;
		}
		catch(Exception e)
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
