import java.util.*; 

class Main { 
  public static void main(String args[]){
    DirectedGraph<Integer> dg = new DirectedGraph<Integer>();
    
    dg.addEdge(1, 2);
    dg.addEdge(2,3);
    dg.addEdge(3,4);
    dg.addEdge(4,1);
    dg.addEdge(4,2);
    dg.addEdge(4,2);

    System.out.println(dg);
    System.out.println("NUM VERTICIES: " + dg.getVertexCount());
    System.out.println("NUM EDGES: " + dg.getEdgesCount());
  }

  public static void RunDijksta(DirectedGraph g, int source, int destination) throws NullPointerException {
    if(g.hasVertex(source) && g.hasVertex(destination)) {
      
    } else {
      throw new NullPointerException();
    }
  }
} 