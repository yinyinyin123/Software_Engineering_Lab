package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Test;

public class testcase3 {

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		graph G = new graph();
		G.creat_graph();
		//第一个单词不存在
		String words = G.queryBridgeWords("good", "out");
		assertEquals("No \"good\" in the graph!", words);		
	}

}
