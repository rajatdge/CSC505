import java.io.BufferedReader;
import java.io.InputStreamReader;

 class unique1 {

 	static int[] myfunction(int a[]) {
		int start_index=0;
		int length = 0;
		int i=0;
		int j=0;
		int k=0;
		int flag;
		for(i=0;i<a.length;i++){
			for(j=1;j<=a.length-i;j++){
				for(k=i;k<i+j-1;k++){
					if(a[k] == a[i+j-1]){
						break;
					}
				}
				if(k == i+j-1){
					if (j>length){
						length = j;
						start_index = i;
					}
				}
				else{
					break;
				}
				
		}
		}
		return new int[] {start_index ,length};
		
	    }

	public static void main(String[] args) {
		int size=0;
		int res[]= new int[2];



	       try{
	       BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
	       String x = null;
	       String n=null;
	       int c=0;

	       n = f.readLine();
	       size=Integer.parseInt(n);
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
		  res=myfunction(arr);
		  System.out.println(res[0] + " " + res[1]);
		  	      
	  }
	  catch (Exception e){
	  	e.printStackTrace();
	  }
	
	  

	}

}
