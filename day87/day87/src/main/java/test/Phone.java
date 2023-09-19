package test;

public interface Phone {
	void call(String name);
	// public abstract 생략된 것
	// public : 부모의 공개범위 >= 자식의 공개범위 --> 더 넓어야함
	// abstract : 추상이기 때문에 메소드 바디를 가질 수 없음
}
