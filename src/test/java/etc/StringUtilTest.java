package etc;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringUtilTest {


	@Test
	public void test() {
		/***Given***/
		String sontentDisposition = "form-data; name=\"profile\"; filename=\"brown.png\"";

		/***When***/
		//logic
		String fileName = "";
		
		int indexFilename = sontentDisposition.indexOf("filename");
		int indexEnd = sontentDisposition.lastIndexOf("\"");
		fileName = sontentDisposition.substring(indexFilename+10, indexEnd);
		System.out.println(indexFilename + "/" + indexEnd);

		/***Then***/
		assertEquals("brown.png",fileName);
	}

}
