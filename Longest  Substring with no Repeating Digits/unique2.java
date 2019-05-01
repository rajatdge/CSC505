import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

 class unique2 {

 	static int[] myfunction(int a[]) {
		int start_index=0;
		int length = 0;
		int i=0;
		int j=0;
		TreeSet t = new TreeSet();
		for(i=0;i<a.length;i++){
			for (j=i;j<a.length;j++){
			if (t.contains(a[j])){
				break;
			}
			else {
				t.add(a[j]);
			}
			
			if (t.size()>length) {
			length = t.size();
			start_index = i;
			}
				
		}
		t.clear();
		}
		if(t.size()>length) {
			length=t.size();
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
