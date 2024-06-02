package Java.BFS;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER m
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
    // Write your code here
        HashMap<Integer, List<Integer>> adjacencyList = new HashMap<>();

        // create adjacency list with hashmap with each edge as key and
        // a list of the edge's adjacency stored as a list as value (currently empty)
        for (int i = 1; i <= n; i++) {
            adjacencyList.put(i, new ArrayList<Integer>());
        }
                
        // Fill in the empty adjacency values
        for (List<Integer> pair: edges) {
            int node1 = pair.get(0);
            int node2 = pair.get(1);
            List<Integer> node1Pair = adjacencyList.get(node1);
            List<Integer> node2Pair = adjacencyList.get(node2);
            node1Pair.add(node2);
            node2Pair.add(node1);
        }

        // Use a map to represent distance of start to node
        // Use a TreeMap instead of hashmap so that keys are ordered/sorted ascending
        Map<Integer, Integer> distance = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            distance.put(i, 0);
        }

        // Use a hashmap to track which node has been visited
        HashSet<Integer> visited = new HashSet<>();
        visited.add(s);

        // Use a queue to list out nodes t visit
        Queue<Integer> q = new LinkedList<>();
        q.add(s);

        while (!q.isEmpty()) {
            int node = q.remove();
            List<Integer> nodeAdjacency = adjacencyList.get(node);
            for (int node2: nodeAdjacency) {
                if (!visited.contains(node2)) {
                    distance.put(node2, distance.get(node) + 6);
                    q.add(node2);
                    visited.add(node2);
                }
            }
        }

        distance.remove(s);
        List<Integer> result = new ArrayList<>();
        for (int node: distance.keySet()) {
            int dist = distance.get(node);
            if (dist <= 0) result.add(-1);
            else result.add(dist);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
