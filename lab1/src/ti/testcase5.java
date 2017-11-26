package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase5 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		graph G = new graph();
		G.creat_graph("D:/123.txt");
		//两个词都不存在
		String words = G.queryBridgeWords("good", "wealth");
		assertEquals("No \"good\" and \"wealth\" in the graph!", words);
	}

}
