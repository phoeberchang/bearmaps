public class MyRectangle {
    private double x;
    private double y;
    private double width;
    private double height;

    public MyRectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean overlaps(MyRectangle r) {
        double left = Math.min(x, x + width);
        double right = Math.max(x, x + width);
        double top = Math.max(y, y - height);
        double bottom = Math.min(y, y - height);
        double left2 = Math.min(r.x, r.x + r.width);
        double right2 = Math.max(r.x, r.x + r.width);
        double top2 = Math.max(r.y, r.y - r.height);
        double bottom2 = Math.min(r.y, r.y - r.height);
        return left <= right2 && right >= left2 && top >= bottom2 && bottom <= top2;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
