import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacificAtlanticWaterFlow {
    List<List<Integer>> result;
    int m, n;
    int[][] heights;

    private record Cell(int row, int column) {

    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        result = new ArrayList<>();
        m = heights.length;
        n = heights[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, "pacific", new HashSet<>()) && dfs(i, j, "atlantic", new HashSet<>())) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private boolean dfs(int y, int x, String target, Set<Cell> visited) {
        if (y < 0 || x < 0) {
            return "pacific".equals(target);
        }
        if (y >= m || x >= n) {
            return "atlantic".equals(target);
        }
        if (!visited.contains(new Cell(y, x))) {
            visited.add(new Cell(y, x));
            boolean possible = false;
            Cell[] neighbors = {
                    new Cell(y - 1, x),
                    new Cell(y + 1, x),
                    new Cell(y, x - 1),
                    new Cell(y, x + 1)
            };
            for (Cell c : neighbors) {
                if (0 <= c.row && c.row < m && 0 <= c.column && c.column < n) {
                    if (heights[c.row][c.column] <= heights[y][x]) {
                        possible |= dfs(c.row, c.column, target, visited);
                    }
                } else {
                    possible |= dfs(c.row, c.column, target, visited);
                }
            }
            return possible;
        }
        return false;
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();
        int[][] test = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        List<List<Integer>> expected = List.of(
                List.of(0, 4),
                List.of(1, 3),
                List.of(1, 4),
                List.of(2, 2),
                List.of(3, 0),
                List.of(3, 1),
                List.of(4, 0)
        );
        System.out.println(sol.pacificAtlantic(test).equals(expected));
        System.out.println(sol.pacificAtlantic(new int[][]{{1}}).equals(List.of(List.of(0, 0))));
    }
}
