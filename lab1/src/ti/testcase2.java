package ti;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class testcase2 {

	@Test
	public void testQueryBridgeWords() throws IOException{
		//fail("Not yet implemented");
		graph G = new graph();
		G.creat_graph();
		//�������ڵĴ���û���ŽӴ�
        String words =  G.queryBridgeWords("to", "seek");
		assertEquals("No bridge words from \"to\" to \"seek\"!", words);
	}
}
