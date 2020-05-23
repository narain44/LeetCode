package TreesCuttingTreesForGolfEvent;

import java.util.*;

public class CuttingTreesForGolfEvent {

    public static void main(String[] args) {
        CuttingTreesForGolfEvent instance = new CuttingTreesForGolfEvent();
        List<List<Integer>> forest = new ArrayList<>();
        forest.add(0, Arrays.asList(new Integer[]{1, 2, 3}));
        forest.add(1, Arrays.asList(new Integer[]{0, 0, 0}));
        forest.add(2, Arrays.asList(new Integer[]{7, 6, 5}));
        System.out.println(instance.cutOffTree(forest));
    }

    public int cutOffTree(List<List<Integer>> forest) {
        int minDistance = 0;

        //Holds Tree height and its coordinates, row and column
        List<int[]> trees = new ArrayList<>();

        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(0).size(); j++) {
                int v = forest.get(i).get(j);
                if (v > 1)
                    trees.add(new int[]{v, i, j});
            }
        }


        //Sort by Height
        Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

        //Iterate by tree height and add each step distance to total distance.
        int sr = 0, sc = 0;
        for (int[] treeToFind : trees) {
            int tr = treeToFind[1], tc = treeToFind[2];
            int stepDistance = findDistance(forest, sr, sc, tr, tc);
//            int stepDistance=bfs(forest,sr,sc,tr,tc);
            if (stepDistance == -1) return -1;
            minDistance += stepDistance;
            sr = tr;
            sc = tc;
        }
        return minDistance;
    }

    public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int R = forest.size(), C = forest.get(0).size();
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{sr, sc, 0});
        boolean[][] seen = new boolean[R][C];
        seen[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == tr && cur[1] == tc) return cur[2];
            for (int di = 0; di < 4; ++di) {
                int r = cur[0] + dr[di];
                int c = cur[1] + dc[di];
                if (0 <= r && r < R && 0 <= c && c < C &&
                        !seen[r][c] && forest.get(r).get(c) > 0) {
                    seen[r][c] = true;
                    queue.add(new int[]{r, c, cur[2] + 1});
                }
            }
        }
        return -1;
    }

    private int findDistance(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
        int[] dr = new int[]{1, 0, -1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        int R = forest.size(), C = forest.get(0).size();
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] seen = new boolean[R][C];
        //An array containing the coordinates and distance so far
        queue.add(new int[]{sr, sc, 0});
        seen[sr][sc] = true;
        while (!queue.isEmpty()) {
            int[] treeToFind = queue.pop();
            int r = treeToFind[0], c = treeToFind[1], distance = treeToFind[2];
            if (r == tr && c == tc) return distance;
            //Check each direction
            for (int di = 0; di < 4; di++) {
                int nr = r + dr[di];
                int nc = c + dc[di];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && !seen[nr][nc] & forest.get(nr).get(nc) > 0) {
                    seen[nr][nc] = true;
                    queue.add(new int[]{nr, nc, treeToFind[2] + 1});
                }
            }
        }
        return -1;
    }
}
