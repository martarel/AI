package tour;

import search.*;

public class Demo2 {
    public static void main(String[] args) {
  		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
        Node startNode = new Node(null, null, new TourState(startCity), 0, 0);
        TourPrinting printer = new TourPrinting();

        NodeFunction aStarFunction = new AStarFunction(new MinMaxDistanceHeuristicFunction(romania, startCity));
        BestFirstFrontier frontier = new BestFirstFrontier(aStarFunction);
        GraphSearch graphSearch = new GraphSearch(frontier);
        TreeSearch treeSearch = new TreeSearch(frontier);    

        System.out.println("Running A* Graph Search...");
        Node solution = graphSearch.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + graphSearch.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + frontier.maxNodes());

        frontier.clear();

        System.out.println("Running A* Tree Search...");
        solution = treeSearch.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + treeSearch.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + frontier.maxNodes());
    }
}