package string.builder;

import string.method.StringChangeMain;

public class StringBuilderMain1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('A');
        stringBuilder.append('B');
        stringBuilder.append('C');
        stringBuilder.append('D');
        stringBuilder.append('E');
        stringBuilder.insert(4, "java");
        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.delete(4, 8);
        System.out.println("stringBuilder = " + stringBuilder);

        stringBuilder.reverse();
        System.out.println("stringBuilder = " + stringBuilder);

        String string = stringBuilder.toString();
        System.out.println("string = " + string);

        StringBuilder sb = new StringBuilder();
        String string1 = sb.append('A').append('B').append('C').append('D').append('E').insert(4, "java").delete(4, 8).reverse().toString();
        System.out.println("string1 = " + string1);

    }
}
