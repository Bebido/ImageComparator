import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.forms.factories.*;
import net.miginfocom.swing.*;
import sun.swing.ImageIconUIResource;
/*
 * Created by JFormDesigner on Tue Aug 06 21:11:40 CEST 2019
 */



/**
 * @author unknown
 */
public class Gui extends JFrame {
    public Gui() {
        initComponents();
    }

    public JButton getButton1() {
        return button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public JLabel getLabel1() {
        return label1;
    }

    public JLabel getLabel2() {
        return label2;
    }

    private void WybierzObraz1(ActionEvent e) {
        // TODO add your code here

        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);

        ImageIcon obraz = null;
        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                obraz = new ImageIcon(fc.getSelectedFile().toURL());
                getLabel1().setIcon(obraz);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /////////////////////////////

//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & GIF Images", "jpg", "gif");
//        chooser.setFileFilter(filter);
//        int returnVal = chooser.showOpenDialog(parent);
//        if(returnVal == JFileChooser.APPROVE_OPTION) {
//            System.out.println("You chose to open this file: " +
//                    chooser.getSelectedFile().getName());
//        }

//        try {
//            Runtime.getRuntime().exec("explorer.exe /select," + "/");
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    private void WybierzObraz2(ActionEvent e) {
        // TODO add your code here
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);

        ImageIcon obraz = null;
        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                obraz = new ImageIcon(fc.getSelectedFile().toURL());
                getLabel2().setIcon(obraz);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        button1 = new JButton();
        button2 = new JButton();
        label1 = compFactory.createLabel("");
        label2 = compFactory.createLabel("");

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ImageComparator");
        setMinimumSize(new Dimension(600, 400));
        Container contentPane = getContentPane();

        //---- button1 ----
        button1.setText("Wybierz obraz");
        button1.addActionListener(e -> WybierzObraz1(e));

        //---- button2 ----
        button2.setText("Wybierz obraz");
        button2.addActionListener(e -> WybierzObraz2(e));

        //---- label1 ----
        label1.setBorder(LineBorder.createBlackLineBorder());

        //---- label2 ----
        label2.setBorder(LineBorder.createBlackLineBorder());

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(button1)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                            .addComponent(button2)
                            .addGap(10, 10, 10)))
                    .addGap(93, 93, 93))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap(65, Short.MAX_VALUE)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                    .addGap(38, 38, 38)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(54, 54, 54))
        );
        setSize(600, 400);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
