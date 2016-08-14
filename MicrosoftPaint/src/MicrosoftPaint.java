import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle;
import javax.swing.border.BevelBorder;


public class MicrosoftPaint extends JApplet implements ActionListener {
	
	private CenterPanel centerPanel;
	private JPanel northPanel, westPanel, eastPanel,southPanel;
	private JLabel categoryLabel, colorLabel, textToolsLabel, fontLabel, fontSizeLabel, fontStyleLabel, shapeToolsLabel;
	private JRadioButton shapeRadioButton, textRadioButton,triangleRadioButton, rectangleRadioButton, circleRadioButton, lineRadioButton;
	private JButton redButton, blueButton, greenButton, orangeButton, yellowButton, pinkButton, blackButton;
	private JComboBox fontComboBox, fontSizeComboBox;
	private ButtonGroup paintTypeGroup, shapeGroup;
	private JCheckBox boldCheckBox, italicCheckBox;
	private String[] fonts = {"Arial","Calibri","Microsoft SanSerif","Times New Roman"};
	private String[] fontSizes = {"11","12", "14", "18", "20", "24", "28", "32"};
	public static int shapeId = -1, shapeSizeId = 0, fontId = 0, fontStyleId = 0, fontSizeId = 0, paintTypeId = 0;
	public static Color color = Color.BLACK;
	private String c;
	
	public void init(){
		setLayout(null);
		setSize(1000, 900);
		
		//North Panel
		northPanel = new JPanel();
		northPanel.setBounds(0, 0, 1000, 20);
		northPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(northPanel);
		
		//West Panel
		westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setBounds(0, 20, 150, 830);
		westPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		setupWestPanel();				
		
		add(westPanel);
		
		southPanel = new JPanel();
		southPanel.setBounds(0, 850, 1000, 50);
		southPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		add(southPanel);
		
		eastPanel = new JPanel();
		eastPanel.setLayout(null);
		eastPanel.setBounds(850, 20, 150, 830);
		eastPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		setupEastPanel();
		add(eastPanel);
		
		centerPanel = new CenterPanel();
		centerPanel.setLayout(null);
		centerPanel.setBounds(150, 20, 700, 830);
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		add(centerPanel);
		
		setVisible(true);

		manageViews();
	}
	
	private void manageViews(){
		if(paintTypeId == 0){
			fontComboBox.setEnabled(false);
			fontSizeComboBox.setEnabled(false);
			boldCheckBox.setEnabled(false);
			italicCheckBox.setEnabled(false);	
			lineRadioButton.setEnabled(true);
			rectangleRadioButton.setEnabled(true);
			circleRadioButton.setEnabled(true);
			triangleRadioButton.setEnabled(true);
		}else{
			lineRadioButton.setEnabled(false);
			rectangleRadioButton.setEnabled(false);
			circleRadioButton.setEnabled(false);
			triangleRadioButton.setEnabled(false);
			fontComboBox.setEnabled(true);
			fontSizeComboBox.setEnabled(true);
			boldCheckBox.setEnabled(true);
			italicCheckBox.setEnabled(true);			
		}
		
	}
	
	private void setupWestPanel(){
		categoryLabel = new JLabel("Paint Type: ");
		categoryLabel.setBounds(10, 10, 100, 20);
		westPanel.add(categoryLabel);
		
		shapeRadioButton = new JRadioButton("Shape");
		shapeRadioButton.setBounds(30, 40, 100, 20);
		shapeRadioButton.addActionListener(this);
		westPanel.add(shapeRadioButton);
		
		textRadioButton = new JRadioButton("Text");
		textRadioButton.setBounds(30, 70, 100, 20);
		textRadioButton.addActionListener(this);
		westPanel.add(textRadioButton);
		
		paintTypeGroup = new ButtonGroup();
		paintTypeGroup.add(shapeRadioButton);
		paintTypeGroup.add(textRadioButton);
		shapeRadioButton.setSelected(true);
		
		colorLabel = new JLabel("Color");
		colorLabel.setBounds(10, 100, 100, 20);
		westPanel.add(colorLabel);
		
		redButton = new JButton();
		redButton.setBounds(10, 130, 30, 30);
		redButton.setBackground(Color.RED);
		redButton.addActionListener(this);
		westPanel.add(redButton);
		
		orangeButton = new JButton();
		orangeButton.setBounds(50, 130, 30, 30);
		orangeButton.setBackground(Color.ORANGE);
		orangeButton.addActionListener(this);
		westPanel.add(orangeButton);
		
		yellowButton = new JButton();
		yellowButton.setBounds(90, 130, 30, 30);
		yellowButton.setBackground(Color.YELLOW);
		yellowButton.addActionListener(this);
		westPanel.add(yellowButton);
		
		greenButton = new JButton();
		greenButton.setBounds(10, 170, 30, 30);
		greenButton.setBackground(Color.GREEN);
		greenButton.addActionListener(this);
		westPanel.add(greenButton);		
		
		blueButton = new JButton();
		blueButton.setBounds(50, 170, 30, 30);
		blueButton.setBackground(Color.BLUE);
		blueButton.addActionListener(this);
		westPanel.add(blueButton);
		
		pinkButton = new JButton();
		pinkButton.setBackground(Color.PINK);
		pinkButton.setBounds(90, 170, 30, 30);
		pinkButton.addActionListener(this);
		westPanel.add(pinkButton);
		
		blackButton = new JButton();
		blackButton.setBackground(Color.BLACK);
		blackButton.setBounds(10, 210, 30, 30);
		blackButton.addActionListener(this);
		westPanel.add(blackButton);
	}
	
	private void setupEastPanel(){
		
		textToolsLabel = new JLabel("TEXT TOOLS");
		textToolsLabel.setBounds(10, 10, 100, 20);
		eastPanel.add(textToolsLabel);
		
		fontLabel = new JLabel("Font");
		fontLabel.setBounds(10, 40, 100,20);
		eastPanel.add(fontLabel);
		
		fontComboBox = new JComboBox(fonts);
		fontComboBox.setBounds(10, 70, 140, 20);
		fontComboBox.addActionListener(this);
		eastPanel.add(fontComboBox);
		
		fontSizeLabel = new JLabel("Font Size");
		fontSizeLabel.setBounds(10, 100, 100, 20);
		eastPanel.add(fontSizeLabel);
		
		fontSizeComboBox = new JComboBox(fontSizes);
		fontSizeComboBox.setBounds(10, 130, 100, 20);
		fontSizeComboBox.addActionListener(this);
		eastPanel.add(fontSizeComboBox);
		
		fontStyleLabel = new JLabel("Font Style");
		fontStyleLabel.setBounds(10, 160, 100, 20);
		eastPanel.add(fontStyleLabel);
		
		boldCheckBox = new JCheckBox("Bold");
		boldCheckBox.setBounds(30, 190, 100, 20);
		boldCheckBox.addActionListener(this);
		eastPanel.add(boldCheckBox);
		
		italicCheckBox = new JCheckBox("Italic");
		italicCheckBox.setBounds(30, 220, 100, 20);
		italicCheckBox.addActionListener(this);
		eastPanel.add(italicCheckBox);	
		
		shapeToolsLabel = new JLabel("SHAPE TOOLS");
		shapeToolsLabel.setBounds(10, 260, 100, 20);
		eastPanel.add(shapeToolsLabel);
		
		lineRadioButton = new JRadioButton("Line");
		lineRadioButton.setBounds(30, 290, 100, 20);
		lineRadioButton.addActionListener(this);
		eastPanel.add(lineRadioButton);
		
		rectangleRadioButton = new JRadioButton("Rectangle");
		rectangleRadioButton.setBounds(30,320,100,20);
		rectangleRadioButton.addActionListener(this);
		eastPanel.add(rectangleRadioButton);
		
		circleRadioButton = new JRadioButton("Circle");
		circleRadioButton.setBounds(30, 350, 100, 20);
		circleRadioButton.addActionListener(this);
		eastPanel.add(circleRadioButton);
		
		triangleRadioButton = new JRadioButton("Triangle");
		triangleRadioButton.setBounds(30, 380,100,20);
		triangleRadioButton.addActionListener(this);
		eastPanel.add(triangleRadioButton);
		
		shapeGroup = new ButtonGroup();
		shapeGroup.add(triangleRadioButton);
		shapeGroup.add(rectangleRadioButton);
		shapeGroup.add(circleRadioButton);
		shapeGroup.add(lineRadioButton);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == redButton){
			color = Color.RED;
			c = "Red";
		}else if(e.getSource() == orangeButton){
			color = Color.ORANGE;
			c = "Orange";
		}else if(e.getSource() == yellowButton){
			color = Color.YELLOW;
			c = "Yellow";
		}else if(e.getSource() == greenButton){
			color = Color.GREEN;
			c = "Green";
		}else if(e.getSource() == blueButton){
			color = Color.BLUE;
			c = "Blue";
		}else if(e.getSource() == pinkButton){
			color = Color.PINK;
			c = "Pink";
		}else if(e.getSource() == blackButton){
			color = Color.BLACK;
			c = "Black";
		}else if (e.getSource() == shapeRadioButton){
			paintTypeId = 0;
			manageViews();
		}else if (e.getSource() == textRadioButton){
			paintTypeId = 1;
			manageViews();
		}else if(e.getSource() == lineRadioButton){
			shapeId = 0;
		}else if(e.getSource() == rectangleRadioButton){
			shapeId = 1;
		}else if(e.getSource() == circleRadioButton){
			shapeId = 2;
		}else if(e.getSource() == triangleRadioButton){
			shapeId = 3;
		}else if(e.getSource() == boldCheckBox){
			if(italicCheckBox.isSelected()){
				fontStyleId = 2;
			}else{
				fontStyleId = 0;
			}
		}else if(e.getSource() == italicCheckBox){
			if(boldCheckBox.isSelected()){
				fontStyleId = 2;
			}else{
				fontStyleId = 1;
			}
		}else if( e.getSource() == fontComboBox){
			JComboBox combo = (JComboBox) e.getSource();
			fontId = combo.getSelectedIndex();
		}else if(e.getSource() == fontSizeComboBox){
			JComboBox combo1 = (JComboBox) e.getSource();
			fontSizeId = combo1.getSelectedIndex();
		}
		
		/*System.out.println("Paint Type=" + paintTypeId);
		System.out.println("Color = " + c);
		System.out.println("Font Style: " + fontStyleId);
		System.out.println("Shape: " + shapeId);
		System.out.println("Font" + fontId);
		System.out.println("Font Size: " + fontSizeId);*/
	}
}
