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
			try {

				List<String> linhasArquivo = Files.readAllLines(p);

				for (String linha : linhasArquivo) {
					System.out.println(linha);

					try {
						Robot robot = new Robot();

						robot.delay(10000);

						/*
						 * for (byte b : linha.getBytes()) { int code = b; // keycode only handles [A-Z] (which is ASCII
						 * decimal [65-90]) if (code > 96 && code < 123) code = code - 32; robot.delay(500);
						 * System.err.println(code); robot.keyPress(code); robot.keyRelease(code); }
						 */
						
						int x;
						Character y;

						for (int i = 0; i < linha.length(); i++) {
							y = linha.charAt(i);
							System.out.println(y);
							// x = Character.getNumericValue(y);
							if (Character.isUnicodeIdentifierPart(y)) {
								robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(y));
								robot.keyRelease(KeyEvent.getExtendedKeyCodeForChar(y));
								robot.delay(250);
							} else {
								switch (y) {
								case '-':
									doType(robot, KeyEvent.VK_MINUS);
									break;
								case '=':
									doType(robot, KeyEvent.VK_EQUALS);
									break;
								case '~':
									doType(robot, KeyEvent.VK_BACK_QUOTE);
									break;
								case '!':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_1);
									break;
								case '@':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_AT);
									break;
								case '#':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_NUMBER_SIGN);
									break;
								case '$':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_DOLLAR);
									break;
								case '%':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_5);
									break;
								case '^':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_CIRCUMFLEX);
									break;
								case '&':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_AMPERSAND);
									break;
								case '*':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_ASTERISK);
									break;
								case '(':
									doType(robot, KeyEvent.VK_LEFT_PARENTHESIS);
									break;
								case ')':
									doType(robot, KeyEvent.VK_RIGHT_PARENTHESIS);
									break;
								case '_':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_UNDERSCORE);
									break;
								case '+':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_PLUS);
									break;
								case '\t':
									doType(robot, KeyEvent.VK_TAB);
									break;
								case '\n':
									doType(robot, KeyEvent.VK_ENTER);
									break;
								case '[':
									doType(robot, KeyEvent.VK_OPEN_BRACKET);
									break;
								case ']':
									doType(robot, KeyEvent.VK_CLOSE_BRACKET);
									break;
								case '\\':
									doType(robot, KeyEvent.VK_BACK_SLASH);
									break;
								case '{':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_OPEN_BRACKET);
									break;
								case '}':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_CLOSE_BRACKET);
									break;
								case '|':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_BACK_SLASH);
									break;
								case ';':
									doType(robot, KeyEvent.VK_SEMICOLON);
									break;
								case ':':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_SEMICOLON);
									break;
								case '\'':
									doType(robot, KeyEvent.VK_QUOTE);
									break;
								case '"':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_QUOTE);
									break;
								case ',':
									doType(robot, KeyEvent.VK_COMMA);
									break;
								case '<':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_COMMA);
									break;
								case '.':
									doType(robot, KeyEvent.VK_PERIOD);
									break;
								case '>':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_PERIOD);
									break;
								case '/':
									doType(robot, KeyEvent.VK_SLASH);
									break;
								case '?':
									doType(robot, KeyEvent.VK_SHIFT, KeyEvent.VK_SLASH);
									break;
								case ' ':
									doType(robot, KeyEvent.VK_SPACE);
									break;
								case '\b':
									doType(robot, KeyEvent.VK_BACK_SPACE);
									break;
								default:
									robot.delay(250);
								}
								robot.delay(250);
							}
						}

					} catch (AWTException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

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

	private static void buildHelpMessage() {
		System.out.println("\n\n");

		System.out.println("Usage:\n");
		System.out.println("java -jar jtypist {\"file name\"}  {kpm}\n\n");
		System.out.println("- file name: a file that will be read");
		System.out.println("- kpm: integer number - key per minute (100 is good)\n\n");
		// System.out.println("-f: a file that will be read");
		// System.out.println("-t: key per minute (100 is good)\n\n");

		System.out.println("Example:\n");

		System.out.println("java -jar jtypist \"file.txt\"  100\n\n");

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
