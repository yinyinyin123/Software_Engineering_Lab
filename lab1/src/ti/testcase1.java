package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class testcase1 {

	@Test
	public void testQueryBridgeWords() throws IOException {
		//fail("Not yet implemented");
		graph G = new graph();
		G.creat_graph();
		//俩个存在的词中有桥接词
		String words = G.queryBridgeWords("to", "out");
		assertEquals("the bridge words from \"to\" to \"out\" are:seek ", words);
	}

}
