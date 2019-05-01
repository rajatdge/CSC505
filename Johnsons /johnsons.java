import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


  class Pair {
    public int key;
    public int val;

    public Pair( int k, int v ) {
      key = k;
      val = v;
    }
  }

  // Actual representation of the heap
  class MinHeap {
    // Counter of comparison operations, for comparing performance.
    private long comparisons = 0;

    // Power of 2 used as the branchign factor
    private int p;

    // Representation for the heap.
    Pair[] tree;

    // Number of elements in the heap.
    int n;

    // Capacity of the heap.
    int cap;

    // Function to compare keys, so we can also count key comparisons.
    private boolean keyLess( Pair a, Pair b ) {
      comparisons += 1;
      return a.key < b.key;
    }

    public MinHeap( int p ) {
      this.p = p;
      cap = 5;
      n = 0;
      tree = new Pair [ cap ];
    }

    Pair removeMin() {
      // Remove the minimum value and replace it with the last one.
      Pair v = tree[ 0 ];
      tree[ 0 ] = tree[ n - 1 ];
      n -= 1;

      // We need the branching factor below.
      int branch = 1 << p;

      // Push this value down until it satisfies the ordering constraint.
      int idx = 0;
      int child = ( idx << p ) + 1;
      while ( child < n ) {
        // Find index of smallest child.
        int m = child;
        int end = child + branch;
        if ( end > n )
          end = n;
        for ( int i = child + 1; i < end; i++ )
          if ( keyLess( tree[ i ], tree[ m ] ) )
            m = i;

        // Not happy about this early return.  Would be nice to ahve it in the condition
        // on the loop.  Return early if we hit a point where we don't have to swap.
        if ( ! keyLess( tree[ m ], tree[ idx ] ) )
          return v;

        // Swap the current vlaue with its smallest child
        Pair temp = tree[ idx ];
        tree[ idx ] = tree[ m ];
        tree[ m ] = temp;

        // Follow the value down into the tree.
        idx = m;
        child = ( idx << p ) + 1;
      }
      
      return v;
    }
    
    void insertValue( Pair v ) {
      if ( n >= cap ) {
        // Enlarge the heap array and copy everything over.
        cap *= 2;
        Pair[] t2 = new Pair [ cap ];
        for ( int i = 0; i < n; i++ )
          t2[ i ] = tree[ i ];
        tree = t2;
      }

      // Put the new value at the end of the heap.
      int idx = n;
      tree[ n++ ] = v;

      // Move it up in the heap until it's as large as its parent.
      int par = ( idx - 1 ) >> p;
      while ( par >= 0 && keyLess( tree[ idx ], tree[ par ] ) ) {
        // Swap this value with its parent.
        Pair temp = tree[ par ];
        tree[ par ] = tree[ idx ];
        tree[ idx ] = temp;
        
        idx = par;
        par = ( idx - 1 ) >> p;
      }
    }

    /** Return the number of comparisons performed. */
    long ccount() {
      return comparisons;
    }
  }

  


public class johnsons{

	static int[] dijkshtra(HashMap<Integer, ArrayList<int[]>> graph, int v, int vertices, int[] h, int[][] originals, int[][] finalresult){
         MinHeap H = new MinHeap(1);
         
         int res[] = new int[vertices];
         int res2[] = new int[vertices];
         for(int k=0;k<vertices;k++){
         	res[k] = Integer.MAX_VALUE;
         	res2[k] = Integer.MAX_VALUE;
         }
         
         
         

         H.insertValue(new Pair(0,v));
         res[v] = 0;
         res2[v] = 0;

         Set<Integer> set = new HashSet<Integer>();
         while(set.size()< vertices){
         	
            Pair tmp = H.removeMin();
            if(set.contains(tmp.val)){
            	continue;
            }
            else{
            	set.add(tmp.val);
            	
            	ArrayList<int[]> values = graph.get(tmp.val);
            	if(values != null){
            	for(int[] a : values){
                    if(res[tmp.val] + a[1] < res[a[0]]){
                    	res[a[0]] = res[tmp.val] + a[1];
                        res2[a[0]] = res2[tmp.val] + originals[tmp.val][a[0]];
                    	
                    	H.insertValue(new Pair(res[tmp.val] + a[1],a[0]));


                    }
            	}
            	}
            	else{
            		break;
            	} 


            }

         }
         
         return res2;





	}

	static boolean bellmanford(HashMap<Integer, ArrayList<int[]>> graph, int[] h, int v){
			for(int i=0;i<=v;i++){
				for (Map.Entry mapElement : graph.entrySet()) { 
            	Integer key = (Integer)mapElement.getKey();
            	ArrayList<int[]> values = graph.get(key);
            	for(int[] a : values){
                    if(h[key]!=Integer.MAX_VALUE && h[a[0]] > h[key] + a[1]){
                    	h[a[0]] = h[key] + a[1];


                    }
            	} 
  
            
        	} 
			}

			for (Map.Entry mapElement : graph.entrySet()) { 
            	Integer key = (Integer)mapElement.getKey();
            	
            	ArrayList<int[]> values = graph.get(key);
            	for(int[] a : values){
                    if(h[a[0]] > h[key] + a[1]){
                    	
                    	return true;

                    }
            	} 
  
            
        	}
        	return false; 

	}


	public static void main(String[] args) {
		
			try{
		       BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		       String x = null;
		       HashMap<Integer, ArrayList<int[]>> graph = new HashMap<Integer, ArrayList<int[]>>(); 

		       int tmp[] = new int[2];
		       String s[] = f.readLine().split("\\s");
		       int vertices = Integer.parseInt(s[0]);
		       int edges = Integer.parseInt(s[1]);
		       int originals[][] = new int[vertices][vertices];
		       int numqueries = 0;
		       int finalresult[][] = new int[vertices][vertices];
		       int c=0;
		       for(int i=0;i<vertices;i++){
                    for(int j=0;j<vertices;j++){
                    	originals[i][j] = Integer.MAX_VALUE;
                    	finalresult[i][j] = Integer.MAX_VALUE;
                    }
		       }
		       

		       while( (x = f.readLine()) != null )
			      { 
			      	
		    	       int temparr[] = new int[2];
		    	   
		    		   String[] strNums = x.split("\\s");
		    		   if(strNums.length == 1){
		    		   	break;
		    		   }

		    		   
                       if(!graph.containsKey(Integer.parseInt(strNums[0]))){
                       graph.put(Integer.parseInt(strNums[0]), new ArrayList<int[]>());
                       ArrayList<int[]> list = graph.get(Integer.parseInt(strNums[0]));
                       list.add(new int[]{Integer.parseInt(strNums[1]), Integer.parseInt(strNums[2])});
		    		   graph.put(Integer.parseInt(strNums[0]),list);
		    		   }
		    		   else{
                       ArrayList<int[]> list = graph.get(Integer.parseInt(strNums[0]));
                       list.add(new int[]{Integer.parseInt(strNums[1]), Integer.parseInt(strNums[2])});
		    		   graph.put(Integer.parseInt(strNums[0]),list);
		    		   }
		    		}

		    		String[] strNums = x.split("\\s");
		    		numqueries = Integer.parseInt(strNums[0]);
		    		int[][] queries = new int[numqueries][2];
		    		   

		    		
		    		
                    while( (x = f.readLine()) != null )
			        {     
			        strNums = x.split("\\s");	
                    queries[c][0] = Integer.parseInt(strNums[0]);
                    queries[c][1] = Integer.parseInt(strNums[1]);
                    c++;
                    } 
		    		  


		    	   
		    	  ArrayList<int[]> newver = new ArrayList<int[]>();
		    	  for(int i=0;i<vertices;i++){
		    	  newver.add(new int[]{i,0});
		    	  } 
		    	  graph.put(vertices,newver);
		       
		             
		      int h[] = new int[vertices+1];
		      for(int i =0;i<vertices;i++){
                  h[i] = Integer.MAX_VALUE;
		      } 
		      h[vertices] = 0;
		       
		      boolean flag = bellmanford(graph,h,vertices);
		      if(flag){
		      	System.out.println("Negative edge weight cycle");
		      	return;
		      }
		      

		      graph.remove(vertices);

		      for (Map.Entry mapElement : graph.entrySet()) { 
            	Integer key = (Integer)mapElement.getKey();
            	ArrayList<int[]> values = graph.get(key);
            	
            	for(int[] a : values){
            		
            		originals[key][a[0]] = a[1];
                    a[1] = a[1] + h[key] - h[a[0]];
                    

                    
            	} 

		      }
              
        
            


        	
            for(int i=0;i<vertices;i++){
        	finalresult[i] = dijkshtra(graph,i,vertices,h,originals,finalresult);
            }
            
            
            int counter = 0;
             while(counter<numqueries){
             	  if(finalresult[queries[counter][0]][queries[counter][1]] != Integer.MAX_VALUE){
                  System.out.println(queries[counter][0] +  " -> " + queries[counter][1] + " = " + finalresult[queries[counter][0]][queries[counter][1]]);
                  }
                  else{
                  System.out.println(queries[counter][0] +  " -> " + queries[counter][1] + " = x");	
                  }
                  counter = counter + 1;
            
		     }
        }
        	
            
		      

		
		catch (Exception e){
		  	e.printStackTrace();
		  }

	}
}


