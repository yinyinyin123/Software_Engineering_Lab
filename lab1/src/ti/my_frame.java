package ti;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;

public class my_frame extends JPanel {

	private JFrame frame = new JFrame();;
	private JLabel Lab;

	private ArrayList<posi> draw = new ArrayList<posi>();
	private ArrayList<String> str = new ArrayList<String>();
	private ArrayList<posi> draw_edge = new ArrayList<posi>();
	private ArrayList<posi> way = new ArrayList<posi>();
	private ArrayList<Integer> w = new ArrayList<Integer>(); // Ȩֵ
	private String Label = "";

	public void set_way(ArrayList<posi> way) {
		this.way = way;
	}

	public void set_label(String label) {
		this.Label = label;
	}

	public my_frame() {

	}

	public my_frame(ArrayList<posi> draw, ArrayList<String> str,
			ArrayList<posi> draw_edge, ArrayList<Integer> w) {
		this.draw = draw;
		this.str = str;
		this.draw_edge = draw_edge;
		this.w = w;
		Lab = new JLabel();
	}

	public void set(ArrayList<posi> draw, ArrayList<String> str,
			ArrayList<posi> draw_edge, ArrayList<Integer> w) {
		this.draw = draw;
		this.str = str;
		this.draw_edge = draw_edge;
		this.w = w;
		Lab = new JLabel();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		QuadCurve2D q = new QuadCurve2D.Double();
		String temp = "";
		for (int i = 0; i < draw.size(); i++) {
			int x = draw.get(i).get_x();
			int y = draw.get(i).get_y();
			g.drawOval(x * 150 - 10, y * 150 - 30, 100, 100);
			g.drawString(str.get(i), x * 150 + 20, y * 150 + 20);
		}
		for (int i = 0; i < draw_edge.size(); i++) {
			int start_x = (draw.get(draw_edge.get(i).get_x()).get_x()) * 150 + 90;
			int start_y = (draw.get(draw_edge.get(i).get_x()).get_y()) * 150 + 20;
			int end_x = (draw.get(draw_edge.get(i).get_y()).get_x()) * 150 + 40;
			int end_y = (draw.get(draw_edge.get(i).get_y()).get_y()) * 150 + 20;
			g2.setColor(Color.BLUE);
			q.setCurve(start_x, start_y, 50 + (start_x + end_x) / 2, 50 + (start_y + end_y) / 2, end_x, end_y);
			g2.draw(q);
			temp = temp + w.get(i);
			g.drawString(temp, 50 + ((int) (0.9 * start_x) + end_x) / 2, 50 + (start_y + end_y) / 2);
			temp = "";
		}
		for (int i = 0; i < way.size(); i++) {
			int start_x = (draw.get(way.get(i).get_x()).get_x()) * 150 + 90;
			int start_y = (draw.get(way.get(i).get_x()).get_y()) * 150 + 20;
			int end_x = (draw.get(way.get(i).get_y()).get_x()) * 150 + 40;
			int end_y = (draw.get(way.get(i).get_y()).get_y()) * 150 + 20;
			g2.setColor(Color.RED);
			q.setCurve(start_x, start_y, 50 + (start_x + end_x) / 2, 50 + (start_y + end_y) / 2, end_x, end_y);
			g2.draw(q);
			temp = temp + w.get(i);
			g.drawString(temp, 50 + ((int) (0.9 * start_x) + end_x) / 2, 50 + (start_y + end_y) / 2);
			temp = "";
			// frame.add(Lab,BorderLayout.SOUTH);

		}
		frame.add(Lab, BorderLayout.SOUTH);
		Lab.setText(Label);
		Lab.repaint();
		Label = "";
	}

	public void show_graph() {
		frame.setVisible(true);
		frame.setSize(1800, 900);
		frame.add(this);
		// frame.repaint();
		// frame.setDefaultCloseOperation(JFrame.);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
