import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class Visual {
    JFrame frame;
    String[] sortList = {"Bubble Sort", "Quicksort", "Merge Sort"};
    String[] typeList = {"Continuous", "Random"};
    int cells;

    public Visual() {
        initFrame();
    }

    private void initFrame() {
        frame = new JFrame("Sorting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        //frame.setLayout(new );

        //Setting part
        JPanel oPanel = new JPanel();
        JComboBox<String> sortBox = new JComboBox<String>(sortList); //Select algorithm
        sortBox.setSelectedIndex(0);
        JLabel sizeLabel = new JLabel("Size"); //Textbox for array size
        JTextField sizeField = new JTextField(3); //3 Digits
        JLabel leftBoundLabel = new JLabel("Left Bound"); //Left bound
        JTextField lBoundField = new JTextField(6);
        JLabel rightBoundLabel = new JLabel("Right Bound"); //Right bound
        JTextField rBoundField = new JTextField(6);
        JComboBox<String> typeBox = new JComboBox<String>(typeList);
        sortBox.setSelectedIndex(0);
        JButton bSort = new JButton("Sort!");
        //Add
        oPanel.add(sortBox);
        oPanel.add(sizeLabel);
        oPanel.add(sizeField);
        oPanel.add(leftBoundLabel);
        oPanel.add(lBoundField);
        oPanel.add(rightBoundLabel);
        oPanel.add(rBoundField);
        oPanel.add(typeBox);
        oPanel.add(bSort);

        frame.setVisible(true);
    }

    public void updateVisual(int cell) { //Updates 1 cell at a time

    }
    public void initArray(int cells) {

    }
}