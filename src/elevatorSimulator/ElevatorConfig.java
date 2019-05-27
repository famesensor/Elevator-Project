/*
 * Created by JFormDesigner on Fri May 17 15:26:05 ICT 2019
 */

package elevatorSimulator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Woottinan Yaemboo
 */
public class ElevatorConfig extends JFrame {

    public ElevatorConfig() {
        initComponents();
    }

    private void SubmitButtonMousePressed(MouseEvent e) {
        Building.MAX_ELEVATORS = getElevatorNumber();
        Building.MAX_FLOORS = getFloorNumber();
        Elevator.MAX_OCCUPANCY = getPersonNumber();
        Simulator.flag = 1;
    }

    private void SubmitButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    private void aboutMouseClicked(MouseEvent e) {
       About about = new About();
       about.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Sitthinon
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        ElevatorNumber = new JSpinner();
        FloorNumber = new JSpinner();
        PersonNumber = new JSpinner();
        SubmitButton = new JButton();
        panel1 = new JPanel();
        about = new JButton();

        //======== this ========
        setBackground(Color.white);
        setResizable(false);
        var contentPane = getContentPane();

        //---- label1 ----
        label1.setText("Elevator Configurations");
        label1.setForeground(Color.white);
        label1.setFont(new Font("Segoe UI", Font.PLAIN, 20));

        //---- label2 ----
        label2.setText("Number of elevators");
        label2.setForeground(Color.white);

        //---- label3 ----
        label3.setText("Number of floors");
        label3.setForeground(Color.white);

        //---- label4 ----
        label4.setText("Maximum persons in elevator");
        label4.setForeground(Color.white);

        //---- ElevatorNumber ----
        ElevatorNumber.setModel(new SpinnerNumberModel(3, 1, 10, 1));
        ElevatorNumber.setForeground(new Color(102, 102, 102));

        //---- FloorNumber ----
        FloorNumber.setModel(new SpinnerNumberModel(10, 5, 15, 1));
        FloorNumber.setBackground(new Color(102, 102, 102));

        //---- PersonNumber ----
        PersonNumber.setModel(new SpinnerNumberModel(15, 5, 20, 1));
        PersonNumber.setBackground(new Color(102, 102, 102));

        //---- SubmitButton ----
        SubmitButton.setText("Submit");
        SubmitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SubmitButtonMouseClicked(e);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                SubmitButtonMousePressed(e);
            }
        });

        //======== panel1 ========
        {
            panel1.setBackground(new Color(51, 51, 51));

            // JFormDesigner evaluation mark
            panel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel1.getBorder())); panel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});

            panel1.setLayout(null);

            //---- About ----
            about.setText("About US");
            about.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    aboutMouseClicked(e);
                }
            });
            panel1.add(about);
            about.setBounds(new Rectangle(new Point(235, 415), about.getPreferredSize()));

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(76, 76, 76)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(ElevatorNumber, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(81, 81, 81)
                            .addComponent(SubmitButton, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(PersonNumber, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(FloorNumber, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(41, 41, 41)
                            .addComponent(label2)))
                    .addGap(52, 52, Short.MAX_VALUE))
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addComponent(label1))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(ElevatorNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(349, 349, 349)
                            .addComponent(SubmitButton, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(label3))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(label4))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(278, 278, 278)
                            .addComponent(PersonNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(202, 202, 202)
                            .addComponent(FloorNumber, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(label2)))
                    .addContainerGap(62, Short.MAX_VALUE))
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Sitthinon
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JSpinner ElevatorNumber;
    private JSpinner FloorNumber;
    private JSpinner PersonNumber;
    private JButton SubmitButton;
    private JPanel panel1;
    private JButton about;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    protected int getElevatorNumber() {
        return (int) ElevatorNumber.getValue();
    }

    protected int getFloorNumber() {
        return (int) FloorNumber.getValue();
    }

    protected int getPersonNumber() {
        return (int) PersonNumber.getValue();
    }

}
