public class Connection {
    private GraphNode n1;
    private GraphNode n2;
    private double db;

    public Connection(GraphNode n1, GraphNode n2) {
        this.n1 = n1;
        this.n2 = n2;
        this.db = getDist(n1.getLon(), n1.getLat(), n2.getLon(), n2.getLat());
    }

    public GraphNode getN1() {
        return n1;
    }

    public GraphNode getN2() {
        return n2;
    }

    public double getDB() {
        return db;
    }

    public double getDist(double lon1, double lat1, double lon2, double lat2) {
        return Math.sqrt(Math.pow(lon2 - lon1, 2) + Math.pow(lat2 - lat1, 2));
    }
}
