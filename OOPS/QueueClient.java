package OOPS;

public class QueueClient {

	public static void main(String[] args) throws Exception {
      DyanmicQueue q = new DyanmicQueue();
       q.enqueue(1);
       q.enqueue(2);
       q.enqueue(3);
       q.enqueue(4);
       q.display();
       dispreverse(q, 0);
       //actualreverse(q);
       q.display();
       

	}
	public static void actualreverse(DyanmicQueue dq) throws Exception
	{
		if(dq.isEmpty())
		{
			return;
		}
		int val = dq.dequeue();
		actualreverse(dq);
		dq.enqueue(val);
	}
	public static void dispreverse(DyanmicQueue dq,int count) throws Exception
	{
		if(dq.size()==count)
		{
			return;
		}
		int val = dq.dequeue();
		dq.enqueue(val);
		dispreverse(dq,count+1);
		System.out.println(val);
		
	}
	
	
   
}
