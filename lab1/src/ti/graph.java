package ti;

import java.io.IOException;
import javax.swing.*;
import java.util.*;

public class graph {
    private  ArrayList<node> Node;
    private  ArrayList<edge> Edge;
    private  my_frame frame = new my_frame();
    public graph() {
    	Node = new ArrayList<node>();
    	Edge = new ArrayList<edge>();
    }
    public ArrayList<node> get_node(){
    	return Node;
    }
    public ArrayList<edge> get_edge(){
    	return Edge;
    }
    public boolean new_node(String word) {
    	for(int i = 0 ; i < Node.size(); i++) {
    		if(Node.get(i).get_data().equals(word)) {
    			return false;
    		}
    	}
    	return true;
    }
    public node get_node(String word) {
    	for(int i = 0 ; i < Node.size(); i++) {
    		if(Node.get(i).get_data().equals(word)) {
    			return Node.get(i);
    		}
    	}
    	return null;
    }
    public boolean new_edge(int start , int end) {
    	for(edge e : Edge) {
    		if(start == e.get_start() && end == e.get_end()) {
    			return false;
    		}
    	}
    	return true;
    }
    public  int index(int start , int end) {
    	for(int i = 0 ; i < Edge.size() ; i++) {
    		edge e = Edge.get(i);
    		if(start == e.get_start() && end == e.get_end()) {
    			return i;
    		}
    	}
    	return -1;
    }
    public void add_w(int start , int end) {
    	for(edge e : Edge) {
    		if(start == e.get_start() && end == e.get_end()) {
    			e.change_w();
    		}
    	}
    }
    public ArrayList<Integer> find_end(int start){
    	ArrayList<Integer> end = new ArrayList<Integer>();
    	for(edge e : Edge) {
    		if(start == e.get_start()) {
    			end.add(e.get_end());
    		}
    	}
    	return end;
    }
    public ArrayList<Integer> bridge(String p_word1,String p_word2){
    	int p_1,p_2;
    	ArrayList<Integer> end = new ArrayList<Integer>();
    	ArrayList<Integer> bridge = new ArrayList<Integer>();
    	p_1 = Node.indexOf(get_node(p_word1));
		p_2 = Node.indexOf(get_node(p_word2));
		if(p_1 == -1 || p_2 == -1) {
			return bridge;
		}
		end  = find_end(p_1);
        for(int i = 0 ; i < end.size(); i++) {
        	ArrayList<Integer> end_this_node = new ArrayList<Integer>();
        	end_this_node = find_end(end.get(i));
        	if(end_this_node.indexOf(p_2) != -1) {
        		bridge.add(end.get(i));
        	}
        }
        return bridge;
    }
    public String queryBridgeWords(String word1,String word2) {
    	String solution = "";
    	ArrayList<Integer> bridge = new ArrayList<Integer>();
    	node p_word1,p_word2;
    	p_word1 = get_node(word1);
    	p_word2 = get_node(word2);
    	if(p_word1 == null || p_word2 == null) {
    		if(p_word1 == null && p_word2 == null) {
    			solution = "No \""+word1+"\" "+"and \""+word2+"\" in the graph!";
    		}
    		else if(p_word1 == null) {
    			solution = "No \""+word1+"\" in the graph!";
    		}
    		else {
    			solution = "No \""+word2+"\" in the graph!";
    		}
    	}
    	else {
            bridge = bridge(word1,word2);
            if(bridge.size() == 0) {
            	solution = "No bridge words from \""+word1+"\" to \""+word2+"\"!";
            }
            else {
            	solution = "the bridge words from \""+ word1 + "\" to \""+ word2+"\" are:";
            	for(int i = 0 ; i < bridge.size() ; i++) {
            		solution = solution + Node.get(bridge.get(i)).get_data()+" ";
            	}
            }  		
    	}
    	System.out.println(solution);
    	return solution;
    }
    public void function_three() {
    	System.out.println("input the two words:");
    	Scanner in = new Scanner(System.in);
    	String word1 = in.nextLine();
    	String word2 = in.nextLine();
    	queryBridgeWords(word1, word2);
    }
    public String solution(String text) {
    	String solution = "";
    	ArrayList<Integer> bridge = new ArrayList<Integer>();
    	Random rand = new Random();
    	String[] insert_words = new String[100];
    	String[] words;
    	words = text.split("\\s+");
    	for(int i = 0 ; i<100 ; i++) {
    		insert_words[i] = "";
    	}
    	for(int i = 0 ; i < words.length-1 ; i++ ) {
    		bridge = bridge(words[i],words[i+1]);
    		if(bridge.size() > 0) {
    			int m = rand.nextInt(bridge.size());
    			insert_words[i] = Node.get(bridge.get(m)).get_data();
    		}
    	}
    	for(int i = 0 ; i < words.length ; i++) {
    		if(!insert_words[i].equals("")) {
    			solution = solution + words[i] + " " + insert_words[i] + " ";
    		}
    		else {
    			solution = solution + words[i] + " ";
    		}
    	}
    	return solution;
    }
    public String generateNewText() {
    	String solution = "";
//    	ArrayList<Integer> bridge = new ArrayList<Integer>();
//    	String[] insert_words = new String[100];
//    	String[] words;
    	Scanner in = new Scanner(System.in);
    //	Random rand = new Random();
    	System.out.println("Please input the text:");
    	String text = in.nextLine();
    	text = text.toUpperCase();
    	text =  text.replaceAll("[\\p{Punct}]+", " ");
    	//words = text.split("\\s+");
//    	for(int i = 0 ; i<100 ; i++) {
//    		insert_words[i] = "";
//    	}
//    	for(int i = 0 ; i < words.length-1 ; i++ ) {
//    		bridge = bridge(words[i],words[i+1]);
//    		if(bridge.size() > 0) {
//    			int m = rand.nextInt(bridge.size());
//    			insert_words[i] = Node.get(bridge.get(m)).get_data();
//    		}
//    	}
//    	for(int i = 0 ; i < words.length ; i++) {
//    		if(!insert_words[i].equals("")) {
//    			solution = solution + words[i] + " " + insert_words[i] + " ";
//    		}
//    		else {
//    			solution = solution + words[i] + " ";
//    		}
//    	}
    	solution = solution(text);
    	return solution;	
    }
    public String randomwalk() {
    	 String solution = "";
    	 int m,n;
    	 ArrayList<Integer> end = new ArrayList<Integer>();
    	 stop_anytime s = new stop_anytime();
    	 boolean[] walked = new boolean[Edge.size()];
    	 for(int i = 0 ; i < walked.length ; i++) {
    		 walked[i] = false;
    	 }
    	 
    	 //出发点
    	 Random rand = new Random();
    	 m = rand.nextInt(Node.size());
    	 solution =  Node.get(m).get_data()+" ";
    	 node p = Node.get(m);
    	 
    	 while(true) {
    		if(!s.is_stop()) {
    		end  = find_end(m);
    		try {
    			s.setlabel(solution);
				 Thread.sleep(100);
				 s.show();
				 Thread.sleep(500);
			 }catch(Exception e) {
				    System.exit(0);
		     }
    		if(end.size() > 0) {
    			n = end.get(rand.nextInt(end.size()));
    			if(!s.is_stop()) {
    			if(!walked[index(m,n)]) {
    				walked[index(m,n)] = true;
    				solution = solution + Node.get(n).get_data()+" ";
    			}
    			else {
    				solution = solution + Node.get(n).get_data();
    				s.setlabel(solution);
   				    s.show();
    				break;
    			}}
    			m = n;
    		}
    		else {
    			break;
    		}}
    		else { break;}
    	 }
    	 file_out f = new file_out(solution);
    	 f.output();
    	 //System.out.println(solution);
    	 return solution;	 
    }
    String start_to_end(int start,int end,int[] way) {
    	String temp = "";
    	int distance = 0;
    	ArrayList<String> way_word = new ArrayList<String>(); 
    	//temp = temp + "the way from \"" + Node.get(start).get_data() + "\" to \"" + Node.get(end).get_data() + "\":    ";
    	if(way[end] == 1000) {
    		temp = temp + Node.get(start).get_data() +" to " + Node.get(end).get_data() + " no way";
    	}
    	else {
    		int j = end;
    		while(way[j] != start) {
    			way_word.add(Node.get(way[j]).get_data());
    			distance = distance + Edge.get(index(way[j],j)).get_w(); 
    			j = way[j];
    		}
    		distance = distance + Edge.get(index(way[j],j)).get_w();
    		temp = temp + Node.get(start).get_data() + "->";
    		for(int i = way_word.size() - 1; i >= 0 ; i--) {
    			temp = temp + way_word.get(i)+"->";
    		}
    		temp = temp + Node.get(end).get_data()+";"+distance;
    	}
    	return temp;
    }
    void showDirectedGraph(graph G) {
	   	 ArrayList<posi> draw = new ArrayList<posi>();
	   	 ArrayList<String> str = new ArrayList<String>();
	   	 ArrayList<posi> draw_edge = new ArrayList<posi>();
	   	 ArrayList<node> temp_node = G.get_node();
	   	 ArrayList<edge> temp_edge = G.get_edge();
	   	 ArrayList<Integer> w = new ArrayList<Integer>();
	   	 for(int i = 0 ; i <= 10; i++) {
	   		 for(int j = 0 ; j <= 4 ; j++) {
	   			 if(i*5 + j < temp_node.size()) {
	   				 draw.add(new posi(i+1,j+1));
	   			 }
	   			 else {
	   				 break;
	   			 }
	   		 }
	   	 }
	   	 for(int i = 0 ; i < temp_node.size(); i++) {
	   		 str.add(temp_node.get(i).get_data());
	   	 }
	   	 for(int i = 0 ; i < temp_edge.size(); i++) {
	   		 draw_edge.add(new posi(temp_edge.get(i).get_start(),temp_edge.get(i).get_end()));
	   		 w.add(G.get_edge().get(index(temp_edge.get(i).get_start(),temp_edge.get(i).get_end())).get_w());
	   	 }
	   	 frame.set(draw, str, draw_edge, w);
	   	 frame.show_graph();
	   	 //frame.repaint();
   }
    public void show_shortest_way(String[] path) {
    	 String[] way;
    	 String label_way;
    	 ArrayList<posi> show_way = new ArrayList<posi>();
         showDirectedGraph(this);
         for(int i = 0 ; i < path.length ; i++) {
        	 label_way = path[i];
        	 System.out.println(label_way);
        	 if(label_way.indexOf("->")!=-1) {
        	 way = path[i].substring(0, path[i].indexOf(";")).split("->");
        	 for(int j = 0 ; j < way.length-1 ; j++) {
        		 int start = Node.indexOf(get_node(way[j]));
        		 int end   = Node.indexOf(get_node(way[j+1]));
        		 show_way.add(new posi(start,end));
        		 frame.set_way(show_way);
        		 frame.set_label(label_way);
        		 //frame.repaint();
  			     try {
  				    Thread.sleep(1000);
  				    frame.repaint();
  			     }catch(Exception e) {
  				    System.exit(0);
  			     }

        	 }
        	 show_way.clear();}
        	 else {
        		 frame.set_label(label_way);
        		 try {
   				    Thread.sleep(1000);
   				    frame.repaint();
   			     }catch(Exception e) {
   				    System.exit(0);
   			     }       	 
        	 }
         }
         frame.set_label(".");
         try {
			    Thread.sleep(1000);
			    System.out.println("131");
			    frame.repaint();
		     }catch(Exception e) {
			    System.exit(0);
		     } 
    }
    public void creat_graph() throws IOException {
    	node pr = null , p;
    //	Scanner in = new Scanner(System.in);
    	file_read fr = new file_read();
    	ArrayList<String> words = fr.read();
    	for(int i = 0 ; i < words.size(); i++) {
    		if(new_node(words.get(i))) {
    			p = new node(words.get(i));
    			Node.add(p);
    		}
    		else {
    			p = get_node(words.get(i));
    		}
    		if(pr != null) {
    			int start = Node.indexOf(pr);
    			int end = Node.indexOf(p);
    			if(new_edge(start,end)) {
    				Edge.add(new edge(start,end,1));
    			}
    			else {
    				add_w(start,end);
    			}
    		}
    		pr = p;
    	}
//    	for(int i = 0 ; i < Node.size(); i++) {
//    		System.out.println(i+" "+ Node.get(i).get_data());
//    	}
//    	for(int i = 0 ; i < Edge.size(); i++) {
//    		System.out.println(Node.get(Edge.get(i).get_start()).get_data()+"->"+Node.get(Edge.get(i).get_end()).get_data()+"= "+Edge.get(i).get_w());
//    	}
    	//showDirectedGraph(this);
    }
    public void function_two() {
    	showDirectedGraph(this);
    }
    public String[] cal(String word) {
    	node p = get_node(word);
    	int start = Node.indexOf(p);
    	String[] path = new String[Node.size()];
    	int[] way;
    	dijkstra dij = new dijkstra(Edge, start, Node.size());
    	way = dij.solution();
    	for(int i = 0 ; i < Node.size() ; i++) {
        	path[i] = start_to_end(start , i , way);
//        	System.out.println(path[i]);
        }
    	return path;
    }
    public String[] calcShortPath(String word) {
//    	node p = get_node(word);
//    	int start = Node.indexOf(p);
//    	String[] path = new String[Node.size()];
//    	int[] way;
//    	dijkstra dij = new dijkstra(Edge, start, Node.size());
//    	way = dij.solution();
//    	for(int i = 0 ; i < Node.size() ; i++) {
//        	path[i] = start_to_end(start , i , way);
////        	System.out.println(path[i]);
//        }
    	if(new_node(word)) {
    	    JOptionPane.showMessageDialog(null, "错误信息提示", "输入错误", JOptionPane.INFORMATION_MESSAGE);
    	    return null;
    	}
    	else {
    		String[] path = cal(word);
    		show_shortest_way(path);
    		return path;
    	}
    }
    public String calcShortPath(String word1,String word2) {
    	if(new_node(word1) || new_node(word2)) {
    		JOptionPane.showMessageDialog(null, "错误信息提示", "输入错误", JOptionPane.INFORMATION_MESSAGE);
    		return null;
    	}
    	String[] path = cal(word1);
    	int end = Node.indexOf(get_node(word2));
    	String temp = path[end];
    	String[] new_path = new String[1];
    	new_path[0] = path[end];
    	show_shortest_way(new_path);
    	return temp;
    }
    public void funcion_five() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("please input a word and we show the shorest from the word to the other words:");
    	String word = in.nextLine();
    	while(word.equals("")  ||  new_node(word)) {
    		System.out.println("input a word exsited");
    		word = in.nextLine();
    	}
    	calcShortPath(word);
    }
    static void interactive() {
    	System.out.println("input 1 to show the graph;");
    	System.out.println("input 2 to the shortest way");
    	System.out.println("inout 3 to find the bridge words");
    	System.out.println("input 4 to generate new text");
    	System.out.println("input 5 to randomwalk");
    }
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        graph g = new graph();
        g.creat_graph();
     //   g.function_three();
        Scanner in  =new Scanner(System.in);
        interactive();
        int m = in.nextInt();
        while(true) {
        	if(m == 1) {
        		g.function_two();
        	}
        	if(m==2) {
        		g.calcShortPath("to");
        	}
        	if(m==3) {
        		g.function_three();
        	}
        	if(m==4) {
        		System.out.println(g.generateNewText());
        	}
        	if(m == 5) {
        		System.out.println(g.randomwalk());
        	}
            interactive();
        	m = in.nextInt();
        }
      //  g.function_two();
      //System.out.println( g.generateNewText());
        //g.funcion_five();
//      g.calcShortPath("explore");
//        System.out.println(g.randomwalk());
	}

}
