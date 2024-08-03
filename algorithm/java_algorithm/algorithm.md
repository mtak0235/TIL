<h2>🤔Which algorithm to use?</h2>

💨Depending on <b>time complexity</b>!

> <h4>Time complexity?</h4>
>
> * operation counts to solve the problem
> * you can operate 1억 per seconds
>
> <h5>Notation</h5>
>
> * Ω(n) best practice
>
> * Θ(n) average practice 
>
> * Ο(n) worst practice
>
>   💨For Coding Test
>
> <h5>Performance</h5>
>
> <span style="color:#EF5A6F">FAST</span> n > nlogn > n^2 > 2^n > n! <span style="color:#478CCF">SLOW</span>

<h2>Steps to solve problems</h2>

1. Check a size of data and Choose algorithm
2. Solve in on hand

> <h4>🤷‍♀️what if you don't know time complextity for the algorithm?</h4>
>
> derive it following this step
>
> 1. emit constant
> 2. prioritize bad performance

# Type conversion of JAVA

1. String 💨 Primitive : x X.parseX()

```java
int i = Integer.parseInt("123");
long l = Long.parseLong("123");
float f = Float.parseFloat("123.45");
double d = Double.parseDouble("123.45");
boolean b = Boolean.parseBoolean("true");
```

2. Primitive 💨 String : String String.valueOf(x) or String X.toString(x)

```java
String s1 = String.valueOf(123);
String s2 = String.valueOf(123.45);
String s3 = String.valueOf(true);
String s4 = Integer.toString(123);
String s5 = Double.toString(123.45);
```

3. String 💨 Wrapper : X X.valueOf(String)

```java
Integer intObj = Integer.valueOf("123");
Long longObj = Long.valueOf("123");
Float floatObj = Float.valueOf("123.45");
Double doubleObj = Double.valueOf("123.45");
Boolean boolObj = Boolean.valueOf("true");
```

4. Primitive 💨 Wrapper : X = x

```java
Integer intObj = 123;
Long longObj = 123L;
Float floatObj = 123.45f;
Double doubleObj = 123.45;
Boolean boolObj = true;
```

5. Wrapper 💨 Primitive : x ObjX.xValue(x)

```java
int i = intObj.intValue();
long l = longObj.longValue();
float f = floatObj.floatValue();
double d = doubleObj.doubleValue();
boolean b = boolObj.booleanValue();
```

6. char btw integer

```java
char c = '5';
int i = Character.getNumericValue(c);
char c2 = (char)(i + '0');
```

7. String 💨char[]

```java
String str = "12345";
char[] chars = str.toCharArray();
```

# Standard input of JAVA

1. Scanner

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();  // 한 줄 읽기
        int num = sc.nextInt();      // 정수 읽기
        double d = sc.nextDouble();  // 실수 읽기
        
        sc.close();  // 사용 후 닫기
    }
}
```

simple usesage but slow on handling big data

2. BufferedReader

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line = br.readLine();  // 한 줄 읽기
        int num = Integer.parseInt(br.readLine());  // 정수로 변환하여 읽기
        
        br.close();  // 사용 후 닫기
    }
}
```

Faster than Scanner, but it only takes input as 'String', so type conversion is needed sometimes.

3. StringTokenizer

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer stSemiColumn = new StringTokenizer(br.readLine(),';');
        
        int a = Integer.parseInt(st.nextToken());  // 첫 번째 토큰을 정수로
        int b = Integer.parseInt(st.nextToken());  // 두 번째 토큰을 정수로
        
        br.close();
    }
}
```

Used for discretizing a string with delimiter in default, whitespace.

Neglecting empty token, you'd better to use StringObj.split() to keep it.

> StringTokenizer VS split()
>
> ```java
> import java.util.StringTokenizer;
> 
> public class Main {
>     public static void main(String[] args) {
>         String input = ",1,,2,3,,4";
>         StringTokenizer st = new StringTokenizer(input, ",");
>         
>         while (st.hasMoreTokens()) {
>             System.out.println(st.nextToken());
>         }
>     }
> }
> //--results--//
> 1
> 2
> 3
> 4
> ```
>
> ```java
> public class Main {
>     public static void main(String[] args) {
>         String input = ",1,,2,3,,4";
>         String[] tokens = input.split(",", -1);  // -1은 빈 문자열도 포함하라는 의미
>         
>         for (String token : tokens) {
>             System.out.println("'" + token + "'");
>         }
>     }
> }
> //--results--//
> ''
> '1'
> ''
> '2'
> '3'
> ''
> '4'
> ```

# Range Sum

Calculate the sum of elements in a given range of an array.

 ∑A[ i : `from` ~ `to`] 

* Construction: Each element in the prefix sum array represents the sum of all elements up to that index in the original array.

> prefixSum[i] = prefixSum[i-1] + originalArray[i]

* Usage: To find the sum of elements from index a to b, you can use: 

>  rangeSum = prefixSum[b] - prefixSum[a-1]

* Time complexity:

  - Construction: O(n)

  - Query: O(1)

* Space complexity: O(n) additional space

🤷‍♀️What if you should calculate the sum within a rectangular subarray defined by point (r1, c1) and point (r2, c2)?

* Construction

> prefixSum\[r][c] = originalArray\[r][c] + prefixSum\[r][c - 1] + prefixSum\[r - 1][c] - prefixSum\[r - 1][c - 1]

* Usage

> sum = prefixSum\[r2][c2] - prefixSum\[r1-1][c2] - prefixSum\[r2][c1-1] + prefixSum\[r1-1][c1-1]

# Moving Two Pionters

If you should count all the possible cases but it's too much, set two pointers.

* Case A: Count the number of consecutive elements whose sum equals the target amount

  * startIndex, endIndex = 0,  index of the first element
  * sum = then first element
  * count = 1 (on target amount)
  * repeat til endIndex < real endIndex

  | sum of consecutive elements | actions                                                      |
  | --------------------------- | ------------------------------------------------------------ |
  | higher than target amount   | Give up backwards!<br />`sum -= A[startIndex] ; startIndex++` |
  | target amount               | Mission accomplished. Forward march!<br />`count++`<br />`endIndex++ ; sum += A[endIndex]` |
  | lower than target amount    | Forward march!<br />`endIndex++ ; sum += A[endIndex]`        |

* Case B : Count the number of adequate two elements whose sum equals target amount

  * leftIndex = index of first element , right = index of last index
  * sum  = first element + last element
  * count = 0
  * array A should be sorted
  * repeat til leftIndex < rightIndex

  | sum of two elements       | actions                                                      |
  | ------------------------- | ------------------------------------------------------------ |
  | higher than target amount | Right flank! Abandon your belongings and retreat!!<br />`rightIndex--` |
  | target amount             | Mission accomplished. Fall Back!<br />`count++`<br />`leftIndex++ ; rightIndex--` |
  | lower than target amount  | Left flank! Backup! <br />`leftIndex++`                      |
