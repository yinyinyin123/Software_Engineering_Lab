package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase4 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException {
		//fail("Not yet implemented");
		//第二个词不存在
		graph G = new graph();
		G.creat_graph();
		String words = G.queryBridgeWords("out", "good");
		assertEquals("No \"good\" in the graph!", words);
	}

}
