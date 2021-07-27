package mergesort;

public class merge {

	public static void main(String[] args) {
	int [] arr = {2,5,7,1,0};
	quick(arr, 0, arr.length-1);
	
	//int [] result = mergesort(arr, 0, arr.length-1);
	for(int i = 0; i<arr.length; i++)
	{
		System.out.print(arr[i]+" ");
	}
	}
	public static int[] mergesort(int []arr, int lo, int hi)
	{
		int mid = (lo+hi)/2;
		if(lo==hi)
		{
			int [] br = new int[1];
			br[0] = arr[lo];
			return br;
		}
		int[] fh = mergesort(arr, lo, mid);
		int [] sh = mergesort(arr, mid+1, hi);
		int [] merged = merge2sorted(fh, sh);
		return merged;
	}
   public static int[] merge2sorted(int []one, int[] two)
   {
	   int i = 0;
	   int j = 0,k=0;
	   int [] merged = new int[one.length+two.length];
	   while(i<one.length&&j<two.length)
	   {
		   if(one[i]>two[j])
		   {
			   merged[k] = two[j];
			   j++;
			   k++;
		   }
		   else
		   {
			   merged[k] = one[i];
			   i++;
			   k++;
		   }
	   }
	   while(i<one.length&&j==two.length)
	   {
		   merged[k] = one[i];
		   i++;
		   k++;
	   }
	   while(j<two.length&&i==one.length)
	   {
		   merged[k] = two[j];
		   j++;
		   k++;
	   }
	   return merged;
   }
   public static void quick(int []arr, int lo, int hi)
   {
	   if(lo>=hi)
		   return;
	   int mid = (lo+hi)/2;
	   int piv = arr[mid];
	   int left = lo;
	   int right = hi;
	 while(left<=right)  
	 { while(arr[left]<piv)
	   {
		   left++;
	   }
	   while(arr[right]>piv)
	   {
		   right--;
	   }
	   if(left<=right)
	   {
		   int temp = arr[left];
		   arr[left] = arr[right];
		   arr[right] = temp;
		   left++;
		   right--;
	   }
    }
	 quick(arr,lo, right);
	 quick(arr,left,hi);
   }
}
