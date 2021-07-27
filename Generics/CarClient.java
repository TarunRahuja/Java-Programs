package Generics;

import java.util.Comparator;

public class CarClient {

	public static void main(String[] args) throws Exception {
		Car [] arr = new Car[5];
		LinkedListGeneric<Car> ll = new LinkedListGeneric<>();
		for(int i = 0; i<arr.length; i++)
		{
			arr[i] = new Car(i+1,1000*(i+1),"Black");
			ll.addLast(arr[i]);
		}
		ll.display();
		display(arr);
		bubble(arr);
		bubble(arr,new CarSPeedComparator());
		

	}
	public static <T> void display(T[] arr)
	{
		for(T val:arr)
		{
			System.out.println(val);
		}
	}
	public static <T extends Comparable<T>> void bubble(T[] arr)
	{
		for(int i = 0; i<arr.length-1; i++)
		{
			for(int j = 0; j<arr.length-i-1;j++)
			{
				if(arr[j].compareTo(arr[j+1])>0)
				{
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}

		System.out.println();
		System.out.println();
		display(arr);
	}
   	
	public static <T> void bubble(T[] arr,Comparator<T> comp)
	{
		for(int i = 0; i<arr.length-1; i++)
		{
			for(int j = 0; j<arr.length-i-1;j++)
			{
				if(comp.compare(arr[j],arr[j+1])>0)
				{
					T temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
     
		System.out.println();
		System.out.println();
		display(arr);
	}
}
