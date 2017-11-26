package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase_border5 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		//ср╠ъ╫Г
		graph G = new graph();
		G.creat_graph("D:/123.txt");
		String words = G.queryBridgeWords("civilizations", "good");
		assertEquals("No \"good\" in the graph!", words);
	}

}
