package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase_border1 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException {
		//fail("Not yet implemented");
		//²âÊÔ×ó±ß½ç
		graph G = new graph();
		G.creat_graph();
		String words = G.queryBridgeWords("to", "explore");
		assertEquals("No bridge words from \"to\" to \"explore\"!", words);
	}

}
