package ti;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

public class testwhite2 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandomwalk() {
		//fail("Not yet implemented");
		graph G = new graph();
		try {
			G.creat_graph("D:/3.txt");
		}catch(Exception e){
			e.printStackTrace();
		}
		String walk = G.randomwalk();
		if(walk.equals("a big ") || walk.equals("big dog ") || walk.equals("dog is ") || walk.equals("is a "))  {
			assertEquals("ok","ok");
		}
		else {
			assertEquals("error", "ok");
		}
        
	}

}
