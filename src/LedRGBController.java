import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


public class LedRGBController {
	
	// pins allocated to colors
	private static Pin PINRED = RaspiPin.GPIO_00;
	private static Pin PINBLUE = RaspiPin.GPIO_02;
	private static Pin PINGREEN = RaspiPin.GPIO_03;
	
	
	private GpioController gpioController;
	
	private GpioPinDigitalOutput pinOutRed;
	
	private GpioPinDigitalOutput pinOutBlue;
	
	private GpioPinDigitalOutput pinOutGreen;
	
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
	 * Put in high pinOutRed and anyone else in low
	 * @return true
	 */
	public boolean lightRed() {
		
		pinOutRed.high();
		
		pinOutBlue.low();
		
		pinOutGreen.low();
		
		return true;
	}
	
	/**
	 * Persist red light from 
	 * @return true
	 */
	public boolean lightRedPersist() {
		
		pinOutRed.high();
		
		pinOutBlue.low();
		
		pinOutGreen.low();
		
		return true;
	}
	
	/**
	 * Put in high pinOutBlue and anyone else in low
	 * @return true
	 */
	public boolean lightBlue() {
		
		pinOutRed.low();
		
		pinOutBlue.high();
		
		pinOutGreen.low();
		
		return true;
	}

	/**
	 * Put in high pinOutGreen and anyone else in low
	 * @return true
	 */
	public boolean lightGreen() {
	
		pinOutRed.low();
	
		pinOutBlue.low();
		
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
	
}
