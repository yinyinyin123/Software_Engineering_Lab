package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class testcase1 {

	@Test
	public void testQueryBridgeWords() throws IOException {
		//fail("Not yet implemented");
		graph G = new graph();
		G.creat_graph("D:/123.txt");
		//�������ڵĴ������ŽӴ�
		String words = G.queryBridgeWords("to", "out");
		assertEquals("the bridge words from \"to\" to \"out\" are:seek ", words);
	}

}
