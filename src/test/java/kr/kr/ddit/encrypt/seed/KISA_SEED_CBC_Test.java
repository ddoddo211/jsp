package kr.kr.ddit.encrypt.seed;

import static org.junit.Assert.*;
import kr.or.ddit.encrypt.seed.KISA_SEED_CBC;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KISA_SEED_CBC_Test {


	@Test
	public void EndcryptTest() {
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		System.out.println("encrypt : " + encrypt);
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);
		System.out.println("decrypt : " + pass);

		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, decrypt);
	}

}
