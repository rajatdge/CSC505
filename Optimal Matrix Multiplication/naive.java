import java.io.BufferedReader;
import java.io.InputStreamReader;

class naive {

	static long myfun(int arr[]){
		long  res = 0;
		for (int i =1; i<=arr.length - 2; i++){
			res = res + (long)arr[0]*arr[i]*arr[i+1];
		}
		return res;
	} 

public static void main(String[] args) {

try{
	       BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	       String x = null;
	       String n=null;
	       int c = 0;
	       long res = 0;

	       n = f.readLine();
	       int size=Integer.parseInt(n+1);
	       int arr[] = new int[size];

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

	      res = myfun(arr);
	      System.out.println(res);

}
catch (Exception e){
	  	e.printStackTrace();
	  }



}
}
