class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        int sx = -1, sy = -1;
        int[][] litterIdx = new int[m][n];
        int numLitter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                litterIdx[i][j] = -1;
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    litterIdx[i][j] = numLitter++;
                }
            }
        }
        int fullMask = (1 << numLitter) - 1;
        if (fullMask == 0) return 0;
        
        int[][][] bestEnergy = new int[m][n][1 << numLitter];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                java.util.Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        java.util.Queue<int[]> q = new java.util.LinkedList<>();
        q.offer(new int[]{sx, sy, 0, energy});
        bestEnergy[sx][sy][0] = energy;
        int[] dirX = {-1, 1, 0, 0};
        int[] dirY = {0, 0, -1, 1};
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int x = curr[0];
                int y = curr[1];
                int mask = curr[2];
                int e = curr[3];
                if (mask == fullMask) {
                    return steps;
                }
                if (e == 0) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dirX[d];
                    int ny = y + dirY[d];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        char nc = classroom[nx].charAt(ny);
                        if (nc == 'X') continue;
                        int nmask = mask;
                        int ne = e - 1;
                        if (nc == 'L') {
                            nmask |= (1 << litterIdx[nx][ny]);
                        } else if (nc == 'R') {
                            ne = energy;
                        }
                        if (ne > bestEnergy[nx][ny][nmask]) {
                            bestEnergy[nx][ny][nmask] = ne;
                            q.offer(new int[]{nx, ny, nmask, ne});
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}