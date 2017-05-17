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
	//	
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
	 * Put in high pinOutRed and any other in low
	 * @return true
	 */
	public boolean lightRed() {
		
		turnOffAll();
		
		pinOutRed.high();
		
		return true;
	}
	
	/**
	 * Blink pinOutRed and any other in low
	 * @param duration milisenconds to be blinking
	 * @return true
	 */
	public boolean blinkRed(int duration) {
		
		turnOffAll();
		
		pinOutRed.blink(250, duration);
		
		return true;
	}
	
	
	/**
	 * Persist RED light for duration miliseconds
	 * @param duration milisenconds to stay in high
	 * @return true
	 */
	public boolean lightRedPersist(int duration) {
		
		turnOffAll();
		
		pinOutRed.high();
		
		try {
			Thread.sleep(duration);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	
	////// GREEN

	/**
	 * Put in high pinOutGreen and any other in low
	 * @return true
	 */
	public boolean lightGreen() {
	
		turnOffAll();
		
		pinOutGreen.high();
	
		return true;
	}
	
	/**
	 * Blink pinOutGreen and any other in low
	 * @param duration milisenconds to be blinking
	 * @return true
	 */
	public boolean blinkGreen(int duration) {
		
		turnOffAll();
		
		pinOutGreen.blink(250, duration);
		
		
		return true;
	}
	
	/**
	 * Persist GREEN light for duration miliseconds
	 * @param duration milisenconds to stay in high
	 * @return true
	 */
	public boolean lightGreenPersist(int duration) {
		
		turnOffAll();
		
		pinOutGreen.high();
		
		try {
			Thread.sleep(duration);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
	
	//////BLUE
	
	/**
	 * Put in high pinOutBlue and any other in low
	 * @return true
	 */
	public boolean lightBlue() {
		
		turnOffAll();
		
		pinOutBlue.high();
		
		return true;
	}
	
	/**
	 * Blink pinOutBlue and any other in low
	 * @param duration milisenconds to be blinking
	 * @return true
	 */
	public boolean blinkBlue(int duration) {
		
		turnOffAll();
		
		pinOutBlue.blink(250, duration);
		
		return true;
	}
	
	/**
	 * Persist BLUE light for duration miliseconds
	 * @param duration milisenconds to stay in high
	 * @return true
	 */
	public boolean lightBluePersist(int duration) {
		
		turnOffAll();
		
		pinOutBlue.high();
		
		try {
			Thread.sleep(duration);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
	
}
