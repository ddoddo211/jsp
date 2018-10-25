package kr.kr.ddit.encrypt.sha;

import static org.junit.Assert.*;
import kr.or.ddit.encrypt.sha.KISA_SHA256;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class KISA_SHA256_Test {



	/**
	 * 
	 * Method : encryptTest
	 * 작성자 : bms
	 * 변경이력 :
	 * Method 설명 : sha256 encrypt 테스트
	 */
	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "conypass";
		String pass1 = "brownpast";

		/***When***/
		String encrypt = KISA_SHA256.encrypt(pass);
		String encrypt1 = KISA_SHA256.encrypt(pass1);
		System.out.println("encrypt : " + encrypt);
		System.out.println("encrypt : " + encrypt1);

		/***Then***/
		assertEquals("65c8b7874e6e1d2bc0978232e2274f7764ac156926db381f74f7b46fc5dc", encrypt);
	}

}
