import java.util.HashSet;

public class GraphNode implements Comparable<GraphNode> {
    private long id;
    private double lon;
    private double lat;
    private HashSet<Connection> connectionSet;
    private GraphNode prev;
    private double distToCurr;
    private double priority;

    public GraphNode(long id, double lon, double lat) {
        this.id = id;
        this.lon = lon;
        this.lat = lat;
        this.connectionSet = new HashSet<Connection>();
        this.distToCurr = 0;
        this.priority = 0;
    }

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GraphNode graphnode = (GraphNode) o;
        if (id != graphnode.id) {
            return false;
        }
        if (Double.compare(graphnode.lon, lon) != 0) {
            return false;
        }
        if (Double.compare(graphnode.lat, lat) != 0) {
            return false;
        }
        return true;
    }

    public long getID() {
        return id;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public HashSet<Connection> getConnectionSet() {
        return connectionSet;
    }

    public GraphNode getPrev() {
        return prev;
    }

    public double getDistToCurr() {
        return distToCurr;
    }

    public double getPriority() {
        return priority;
    }

    public void setPrev(GraphNode newprev) {
        prev = newprev;
    }

    public void setDistToCurr(double newdist) {
        distToCurr = newdist;
    }

    public void setPriority(double newprio) {
        priority = newprio;
    }

    @Override
    public int compareTo(GraphNode other) {
        if (this.priority < other.priority) {
            return -1;
        }
        if (this.priority > other.priority) {
            return 1;
        }
        return 0;
    }
}
