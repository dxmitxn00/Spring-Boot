package test;

class A {
	public A() {
		System.out.println("기본 생성자 호출됨");
	}
}

public class Test01 {
	
	public static void useA() {
		A apple = new A();
		// 개발자가 직접 new
		// 결합이 강한 상태
	}
	public static void useA(A a) { // 오버로딩 : 메서드 시그니처가 달라서 가능
		A apple = a;
		// 외부에서 객체를 받아옴 == 객체를 주입받음
		// 결합이 약함
	}
	
	public static void main(String[] args) {
		
	}
}
