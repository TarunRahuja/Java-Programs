package OOPS;

public class DynamicStack extends Stack {
	@Override
	public void push(int val) throws Exception
	{
		if(isFull())
		{
			int []na = new int[2*data.length];
			for(int i = 0; i<data.length; i++)
			{
				na[i] = data[i];
			}
			data = na;
		}
		super.push(val);
	}

	

}
