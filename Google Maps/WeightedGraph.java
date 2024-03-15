import java.util.*; 
  
public class WeightedGraph<T,W> implements Network<T,W>{   
  private HashMap<T, HashMap<T,W>> map = new HashMap<>(); 
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
    HashMap<T,W> val = map.get(source);
    return val.containsKey(destination);
    }
    return false;
  }

  @Override
  public void addVertex(T vertex) {
    if(!hasVertex(vertex)) {
    map.put(vertex, new HashMap<T,W>());
    } else {
    }
  }

  @Override
  public void addEdge(T source, T destination, W weight) {
    addVertex(source);
    addVertex(destination);

    if(!hasEdge(source,destination)) {
    map.get(source).put(destination,weight);

    numEdges++;

    } else {
    }
  }

  public HashMap<T,HashMap<T,W>> getHashMap() {
    return map;
  }

  public W getDistance(T source, T destination) {
    if(hasVertex(source) && hasVertex(destination)) {
      return map.get(source).get(destination);
    } else {
      return null;
    }
  }

  @Override
  public void addEdge(T source, T destination) {
    addEdge(source,destination,null);
  }

  @Override
  public HashMap<T,W> getEdges(T source) {
    if(hasVertex(source)) {
      return map.get(source);
    } else {
      return null;
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