package OOPS;

public class Stack {

	protected int[] data;
	protected int tos;
	public Stack()
	{
		data = new int[5];
		tos = -1;
	}
	public Stack(int cap)
	{
		data = new int[cap];
		tos = -1;
	}
	public void push(int val) throws Exception
	{
		if(isFull())
			throw new Exception("Stack Overflow");
		tos++;
		data[tos] = val;
	}
	public int pop() throws Exception
	{
		if(isEmpty())
			throw new Exception("Stack Underflow");
		int val = data[tos];
		tos--;
		return val;
	}
	public int top() throws Exception
	{
		if(isEmpty())
		{		
		  throw new Exception("Stack underflow");
		}
		return data[tos];
	}
	public int size()
	{
		return tos+1;
	}
	public boolean isEmpty()
	{
		return size()==0;
	}
	public boolean isFull()
	{
		return size()==data.length;
	}
	public void display()
	{
		for(int i = tos; i>=0; i--)
		{
			System.out.print(data[i]+" ");
		}
		System.out.println();
		
	}
}
