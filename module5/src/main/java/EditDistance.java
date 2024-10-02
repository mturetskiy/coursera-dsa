import java.util.*;

class EditDistance {
    public static int calculateEditDistance(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int len = Math.max(sLen, tLen);

        Node[][] distances = new Node[len + 1][len + 1];

        // initialize 1st row for empty chars:
        for (int r = 0; r <= len; r++) {
            distances[r][0] = new Node(r, Mode.none);
        }

        for (int c = 0; c <= len; c++) {
            distances[0][c] = new Node(c, Mode.none);
        }

        // calculate real distances for each chars:
        for (int r = 1; r <= len; r++) {
            for (int c = 1; c <= len; c++) {
                int matchCost = calcMatchCost(s, t, r, c);
                Node dMatch = new Node(distances[r - 1][c - 1].cost + matchCost, Mode.match);
                Node dIns = new Node(distances[r][c - 1].cost + 1, Mode.insert);
                Node dDel = new Node(distances[r - 1][c].cost + 1, Mode.delete);

                distances[r][c] = dMatch;
                if (dIns.cost < distances[r][c].cost) {
                    distances[r][c] = dIns;
                }

                if (dDel.cost < distances[r][c].cost) {
                    distances[r][c] = dDel;
                }
            }
        }

//        printMatrix(distances);

        // to convert from s -> t:
        int dRow = s.length(); // 0th row is when s is empty
        int dCol = t.length(); // 0th col is when t is empty

        Node editDistance = distances[dRow][dCol];
        return editDistance.cost;
    }

    private static int calcMatchCost(String s, String t, int r, int c) {
        int sIdx = r - 1; // rows are started for 1
        int tIdx = c - 1; // cols are started for 1

        if (sIdx < s.length() && tIdx < t.length() && s.charAt(sIdx) == t.charAt(tIdx)) {
            return 0;
        }

        return 1;
    }

    static class Node {
        int cost;
        Mode mode;

        public Node(int cost, Mode mode) {
            this.cost = cost;
            this.mode = mode;
        }

        @Override
        public String toString() {
            char modeName = (mode == Mode.none) ? '_' : mode.name().toUpperCase(Locale.ROOT).charAt(0);
            return "(" + cost + ", " + modeName + ')';
        }
    }

    enum Mode {
        insert,
        delete,
        match,
        none
    }

    private static <T> void printMatrix(T[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            T[] row = matrix[r];
            for (int c = 0; c < row.length; c++) {
                System.out.print("  " + row[c]);
            }

            System.out.println(" ");
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

//        String s = "thou shalt";
//        String t = "you should";

//        String s = "ABC";
//        String t = "A";

        System.out.println(calculateEditDistance(s, t));
    }

}
