package npuzzle;

import search.BestFirstFrontier;
import search.GraphSearch;
import search.TreeSearch;
import search.Node;
import search.GoalTest;
import search.AStarFunction;
import search.State;
import search.*;

public class Demo2 {
    public static void main(String[] args) {
        Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
        GoalTest goalTest = new TilesGoalTest();
        Node startNode = new Node(null, null, initialConfiguration, 0, 0);
        NPuzzlePrinting printer = new NPuzzlePrinting();


        NodeFunction aStarFunction = new AStarFunction(new MisplacedTilesHeuristic());
        BestFirstFrontier frontier = new BestFirstFrontier(aStarFunction);
        GraphSearch graphSearch = new GraphSearch(frontier);
        TreeSearch treeSearch = new TreeSearch(frontier);    

        System.out.println("Running A* Tree Search...");
        Node solution = treeSearch.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + treeSearch.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + frontier.maxNodes());

        frontier.clear();

        System.out.println("Running A* Graph Search...");
        solution = graphSearch.findSolution(startNode, goalTest);
        //printer.printSolution(solution);
        System.out.println("Number of nodes expanded " + graphSearch.numberOfNodesExpanded());
        System.out.println("Maximum number of nodes in frontier " + frontier.maxNodes());
    }
}


