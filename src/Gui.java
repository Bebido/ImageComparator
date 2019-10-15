import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Tue Aug 06 21:11:40 CEST 2019
 */



/**
 * @author unknown
 */
public class Gui extends JFrame {

//    private JButton button1;
//    private JButton button2;
//    private JButton compareButton;
//    private JLabel label1;
//    private JLabel label2;
    private boolean imageOneChoosed = false;
    private boolean imageSecondChoosed = false;
    Gui() {
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
                //////////////////////////////////////////
                File img = new File(String.valueOf(fc.getSelectedFile()));
                BufferedImage in = ImageIO.read(img);
                BufferedImage newImage = new BufferedImage(
                        in.getWidth(), in.getHeight(), BufferedImage.TYPE_INT_RGB);
                newImage.getColorModel();
                newImage.getPropertyNames();
                int color = new Color(in.getRGB(321, 41)).getRed();


                imageOneChoosed = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
                imageSecondChoosed = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JButton getCompareButton() {
        return compareButton;
    }

    public JTextArea getTextAreaWynik() {
        return textAreaWynik;
    }

    private void compareActionPerformed(ActionEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        DefaultComponentFactory compFactory = DefaultComponentFactory.getInstance();
        button1 = new JButton();
        button2 = new JButton();
        label1 = compFactory.createLabel("");
        label2 = compFactory.createLabel("");
        compareButton = new JButton();
        textAreaWynik = new JTextArea();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("ImageComparator");
        setMinimumSize(new Dimension(600, 400));
        var contentPane = getContentPane();

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

        //---- compareButton ----
        compareButton.setText("Por\u00f3wnaj");
        compareButton.addActionListener(e -> compareActionPerformed(e));

        //---- textAreaWynik ----
        textAreaWynik.setText("Wynik:");
        textAreaWynik.setEditable(false);
        textAreaWynik.setRows(1);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(compareButton)
                                .addComponent(textAreaWynik)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(button1)))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
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
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addContainerGap(65, Short.MAX_VALUE)
                            .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
                            .addGap(38, 38, 38))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(99, 99, 99)
                            .addComponent(compareButton)
                            .addGap(27, 27, 27)
                            .addComponent(textAreaWynik, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)))
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(button1)
                        .addComponent(button2))
                    .addGap(54, 54, 54))
        );
        setSize(600, 400);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

//    private void PorownajObrazy(ActionEvent e) {
//        if (imageOneChoosed && imageSecondChoosed) {
//            compareButton.setText("Kocik");
//        }
//    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JButton compareButton;
    private JTextArea textAreaWynik;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
