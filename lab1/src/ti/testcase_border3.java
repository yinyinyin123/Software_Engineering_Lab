package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase_border3 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		//×ó±ß½ç
		graph G = new graph();
		G.creat_graph();
		String words = G.queryBridgeWords("good","to" );
		assertEquals("No \"good\" in the graph!", words);
	}

}
