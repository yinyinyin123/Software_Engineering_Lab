package ½á¶Ô±à³Ì;

import java.util.ArrayList;

public class dijkstra {
	private int[][] distance;
    private int start;
    private int num;  //number of node
    public dijkstra(int[][] distance,int start,int num) {
    	this.distance = distance;
    	this.start = start;
    	this.num = num;
    }
    public dijkstra(ArrayList<edge> Edge,int start,int num) {
    	this.num = num;
    	this.start = start;
    	this.distance = new int[num][num];
    	for(int i = 0 ; i < num ; i++) {
    		for(int j = 0 ; j < num ; j++) {
    			distance[i][j] = 1000;
    		}
    	}
    	for(edge temp : Edge){
    		distance[temp.get_start()][temp.get_end()] = temp.get_w();
    	}
    }
    public int the_min_node(int[] dis,boolean[] walked) {
    	int temp_min = 1000,count = -1;
    	for(int i = 0 ; i < dis.length; i++) {
    		if(!walked[i] && dis[i] < temp_min) {
    			count = i;
    			temp_min = dis[i];
    		}
    	}
    	return count;
    }
    public void show_way(int[] way) {
    	for(int i = 0 ; i < way.length ; i++) {
    		System.out.print(start+"->"+i+": ");
    		if(way[i] == 1000) {
    			System.out.println("no way");
    		}
    		else {
    			System.out.print(i+" ");
    			int j = i;
    			while(way[j] != start) {
    				System.out.print(way[j]+" ");
    				j = way[j];
    			}
    			System.out.println(start+" ");
    		}
    	}
    }
    public int[] solution() {
    	int[] dis = new int[num];
    	int[] way = new int[num];
    	boolean walked[] = new boolean[num];
    	int temp_min;
    	for(int i = 0 ; i < num ; i++) {
    		dis[i] = distance[start][i];
    		walked[i] = false;
    		way[i] = start;
    	}
    	temp_min = the_min_node(dis,walked);
    	while(temp_min != -1) {
    		walked[temp_min] = true;
    		for(int i = 0 ; i < num ; i++) {
    			if(!walked[i] && dis[i] > dis[temp_min] + distance[temp_min][i]) {
    				dis[i] = dis[temp_min]+distance[temp_min][i];
    				way[i] = temp_min;
    			}
    		}
    		temp_min = the_min_node(dis,walked);
    	}
    	for(int i = 0 ; i < num ; i++) {
    		if(dis[i] == 1000) {
    			way[i] = 1000;
    		}
    	}
    	//show_way(way);
    	return way;
    }
    public void print() {
    	for(int i = 0 ; i< num ; i++) {
    		for(int j = 0; j < num ; j++) {
    			System.out.print(distance[i][j]+" ");
    		}
    		System.out.println(" ");
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
