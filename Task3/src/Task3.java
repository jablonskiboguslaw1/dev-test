import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        GraphResolver graphResolver = new GraphResolver();
        graphResolver.collectEdges();
        graphResolver.extractAndMarge();
        System.out.println(graphResolver.getSeparateGraphs().size());

    }
}


class GraphResolver {

    public List<Set<Integer>> getSeparateGraphs() {
        return separateGraphs;
    }

    private final List<Set<Integer>> separateGraphs = new ArrayList<>();
    private final List<Set<Integer>> jointGraphs = new ArrayList<>();
    private final List<Set<Integer>> tempGraphs = new ArrayList<>();


    public void collectEdges() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the edges number");
        String recordsNumStr = scanner.nextLine();
        int recordsNum = Integer.parseInt(recordsNumStr);
        if (recordsNum > 0) {

            for (int i = 0; i < recordsNum; i++) {
                System.out.println("Enter the edge");
                String edgeStr = scanner.nextLine().trim();
                String[] s = edgeStr.split(" ");
                int vertex1 = Integer.parseInt(s[0].trim());
                int vertex2 = Integer.parseInt(s[1].trim());
                HashSet<Integer> edge = new HashSet<>();
                edge.add(vertex2);
                edge.add(vertex1);
                tempGraphs.add(edge);
            }
        }
    }

    private void extractSeparate() {

        for (int j = 0; j < tempGraphs.size(); j++) {
            for (int k = j + 1; k < tempGraphs.size(); k++) {
                if (!Collections.disjoint(tempGraphs.get(j), tempGraphs.get(k))) {
                    jointGraphs.add(tempGraphs.get(j));
                    jointGraphs.add(tempGraphs.get(k));
                }
            }
        }
        tempGraphs.removeAll(jointGraphs);
        separateGraphs.addAll(tempGraphs);
        tempGraphs.clear();
        tempGraphs.addAll(jointGraphs);
        jointGraphs.clear();

    }

    private void margeJointGraphs() {

        for (int j = 0; j < tempGraphs.size(); j++) {
            for (int k = j + 1; k < tempGraphs.size(); k++) {
                if (!Collections.disjoint(tempGraphs.get(j), tempGraphs.get(k))) {
                    tempGraphs.get(j).addAll(tempGraphs.get(k));
                    tempGraphs.remove(tempGraphs.get(k));
                }
            }
        }
    }

    public void extractAndMarge() {
        while (tempGraphs.size() > 0) {
            extractSeparate();
            margeJointGraphs();
        }
    }
}

