public class Concurrency {

    public int sharedX;

    public void addOne() {
        int x = sharedX;
        x = x + 1;
        sharedX = x;
    }
}
