package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testwhite {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandomwalk() {
		//fail("Not yet implemented");
		graph G = new graph();
		try {
			G.creat_graph("D:/1.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
		String walk = G.randomwalk();
		if(walk.equals("good game") || walk.equals("game")) {
			assertEquals("ok", "ok");
		}
		else {
			assertEquals("ok", "error");
		}
	}

}
