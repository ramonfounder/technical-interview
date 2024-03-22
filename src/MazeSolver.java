import java.util.LinkedList;
import java.util.Queue;

public class MazeSolver {

    public static void main(String[] args) {
        MazeSolver solver = new MazeSolver();

        int[][] grid1 = {
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}
        };
        int[] source1 = {0, 1};
        int[] destination1 = {2, 2};
        System.out.println(solver.shortestPath(grid1, source1, destination1)); // Output: 3

        int[][] grid2 = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 0, 1}
        };
        int[] source2 = {0, 0};
        int[] destination2 = {3, 4};
        System.out.println(solver.shortestPath(grid2, source2, destination2)); // Output: -1
    }

    // Method to find the shortest path in a binary maze
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        if (grid == null || grid.length == 0) return -1;
        if (grid[source[0]][source[1]] == 0 || grid[destination[0]][destination[1]] == 0) return -1;

        int n = grid.length, m = grid[0].length;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // Right, Down, Up, Left
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{source[0], source[1], 0}); // Add source to queue with distance 0
        visited[source[0]][source[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            if (x == destination[0] && y == destination[1]) {
                return distance;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY] && grid[newX][newY] == 1) {
                    queue.add(new int[]{newX, newY, distance + 1});
                    visited[newX][newY] = true;
                }
            }
        }

        return -1; // If destination is not reached
    }
}
