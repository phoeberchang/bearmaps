public class Node implements Comparable<Node> {
    private double tlon;
    private double tlat;
    private double blon;
    private double blat;
    private int img;
    private int depth;
    private MyRectangle rect;
    private Node nw, ne, sw, se;

    public Node(double tlon, double tlat, double blon, double blat, int img, int depth) {
        this.tlon = tlon;
        this.tlat = tlat;
        this.blon = blon;
        this.blat = blat;
        this.img = img;
        this.depth = depth;
        this.rect = new MyRectangle(tlon, tlat, blon - tlon, tlat - blat);
    }

    public void split(Node root) {
        root.nw = new Node(root.tlon, root.tlat, (root.blon - root.tlon) / 2 
            + root.tlon, (root.tlat - root.blat) / 2 + root.blat, root.img * 10 
                + 1, root.depth + 1);
        root.ne = new Node((root.blon - root.tlon) / 2 + root.tlon, root.tlat, 
            root.blon, (root.tlat - root.blat) / 2 + root.blat, root.img * 10 + 2, root.depth + 1);
        root.sw = new Node(root.tlon, (root.tlat - root.blat) / 2 
            + root.blat, (root.blon - root.tlon) / 2 + root.tlon, root.blat, root.img 
                * 10 + 3, root.depth + 1);
        root.se = new Node((root.blon - root.tlon) / 2 + root.tlon, 
            (root.tlat - root.blat) / 2 + root.blat, root.blon, root.blat, 
                root.img * 10 + 4, root.depth + 1);
    }

    public void makeTree(Node root) {
        split(root);
        if (root.img * 10 + 1 < 9999999) {
            makeTree(root.nw);
            makeTree(root.ne);
            makeTree(root.sw);
            makeTree(root.se);
        }
    }

    public int compareTo(Node other) {
        if (this.rect.getX() < other.rect.getX()) {
            if (this.rect.getY() >= other.rect.getY()) {
                return -1;
            } else {
                return 1;
            }
        }
        if (this.rect.getX() > other.rect.getX()) {
            if (this.rect.getY() > other.rect.getY()) {
                return -1;
            } else {
                return 1;
            }
        }
        if (this.rect.getX() == other.rect.getX()) {
            if (this.rect.getY() > other.rect.getY()) {
                return -1;
            }
            if (this.rect.getY() == other.rect.getY()) {
                return 0;
            } else {
                return 1;
            }
        }
        return 0;
    }

    public double getTLON() {
        return tlon;
    }

    public double getTLAT() {
        return tlat;
    }

    public double getBLON() {
        return blon;
    }

    public double getBLAT() {
        return blat;
    }

    public int getImg() {
        return img;
    }

    public int getDepth() {
        return depth;
    }

    public MyRectangle getRect() {
        return rect;
    }

    public Node getNW() {
        return nw;
    }

    public Node getNE() {
        return ne;
    }

    public Node getSW() {
        return sw;
    }

    public Node getSE() {
        return se;
    }
}
