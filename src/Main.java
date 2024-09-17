import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        for(int num : new int[]{500, 1000, 2000, 4000}){
            profileMultiSet(new TreeMultiSet(), num);
        }
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

        long start = System.nanoTime();

        for (int x : itemsAdded) {
            input.remove(x);
        }

        long end = System.nanoTime();

        assert input.isEmpty();

        System.out.printf("%5d   %-37s %.6f ns\n", n, input.getClass().getSimpleName(), (end - start)/1000_000.0);
    }
}
