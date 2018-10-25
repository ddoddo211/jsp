package locales;

import static org.junit.Assert.*;

import java.util.TimeZone;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TimezoneTest {

	
	@Test
	public void timezoneTest() {
		/***Given***/

		/***When***/
		String[] timezones = TimeZone.getAvailableIDs();
		for(String str : timezones){
			System.out.println(str);
		}

		/***Then***/

	}

}
