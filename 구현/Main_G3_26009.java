package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G3_26009 {
    static int N, M, map[][];
    static int[][] delta1 = {{-1,0},{1,0},{0,-1},{0,1}};
    static int[][] delta2 = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1}};
    static boolean visited[][], arrived = true;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int dist = Integer.parseInt(st.nextToken());

            map[r][c] = -1;

            mark(r, c, dist);
        }

        int result = commute(0, 0);

        if(arrived) {
            System.out.println("YES");
            System.out.println(result);
        } else {
            System.out.println("NO");
        }

    }

    private static int commute(int i, int j) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{i, j});
        visited[i][j] = true;
        int distance = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int s=0; s<size; s++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int d=0; d<4; d++) {
                    int nr = r + delta1[d][0];
                    int nc = c + delta1[d][1];

                    if (nr == N - 1 && nc == M - 1) return distance + 1;

                    if (nr > -1 && nr < N && nc > -1 && nc < M
                            && map[nr][nc] == 0
                            && !visited[nr][nc]) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            distance++;
        }
        arrived = false;
        return distance;
    }

    private static void mark(int r, int c, int dist) {
        for(int d=1; d<=dist; d++) {
            for(int dir=0; dir<8; dir++) {
                int nr = r + delta2[dir][0] * d;
                int nc = c + delta2[dir][1] * d;

                if (distance(r, c, nr, nc, dist)
                        && nr > -1 && nr < N && nc > -1 && nc < M) {
                    map[nr][nc] = -1;
                }
            }
        }
    }

    private static boolean distance(int r, int c, int nr, int nc, int dist) {
        if(Math.abs(r-nr)+Math.abs(c-nc) <= dist) return true;
        return false;
    }

    static String src= "5 5\n" +
            "2\n" +
            "4 2 1\n" +
            "2 4 1";
}
