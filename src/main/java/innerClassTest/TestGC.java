package innerClassTest;

/**
 * TODO
 *
 * @author liu kai
 * @date 2020-06-16 16:45
 */
public class TestGC {
    public static void main(String[] args) throws Exception {
        Aoo a = new Aoo(1, "a");
        a = null;
        ThreadA ta = new ThreadA();
        Thread t = new Thread(ta);
        t.start();
        Thread.sleep(2000);
        System.exit(0);
    }
}
