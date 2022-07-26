package polymorphism;

//public class SamsungTV {
//	public void powerOn() {
//		System.out.println("SamsungTV---전원을 켠다.");
//	}
//	public void powerOff() {
//		System.out.println("SamsungTV---전원을 끈다.");
//	}
//	public void volumeUp() {
//		System.out.println("SamsungTV---소리를 올린다.");
//	}
//	public void volumnDown() {
//		System.out.println("SamsungTV---소리를 내린다.");
//	}
//}

//다형성 연습 - 상속
public class SamsungTV implements TV {
	public void initMethod() {
		System.out.println("===객체 초기화 작업 처리..===");
	}
	public void destroyMethod() {
		System.out.println("===객체 삭제 전에 처리해야할 로직 처리..===");
	}
	public SamsungTV() {
		System.out.println("===SamsungTV 객체 생성===");
	}
	public void powerOn() {
		System.out.println("SamsungTV---전원을 켠다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV---소리를 올린다.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV---소리를 내린다.");
	}
}