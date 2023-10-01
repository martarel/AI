package npuzzle;

import search.NodeFunction;
import search.Node;
import search.State;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    public int value(Node node) {
        Tiles tiles = (Tiles) node.state;
        int misplacedTiles = 0;
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
