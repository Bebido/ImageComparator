import com.jgoodies.forms.factories.DefaultComponentFactory;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static java.lang.Math.sqrt;

/**
 * @author unknown
 */
public class Gui extends JFrame {

    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JButton compareButton;
    private JTextArea textAreaWynik;
    private boolean imageOneChoosed = false;
    private boolean imageSecondChoosed = false;
    BufferedImage imageFirst;
    BufferedImage imageSecond;

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

        //Create a file chooser
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);

        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File img = new File(String.valueOf(fc.getSelectedFile()));
                imageFirst = ImageIO.read(img);
                Image icon = ImageIO.read(img);
                icon = icon.getScaledInstance(ConstWindow.DISPLAY_IMAGE_WIDTH, ConstWindow.DISPLAY_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                ImageIcon obraz = new ImageIcon(icon);
                getLabel1().setIcon(obraz);
                imageOneChoosed = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void WybierzObraz2(ActionEvent e) {
        final JFileChooser fc = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        fc.setFileFilter(filter);
        int returnVal = fc.showOpenDialog(this);

        try {
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File img = new File(String.valueOf(fc.getSelectedFile()));
                imageSecond = ImageIO.read(img);
                Image icon = ImageIO.read(img);
                icon = icon.getScaledInstance(ConstWindow.DISPLAY_IMAGE_WIDTH, ConstWindow.DISPLAY_IMAGE_HEIGHT, Image.SCALE_DEFAULT);
                ImageIcon obraz = new ImageIcon(icon);
                getLabel2().setIcon(obraz);
                imageSecondChoosed = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void compareActionPerformed(ActionEvent e) {
        if (imageOneChoosed && imageSecondChoosed) {

            DecimalFormat df = new DecimalFormat("#.00");
            ArrayList<ColourProperties> colourProperties = ColourProperties.generateCoordinates();

            Image tmpImage = imageFirst.getScaledInstance(ConstWindow.IMAGE_WIDTH, ConstWindow.IMAGE_HEIGHT, Image.SCALE_DEFAULT);
            imageFirst = toBufferedImage(tmpImage);
            tmpImage = imageSecond.getScaledInstance(ConstWindow.IMAGE_WIDTH, ConstWindow.IMAGE_HEIGHT, Image.SCALE_DEFAULT);
            imageSecond = toBufferedImage(tmpImage);

            double percentageResult = 0;
            textAreaWynik.setText("");

            for (ColourProperties colour : colourProperties) {
                Integer numberOfCompares = 0;
                double difference = 0;

                for (int x = colour.getStartX(); x < colour.getStopX(); x++) {
                    for (int y = colour.getStartY(); y < colour.getStopY(); y++) {
                        difference = difference + getDifferecne(imageFirst, imageSecond, x, y);
                        numberOfCompares++;
                    }
                }
                percentageResult = percentageResult + resultToPercents(difference, numberOfCompares);
                textAreaWynik.append(colour.getColour() + ": " + df.format(resultToPercents(difference, numberOfCompares)) + "%\n");
            }

            textAreaWynik.append("Wynik: " + df.format(percentageResult / 7) + "%");
        }
    }

    private Double resultToPercents(Double difference, Integer numberOfCompares) {
        difference = difference / numberOfCompares;
        difference = difference / 4.41;
        difference = 100 - difference;
        return difference;
    }

    private Double getDifferecne(BufferedImage imageFirst, BufferedImage imageSecond, int x, int y) {
        int red1 = new Color(imageFirst.getRGB(x, y)).getRed();
        int green1 = new Color(imageFirst.getRGB(x, y)).getGreen();
        int blue1 = new Color(imageFirst.getRGB(x, y)).getBlue();
        int red2 = new Color(imageSecond.getRGB(x, y)).getRed();
        int green2 = new Color(imageSecond.getRGB(x, y)).getGreen();
        int blue2 = new Color(imageSecond.getRGB(x, y)).getBlue();

        Double r = (double) (red2 - red1);
        Double g = (double) (green2 - green1);
        Double b = (double) (blue2 - blue1);

        r = Math.pow(r, 2);
        g = Math.pow(g, 2);
        b = Math.pow(b, 2);

        return sqrt(r + g + b);
    }

    private BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage =
                new BufferedImage(
                        img.getWidth(null),
                        img.getHeight(null),
                        BufferedImage.TYPE_INT_ARGB
                );

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
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
        setMinimumSize(new Dimension(ConstWindow.WINDOW_WIDTH, ConstWindow.WINDOW_HEIGHT));
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
        compareButton.setText("Porównaj");
        compareButton.addActionListener(e -> compareActionPerformed(e));

        //---- textAreaWynik ----
        textAreaWynik.setEditable(false);
        textAreaWynik.setRows(8);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, ConstWindow.DISPLAY_IMAGE_WIDTH, GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addGroup(contentPaneLayout.createParallelGroup()
                                                        .addComponent(compareButton)
                                                        .addComponent(textAreaWynik)))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(button1)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, ConstWindow.DISPLAY_IMAGE_WIDTH, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                                .addComponent(button2)
                                                .addGap(10, 10, 10)))
                                .addGap(86, 86, 86))
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                                .addGroup(contentPaneLayout.createParallelGroup()
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addContainerGap(65, Short.MAX_VALUE)
                                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, ConstWindow.DISPLAY_IMAGE_HEIGHT, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, ConstWindow.DISPLAY_IMAGE_HEIGHT, GroupLayout.PREFERRED_SIZE))
                                                .addGap(38, 38, 38))
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(compareButton)
                                                .addGap(27, 27, 27)
                                                .addComponent(textAreaWynik, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)))
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(button1)
                                        .addComponent(button2))
                                .addGap(54, 54, 54))
        );
        setSize(ConstWindow.WINDOW_WIDTH, ConstWindow.WINDOW_HEIGHT);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
