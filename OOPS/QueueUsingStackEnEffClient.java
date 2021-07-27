package OOPS;

public class QueueUsingStackEnEffClient {

	public static void main(String[] args) throws Exception {
		QueueUsingStackEnEff q = new QueueUsingStackEnEff();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		
				

	}

}
