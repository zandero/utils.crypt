package com.zandero.utils.crypt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 *
 */
public class EncodeUtilsTest {

	@Test
	public void testEncryptDecrypt() throws Exception {

		String some = com.zandero.utils.crypt.EncodeUtils.encrypt("bla bla bla", "secret");
		assertNotEquals("bla bla bla", some);
		System.out.println(some);
		assertEquals("bla bla bla", com.zandero.utils.crypt.EncodeUtils.decrypt(some, "secret"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidKey() {

		String some = com.zandero.utils.crypt.EncodeUtils.encrypt("bla bla bla", "secret");

		try {
			com.zandero.utils.crypt.EncodeUtils.decrypt(some, "otherSecret");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Invalid password given!", e.getMessage());
			throw e;
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidKey_2() {

		try {
			com.zandero.utils.crypt.EncodeUtils.encrypt("bla bla bla", "");
		}
		catch (IllegalArgumentException e) {
			assertEquals("Password cannot be set empty", e.getMessage());
			throw e;
		}
	}

}