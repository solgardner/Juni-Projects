import java.util.*; 
  
public class DirectedGraph<T> implements Graph<T>{   
  private HashMap<T, ArrayList<T>> map = new HashMap<>(); 
  private int numEdges = 0;

  @Override
  public int getVertexCount() {
    return map.size();
  }

  @Override
  public int getEdgesCount() {
    return numEdges;
  }

  @Override
  public boolean hasVertex(T vertex) {
    return map.containsKey(vertex);
  }

  @Override
  public boolean hasEdge(T source, T destination) {
    if(hasVertex(source)) {
    ArrayList<T> val = map.get(source);
    return val.contains(destination);
    }
    return false;
  }

  @Override
  public void addVertex(T vertex) {
    if(!hasVertex(vertex)) {
    map.put(vertex, new ArrayList<T>());
    } else {
        System.out.println("---WARNING: DUPLICATE VALUE. PLEASE TRY AGAIN---");
    }
  }

  @Override
  public void addEdge(T source, T destination) {
    addVertex(source);
    addVertex(destination);

    if(!hasEdge(source,destination)) {
    ArrayList<T> sourceAL = map.get(source);

    sourceAL.add(destination);
    map.put(source, sourceAL);

    numEdges++;

    } else {
        System.out.println("---WARNING: DUPLICATE VALUE. PLEASE TRY AGAIN---");
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    for(T i : map.keySet()) {
        s.append(String.format("Value: %s\n\tConnects To: %s\n",i.toString(),map.get(i).toString()));
    }
    return s.toString();
    
  }
   
} 