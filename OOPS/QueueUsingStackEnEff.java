package OOPS;

public class QueueUsingStackEnEff {
	private DynamicStack qs = new DynamicStack();
	public void enqueue(int val) throws Exception
	{
		try {
			qs.push(val);
		}
		catch(Exception e)
		{
			throw new Exception("Queue Overflow");
		}
	}
	public int dequeue() throws Exception
	{
		 try {
	    	DynamicStack help = new DynamicStack();
	    	actualrev(qs, help);
	    	int val = qs.pop();
	    	actualrev(qs, help);
	    	return val;
		 }
		 catch(Exception e)
		 {
			 throw new Exception("Queue UnderFlow");
		 }
	}

	private void actualrev(DynamicStack st, DynamicStack help) throws Exception {
		if (st.size() == 0) {
			actualrev2(help, st);
			return;
		}
		int val = st.pop();
		help.push(val);
		actualrev(st, help);

	}

	private void actualrev2(DynamicStack st, DynamicStack help) throws Exception {
		if (st.size() == 0) {
			return;
		}
		int val = st.pop();
		actualrev2(st, help);
		help.push(val);

	}
}
