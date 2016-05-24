import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CircleOfPeople {

	private int circleSize;
	private int personToRemove;
	private int removeCount = 1;	
	
	JTextField circleSize2;
	JTextField personToRemove2;
	JTextArea printResult;

	
	public CircleOfPeople(JTextField circleSize2, JTextField personToRemove2, JTextArea printResult) {
		this.circleSize2 = circleSize2;
		this.personToRemove2 = personToRemove2;
		this.printResult = printResult;
	}

	public int getCircleSize() {
		return circleSize;
	}

	public int getPersonToRemove() {
		return personToRemove;
	}

	public int getRemoveCount() {
		return removeCount;
	}

	public void setRemoveCount(int removeCount) {
		this.removeCount = removeCount;
	}



	public void removePeople(List<Integer> circle) {
		int contador = 0;
		int removed = 0;
		
		print("\n");
		print("Now we will remove always the " + personToRemove + "º we found on the circle!");
		print("\n");		
		
		while (circleSize > removed) {
			// Put 0 on contador variable when its in the same time from the
			// circle, its make the while work like a circle
			if (contador >= circleSize)
				contador = 0;

			if (circle.get(contador) == -1) { // if value of position is -1, it's already removed, so go next.
				contador++;

			} else {

				if (!getRemove()) { // its not time to remove

					if (circleSize == removed + 1) { // its the last one on the circle! CONGRATS!!! :) :p
						print("   *** LAST PERSON:  " + circle.get(contador) + " ***   ");
						break;
					}
					//print("   Person " + circle.get(contador) + " NOT removed!");
					contador++;

				} else {
					if (circleSize == removed + 1) { // its the last one on the circle! CONGRATS!!! :) :p
						print("   *** LAST PERSON:  " + circle.get(contador) + " ***   ");
						break;

					} else { // remove position, sorry! :(
						print(" Person " + circle.get(contador) + " removed!");
						circle.set(contador, -1);
						contador++;
						removed++;
					}

				}
			}
		}
	}

	public List<Integer> createCircle() {
		
		try{
			circleSize = new Integer(circleSize2.getText());
			personToRemove = new Integer(personToRemove2.getText());
		}catch (Exception e) {
			print("Insert only positive number!");
			return null;
		}
		
		List<Integer> circle = new ArrayList<>(circleSize);

		// put people on the circle
		print("First we create a circle whith " + circleSize + " positions.");
		for (int i = 0; i < circleSize; i++) {
			circle.add(i, (i + 1));
			//print(" >Put person " + (i + 1) + " on the circle!");
		}
		return circle;
	}

	private boolean getRemove() {
		if (removeCount == personToRemove) {
			removeCount = 1;
			return true;
		} else {
			removeCount++;
			return false;
		}
	}
	
	public void print(String text){
		printResult.setText(printResult.getText() + "\n" + text);
	}
	
}
