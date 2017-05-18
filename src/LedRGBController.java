

import java.util.concurrent.Future;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.RaspiPin;


public class LedRGBController {
	
	// pins allocated to colors
	private static final Pin PINRED = RaspiPin.GPIO_00;
	private static final Pin PINGREEN = RaspiPin.GPIO_02;
	private static final Pin PINBLUE = RaspiPin.GPIO_03;
	
	
	private static final long BLINKDELAY = 250;
	
	
	private GpioController gpioController;
	
	private GpioPinDigitalOutput pinOutRed;
	
	private GpioPinDigitalOutput pinOutGreen;
	
	private GpioPinDigitalOutput pinOutBlue;
	
	private Future<?> blinkRed;
	private Future<?> blinkGreen;
	private Future<?> blinkBlue;
	
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
		
		pinOutGreen.high();
		
		pinOutBlue.high();
		
		return true;
	}
	
	/**
	 * Put all lights in low
	 * @return true
	 */
	public boolean turnOffAll() {
		
		pinOutRed.low();
		
		pinOutGreen.low();
		
		pinOutBlue.low();
		
		return true;
	}
	
	/**
	 * Put all lights which are blinking not to blink
	 * @return true
	 */
	public boolean turnOffAllBlinking() {
		
		stopBlinkRed();
		
		stopBlinkGreen();
		
		stopBlinkBlue();
		
		return true;
	}
	
	////// RED
	
	/**
	 * Put in high RED and any other in low
	 * @return true
	 */
	public boolean lightRed() {
		
		turnOffAll();
		turnOffAllBlinking();
		
		pinOutRed.high();
		
		return true;
	}
	
	/**
	 * Blink only RED pin (set in low any other)
	 * @return true
	 * @see stopBlinkRed
	 */
	public boolean blinkRed() {
		
		turnOffAll();
		turnOffAllBlinking();
		
		blinkRed = pinOutRed.blink(BLINKDELAY);
		return true;		
		
	}
	
	/**
	 * Blink RED and any other in low
	 * @return true
	 */
	public boolean stopBlinkRed() {
		
		if(blinkRed == null) {
			return false;
		}
		
		turnOffAll();
		blinkRed.cancel(true);
		
		return true;		
	}
	
	
	/**
	 * Persist RED light for duration miliseconds
	 * @param duration milisenconds to stay in high
	 * @return true
	 */
	public boolean lightRedPersist(int duration) {
		
		turnOffAll();
		turnOffAllBlinking();
		
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
	 * Put in high GREEN pin and any other in low
	 * @return true
	 */
	public boolean lightGreen() {
	
		turnOffAll();
		turnOffAllBlinking();
		
		pinOutGreen.high();
	
		return true;
	}
	
	
	/**
	 * Blink only GREEN pin (set in low any other)
	 * @return true
	 * @see stopBlinkGreen
	 */
	public boolean blinkGreen() {
		
		turnOffAll();
		turnOffAllBlinking();
		
		blinkGreen = pinOutGreen.blink(BLINKDELAY);
		return true;		
		
	}
	
	/**
	 * Blink pinOutRed and any other in low
	 * @return true
	 */
	public boolean stopBlinkGreen() {
		
		if(blinkGreen == null) {
			return false;
		}
		
		turnOffAll();
		blinkGreen.cancel(true);
		
		return true;		
	}
	
	/**
	 * Persist GREEN light for duration miliseconds
	 * @param duration milisenconds to stay in high
	 * @return true
	 */
	public boolean lightGreenPersist(int duration) {
		
		turnOffAll();
		turnOffAllBlinking();
		
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
	 * Put in high BLUE pin and any other in low
	 * @return true
	 */
	public boolean lightBlue() {
		
		turnOffAll();
		turnOffAllBlinking();
		
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
		turnOffAllBlinking();
		
		pinOutBlue.blink(BLINKDELAY, duration);
		
		return true;
	}
	
	/**
	 * Blink only BLUE pin (set in low any other)
	 * @return true
	 * @see stopBlinkBlue
	 */
	public boolean blinkBlue() {
		
		turnOffAll();
		turnOffAllBlinking();
		
		blinkBlue = pinOutBlue.blink(BLINKDELAY);
		return true;		
		
	}
	
	/**
	 * Blink BLUE and any other in low
	 * @return true
	 */
	public boolean stopBlinkBlue() {
		
		if(blinkBlue == null) {
			return false;
		}
		
		turnOffAll();
		blinkBlue.cancel(true);
		
		return true;		
	}
	
	/**
	 * Persist BLUE light for duration miliseconds
	 * @param duration milisenconds to stay in high
	 * @return true
	 */
	public boolean lightBluePersist(int duration) {
		
		turnOffAll();
		turnOffAllBlinking();
		
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
