package boj.Silver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_G5_2023 {
    static List<Integer> answer = new ArrayList<Integer>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        dfs(sb, N);
    }

    private static void dfs(StringBuilder str, int N) {
        if(str.length() == N) {
            if(isPrime(Integer.parseInt(str.toString()))) {
                System.out.println(str.toString());
            }
            return;
        }

        for(int i=1; i<10; i++) {
            if(isPrime(Integer.parseInt(str.toString()+i))) {
                str.append(i);
                dfs(str, N);
                str.setLength(str.length()-1);
            }
        }
    }

    private static boolean isPrime(int number) {
        if(number < 2) return false;

        for(int i=2; i<=Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}