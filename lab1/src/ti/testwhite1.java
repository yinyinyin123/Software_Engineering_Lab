package ti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class testwhite1 {
	@Test
	public void testRandomwalk() {
		//fail("Not yet implemented");
		graph G = new graph();
		try {
			G.creat_graph("D:/2.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
		String walk = G.randomwalk();
		if(walk.equals("hello world hello world") || walk.equals("world hello world hello")) {
			assertEquals("ok","ok");
		}
		else {
			assertEquals("error", "ok");
		}
	}

}
