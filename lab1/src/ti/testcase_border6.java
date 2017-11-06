package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase_border6 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		//ср╠ъ╫Г
		graph G = new graph();
		G.creat_graph();
		String words = G.queryBridgeWords("and", "civilizations");
		assertEquals("the bridge words from \"and\" to \"civilizations\" are:new ", words);
	}

}
