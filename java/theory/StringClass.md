```java
public class Main() {
  // String.class 로 문자열 생성하는 방법 두 가지
  String v1 = "hello";
  String v2 = new String("hello");
}
```

* String 은 기본형이 아닌 참조형인데, v1이 가능하다. 
* v1 “hello” 는 힙 영역에 있는 String pool 에 저장
* v2 “hello”는  ?에 저장 todo:변수 값 저장 위치 정리



# 주요 메서드

* **문자열 정보 조회**
   `length()` : 문자열의 길이를 반환한다.
   `isEmpty()` : 문자열이 비어 있는지 확인한다. (길이가 0)
   `isBlank()` : 문자열이 비어 있는지 확인한다. (길이가 0이거나 공백(Whitespace)만 있는 경우), 자바 11 `charAt(int index)` : 지정된 인덱스에 있는 문자를 반환한다.

* **문자열 비교**
   `equals(Object anObject)` : 두 문자열이 동일한지 비교한다. `equalsIgnoreCase(String anotherString)` : 두 문자열을 대소문자 구분 없이 비교한다. `compareTo(String anotherString)` : 두 문자열을 사전 순으로 비교한다. `compareToIgnoreCase(String str)` : 두 문자열을 대소문자 구분 없이 사전적으로 비교한다. `startsWith(String prefix)` : 문자열이 특정 접두사로 시작하는지 확인한다. `endsWith(String suffix)` : 문자열이 특정 접미사로 끝나는지 확인한다.

* **문자열 검색**
   `contains(CharSequence s)` : 문자열이 특정 문자열을 포함하고 있는지 확인한다.
   `indexOf(String ch)` / `indexOf(String ch, int fromIndex)` : 문자열이 처음 등장하는 위치를 반환한다.
   `lastIndexOf(String ch)` : 문자열이 마지막으로 등장하는 위치를 반환한다.

* **문자열 조작 및 변환**
   `substring(int beginIndex)` / `substring(int beginIndex, int endIndex)` : 문자열의 부분 문자열을 반환한다.
   `concat(String str)` : 문자열의 끝에 다른 문자열을 붙인다.
   `replace(CharSequence target, CharSequence replacement)` : 특정 문자열을 새 문자열로 대체한다.
   `replaceAll(String regex, String replacement)` : 문자열에서 정규 표현식과 일치하는 부분을 새 문자열로 대체한다.
   `replaceFirst(String regex, String replacement)` : 문자열에서 정규 표현식과 일치하는 첫 번째 부분을 새 문자열로 대체한다.
   `toLowerCase()` / `toUpperCase()` : 문자열을 소문자나 대문자로 변환한다. `trim()` : 문자열 양쪽 끝의 공백을 제거한다. 단순 `Whitespace` 만 제거할 수 있다. `strip()` : `Whitespace` 와 유니코드 공백을 포함해서 제거한다. 자바 11

* **문자열 분할 및 조합**
   `split(String regex)` : 문자열을 정규 표현식을 기준으로 분할한다.
   `join(CharSequence delimiter, CharSequence... elements)` : 주어진 구분자로 여러 문자열을 결합한다.

* **기타 유틸리티**
   `valueOf(Object obj)` : 다양한 타입을 문자열로 변환한다.
   `toCharArray():` 문자열을 문자 배열로 변환한다.
   `format(String format, Object... args)` : 형식 문자열과 인자를 사용하여 새로운 문자열을 생성한다.

  #  `matches(String regex)` : 문자열이 주어진 정규 표현식과 일치하는지 확인한다.

  

# substring()

```java
String target = "hello world";
//target.substring(int beginIndex) 끝까지 긁어옴.
target.substring(6);//world
////target.substring(int beginIndex, int lastIndex + 1) 
target.substring(6, target.length());//world
```

