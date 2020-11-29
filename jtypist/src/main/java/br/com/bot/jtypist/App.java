package br.com.bot.jtypist;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println(
				"\r\n" + "#   _____              _       _   \r\n" + "#  |_   _|            (_)     | |  \r\n" + "#    | | _   _  _ __   _  ___ | |_ \r\n" + "#    | || | | || '_ \\ | |/ __|| __|\r\n" + "#    | || |_| || |_) || |\\__ \\| |_ \r\n" + "#    \\_/ \\__, || .__/ |_||___/ \\__|\r\n" + "#         __/ || |                 \r\n" + "#        |___/ |_|                 \r\n" + "");

		if (args.length == 2) {
			Path p = Paths.get(args[0]);
			int timeExec = Integer.valueOf(args[1]);
			try {

				List<String> linhasArquivo = Files.readAllLines(p);
				Robot robot = null;
				try {
					robot = new Robot();
				} catch (AWTException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// total time (estimated)

				Double totalTime = (double) ((((Files.size(p) / 8) * timeExec) / 60) / 60);

				System.out.println("\n=> Estimated time: " + totalTime + " minutes.");

				robot.delay(10000);

				for (String linha : linhasArquivo) {

					Character y;

					for (int i = 0; i < linha.length(); i++) {
						y = linha.charAt(i);

						switch (y) {

						case '\t':
							doType(robot, KeyEvent.VK_TAB);
							break;
						case '\n':
							doType(robot, KeyEvent.VK_ENTER);
							break;
						case ' ':
							doType(robot, KeyEvent.VK_SPACE);
							break;
						case '\b':
							doType(robot, KeyEvent.VK_BACK_SPACE);
							break;
						case '_':
							System.out.println("underscore");
							doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_MINUS);
							break;

						default:

							if (Character.isUnicodeIdentifierPart(y)) {
								System.out.println("unicode");

								if (Character.isUpperCase(y)) {
									robot.keyPress(KeyEvent.VK_CAPS_LOCK);
									robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
								}

								robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(y));
								robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(y));

								if (Character.isUpperCase(y)) {
									robot.keyPress(KeyEvent.VK_CAPS_LOCK);
									robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
								}

							} else {
								doSpecialType(y);
							}

						}

						robot.delay(timeExec);
					}
					doType(robot, KeyEvent.VK_ENTER);
					robot.delay(1500);
				}

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("File not found\n\n");
				buildHelpMessage();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("\r\n" + "could not read the file.\n\n");
				buildHelpMessage();
			}

		} else

		{

			System.err.println("ERROR: Wrong number of arguments");
			buildHelpMessage();
		}

	}

	// apertar alt
	// pegar os caracteres e convertelos em string
	// rodar for para cada caractere da string, apertando o numero no teclado

	private static void doSpecialType(Character ch) {
		System.out.println("special");

		String hash = String.valueOf(ch.hashCode());

		try {
			Robot robot = new Robot();

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

			}
			// release alt
			robot.keyRelease(KeyEvent.VK_ALT);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void buildHelpMessage() {
		System.out.println("\n\n");

		System.out.println("Usage:\n");
		System.out.println("java -jar jtypist {\"file name\"}  {kpm}\n\n");
		System.out.println("- file name: a file that will be read");
		System.out.println("- value: time interval between each key - milliseconds (100 is good)\n\n");
		// System.out.println("-f: a file that will be read");
		// System.out.println("-t: key per minute (100 is good)\n\n");

		System.out.println("Example:\n");

		System.out.println("java -jar jtypist \"file.txt\"  230\n\n");

	}

	private static void doType(Robot robot, int... keyCodes) {
		doType(robot, keyCodes, 0, keyCodes.length);
	}

	private static void doType(Robot robot, int[] keyCodes, int offset, int length) {
		if (length == 0) {
			return;
		}

		robot.keyPress(keyCodes[offset]);

		if (keyCodes[offset] == KeyEvent.VK_ALT || keyCodes[offset] == KeyEvent.VK_SHIFT) {
			doType(robot, keyCodes, offset + 1, length - 1);
			robot.keyRelease(keyCodes[offset]);
		} else {
			robot.keyRelease(keyCodes[offset]);
			doType(robot, keyCodes, offset + 1, length - 1);
		}

	}
}
