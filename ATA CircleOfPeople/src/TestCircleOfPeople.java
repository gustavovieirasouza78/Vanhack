import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestCircleOfPeople extends JFrame implements ActionListener {
	
	JTextField circleSize;
	JTextField personToRemove;
	JTextArea printResult;	

	public static void main(String[] args) {
		TestCircleOfPeople testCircleOfPeople = new TestCircleOfPeople();
		testCircleOfPeople.init();

	}

	public void init() {
		JFrame window = new JFrame("ATA Remove from Circle");
		window.setLocation(100, 100);
		JPanel panel = new JPanel();

		circleSize = new JTextField(4);
		personToRemove = new JTextField(2);

		JButton removeButton = new JButton("Remove!");

		printResult = new JTextArea(20, 50);
		JScrollPane scrollPane = new JScrollPane(printResult); 
		printResult.setEditable(false);		
		
		removeButton.addActionListener(this);
		
		panel.setName("ATA Circle Of People");
		panel.add(new JLabel("People: \n"));
		panel.add(circleSize);
		panel.add(new JLabel("Position to Remove: \n"));
		panel.add(personToRemove);
		panel.add(removeButton);
		panel.add(scrollPane);

		window.add(panel);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		printResult.setText(null);
		
		CircleOfPeople circleOfPeople = new CircleOfPeople(circleSize, personToRemove, printResult);

		List<Integer> circle = circleOfPeople.createCircle();

		if(circle!=null){
			circleOfPeople.removePeople(circle);
		}


	}

}
