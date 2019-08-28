import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Visual extends JFrame {

    Canvas c;
    int width, delta;
    
    String[] sortList = {"Bubble Sort", "Quicksort", "Merge Sort"};
    String[] typeList = {"Continuous", "Random"};

    JComboBox<String> sortBox;
    JComboBox<String> typeBox;

    JButton startButton;

    String sortType, arrayType;
    int size, lBound, rBound;

    //25 pixels from the edge of the screen
    int[] cellArray;

    public Visual() {
        super("Sorting");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1050, 625);

        //Canvas?
        c = new Canvas() {
            public void paint(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(25, 25, 100, 100);
            }
        };
        c.setBackground(Color.BLACK);

        //Setting part
        JPanel oPanel = new JPanel();

        JButton updateButton = new JButton("Apply");

        sortBox = new JComboBox<String>(sortList); //Select algorithm
        sortBox.setSelectedIndex(0);
    
        JLabel sizeLabel = new JLabel("Size"); //Textbox for array size
        JTextField sizeField = new JTextField(3); //3 Digits;
        JLabel leftBoundLabel = new JLabel("Left Bound"); //Left bound
        JTextField lBoundField = new JTextField(6);
        JLabel rightBoundLabel = new JLabel("Right Bound"); //Right bound
        JTextField rBoundField = new JTextField(6);

        ActionListener doUpdate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                size = Integer.parseInt(sizeField.getText());
                lBound = Integer.parseInt(lBoundField.getText());
                rBound = Integer.parseInt(rBoundField.getText());
                sortType = sortBox.getItemAt(sortBox.getSelectedIndex());
                arrayType = typeBox.getItemAt(typeBox.getSelectedIndex());
            }
        };
        updateButton.addActionListener(doUpdate);

        typeBox = new JComboBox<String>(typeList);
        typeBox.setSelectedIndex(0);

        startButton = new JButton("Sort!");

        //Add
        oPanel.add(updateButton);
        oPanel.add(sortBox);
        oPanel.add(sizeLabel);
        oPanel.add(sizeField);
        oPanel.add(leftBoundLabel);
        oPanel.add(lBoundField);
        oPanel.add(rightBoundLabel);
        oPanel.add(rBoundField);
        oPanel.add(typeBox);
        oPanel.add(startButton);

        add(c);
        add(BorderLayout.SOUTH, oPanel);

        setVisible(true);
    }

    public void initCells(int size, int low, int high) {
        cellArray = new int[size];
    }

    JLabel sizeLabel = new JLabel();

    public void prepare() {
        while (!startButton.isSelected()) {
            initArray(c.getGraphics());
        }
    }

    public void updateVisual(int cell) { //Updates 1 cell at a time
        Graphics g = c.getGraphics();

        g.setColor(Color.WHITE);


    }

    public void initArray(Graphics g) {
        cellArray = new int[size];

        g.setColor(Color.WHITE);

        for (int i = 0; i < cellArray.length; i++) {
            g.fillRect(25+5*i, 575+15*i, 10, 575-15*i);
            System.out.println("kms");
        }
    }
}