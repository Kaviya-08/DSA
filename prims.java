
import java.util.*;
public class prims{
    
    static class Pair{
        int v,p,w;
        
     Pair(int v, int p, int w){
         this.v = v;
         this.p = p;
         this.w = w;
     }    
        
    }
    

    public static void main(String[] args){
        int V = 5;
        
        List<List<int[]>> g = new ArrayList<>();
        
        for(int i =0; i<V; i++){
            g.add(new ArrayList<>());
        }
        
        g.get(0).add( new int[] {1,2});
        g.get(1).add(new int[] {0,2});
        
        g.get(0).add(new int[] {3,6});
        g.get(3).add(new int[] {0,6});
        
        g.get(1).add(new int[] {2,3});
        g.get(2).add(new int[] {1,3});
        
        g.get(1).add(new int[]{3,8});
        g.get(3).add(new int[]{1,8});
        
        g.get(1).add(new int[]{4,5});
        g.get(4).add(new int[]{1,5});
        
        
        g.get(2).add(new int[] {4,7});
        g.get(4).add(new int[] {2,7});

        prim(g,V);
    }
    static void prim(List<List<int[]>> g, int V){
            boolean[] visited = new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.w));
        pq.offer(new Pair(0,-1,0)); // starting point
        
        int sum = 0;
        
        System.out.println("Edges of Minimum Spanning Tree");
        
        while(!pq.isEmpty()){
            Pair current = pq.poll();
            
        if(visited[current.v])
        continue;
        
        visited[current.v] = true;
        
        if(current.p!=-1){
            System.out.println(current.p + " -" + current.v + "(weight:" + current.w+")");
            sum += current.w;
        }
            
            
        for(int[] neigh : g.get(current.v)){
            
            
            if(!visited[neigh[0]]){
                pq.offer(new Pair (neigh[0],current.v,neigh[1]));
                // visited[neigh[]]
            }
        } 
        System.out.println("Total cost of MST:"+sum);
            
            
        }
    }
}