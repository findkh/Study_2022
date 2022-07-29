package polymorphism;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//public class LgTV {
//	public void turnOn() {
//		System.out.println("LgTV---전원을 켠다.");
//	}
//	public void turnOff() {
//		System.out.println("LgTV---전원을 끈다.");
//	}
//	public void soundUp() {
//		System.out.println("LgTV---소리를 올린다.");
//	}
//	public void soundDown() {
//		System.out.println("LgTV---소리를 내린다.");
//	}
//}

//다형성 연습 - 상속
//public class LgTV implements TV{
//	@Override
//	public void powerOn() {
//		System.out.println("LgTV---전원을 켠다.");		
//	}
//	@Override
//	public void powerOff() {
//		System.out.println("LgTV---전원을 끈다.");		
//	}
//	@Override
//	public void volumeUp() {
//		System.out.println("LgTV---소리를 올린다.");		
//	}
//	@Override
//	public void volumeDown() {
//		System.out.println("LgTV---소리를 내린다.");		
//	}
//}

//의존성 주입 설정
@Component("tv")
public class LgTV implements TV{
	
	@Autowired
	private Speaker speaker;
	
//	@Qualifier("sony")
//	private Speaker speaker;
	
	@Override
	public void powerOn() {
		System.out.println("LgTV---전원을 켠다.");		
	}
	@Override
	public void powerOff() {
		System.out.println("LgTV---전원을 끈다.");		
	}
	@Override
	public void volumeUp() {
		speaker.volumnUp();	
	}
	@Override
	public void volumeDown() {
		speaker.volumeDown();
	}
}