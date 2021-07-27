package OOPS;

public class Stackclient {

	public static void main(String[] args) throws Exception {
		DynamicStack s = new DynamicStack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		s.display();
		s.pop();
		s.display();
		// reverse(s);
//		DynamicStack help = new DynamicStack();
//        actualrev(s,help);
//        s.display();
		System.out.println("NGE");
		int[] arr = { 30, 20, 10, 5, 25, 15, 45, 37, 28, 42 };
		//nextgre2(arr);
		int []ss = {50,35,5,70,7,3,40,37,45,7};
		stockspan(ss);
	}

	public static void reverse(DynamicStack st) throws Exception {
		if (st.size() == 0)
			return;
		int val = st.pop();
		reverse(st);
		System.out.print(val + " ");
		st.push(val);
	}

	public static void actualrev(DynamicStack st, DynamicStack help) throws Exception {
		if (st.size() == 0) {
			actualrev2(help, st);
			return;
		}
		int val = st.pop();
		help.push(val);
		actualrev(st, help);

	}

	public static void actualrev2(DynamicStack st, DynamicStack help) throws Exception {
		if (st.size() == 0) {
			return;
		}
		int val = st.pop();
		actualrev2(st, help);
		help.push(val);

	}

	public static void nextgre(int[] arr) throws Exception {
		DynamicStack ng = new DynamicStack();
		for (int i = 0; i < arr.length; i++) {

			while (!ng.isEmpty() && ng.top() < arr[i]) {
				System.out.println(ng.pop() + "->" + arr[i]);
			}
			ng.push(arr[i]);

		}
		while (!ng.isEmpty()) {
			System.out.println(ng.pop() + "->" + -1);
		}
	}
	public static void nextgre2(int[] arr) throws Exception {
		DynamicStack ng = new DynamicStack();
		int []ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {

			while (!ng.isEmpty() && arr[ng.top()] < arr[i]) {
				ans[ng.pop()] = arr[i];
			}
			ng.push(i);

		}
		while (!ng.isEmpty()) {
			ans[ng.pop()] = -1;
		}
		for(int i = 0; i<ans.length ; i++)
		{
			System.out.println(arr[i]+"-->"+ans[i]);
		}
	}
	public static void stockspan(int[] arr) throws Exception {
		DynamicStack ng = new DynamicStack();
		int []ans = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
                    while(!ng.isEmpty() && arr[i]>arr[ng.top()])
                    {
                    	ng.pop();
                    }
                    if(!ng.isEmpty())
                    {
                    	ans[i] = i-ng.top(); 
                    }
                    else
                    {
                    	ans[i] = i+1;
                    }
                    ng.push(i);     
			}
		for(int i = 0; i<ans.length;i++)
		{
			System.out.println(ans[i]);
		}
		
		}
		
	}


