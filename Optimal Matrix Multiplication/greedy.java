import java.io.BufferedReader;
import java.io.InputStreamReader;

class greedy {

	static long myfun(int arr[], int start, int end){
		if (end == start + 1){
			return (long)0;
		} 

		long cost = Long.MAX_VALUE;
		int k=0;
		for (int i=start+1;i<=end-1;i++){
			if ((long)arr[start]*arr[i]*arr[end]<cost){
				cost = (long)arr[start]*arr[i]*arr[end];
				k = i;
			}
		}
		long c1 = myfun(arr,start,k);
		long c2 = myfun(arr,k,end);
		return (long)arr[start]*arr[k]*arr[end] + c1 + c2;
	} 


public static void main(String[] args) {

try{
	       BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	       String x = null;
	       String n=null;
	       int c = 0;
	       long res = 0;

	       n = f.readLine();

	       int size=Integer.parseInt(n);
	       int arr[] = new int[size+1];

	       while( (x = f.readLine()) != null )
	      {
	      	try{
	        String[] strNums = x.split("\\s");
	        for(int i=0; i<strNums.length; i++) {
	            arr[c] = Integer.parseInt(strNums[i]);
	            c=c+1;
	        }
	      }
	      catch (Exception e){
	      	break;
	      }
	      } 

	      res = myfun(arr,0,arr.length-1);
	      System.out.println(res);

}
catch (Exception e){
	  	e.printStackTrace();
	  }



}
}
