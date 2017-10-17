package ��Ա��;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

public class gui {
	private graph g = new graph();
	private boolean flag = false;
	public void show() {
		g.calcShortPath("new");
	}
    void java_thread(String word1) {
    	Thread t = new Thread(new Runnable() {
    		public void run() {
    			g.calcShortPath(word1);
    		}
    	});
    	t.start();
    }
    void java_thread1() {
    	Thread t = new Thread(new Runnable() {
    		public void run() {
    			g.randomwalk();
    		}
    	});
    	t.start();
    }
    void java_thread2(String word1,String word2) {
    	Thread t = new Thread(new Runnable() {
    		public void run() {
    			g.calcShortPath(word1, word2);
    		}
    	});
    	t.start();
    }
    public void init() throws IOException{
    	JFrame frame = new JFrame();
    	JPanel panel = new JPanel();
    	g.creat_graph();
    	//show();
    	JButton button = new JButton("չʾ����ͼ");
    	JButton button1 = new JButton("���·��(all)");
    	JButton button2 = new JButton("�������");
    	JButton button3 = new JButton("�������ı�");
    	JButton button4 = new JButton("��ѯ���Ӵ�");
    	JButton button5 = new JButton("���·��(two)");
    	panel.add(button);
    	panel.add(button1);
    	panel.add(button2);
    	panel.add(button3);
    	panel.add(button4);
    	panel.add(button5);
    	frame.add(panel);
    	frame.setVisible(true);
    	frame.setSize(800,100);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				g.function_two();
			}
		});
    	button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				JPanel p = new JPanel();
	            JButton b = new JButton("ok");
				JTextField text=new JTextField(10);
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						flag = true;
						java_thread(text.getText());
						f.dispose();
						//mm();
					}
				});
				p.add(text);
				p.add(b);
				f.add(p);
				f.setVisible(true);
				f.setSize(500, 500);
				//g.calcShortPath("new");
				//show();
			}
		});
    	button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				java_thread1();
			}
		});
        button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame j = new JFrame();
				JPanel p = new JPanel();
				JTextField text=new JTextField(40);
				JButton b = new JButton("ok");
				p.add(text);
				p.add(b);
				j.add(p);
				j.setVisible(true);
				j.setSize(800, 200);
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String temp = g.solution(text.getText().replaceAll("[^a-z^A-Z]", " "));
						JFrame f = new JFrame();
						JLabel l = new JLabel(temp);;
						f.add(l);
						f.setVisible(true);
						f.setSize(800,100);
						j.dispose();
					}
				});
				
				
			}
		});
        button4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame ff = new JFrame();
				JPanel pp1 =  new JPanel();
				JTextField text=new JTextField(20);
				JLabel ll1 = new JLabel("��һ������");
				JTextField text1=new JTextField(20);
				JLabel ll2 = new JLabel("�ڶ�������");			
				pp1.add(ll1);
				pp1.add(text);
				pp1.add(ll2);
				pp1.add(text1);
				JButton bb = new JButton("ok");
				bb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String temp = g.queryBridgeWords(text.getText(), text1.getText());
						JFrame n = new JFrame();
						JLabel l = new JLabel(temp);
						n.add(l);
						n.setVisible(true);
						n.setSize(600, 100);
						ff.dispose();
					}
				});
				ff.add(pp1);
				ff.add(bb,BorderLayout.SOUTH);
				ff.setVisible(true);
				ff.setSize(1000, 400);
				
			}
		});
        button5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame ff = new JFrame();
				JPanel pp1 =  new JPanel();
				JTextField text=new JTextField(20);
				JLabel ll1 = new JLabel("��һ������");
				JTextField text1=new JTextField(20);
				JLabel ll2 = new JLabel("�ڶ�������");			
				pp1.add(ll1);
				pp1.add(text);
				pp1.add(ll2);
				pp1.add(text1);
				JButton bb = new JButton("ok");
				bb.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					    java_thread2(text.getText(), text1.getText());
						ff.dispose();
					}
				});
				ff.add(pp1);
				ff.add(bb,BorderLayout.SOUTH);
				ff.setVisible(true);
				ff.setSize(1000, 400);
				
			}
		});
     	//g.function_two();
    }

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
        gui G = new gui();
        G.init();

	}

}
