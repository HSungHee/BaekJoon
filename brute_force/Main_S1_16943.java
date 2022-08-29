package boj;

import java.util.Scanner;

public class Main_S1_16943 {
    static char A[];
    static int B, length, answer = Integer.MIN_VALUE;
    static StringBuilder sb = new StringBuilder();
    static boolean visited[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.next().toCharArray();
        B = sc.nextInt();
        length = A.length;
        visited = new boolean[length];

        permutation(0);
        System.out.println(answer==Integer.MIN_VALUE ? -1 : answer);
    }

    private static void permutation(int cnt) {
        if(cnt == length) {
            if(Integer.parseInt(sb.toString()) < B) {
                answer = Math.max(answer, Integer.parseInt(sb.toString()));
            }
            return;
        }

        if(cnt==1 && sb.charAt(0)=='0') return;

        for(int i=0; i<length; i++) {
            if(visited[i]) continue;

            sb.append(A[i]);
            visited[i] = true;
            permutation(cnt+1);
            sb.setLength(sb.length()-1);
            visited[i] = false;
        }
    }
}
