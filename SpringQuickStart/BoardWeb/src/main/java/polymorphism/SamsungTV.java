package polymorphism;

//public class SamsungTV {
//	public void powerOn() {
//		System.out.println("SamsungTV---������ �Ҵ�.");
//	}
//	public void powerOff() {
//		System.out.println("SamsungTV---������ ����.");
//	}
//	public void volumeUp() {
//		System.out.println("SamsungTV---�Ҹ��� �ø���.");
//	}
//	public void volumnDown() {
//		System.out.println("SamsungTV---�Ҹ��� ������.");
//	}
//}

//������ ���� - ���
public class SamsungTV implements TV {
	public void initMethod() {
		System.out.println("===��ü �ʱ�ȭ �۾� ó��..===");
	}
	public void destroyMethod() {
		System.out.println("===��ü ���� ���� ó���ؾ��� ���� ó��..===");
	}
	public SamsungTV() {
		System.out.println("===SamsungTV ��ü ����===");
	}
	public void powerOn() {
		System.out.println("SamsungTV---������ �Ҵ�.");
	}
	public void powerOff() {
		System.out.println("SamsungTV---������ ����.");
	}
	public void volumeUp() {
		System.out.println("SamsungTV---�Ҹ��� �ø���.");
	}
	public void volumeDown() {
		System.out.println("SamsungTV---�Ҹ��� ������.");
	}
}