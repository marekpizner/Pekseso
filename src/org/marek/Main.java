package org.marek;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main extends JFrame {

	private JPanel contentPane;
	private  int a=0;
	private List<ImageIcon> images = new ArrayList<ImageIcon>();
	private List<Karta> karta = new ArrayList<Karta>();
	private String std;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	protected int getCount()
	{
		int count =0;
		for(Karta kar : karta)
		{					
			if(kar.getSet() == 1)
			{
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Main() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		lblNewLabel.setBounds(139, 109, 70, 15);
		//contentPane.add(lblNewLabel);
		
		
		for(int i = 1 ;i<16;i++){
			std = String.format("/org/marek/p%d.png",i);
			images.add(new ImageIcon(Main.class.getResource(std.toString())));
		}
		Collections.shuffle(images);
		
		int x=5;
		int y=5;
		int position=1;
		
		for(int i=1;i<=20;i++){

			karta.add(new Karta(x,y,contentPane,images.get(position),i));
			
			
			if(i%5 == 0)
			{
				y+=128;
				x=5;
			}
			else
			{
				x+=128;
			}
			
			if(position == 14){
				position=0;
			}
			position++;
	
		}
		int index=0;
		for(Karta kar : karta)
		{
			karta.get(index).setKarta(karta);
			index++;
		}
		
		
			

			

			
	

	}
}
