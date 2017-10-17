package ti;

public class edge {
    private int start;
    private int end;
    private int w;
    public edge(int start , int end , int w) {
    	this.start = start ;
    	this.end = end;
    	this.w = w;
    }
    public int get_start() {
    	return start;
    }
    public int get_end() {
    	return end;
    }
    public void change_w(){
    	w = w + 1;
    }
    public int get_w() {
    	return w;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
