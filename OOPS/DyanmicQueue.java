package OOPS;

public class DyanmicQueue extends Queue {
	public void enqueue(int val) throws Exception
	{
		if(isFull())
		{
			int []na = new int [2*data.length];
			for(int i = 0; i<data.length; i++)
			{
				na[(i)] = data[(i+front)%data.length];
			}
			data = na;
			front = 0;
		}
		super.enqueue(val);	
	}

}
