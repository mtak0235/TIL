package collection.set;

import collection.set.member.Member;

public class JavaHashCodeMain {
	public static void main(String[] args) {
		//object의 기본 hashCode 는 객체의 참조값을 기반으로 생성
		Object o = new Object();
		Object o2 = new Object();
		System.out.println("o.hashCode() = " + o.hashCode());
		System.out.println("o2.hashCode() = " + o2.hashCode());
		System.out.println(Integer.toHexString(o.hashCode()));
		System.out.println("o = " + o);

		//각 클래스마다 hasgCode를 이미 오버라이딩 해 두었다.
		Integer i = 10;
		String strA = "A";
		String strB = "B";
		System.out.println("i.hashCode() = " + i.hashCode());
		System.out.println("strA.hashCode() = " + strA.hashCode());
		System.out.println("strB.hashCode() = " + strB.hashCode());

		//hashCode < 0
		System.out.println("Integer.valueOf(-1).hashCode() = " + Integer.valueOf(-1).hashCode());

		//instance 는 달라도 equals는 갑다
		Member m1 = new Member("idA");
		Member m2 = new Member("idA");
		System.out.println("(m1==m2) = " + (m1 == m2));
		System.out.println("(m1.equals(m2)) = " + (m1.equals(m2)));
		System.out.println("m1.hashCode() = " + m1.hashCode());
		System.out.println("m2.hashCode() = " + m2.hashCode());

	}
}
