package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase_border4 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		//×ó±ß½ç
		graph G = new graph();
		G.creat_graph("D:/123.txt");
		String words = G.queryBridgeWords("to", "strange");
		assertEquals("the bridge words from \"to\" to \"strange\" are:explore ", words);
	}

}
