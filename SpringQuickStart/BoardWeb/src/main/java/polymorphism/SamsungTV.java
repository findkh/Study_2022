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
//public class SamsungTV implements TV {
//	public void initMethod() {
//		System.out.println("===객체 초기화 작업 처리..===");
//	}
//	public void destroyMethod() {
//		System.out.println("===객체 삭제 전에 처리해야할 로직 처리..===");
//	}
//	public SamsungTV() {
//		System.out.println("===SamsungTV 객체 생성===");
//	}
//	public void powerOn() {
//		System.out.println("SamsungTV---전원을 켠다.");
//	}
//	public void powerOff() {
//		System.out.println("SamsungTV---전원을 끈다.");
//	}
//	public void volumeUp() {
//		System.out.println("SamsungTV---소리를 올린다.");
//	}
//	public void volumeDown() {
//		System.out.println("SamsungTV---소리를 내린다.");
//	}
//}

//의존관계
//public class SamsungTV implements TV { 
//	
//	private SonySpeaker speaker;
//	
//	public SamsungTV() {
//		System.out.println("===SamsungTV 객체 생성===");
//	}
//	public void powerOn() {
//		System.out.println("SamsungTV---전원을 켠다.");
//	}
//	public void powerOff() {
//		System.out.println("SamsungTV---전원을 끈다.");
//	}
//	public void volumeUp() {
//		speaker = new SonySpeaker();
//		speaker.volumnUp();
//	}
//	public void volumeDown() {
//		speaker = new SonySpeaker();
//		speaker.volumeDown();
//	}
//}

//public class SamsungTV implements TV { 
//	
//	private SonySpeaker speaker;
//	private int price;
//	
//	public SamsungTV() {
//		System.out.println("===SamsungTV(1) 객체 생성===");
//	}
//	public SamsungTV(SonySpeaker speaker) {
//		System.out.println("=== SamsungTV(2) 객체 생성===");
//		this.speaker = speaker;
//	}
//	public SamsungTV(SonySpeaker speaker, int price) {
//		System.out.println("=== SamsungTV(3) 객체 생성===");
//		this.speaker = speaker;
//		this.price = price;
//	}
//	public void powerOn() {
//		System.out.println("SamsungTV---전원을 켠다. (가격 : "+ price + ")");
//	}
//	public void powerOff() {
//		System.out.println("SamsungTV---전원을 끈다.");
//	}
//	public void volumeUp() {
//		speaker.volumnUp();
//	}
//	public void volumeDown() {
//		speaker.volumeDown();
//	}
//}

public class SamsungTV implements TV { 
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("===SamsungTV(1) 객체 생성===");
	}
	public SamsungTV(Speaker speaker) {
		System.out.println("=== SamsungTV(2) 객체 생성===");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) {
		System.out.println("=== SamsungTV(3) 객체 생성===");
		this.speaker = speaker;
		this.price = price;
	}
	public void powerOn() {
		System.out.println("SamsungTV---전원을 켠다. (가격 : "+ price + ")");
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원을 끈다.");
	}
	public void volumeUp() {
		speaker.volumnUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
}