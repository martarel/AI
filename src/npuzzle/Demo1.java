package npuzzle;

import search.DepthFirstFrontier;
import search.BreadthFirstFrontier;
import search.GraphSearch;
import search.TreeSearch;
import search.Node;
import search.GoalTest;
import search.IterativeDeepeningTreeSearch;

public class Demo1 {
    public static void main(String[] args) {
        Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
        GoalTest goalTest = new TilesGoalTest();
        Node startNode = new Node(null, null, initialConfiguration);
        NPuzzlePrinting printer = new NPuzzlePrinting();

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
        solution = treeSearchDFS.findSolution(startNode, goalTest);
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


