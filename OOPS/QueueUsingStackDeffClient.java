package OOPS;

public class QueueUsingStackDeffClient {

	public static void main(String[] args) throws Exception {
		QueueUsingStackDeff q = new QueueUsingStackDeff();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		System.out.println(q.dequeue());
		q.display();
		
		

	}

}
