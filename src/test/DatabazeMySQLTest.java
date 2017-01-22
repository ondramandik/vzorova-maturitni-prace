package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import databaze.Databaze;
import databaze.DatabazeInterface;
import entity.Kotec;
import entity.Majitel;

public class DatabazeMySQLTest {

	@Test
	public void testKotce() throws SQLException, IOException {
		
		DatabazeInterface db = Databaze.getInstance();
		List<Kotec> kotce = db.getKotecVsechny();
		assertEquals("1",kotce.get(0).getCislo());
	
		Databaze.odpojit();
		
	}
	
	@Test
	public void testMajitele() throws SQLException, IOException {
		
		Majitel m = new Majitel();
		m.setJmeno("Karel");
		m.setPrijmeni("Novak");
		m.setTelefon("123123123");
		System.out.println(m.getId());

		
		DatabazeInterface db = Databaze.getInstance();
		db.saveMajitel(m);
		
		assertNotEquals(0, m.getId());
		assertNotEquals(-1, m.getId());
		
		boolean findInAll = false;
		for(Majitel m2 : db.getMajitelVsechny()) {
			if(m2.getId()==m.getId()) {
				findInAll = true;
				break;
			}
		}
		assertTrue(findInAll);
	}
	


}
