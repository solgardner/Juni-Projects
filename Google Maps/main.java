//Distances are in miles

import java.util.*; 
import java.io.*;

class Main { 
  public static HashMap<String,Location> locations = new HashMap<>();
  public static WeightedGraph<String,Double> wg = new WeightedGraph<>();
  public static Double total = 0.0;
  public static Location start;
  public static Location end;
  public static void main(String args[]) { 
    loadData();
    DjikstrasAlgorithm dj = new DjikstrasAlgorithm();
    Scanner s = new Scanner(System.in);
    System.out.println("Please Enter Starting Position: ");
    Location start = locations.get(s.nextLine());
    System.out.println("Please Enter Destination: ");
    Location end = locations.get(s.nextLine());
    dj.dijkstra(wg,locations,start,end);
    System.out.println("\n\n\n");

    System.out.println("ROUTE:\n")
    printAnswer(end);
    System.out.println("TOTAL: \n" + Math.round(total * 100.0)/100.0);
  } 
  public static void printAnswer(Location e) {
    if(e.getPrevious() == null) {
      return;
    }
    total += e.getDistance();
    printAnswer(e.getPrevious());
    System.out.println(e.getPrevious().name  + " ---> " + e.name + "--" + Math.round(e.getDistance()*100.0)/100.0);
  }


  public static void loadData() {
    Scanner sc = new Scanner(System.in);
    System.out.println("File Name: ");
    String fileName = sc.nextLine();
    File f = new File(fileName);
    Scanner s = null;
    try {
      s = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println(e);
    }
    while(s.hasNext()) {
      String[] line = s.nextLine().split(" ");
      String startCoords = line[0];
      String endCoords = line[1];
      String distance = line[2];
      String start = line[3].split("--")[0];
      String end = line[3].split("--")[1];
      Location startL = new Location(start,Double.parseDouble(startCoords.split(",")[0]), Double.parseDouble(startCoords.split(",")[1]));
      Location endL = new Location (end, Double.parseDouble(endCoords.split(",")[0]), Double.parseDouble(endCoords.split(",")[1]));
      locations.put(start,startL);
      locations.put(end,endL);
      wg.addEdge(start,end,Double.parseDouble(distance));
    }
  }
} 