package OOPS;

public class Queue {
	protected int []data;
	protected int front;
	protected int size;
	public Queue()
	{
		front = 0;
		size = 0;
		data = new int[5];
	}
	public Queue(int size)
	{
		front = 0;
		data = new int[size];
	}
	public void enqueue(int val) throws Exception
	{
		if(isFull())
			throw new Exception("Queue is Full");
			
	   int idx = (front + size)%data.length;
	   data[idx] = val;
	   size++;
	}
	public int dequeue() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue Empty");
	   int val = data[front];
	   front = (front+1)%data.length;
	   size--;
	   return val;
	}
	public int size()
	{
		return size;
	}
	public int getfront()
	{
		return data[front];
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
		for(int i = 0; i<size; i++)
		{
			System.out.print(data[(i+front)%data.length]+" ");
		}
		System.out.println();
	}

}
