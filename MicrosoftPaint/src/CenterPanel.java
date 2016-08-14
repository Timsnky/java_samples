import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;


public class CenterPanel extends JPanel{
	
	private Point startPoint, stopPoint;
	
	public CenterPanel(){
		init();
	}
	
	public void init(){
		addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				startPoint = e.getPoint();
				repaint();
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
				startPoint = e.getPoint();			
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				stopPoint = e.getPoint();
				repaint();				
			}			
		});
		
		addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				stopPoint = e.getPoint();
				repaint();			
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public void paint(Graphics g){
		super.paintComponent(g);
		
		g.setColor(MicrosoftPaint.color);
		
		if(MicrosoftPaint.paintTypeId == 0){
			paintShape(g);
		}else{
			paintText(g);
		}		
	}
	
	private void paintShape(Graphics g){
		switch(MicrosoftPaint.shapeId){
		case 0:
			g.drawLine(startPoint.x, startPoint.y, stopPoint.x, stopPoint.y);
			break;
		case 1:
			g.drawRect(startPoint.x, startPoint.y, stopPoint.x - startPoint.x, stopPoint.y - startPoint.y);
			break;		
		case 2:
			g.drawOval(startPoint.x, startPoint.y, stopPoint.x - startPoint.x, stopPoint.y - startPoint.y);
			break;
		case 3:
			int[] xPoints = {startPoint.x, startPoint.x, stopPoint.x};
			int[] yPoints = {startPoint.y, stopPoint.y, stopPoint.y};
			g.drawPolygon(xPoints, yPoints, 3);
			break;
		}
		
	}
	
	private void paintText(Graphics g){
		removeAll();
		JTextArea text = new JTextArea();
		text.setBounds(startPoint.x, startPoint.y, 500, 50);
		text.setWrapStyleWord(true);
		add(text);
	}
	

}
