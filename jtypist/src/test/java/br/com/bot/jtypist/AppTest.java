package br.com.bot.jtypist;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest

{
	@Test
	public void testInputParams() {
		String[] args = { "pom.xml", "1" };
		App.main(args);

	}

	@Test
	public void testI() {

		Character a = '~';

		System.out.print(a.hashCode());

	}

}
// <!-- teste --><project xmlns="http:>