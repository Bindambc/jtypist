package br.com.bot.jtypist;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest

{
	@Test
	public void testInputParams() {
		String[] args = { "c:/test.txt", "50" };
		App.main(args);

	}
	/*
	 * 
	 * */

	@Test
	public void testI() {

		Character a = '~';

		String hash = String.valueOf(a.hashCode());

		System.out.print(hash);

		try {
			Robot robot = new Robot();

			robot.delay(10000);

			// press alt
			robot.keyPress(KeyEvent.VK_ALT);
			for (int i = 0; i < hash.length(); i++) {

				switch (hash.charAt(i)) {
				case '0':
					robot.keyPress(KeyEvent.VK_NUMPAD0);
					robot.keyRelease(KeyEvent.VK_NUMPAD0);
					break;
				case '1':
					robot.keyPress(KeyEvent.VK_NUMPAD1);
					robot.keyRelease(KeyEvent.VK_NUMPAD1);
					break;
				case '2':
					robot.keyPress(KeyEvent.VK_NUMPAD2);
					robot.keyRelease(KeyEvent.VK_NUMPAD2);
					break;
				case '3':
					robot.keyPress(KeyEvent.VK_NUMPAD3);
					robot.keyRelease(KeyEvent.VK_NUMPAD3);
					break;
				case '4':
					robot.keyPress(KeyEvent.VK_NUMPAD4);
					robot.keyRelease(KeyEvent.VK_NUMPAD4);
					break;
				case '5':
					robot.keyPress(KeyEvent.VK_NUMPAD5);
					robot.keyRelease(KeyEvent.VK_NUMPAD5);
					break;
				case '6':
					robot.keyPress(KeyEvent.VK_NUMPAD6);
					robot.keyRelease(KeyEvent.VK_NUMPAD6);
					break;
				case '7':
					robot.keyPress(KeyEvent.VK_NUMPAD7);
					robot.keyRelease(KeyEvent.VK_NUMPAD7);
					break;
				case '8':
					robot.keyPress(KeyEvent.VK_NUMPAD8);
					robot.keyRelease(KeyEvent.VK_NUMPAD8);
					break;
				case '9':
					robot.keyPress(KeyEvent.VK_NUMPAD9);
					robot.keyRelease(KeyEvent.VK_NUMPAD9);
					break;

				}
				robot.delay(250);

			}
			// release alt
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.print(a.hashCode());

	}

}
// <!-- teste --><project xmlns="http:>