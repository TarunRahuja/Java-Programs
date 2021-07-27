package Heap;

import java.util.ArrayList;

public class Heap {
private ArrayList<Integer> data = new ArrayList<>();
public int size() {
	return data.size();
}
public boolean isEmpty()
{
	return size()==0;
}
public void add(int item)
{
	data.add(item);
	upheapify(size()-1);
}
private void upheapify(int ci) {
	int pi = (ci-1)/2;
	if(data.get(ci)<data.get(pi))
	{
		swap(ci,pi);
		upheapify(pi);
	}
	
}
private void swap(int ci, int pi) {
	int cival = data.get(ci);
	int pival = data.get(pi);
	data.set(ci, pival);
	data.set(pi,cival);
}
public void display()
{
	System.out.println(data);
}
public int remove()
{
	swap(0,size()-1);
	int delval = data.remove(size()-1);
	downheapify(0);
	return delval;
}
private void downheapify(int pi) {
	int lci = 2*pi+1;
	int rci = 2*pi+2;
	int mini = pi;
	if(lci<data.size()&&data.get(mini)>data.get(lci))
	{
		mini = lci;
	}
	if(rci<data.size()&&data.get(mini)>data.get(rci))
	{
		mini = rci;
	}
	if(mini!=pi)
	{
		swap(mini,pi);
		downheapify(mini);
	}
	
}
public int get()
{
	return data.get(0);
}
}
