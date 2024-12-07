import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static class Node {
        int from, to, cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    static int N,M;
    static long INF = Long.MAX_VALUE;
    static long[] isVisited;
    static List<Node> graph;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] noStr1 = bf.readLine().split(" ");
        N = Integer.parseInt(noStr1[0]);
        M = Integer.parseInt(noStr1[1]);

        isVisited = new long[N + 1];
        graph = new ArrayList<>();
        Arrays.fill(isVisited,INF);

        for(int i = 0; i < M; i++) {
            String[] noStr2 = bf.readLine().split(" ");
            int from = Integer.parseInt(noStr2[0]);
            int to = Integer.parseInt(noStr2[1]);
            int cost = Integer.parseInt(noStr2[2]);

            graph.add(new Node(from,to,cost));
        }

        if(ballmanford(1)) {
            System.out.println(-1);
        }else {
            for(int i = 2; i <= N; i++) {
                System.out.println((isVisited[i] == INF) ? "-1" : isVisited[i]);
            }
        }

    }

    public static boolean ballmanford(int start) {

        isVisited[start] = 0;

        for(int i = 1; i < N; i++) {
            for(Node node : graph){
                if (isVisited[node.from] != INF && isVisited[node.from] + node.cost < isVisited[node.to]) {
                    isVisited[node.to] = isVisited[node.from] + node.cost;
                }
            }
        }

        for(Node node : graph) {
            if(isVisited[node.from] != INF && isVisited[node.from] + node.cost < isVisited[node.to]){
                return true;
            }
        }


        return false;
    }
}