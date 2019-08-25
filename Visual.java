import java.awt.*;
import javax.swing.*;

public class Visual {
    JFrame frame;
    Canvas c;
    
    String[] sortList = {"Bubble Sort", "Quicksort", "Merge Sort"};
    String[] typeList = {"Continuous", "Random"};

    JComboBox<String> sortBox;
    JTextField sizeField;
    JTextField lBoundField;
    JTextField rBoundField;
    JComboBox<String> typeBox;
    JButton startButton;

    String sortType, arrayType;
    int size, lBound, rBound;

    int[] cellArray;
    int cells;

    public Visual() {
        initFrame();
    }

    private void initFrame() {
        frame = new JFrame("Sorting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);

        //Canvas?
        c = new Canvas() {
            public void paint(Graphics g) {}
        };
        //c.setBackground(Color.BLACK);

        //Setting part
        JPanel oPanel = new JPanel();
        sortBox = new JComboBox<String>(sortList); //Select algorithm
        sortBox.setSelectedIndex(0);
        JLabel sizeLabel = new JLabel("Size"); //Textbox for array size
        sizeField = new JTextField(3); //3 Digits
        JLabel leftBoundLabel = new JLabel("Left Bound"); //Left bound
        lBoundField = new JTextField(6);
        JLabel rightBoundLabel = new JLabel("Right Bound"); //Right bound
        rBoundField = new JTextField(6);
        typeBox = new JComboBox<String>(typeList);
        sortBox.setSelectedIndex(0);
        startButton = new JButton("Sort!");

        //Add
        oPanel.add(sortBox);
        oPanel.add(sizeLabel);
        oPanel.add(sizeField);
        oPanel.add(leftBoundLabel);
        oPanel.add(lBoundField);
        oPanel.add(rightBoundLabel);
        oPanel.add(rBoundField);
        oPanel.add(typeBox);
        oPanel.add(startButton);

        frame.add(c);
        frame.add(BorderLayout.SOUTH, oPanel);

        frame.setVisible(true);
    }

    public void initCells(int size, int low, int high) {
        cellArray = new int[size];
    }

    JLabel sizeLabel = new JLabel();

    public void prepare() {
        while (!startButton.isSelected()) {
            try {
                sortType = sortBox.getItemAt(sortBox.getSelectedIndex());
                size = Integer.parseInt(sizeField.getText());
                lBound = Integer.parseInt(lBoundField.getText());
                rBound = Integer.parseInt(rBoundField.getText());
                arrayType = typeBox.getItemAt(typeBox.getSelectedIndex());
            }
            catch (Exception e) {
                continue;
            }

            System.out.println(size);
            sizeLabel.setText(String.valueOf(size));
            frame.add(BorderLayout.CENTER, sizeLabel);
        }
    }

    public void updateVisual(int cell) { //Updates 1 cell at a time
        Graphics g = c.getGraphics();

        g.setColor(Color.WHITE);


    }
    
    public void initArray(int cells) {

    }
}