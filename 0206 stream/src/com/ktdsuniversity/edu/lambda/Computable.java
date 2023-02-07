package com.ktdsuniversity.edu.lambda;

//인터페이스를 상속받지않고 인스턴스화 시키는 방법... 익명 클래스
// 객체지향에서는 좋지 못한 선택... 람다형식을 사용하겠다는 뜻.
// 이벤트 드라이빙에서는 많이 활용 ... 안드로이드와 같은

// 이것은 함수형 인터페이스다
// * 구현되지않은 메소드가 1개여야만 람다식을 사용할 수 있
@FunctionalInterface		// 안적어도 굴러는 가는데 성능 이슈 발생 가능성
public interface Computable {

	public int sum(int numberOne, int numberTwo);

}
