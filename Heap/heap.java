import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Pairs{
	int key;
	int value;
	
	Pairs(int key,int value){
		this.key = key;
		this.value = value;
	}
}

public class heap {
	
	static int comparisons; 
	
	static void minheapify(ArrayList a, int bf , int x) {
		int parent = x;
		int v = (int) Math.pow(2, bf);
		int position ;
		position = parent << bf;
		position = position +1;
		
		if (position > a.size()-1) {
			return;
		}
		
		
		if (position < a.size()-1) { 
		for (int i=2;i<=v;i++) {
			int child = parent << bf;
			child= child + i;
			
			if (child > a.size()-1 || position > a.size()-1) {
				break;
			}
			comparisons = comparisons +1;
				
			Pairs c = (Pairs) a.get(child);
			Pairs pos = (Pairs) a.get(position);
			if (c.key < pos.key) {
				position = child;
			}
			else if(c.key == pos.key && c.value < pos.value) {
				position = child;
			}
			
		}
		}
		    comparisons = comparisons +1;
			Pairs pos = (Pairs) a.get(position); 
			Pairs pa = (Pairs) a.get(parent);
			if(pa.key > pos.key) {
				Collections.swap(a, parent, position);
				minheapify(a,bf,position);
			}
			else if(pa.key == pos.key && pa.value > pos.value) {
				Collections.swap(a, parent, position);
				minheapify(a,bf,position);
			}
		
		
	}
	static void insertvalue(ArrayList a , int bf) {
		int child = a.size() - 1;
		int parent = (child -1) >> bf;
		while(child > 0) {
			
            comparisons = comparisons +1;
			Pairs p =(Pairs) a.get(parent);
			Pairs c =(Pairs) a.get(child);
			if (p.key > c.key) {
				Collections.swap(a, parent, child);
			}
			else if(p.key == c.key && p.value > c.value){
				Collections.swap(a, parent, child);
			}
			else {
				break;
			}
			child = parent;
			parent = (parent-1) >> bf;
		}
		
	}
	
	static void removeMin(ArrayList a,int bf) {
		Pairs fpair = (Pairs) a.get(0);
		System.out.println(fpair.key + " " + fpair.value);
		Collections.swap(a, 0, a.size()-1);
		a.remove(a.size()-1);
	
		minheapify(a,bf,0);
		}
	
	public static void main(String[] args) {
		int branching_factor;
		if (args.length > 0) {
		branching_factor = (int)(Math.log(Integer.parseInt(args[0]))/Math.log(2));
		}
		else {
		branching_factor = 1;
		}
		System.out.println(branching_factor);
		ArrayList<Pairs> arrli = new ArrayList<Pairs>();
		
		
		try{
		       BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		       String x = null;
		       while( (x = f.readLine()) != null )
			      { 
		    	       int temparr[] = new int[2];
		    	   
		    		   String[] strNums = x.split("\\s");
		    		   if (Integer.parseInt(strNums[0]) == -1){
	    			   removeMin(arrli,branching_factor);

		    		   }
		    		   else {
		    			   arrli.add(new Pairs(Integer.parseInt(strNums[0]),Integer.parseInt(strNums[1])));
		    			   insertvalue(arrli,branching_factor);
		    		   }
		    		   
		    		   
		   
		    	   }
		       
		       System.out.println("Key Comparisons = " + comparisons);
		       
		      
		       
			      
	       }
		
		catch (Exception e){
		  	e.printStackTrace();
		  }

}
}
