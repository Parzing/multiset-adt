import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        profileMultiSet(new TreeMultiSet(), 500);
    }

    private static void profileMultiSet(MultiSet input, int n) {
        ArrayList<Integer> itemsAdded = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int x = random.nextInt(100);
            input.add(x);
            itemsAdded.add(x);
        }

        assert input.size() == n;

        long start = System.currentTimeMillis();

        for (int x : itemsAdded) {
            input.remove(x);
        }

        long end = System.currentTimeMillis();

        assert input.isEmpty();

        System.out.printf("%5d, %-37s, %.6f\n", n, input.getClass().getSimpleName(), (end - start)/1000.0);
    }
}
