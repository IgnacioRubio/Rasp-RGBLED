import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


public class LedRGBController {
	
	// pins allocated to colors
	private static Pin PINRED = RaspiPin.GPIO_00;
	private static Pin PINGREEN = RaspiPin.GPIO_02;
	private static Pin PINBLUE = RaspiPin.GPIO_03;
	
	
	private GpioController gpioController;
	
	private GpioPinDigitalOutput pinOutRed;
	
	private GpioPinDigitalOutput pinOutGreen;
	
	private GpioPinDigitalOutput pinOutBlue;
	
	// Constructor
	public LedRGBController() {
		
		this.gpioController = GpioFactory.getInstance();
		
		this.pinOutRed = gpioController.provisionDigitalOutputPin(PINRED);
				
		this.pinOutBlue = gpioController.provisionDigitalOutputPin(PINBLUE);
		
		this.pinOutGreen = gpioController.provisionDigitalOutputPin(PINGREEN);
	}
	
	//public LedRGBController(int red, int green, int blue) {
	//	this.gpioController = GpioFactory.getInstance();
	//}
	
	/**
	 * Put all lights in high
	 * @return true
	 */
	public boolean turnOnAll() {
		
		pinOutRed.high();
		
		pinOutBlue.high();
		
		pinOutGreen.high();
		
		return true;
	}
	
	/**
	 * Put all lights in low
	 * @return true
	 */
	public boolean turnOffAll() {
		
		pinOutRed.low();
		
		pinOutBlue.low();
		
		pinOutGreen.low();
		
		return true;
	}
	
	////// RED
	
	/**
	 * Put in high pinOutRed and anyone else in low
	 * @return true
	 */
	public boolean lightRed() {
		
		turnOffAll();
		
		pinOutRed.high();
		
		return true;
	}
	
	
	/**
	 * Persist RED light for m miliseconds
	 * @param m milisenconds to stay in high
	 * @return true
	 */
	public boolean lightRedPersist(int m) {
		
		turnOffAll();
		
		pinOutRed.high();
		
		try {
			Thread.sleep(m);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	//////GREEN

	/**
	 * Put in high pinOutGreen and anyone else in low
	 * @return true
	 */
	public boolean lightGreen() {
	
		turnOffAll();
		
		pinOutGreen.high();
	
		return true;
	}
	
	/**
	 * Persist GREEN light for m miliseconds
	 * @param m milisenconds to stay in high
	 * @return true
	 */
	public boolean lightGreenPersist(int m) {
		
		turnOffAll();
		
		pinOutGreen.high();
		
		try {
			Thread.sleep(m);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	//////BLUE
	
	/**
	 * Put in high pinOutBlue and anyone else in low
	 * @return true
	 */
	public boolean lightBlue() {
		
		turnOffAll();
		
		pinOutBlue.high();
		
		return true;
	}
	
	/**
	 * Persist BLUE light for m miliseconds
	 * @param m milisenconds to stay in high
	 * @return true
	 */
	public boolean lightBluePersist(int m) {
		
		turnOffAll();
		
		pinOutBlue.high();
		
		try {
			Thread.sleep(m);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
