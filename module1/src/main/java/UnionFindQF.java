public class UnionFindQF {
    private int[] ids;

    public UnionFindQF(int size) {
        initialize(size);
    }

    private void initialize(int size) {
        this.ids = new int[size];

        for (int i = 0; i < size; i++) {
            ids[i] = i;
        }
    }

    public void union(int p, int q) {
        int pId = ids[p];
        int qId = ids[q];

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) { // move all elements from pid component to qid's one.
                ids[i] = qId;
            }
        }
    }

    public boolean isConnected(int p, int q) {
        return ids[p] == ids[q];
    }
}