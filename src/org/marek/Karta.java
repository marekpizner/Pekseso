package org.marek;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Karta {
	
	public JLabel label;
	private ImageIcon icon2;
	private ImageIcon back;
	private int set=0;
	private List<Karta> karta;
	private boolean live = true;
	private int position;
	
	public Karta(int x, int y,JPanel contentPane, ImageIcon icon, int p){
		
		position = p;
		this.icon2 = icon;
		back = new ImageIcon(Main.class.getResource("/org/marek/back.png"));
		label = new JLabel("");
		label.setBounds(x, y, 128,120 );
		label.setIcon(back);
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clicked();
			}
		});
		
		contentPane.add(label);
		
	}
	public void setKarta(List<Karta> karta){
		this.karta = karta;
	}

	public void clicked(){
		int posa = 0;
		int posb = 0;
		int count=0;
		int c=0;
		
		for(Karta kar : karta)
		{
			if(kar.getLive() == true){
				if(count < 2){
					if(kar.getSet() == 1){
						count++;
						if(count == 1){
							posa = c;
						}
						else
							if(count == 2){
								posb = c; 
							}
					}
				}
				c++;
		}
		}
		
		if(count == 0 && c >= 1 ){
			label.setIcon(this.icon2);
			set=1;
		}
		if(count == 1 ){
			label.setIcon(this.icon2);
			set=1;
		}		
		if(count == 2){
			if(karta.get(posa).getIcon() == karta.get(posb).getIcon())
			{
				karta.get(posa).setDeat();
				karta.get(posb).setDeat();
			}else{
				karta.get(posa).close();
				karta.get(posb).close();
				label.setIcon(this.icon2);
				set=1;
			}
		}
	}
	public void close(){
		label.setIcon(back);
		set=0;
	}
	public int getSet(){
		return set;	
	}
	public void setSet(int i){
		set = i;
	}
	public ImageIcon getIcon(){
		return icon2;
	}
	public void  setDeat(){
		set = 0;
		live= false;
		label.setVisible(false);
	}
	public boolean getLive(){
		return live;
	}
	public int getPosition(){
		return position;
	}
}
