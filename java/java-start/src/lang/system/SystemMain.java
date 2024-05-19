package lang.system;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemMain {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        long nanoTime = System.nanoTime();
        System.out.println("nanoTime = " + nanoTime);

        Map<String, String> getenv = System.getenv();
        System.out.println("getenv = " + getenv);

        Properties properties = System.getProperties();
        System.out.println("properties = " + properties);
        String property = System.getProperty("java.version");
        System.out.println("property = " + property);

        char[] original = {'m', 't', 'a', 'k'};
        char[] copied = new char[original.length];
        System.arraycopy(original, 0, copied, 0, original.length);
        System.out.println("copied = " + copied);
        System.out.println("Arrays.toString(copied) = " + Arrays.toString(copied));

        System.exit(0);
        System.out.println('X');
    }
}
