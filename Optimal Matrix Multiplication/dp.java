import java.io.BufferedReader;
import java.io.InputStreamReader;

class dp {

	static long myfun(int arr[]){
		int n = arr.length;
		long m[][] = new long[n][n]; 
  
        int i, j, k, l;
        long q; 
  
         
        for (l=2; l<n; l++) 
        { 
            for (i=1; i<n-l+1; i++) 
            { 
                j = i+l-1; 
                if(j == n) continue; 
                m[i][j] = Long.MAX_VALUE; 
                for (k=i; k<=j-1; k++) 
                { 
                     
                    long temp = (long) arr[i-1]*arr[k]*arr[j];
                    q = m[i][k] + m[k+1][j] +temp; 
                    if (q < m[i][j]) 
                        m[i][j] = q; 
                } 
            } 
        } 
        
        return m[1][n-1]; 
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
	    

	      res = myfun(arr);
	      System.out.println(res);

}
catch (Exception e){
	  	e.printStackTrace();
	  }



}
}
