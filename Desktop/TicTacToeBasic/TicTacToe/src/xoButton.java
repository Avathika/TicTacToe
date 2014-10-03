import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class xoButton extends JButton implements ActionListener {
ImageIcon X,O;
byte value;

	
	public xoButton(){
		X=new ImageIcon(this.getClass().getResource("Gryffindor.jpg"));
		O=new ImageIcon(this.getClass().getResource("Slytherin.jpg"));
		this.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		value++;
		value%=3;
		switch(value){
		case 0:
			setIcon(null); break;
			
		case 1:
			setIcon(X);break;
		case 2: 
			setIcon(O);break;
			
		}
	}
	
}
