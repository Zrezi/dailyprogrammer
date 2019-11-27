package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * +---------------------------------------------------------------------------+
 * | Standard Challenge                                                        |
 * +---------------------------------------------------------------------------+
 * The famous lumberjacks of /r/dailyprogrammer are well known to be weird and
 * interesting. But we always enjoy solving their problems with some code.
 * <p>
 * For today's challenge the lumberjacks pile their logs from the forest in a
 * grid N x N. Before using us to solve their inventory woes they randomly just
 * put logs in random piles. Currently the pile sizes vary and they want to
 * even them out. So let us help them out.
 * <p>
 * You will be given the size of the storage area, the number of logs we have
 * to put into storage and the log count in each pile currently in storage. You
 * can either read it in from the user or hardcode this data. For example:
 * <p>
 * 3
 * 7
 * 1 1 1
 * 3 1 3
 * 1 4 1
 * <p>
 * So the size is 3 x 3, we have 7 logs to place, and we see the 3 x 3 grid of
 * current size of the log piles.
 * <p>
 * We want to fill the smallest piles first and we want to evenly spread out
 * the logs. So in the above example we have 7 logs. The lowest log count is
 * 1. So starting with teh first pile in the upper left and going left-right
 * on each row we place 1 log in each 1 pile until all the current 1 piles get
 * a log (or we run out). After that, if we have more logs we then have to add
 * logs to piles with 2 (again moving left-right on each row).
 * <p>
 * Once we have placed the logs we need to output the new log count for the
 * lumberjacks to tack up on their cork board.
 */
class Challenge217 {

    private List<GridLocation> minimumLocations;

    Challenge217() {
        this.minimumLocations = new ArrayList<>();
    }

    int[][] logs(int logs, int[][] grid) {
        while (logs > 0) {
            populateMinimumLocations(logs, grid);
            for (GridLocation minimumLocation : minimumLocations) {
                grid[minimumLocation.getY()][minimumLocation.getX()]++;
                logs--;
            }
        }

        printGrid(grid);
        return grid;
    }

    private void populateMinimumLocations(int logs, int[][] grid) {
        minimumLocations.clear();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] < min) {
                    min = grid[i][j];
                    minimumLocations.clear();
                }
                if (grid[i][j] == min) {
                    minimumLocations.add(new GridLocation(j, i));
                    if (minimumLocations.size() == logs) {
                        return;
                    }
                }
            }
        }
    }

    private void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    private class GridLocation {

        private int x;
        private int y;

        GridLocation(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }

    }

}
