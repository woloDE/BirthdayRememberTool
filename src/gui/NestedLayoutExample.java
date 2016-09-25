package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.TitledBorder;

/** A short example of a nested layout that can change PLAF at runtime.
The TitledBorder of each JPanel shows the layouts explicitly set.
@author Andrew Thompson
@version 2011-04-12 */
class NestedLayoutExample {

    public static void main(String[] args) {

        Runnable r = new Runnable() {

            public void run() {
                final JFrame frame = new JFrame("Birthday Connection Tool");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JPanel gui = new JPanel(new BorderLayout(5,5));
                gui.setBorder( new TitledBorder("BorderLayout(5,5)") );

                //JToolBar tb = new JToolBar();
                JPanel plafComponents = new JPanel(
                    new FlowLayout(FlowLayout.RIGHT, 3,3));
                plafComponents.setBorder(
                    new TitledBorder("Add a Brithday") );

                final UIManager.LookAndFeelInfo[] plafInfos =
                    UIManager.getInstalledLookAndFeels();
                String[] plafNames = new String[plafInfos.length];
                for (int ii=0; ii<plafInfos.length; ii++) {
                    plafNames[ii] = plafInfos[ii].getName();
                }
                final JButton addButton = new JButton("Add a birthday");

                addButton.addActionListener( new ActionListener(){
                    public void actionPerformed(ActionEvent ae) {
                       //TODO Action to add a Birthday!
                       
                    }
                } );

                gui.add(addButton, BorderLayout.NORTH);


                
                String[] header = {"Name", "Value"};
                String[] a = new String[0];
                String[] names = System.getProperties().
                    stringPropertyNames().toArray(a);
                String[][] data = new String[names.length][2];
                for (int ii=0; ii<names.length; ii++) {
                    data[ii][0] = names[ii];
                    data[ii][1] = System.getProperty(names[ii]);
                }
                DefaultTableModel model = new DefaultTableModel(data, header);
                JTable table = new JTable(model);
                try {
                    // 1.6+
                    table.setAutoCreateRowSorter(true);
                } catch(Exception continuewithNoSort) {
                }
                JScrollPane tableScroll = new JScrollPane(table);
                Dimension tablePreferred = tableScroll.getPreferredSize();
                tableScroll.setPreferredSize(
                    new Dimension(tablePreferred.width, tablePreferred.height/3) );

                JPanel imagePanel = new JPanel(new GridBagLayout());
                imagePanel.setBorder(
                    new TitledBorder("List of Birthdays") );

                BufferedImage bi = new BufferedImage(
                    200,200,BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = bi.createGraphics();
                GradientPaint gp = new GradientPaint(
                    20f,20f,Color.red, 180f,180f,Color.yellow);
                g.setPaint(gp);
                g.fillRect(0,0,200,200);
                ImageIcon ii = new ImageIcon(bi);
                JLabel imageLabel = new JLabel(ii);
                imagePanel.add( imageLabel, null );

                JSplitPane splitPane = new JSplitPane(
                    JSplitPane.VERTICAL_SPLIT,
                    tableScroll,
                    new JScrollPane(imagePanel));
                gui.add( splitPane, BorderLayout.CENTER );

                frame.setContentPane(gui);

                frame.pack();

                frame.setLocationRelativeTo(null);
                try {
                    // 1.6+
                    frame.setLocationByPlatform(true);
                    frame.setMinimumSize(frame.getSize());
                } catch(Throwable ignoreAndContinue) {
                }

                frame.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}