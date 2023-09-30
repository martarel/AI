package npuzzle;

import search.NodeFunction;
import search.Node;
import search.State;

public class MisplacedTilesHeuristicFunction {
    public static int value(Node node) {
        int misplacedTiles = 0;
        State tiles = node.state;
        int width = tiles.getWidth();
        for (int r = 0; r < width; r++) {
            for (int c = 0; c < width; c++) {
                if (tiles.getTile(r, c) != r * width + c + 1) {
                    misplacedTiles++;
                }
            }
        }
        return misplacedTiles;
    }
}
