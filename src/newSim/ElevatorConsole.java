/*
 * Created by JFormDesigner on Fri May 10 22:35:52 ICT 2019
 */

package newSim;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.WindowEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 * @author tee konwich
 */
public class ElevatorConsole extends JFrame {

    public ElevatorConsole() {
        initComponents();
    }

    private void slider1StateChanged(ChangeEvent e) {

        Simulator.timestate = slider1.getValue();
        System.out.println(Simulator.timestate);

    }

    private void slider1MousePressed(MouseEvent e) {
        // TODO add your code here
    }

    //    private void slider1MousePressed(MouseEvent e) {
//        if (e.getSource() == slider1) {
//            Simulator.timestate = slider1.getValue();
//            System.out.println(Simulator.timestate);
//        }
//    }
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Satit
        Config = new JPanel();
        label1 = new JLabel();
        panel1 = new JPanel();
        clock = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel2 = new JPanel();
        label5 = new JLabel();
        panel3 = new JPanel();
        label6 = new JLabel();
        panel4 = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        panel5 = new JPanel();
        slider1 = new JSlider();
        Working = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== Config ========
        {
            Config.setForeground(Color.white);
            Config.setBackground(Color.darkGray);

            // JFormDesigner evaluation mark
            Config.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), Config.getBorder()));
            Config.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });


            //---- label1 ----
            label1.setText("Elevator Display");
            label1.setFont(new Font("Segoe UI", Font.PLAIN, 16));
            label1.setHorizontalAlignment(SwingConstants.CENTER);
            label1.setForeground(Color.white);

            //======== panel1 ========
            {
                panel1.setBackground(Color.white);
                panel1.setBorder(new LineBorder(Color.black, 2));

                //---- clock ----
                clock.setText("text");
                clock.setHorizontalAlignment(SwingConstants.CENTER);
                clock.setForeground(Color.black);

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addComponent(clock, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addComponent(clock, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                );
            }

            //---- label2 ----
            label2.setText("Number of elevators");
            label2.setForeground(Color.white);

            //---- label3 ----
            label3.setText("Number of floors");
            label3.setForeground(Color.white);

            //---- label4 ----
            label4.setText("Maximum persons in elevator");
            label4.setForeground(Color.white);

            //======== panel2 ========
            {
                panel2.setBackground(Color.white);

                //---- label5 ----
                label5.setText("3");
                label5.setBackground(Color.white);
                label5.setForeground(Color.black);

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label5, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                        panel2Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(label5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
                );
            }

            //======== panel3 ========
            {
                panel3.setBackground(Color.white);

                //---- label6 ----
                label6.setText("10");
                label6.setForeground(Color.black);

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label6, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                );
                panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                                .addComponent(label6, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                );
            }

            //======== panel4 ========
            {
                panel4.setBackground(Color.white);

                //---- label7 ----
                label7.setBackground(Color.black);
                label7.setForeground(Color.black);
                label7.setText("15");

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(label7, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                );
                panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                                .addComponent(label7, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                );
            }

            //---- label8 ----
            label8.setText("Speed of time");
            label8.setForeground(Color.white);

            //======== panel5 ========
            {
                panel5.setBorder(new LineBorder(Color.white));
                panel5.setBackground(Color.darkGray);
                panel5.setForeground(new Color(51, 51, 51));

                //---- slider1 ----
                slider1.setBackground(Color.darkGray);
                slider1.setForeground(new Color(102, 102, 102));
                slider1.setMajorTickSpacing(200);
                slider1.setOrientation(SwingConstants.VERTICAL);
                slider1.setMaximum(1000);
                slider1.setPaintLabels(true);
                slider1.setPaintTicks(true);
                slider1.setSnapToTicks(true);
                slider1.setValue(1000);
                slider1.setMinimum(200);
                slider1.addChangeListener(e -> slider1StateChanged(e));
                slider1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        slider1MousePressed(e);
                    }
                });

                GroupLayout panel5Layout = new GroupLayout(panel5);
                panel5.setLayout(panel5Layout);
                panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(slider1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(18, Short.MAX_VALUE))
                );
                panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(slider1, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                );
            }

            GroupLayout ConfigLayout = new GroupLayout(Config);
            Config.setLayout(ConfigLayout);
            ConfigLayout.setHorizontalGroup(
                    ConfigLayout.createParallelGroup()
                            .addComponent(label1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(ConfigLayout.createSequentialGroup()
                                    .addGroup(ConfigLayout.createParallelGroup()
                                            .addGroup(ConfigLayout.createSequentialGroup()
                                                    .addGap(68, 68, 68)
                                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGroup(ConfigLayout.createSequentialGroup()
                                                    .addGap(18, 18, 18)
                                                    .addGroup(ConfigLayout.createParallelGroup()
                                                            .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label2)
                                                            .addComponent(label3)
                                                            .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label4)
                                                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(label8)
                                                            .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                                    .addContainerGap(60, Short.MAX_VALUE))
            );
            ConfigLayout.setVerticalGroup(
                    ConfigLayout.createParallelGroup()
                            .addGroup(ConfigLayout.createSequentialGroup()
                                    .addGap(29, 29, 29)
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label4)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(panel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(16, 16, 16)
                                    .addComponent(label8)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
        }

        //======== Working ========
        {
            Working.setBackground(Color.white);

            GroupLayout WorkingLayout = new GroupLayout(Working);
            Working.setLayout(WorkingLayout);
            WorkingLayout.setHorizontalGroup(
                    WorkingLayout.createParallelGroup()
                            .addGap(0, 779, Short.MAX_VALUE)
            );
            WorkingLayout.setVerticalGroup(
                    WorkingLayout.createParallelGroup()
                            .addGap(0, 0, Short.MAX_VALUE)
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addComponent(Config, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(Working, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, 0))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(Config, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Working, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Satit
    private JPanel Config;
    private JLabel label1;
    private JPanel panel1;
    private JLabel clock;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JPanel panel2;
    private JLabel label5;
    private JPanel panel3;
    private JLabel label6;
    private JPanel panel4;
    private JLabel label7;
    private JLabel label8;
    private JPanel panel5;
    private JSlider slider1;
    private JPanel Working;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Building building;
    private int totalWaiting;
    private int totalRiding;
    private JLabel uCableGrid[][];
    private JLabel lCableGrid[][];
    private JLabel fCableGrid[][];
    private JLabel floorInd[];
    private JLabel floorImg[];
    private JLabel floorLabel[];
    private JLabel floorStatus[];
    private JLabel floorStatusImg[];
    private int[] elevatorLocations;
    private Container theContainer;
    private Insets inset;
    private JFrame frame;
    private JFrame frameConfig;
    private ElevatorConsole GUI;
    private ElevatorConfig ConfigGUI;

    public ElevatorConsole(String source) {
        configGUI();
        while (Simulator.flag == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        try {
            Thread.sleep(250);
            frameConfig.setVisible(false);
        } catch (InterruptedException e) {
        }
        setUpGUI();
    }

    public void setBuilding(Building theBuilding) {
        building = theBuilding;
    }

    public void updateDisplay() {
        updateFloors();
        updateElevators();
        updateCounters();
    }

    private void updateCounters() {
        GUI.clock.setText(Time.getTime_run());
    }

    private void updateFloors() {
        totalWaiting = 0;
        ImageIcon imagefloor = new ImageIcon(ElevatorConsole.class.getResource("/img/floor.png"));
        ImageIcon imagecircle = new ImageIcon(ElevatorConsole.class.getResource("/img/circle.png"));
        ImageIcon imagecircle_up = new ImageIcon(ElevatorConsole.class.getResource("/img/circle_up.png"));
        ImageIcon imagecircle_down = new ImageIcon(ElevatorConsole.class.getResource("/img/circle_down.png"));
        int up = 0;
        int down = 0;
        for (int i = 0; i < floorLabel.length; i++) {
            up = building.getNumberWaitingUp(i + 1);
            down = building.getNumberWaitingDown(i + 1);
            totalWaiting += up;
            totalWaiting += down;

            floorLabel[i].setText("Floor " + (i + 1));
            GUI.Working.add(floorLabel[i]);
            floorLabel[i].setBounds(15, ((-(i) * 28) + 523), 100, 25);

            floorStatus[i].setText(up + "                " + down);
            GUI.Working.add(floorStatus[i]);
            floorStatus[i].setBounds(104, ((-(i) * 28) + 523), 100, 25);

            floorImg[i].setIcon(imagefloor);
            GUI.Working.add(floorImg[i]);
            floorImg[i].setBounds(15, ((-(i) * 28) + 519), (building.MAX_ELEVATORS * 60) + 150, 30);

            int state = building.getFloorStatus(i + 1);

//            if (state == 1) {
//                floorStatusImg[i].setIcon(imagecircle_up);
//                GUI.Working.add(floorStatusImg[i]);
//                floorStatusImg[i].setBounds(65, ((-(i) * 28) + 523), 100, 25);
//                building.setFloorStatus(0, i+1);
//            } else if (state == -1) {
//                floorStatusImg[i].setIcon(imagecircle_down);
//                GUI.Working.add(floorStatusImg[i]);
//                floorStatusImg[i].setBounds(65, ((-(i) * 28) + 523), 100, 25);
//                building.setFloorStatus(0, i+1);
//            } else {
                floorStatusImg[i].setIcon(imagecircle);
                GUI.Working.add(floorStatusImg[i]);
                floorStatusImg[i].setBounds(65, ((-(i) * 28) + 523), 100, 25);
                building.setFloorStatus(0, i+1);
//            }
        }
    }

    private void updateElevators() {
        ElevatorState state = null;
        ImageIcon imageblack_up = new ImageIcon(ElevatorConsole.class.getResource("/img/up.png"));
        ImageIcon imageblack_dn = new ImageIcon(ElevatorConsole.class.getResource("/img/down.png"));
        ImageIcon imageblack = new ImageIcon(ElevatorConsole.class.getResource("/img/still.png"));
        ImageIcon imagewhite = new ImageIcon(ElevatorConsole.class.getResource("/img/white.png"));
        ImageIcon imageopen = new ImageIcon(ElevatorConsole.class.getResource("/img/dooropen.png"));

        int currentFloor = 0;

        int f = 0;
        totalRiding = 0;
        String directionInd = new String();
        for (int e = 0; e < building.MAX_ELEVATORS; e++) {
            state = building.getElevatorState(e + 1);
            totalRiding += state.numberRiders;
            currentFloor = state.currentFloorNumber; //TODO: update elevator floor
            f = e + 1;

            floorInd[e].setText(String.valueOf(currentFloor));
            GUI.Working.add(floorInd[e]);//
            floorInd[e].setBounds(e * 60 + 180, ((-(Building.MAX_FLOORS) * 28) + 520), 30, 30); //TODO: Set Y

            if (elevatorLocations[e] != currentFloor) {
                elevatorLocations[e] = currentFloor;
                if (currentFloor > 1) {
                    for (f = currentFloor - 1; f >= 0; f--) {

                        uCableGrid[e][f].setIcon(imagewhite);
                        GUI.Working.add(uCableGrid[e][f]);
                        uCableGrid[e][f].setBounds(e * 60 + 180, ((-(f) * 28) + 520), 30, 30);

                        fCableGrid[e][f].setIcon(imagewhite);
                        GUI.Working.add(fCableGrid[e][f]);
                        fCableGrid[e][f].setBounds(e * 60 + 180, ((-(f) * 28) + 520), 30, 30);

                        lCableGrid[e][f].setText("  ");
                        GUI.Working.add(lCableGrid[e][f]);
                        lCableGrid[e][f].setBounds(e * 60 + 200, ((-(f) * 28) + 520), 30, 30);
                    }
                }
                if (currentFloor < Building.MAX_FLOORS) {
                    for (f = currentFloor; f < Building.MAX_FLOORS; f++) {

                        uCableGrid[e][f].setIcon(imagewhite);
                        GUI.Working.add(uCableGrid[e][f]);
                        uCableGrid[e][f].setBounds(e * 60 + 180, ((-(f) * 28) + 520), 30, 30);

                        fCableGrid[e][f].setIcon(imagewhite);
                        GUI.Working.add(fCableGrid[e][f]);
                        fCableGrid[e][f].setBounds(e * 60 + 180, ((-(f) * 28) + 520), 30, 30);

                        lCableGrid[e][f].setText("  ");
                        GUI.Working.add(lCableGrid[e][f]);
                        lCableGrid[e][f].setBounds(e * 60 + 200, ((-(f) * 28) + 520), 30, 30);
                    }
                }
            }

            switch (state.motionDirection) {
                case Elevator.DOOR_OPEN:
                    uCableGrid[e][currentFloor - 1].setIcon(imageopen);
                    GUI.Working.add(uCableGrid[e][currentFloor - 1]);
                    uCableGrid[e][currentFloor - 1].setBounds(e * 60 + 180, ((-(currentFloor - 1) * 28) + 520), 30, 30);
                    break;
                case Elevator.DOOR_CLOSED:
                    uCableGrid[e][currentFloor - 1].setIcon(imageopen);
                    GUI.Working.add(uCableGrid[e][currentFloor - 1]);
                    uCableGrid[e][currentFloor - 1].setBounds(e * 60 + 180, ((-(currentFloor - 1) * 28) + 520), 30, 30);
                    break;
                case Elevator.NO_DIRECTION:
                    uCableGrid[e][currentFloor - 1].setIcon(imageblack);
                    GUI.Working.add(uCableGrid[e][currentFloor - 1]);
                    uCableGrid[e][currentFloor - 1].setBounds(e * 60 + 180, ((-(currentFloor - 1) * 28) + 520), 30, 30);
                    break;
                case Elevator.MOVING_UP:
                    uCableGrid[e][currentFloor - 1].setIcon(imageblack_up);
                    GUI.Working.add(uCableGrid[e][currentFloor - 1]);
                    uCableGrid[e][currentFloor - 1].setBounds(e * 60 + 180, ((-(currentFloor - 1) * 28) + 520), 30, 30);
                    break;
                case Elevator.MOVING_DOWN:
                    uCableGrid[e][currentFloor - 1].setIcon(imageblack_dn);
                    GUI.Working.add(uCableGrid[e][currentFloor - 1]);
                    uCableGrid[e][currentFloor - 1].setBounds(e * 60 + 180, ((-(currentFloor - 1) * 28) + 520), 30, 30);
                    break;
            }

            lCableGrid[e][currentFloor - 1].setText(String.valueOf(state.numberRiders));
            GUI.Working.add(lCableGrid[e][currentFloor - 1]);
            lCableGrid[e][currentFloor - 1].setBounds(e * 60 + 200, ((-(currentFloor - 1) * 28) + 520), 30, 30);

        }
    }

    private void configGUI() {
        frameConfig = new JFrame("ConfigGUI");
        ConfigGUI = new ElevatorConfig();
        frameConfig.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameConfig.setContentPane(ConfigGUI.getContentPane());
        frameConfig.pack();
        frameConfig.setLocationRelativeTo(null);
        frameConfig.setVisible(true);
        frameConfig.setTitle("Elevator Simulator");
        frameConfig.setResizable(false);
    }

    private void setUpGUI() {
        frame = new JFrame("GUI");
        GUI = new ElevatorConsole();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(GUI.getContentPane());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setTitle("Elevator Simulator");
        frame.setResizable(false);

        GUI.label5.setText(String.valueOf(Building.MAX_ELEVATORS));
        GUI.label6.setText(String.valueOf(Building.MAX_FLOORS));
        GUI.label7.setText(String.valueOf(Elevator.MAX_OCCUPANCY));

        ImageIcon imageblack = new ImageIcon(ElevatorConsole.class.getResource("/img/still.png"));
        ImageIcon imagewhite = new ImageIcon(ElevatorConsole.class.getResource("/img/white.png"));
        ImageIcon imagefloor = new ImageIcon(ElevatorConsole.class.getResource("/img/floor.png"));
        ImageIcon imagecircle = new ImageIcon(ElevatorConsole.class.getResource("/img/circle.png"));

        elevatorLocations = new int[Building.MAX_ELEVATORS];

        uCableGrid = new JLabel[Building.MAX_FLOORS][Building.MAX_FLOORS];
        lCableGrid = new JLabel[Building.MAX_FLOORS][Building.MAX_FLOORS];
        fCableGrid = new JLabel[Building.MAX_FLOORS][Building.MAX_FLOORS];
        floorInd = new JLabel[Building.MAX_ELEVATORS];

        for (int e = 0; e < Building.MAX_ELEVATORS; e++) {
            lCableGrid[e][0] = new JLabel("  ", JLabel.CENTER);
            uCableGrid[e][0] = new JLabel(imageblack, JLabel.CENTER);
            fCableGrid[e][0] = new JLabel(imageblack, JLabel.CENTER);
            floorInd[e] = new JLabel("1", JLabel.CENTER);
            for (int f = 1; f < Building.MAX_FLOORS; f++) {
                lCableGrid[e][f] = new JLabel("  ", JLabel.CENTER);
                uCableGrid[e][f] = new JLabel(imagewhite, JLabel.CENTER);
                fCableGrid[e][f] = new JLabel(imagewhite, JLabel.CENTER);
            }
        }

        floorImg = new JLabel[Building.MAX_FLOORS];
        floorLabel = new JLabel[Building.MAX_FLOORS];
        floorStatus = new JLabel[Building.MAX_FLOORS];
        floorStatusImg = new JLabel[Building.MAX_FLOORS];
        for (int i = 0; i < Building.MAX_FLOORS; i++) {
            floorLabel[i] = new JLabel("" + (i + 1));
            floorImg[i] = new JLabel(imagefloor, JLabel.CENTER);
            floorStatus[i] = new JLabel("");
            floorStatusImg[i] = new JLabel(imagecircle, JLabel.CENTER);
        }
    }
}
