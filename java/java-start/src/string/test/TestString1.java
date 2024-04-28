package string.test;

public class TestString1 {
    public static void main(String[] args) {
        String url = "https://www.example.com";
        boolean result = url.startsWith("https://");
        System.out.println("result = " + result);

        String[] arr = {"hello", "java", "jvm", "spring", "jpa"};
        int len = 0;
        for (String s : arr) {
            System.out.printf("%s: %d\n", s, s.length());
            len+= s.length();
        }
        System.out.println("sum = " + len);

        String str = "hello.txt";
        int i = str.indexOf(".txt");
        System.out.println("index = " + i);

        System.out.println("filename = " + str.substring(0, i));
        System.out.println("extName = " + str.substring(i));

        String sentence = "start hello java, hello spring, hello jpa";
        String key = "hello";

        int start = sentence.indexOf(key);
        int count = 0;
        while (start != -1) {
            start = sentence.indexOf(key, start + key.length());
            count++;
        }
        System.out.println("count = " + count);

        String original = " Hello Java ";
        System.out.println(original.strip());

        String input = "hello java spring jpa java";
        System.out.println(input.replace("java", "jvm"));

        String email = "hello@example.com";
        String[] split = email.split("@");
        System.out.printf("ID: %s\nDomain: %s\n", split[0], split[1]);

        String fruits = "apple,banana,mango";
        String[] split1 = fruits.split(",");
        System.out.println(String.join("\n", split1));
        System.out.println("joinedString = " + String.join("->", split1));

        String s = "Hello Java";
        System.out.println((new StringBuilder(s)).reverse().toString());


    }
}
