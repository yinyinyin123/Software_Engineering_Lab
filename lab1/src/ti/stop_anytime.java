package ti;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class stop_anytime  {
    
	private JLabel label = new JLabel();
	private JFrame frame = new JFrame();
	private boolean stop;
	public stop_anytime() {
		JButton button = new JButton("stop");
		stop = false;
		label.setText("random_walk");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				stop = true;
			}
		});
		frame.add(button);
		frame.add(label,BorderLayout.SOUTH);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}
	public void setlabel(String str) {
		label.setText("random_walk:"+str);
	}
	public boolean is_stop() {
		return stop;
	}
	public void show() {
		label.repaint();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       stop_anytime s = new stop_anytime();
       s.setlabel("good");
       s.show();
	}

}
