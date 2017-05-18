
public class MainClass {

	public static void main(String[] args) {
		
		LedRGBController interruptor = new LedRGBController();
		
		while(true) {
			interruptor.blinkRed();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			interruptor.blinkGreen();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			interruptor.blinkBlue();
			
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
			
			
			interruptor.lightBlue();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
			ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
		    int noThreads = currentGroup.activeCount();
		    Thread[] lstThreads = new Thread[noThreads];
		    currentGroup.enumerate(lstThreads);
		      
		    for (int i = 0; i < noThreads; i++) System.out.println("Thread No:" + i + " = " + lstThreads[i].getName());
		}
		
	}

}
