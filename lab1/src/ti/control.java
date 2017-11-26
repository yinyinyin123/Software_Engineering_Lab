package ti;

public class control {
     private graph g = new graph();
     public void create_graph(String file) {
    	 try {
    		 g.creat_graph(file);
    	 }catch(Exception e) {
    		 e.printStackTrace();
    	 }
     }
     void javaThread(String word1) {
     	Thread t = new Thread(new Runnable() {
     		public void run() {
     			g.calcShortPath(word1);
     		}
     	});
     	t.start();
     }
     void javaThread1() {
     	Thread t = new Thread(new Runnable() {
     		public void run() {
     			g.randomwalk();
     		}
     	});
     	t.start();
     }
     void javaThread2(String word1,String word2) {
     	Thread t = new Thread(new Runnable() {
     		public void run() {
     			g.calcShortPath(word1, word2);
     		}
     	});
     	t.start();
     }
     public void show_graph() {
    	 g.function_two();
     }
     public void func_calushortpath(String word) {
    	 g.calcShortPath(word);
     }
     public void func_randomwalk() {
//    	 g.randomwalk();
    	 javaThread1();
     }
     public String new_text(String word) {
    	 return g.solution(word);
     }
     public String Bridgewords(String word1,String word2) {
    	 return g.queryBridgeWords(word1, word2);
     }
     public void calushortpath_two(String word1,String word2) {
    	 javaThread2(word1, word2);
     }
}
