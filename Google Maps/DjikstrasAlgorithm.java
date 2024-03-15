/*
Total Distance: 12.35 miles
Bryant_Park --> Grand_Central_Terminal(0.67 miles)
Grand_Central_Terminal --> Central_Park_Zoo(0.76 miles)
Central_Park_Zoo --> Central_Park(0.72 miles)
Central_Park --> Metropolitan_Museum_of_Art(0.37 miles)
Metropolitan_Museum_of_Art --> Bronx_Zoo(9.84 miles)
 */


import java.util.*; 
import java.lang.*; 
import java.io.*; 
  
public class DjikstrasAlgorithm { 

  WeightedGraph<String,Double> vertices;
  PriorityQueue<Location> unvisited;

  public double dijkstra(WeightedGraph<String,Double> wg, HashMap<String,Location> hm, Location source, Location destination) {
    vertices = wg;
    unvisited = new PriorityQueue<>();

     for(String s : hm.keySet()) {
      Location l = hm.get(s);
      l.setDistance(Double.MAX_VALUE);
      l.setPrevious(null);
    }

    hm.get(source.name).setDistance(0.0);

    for(String s : hm.keySet()) {
      Location l = hm.get(s);
    }

    for(String l : hm.keySet()) {
       unvisited.add(hm.get(l));
    }
    

    //double currDistance = unvisited.peek().getDistance();
    Location curr = source;

    while(unvisited.contains(destination)) {
      curr = unvisited.poll();
      UpdateNeighbors(wg, hm, curr);
    }
      
    return curr.getDistance();
  }

  public void UpdateNeighbors(WeightedGraph<String,Double> wg, HashMap<String,Location> hm, Location curr) {
    HashMap<String,Double> distFromCenter = wg.getEdges(curr.name);
      for(String nextKey : distFromCenter.keySet()) {
        Location next = hm.get(nextKey);
        if(unvisited.contains(next)){
          if(curr.getDistance() + distFromCenter.get(next.name) < next.getDistance()) {
            next.setPrevious(curr);
            next.setDistance(distFromCenter.get(next.name));
            unvisited.remove(next);
            unvisited.add(next);        
            }
          }
        }
  }
}
