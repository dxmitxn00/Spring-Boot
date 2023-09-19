package test;

public class PhoneA implements Phone {

	@Override
	public void call(String name) { // 오버로딩
		System.out.println("PhoneB : "+ name +"이(가) 전화거는중,,,");
	}

}
