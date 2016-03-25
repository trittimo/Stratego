package stratego.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{

	Main main;
	
	public Mouse(Main main){
		this.main = main;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < 10; i++){
			for (int j = 0; j < 10; j++) {
				if(e.getX()>i*60+30 && e.getX()<60*(i+1)+30){
					if(e.getY()>j*60+30 && e.getY()<60*(j+1)+30){
						System.out.println(j+10*i);
						this.main.selectPiece(j+10*i);
					}
				}
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
