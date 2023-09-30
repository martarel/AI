package tour;

import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;
import search.GraphSearch;
import search.TreeSearch;
import search.Node;
import search.GoalTest;
import search.IterativeDeepeningTreeSearch;

public class Demo1 {
    public static void main(String[] args) {
  		Cities romania = SetUpRomania.getRomaniaMapSmall();
		City startCity = romania.getState("Bucharest");
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
        Node startNode = new Node(null, null, new TourState(startCity));
        TourPrinting printer = new TourPrinting();

        DepthFirstFrontier DFSfrontier = new DepthFirstFrontier();
        BreadthFirstFrontier BFSfrontier = new BreadthFirstFrontier();
        GraphSearch graphSearchDFS = new GraphSearch(DFSfrontier);
        GraphSearch graphSearchBFS = new GraphSearch(BFSfrontier);
        TreeSearch treeSearchDFS = new TreeSearch(DFSfrontier);
        TreeSearch treeSearchBFS = new TreeSearch(BFSfrontier);
        IterativeDeepeningTreeSearch iterativeDeepeningTreeSearch = new IterativeDeepeningTreeSearch();


        System.out.println("Running BFS Tree Search...");
        Node solution = treeSearchBFS.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + treeSearchBFS.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + BFSfrontier.maxNodes());

        System.out.println("Running DFS Tree Search...");
        //solution = treeSearchDFS.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + treeSearchDFS.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + DFSfrontier.maxNodes());

        BFSfrontier.clear();
        DFSfrontier.clear();

        System.out.println("Running BFS Graph Search...");
        solution = graphSearchBFS.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + graphSearchBFS.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + BFSfrontier.maxNodes());

        System.out.println("Running DFS Graph Search...");
        solution = graphSearchDFS.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + graphSearchDFS.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + DFSfrontier.maxNodes());

        System.out.println("Running Iterative Deepening Search...");
        solution = iterativeDeepeningTreeSearch.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + iterativeDeepeningTreeSearch.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + iterativeDeepeningTreeSearch.maxNodes());
    }
}