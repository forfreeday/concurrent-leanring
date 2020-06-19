package innerClassTest;

import java.util.ArrayList;
import java.util.List;

public class ThreadA implements Runnable {
    @Override
    public void run() {
        List<Integer> list = new ArrayList<Integer>();
        int i = 0;
        while (true) {
            list.add(i);
            i++;
        }
    }
}