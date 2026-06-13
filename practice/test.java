import java.util.ArrayList;
import java.util.Arrays;

public class test {
    static void main() {
        boolean t = true;
        boolean f = false;

        int a = 1, b = 2, c = 3, d = 0;
        int[] arr = {a, b, c, d};
        Arrays.sort(arr);

        ArrayList<Integer> idxList = new ArrayList<Integer>();
        idxList.stream().count();
        idxList.isEmpty();
        
    }
}
