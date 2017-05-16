public class MainClass {

	public static void main(String[] args) {
		
		LedRGBController interruptor = new LedRGBController();
		
		interruptor.lightBlue();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		interruptor.lightRed();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		interruptor.lightGreen();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		interruptor.turnOffAll();
		
	}

}
