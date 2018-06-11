import java.io.File;

public class QuadTree {

    private Node root;
    private File imgdir;

    public QuadTree(Node root, File imgdir) {
        this.root = root;
        this.imgdir = imgdir;
        root.makeTree(root);
    }

    public Node getNode() {
        return root;
    }
}
