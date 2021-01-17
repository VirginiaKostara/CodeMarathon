package codemarathon;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

/**
 * This class includes the graphic representation of the statistics of every covid case.
 * It takes the data from the Statistics class and creates bar graphs based. 
 * on the emploees that had covid-19.
 * @author codemarathon team
 */

public class GraphStats extends JPanel {
  private int histogramHeight = 200;
  private int barWidth = 50;
  private int barGap = 10;

  private JPanel barPanel;
  private JPanel labelPanel;

  private List<Bar> bars = new ArrayList<Bar>();
  /** this is the constructor of the graphics class, it sets the borders and the general.
  * layout of the bar graphs that this class creates based on the statistics of the covid cases.
  */
  
  public GraphStats() { 
    setBorder(new EmptyBorder(10, 10, 10, 10));
    setLayout(new BorderLayout());

    barPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
    Border outer = new MatteBorder(1, 1, 1, 1, Color.BLACK);
    Border inner = new EmptyBorder(10, 10, 0, 10);
    Border compound = new CompoundBorder(outer, inner);
    barPanel.setBorder(compound);

    labelPanel = new JPanel(new GridLayout(1, 0, barGap, 0));
    labelPanel.setBorder(new EmptyBorder(5, 10, 0, 10));

    add(barPanel, BorderLayout.CENTER);
    add(labelPanel, BorderLayout.PAGE_END);
  }

  public void addHistogramColumn(String label, int value, Color color) {
    Bar bar = new Bar(label, value, color);
    bars.add(bar);
  }

  /**this method creates the bars of the chart with mathematical calculation so.
   * it can fit the border 
   */
  
  public void layoutHistogram() {
    barPanel.removeAll();
    labelPanel.removeAll();

    int maxValue = 0;

    for (Bar bar: bars) {
      maxValue = Math.max(maxValue, bar.getValue());
    }
    for (Bar bar: bars) {
      JLabel label = new JLabel(bar.getValue() + "");
      label.setHorizontalTextPosition(JLabel.CENTER);
      label.setHorizontalAlignment(JLabel.CENTER);
      label.setVerticalTextPosition(JLabel.TOP);
      label.setVerticalAlignment(JLabel.BOTTOM);
      int barHeight = (bar.getValue() * histogramHeight) / maxValue;
      Icon icon = new ColorIcon(bar.getColor(), barWidth, barHeight);
      label.setIcon(icon);
      barPanel.add(label);

      JLabel barLabel = new JLabel(bar.getLabel());
      barLabel.setHorizontalAlignment(JLabel.CENTER);
      labelPanel.add(barLabel);
    }
  }

  private class Bar {
    private String label;
    private int value;
    private Color color;

    public Bar(String label, int value, Color color) {
      this.label = label;
      this.value = value;
      this.color = color;
    }

    public String getLabel() {
      return label;
    }

    public int getValue() {
      return value;
    }

    public Color getColor() {
      return color;
    }
  }

  private class ColorIcon implements Icon {
    private int shadow = 3;

    private Color color;
    private int width;
    private int height;

    public ColorIcon(Color color, int width, int height) {
      this.color = color;
      this.width = width;
      this.height = height;
    }

    public int getIconWidth() {
      return width;
    }

    public int getIconHeight() {
      return height;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
      g.setColor(color);
      g.fillRect(x, y, width - shadow, height);
      g.setColor(Color.GRAY);
      g.fillRect(x + width - shadow, y + shadow, shadow, height - shadow);
    }
  }

  static void createAndShowGuitmimata() {
    GraphStats panel = new GraphStats();
    panel.addHistogramColumn("Λογιστήριο", (int) Statistics.logistirio(), Color.RED);
    panel.addHistogramColumn("Μάρκετινγκ", (int) Statistics.marketing(), Color.YELLOW);
    panel.addHistogramColumn("IT", (int) Statistics.it(), Color.BLUE);
    panel.addHistogramColumn("Ανθρώπινο Δυναμικό", (int) Statistics.humanResources(), Color.ORANGE);
    panel.addHistogramColumn("Καθαριότητα", (int) Statistics.cleaning(), Color.MAGENTA);
    panel.addHistogramColumn("Πωλήσεις", (int) Statistics.sales(), Color.CYAN);
    panel.addHistogramColumn("Διεύθυνση", (int) Statistics.dieuthunsh(), Color.DARK_GRAY);
    panel.addHistogramColumn("Εξυπηρέτηση Πελατών", 
          (int) Statistics.customerService(), Color.GREEN);
    panel.addHistogramColumn("Δημόσιες Σχέσεις", (int) Statistics.pr(), Color.LIGHT_GRAY);
    panel.addHistogramColumn("Εκπαίδευση", (int) Statistics.edu(), Color.BLACK);
    panel.layoutHistogram();
        

    JFrame frame = new JFrame("Ποσοστό κρουσμάτων ανα τμήμα (στρογγυλοποιημένο)");
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.add(panel);
    frame.setLocationByPlatform(true);
    frame.pack();
    frame.setVisible(true);
  }
  
  static void createAndShowGuifilo() {
    GraphStats panel2 = new GraphStats();
    panel2.addHistogramColumn("Γυναίκες", (int) Statistics.women(), Color.RED);
    panel2.addHistogramColumn("Άνδρες", (int) Statistics.men(), Color.BLUE);
    panel2.layoutHistogram();
    JFrame frame = new JFrame("Ποσοστό κρουσμάτων ανα φύλο (στρογγυλοποιημένο)");
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.add(panel2);
    frame.setLocationByPlatform(true);
    frame.pack();
    frame.setVisible(true);
  }
  
  static void createAndShowGuimm() {
    GraphStats panel3 = new GraphStats();
    panel3.addHistogramColumn("Λεωφορείο 1", (int) Statistics.bus1Covid(), Color.RED);
    panel3.addHistogramColumn("Λεωφορείο 2", (int) Statistics.bus2Covid(), Color.BLUE);
    panel3.addHistogramColumn("Ατομικό Μέσο", (int) Statistics.atomikomesoCovid(), Color.GREEN);
    panel3.layoutHistogram();
    JFrame frame = new JFrame("Ποσοστό κρουσμάτων ανα μέσο μεταφοράς (στρογγυλοποιημένο)");
    frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    frame.add(panel3);
    frame.setLocationByPlatform(true);
    frame.pack();
    frame.setVisible(true);
  }
    
  static void createAndShowGuitotal() {
    JFrame frame = new JFrame(); 
    frame.setTitle(""); 
    frame.setResizable(false); 
    frame.setSize(650, 150);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true); 
    frame.getContentPane().setBackground(new Color(203, 239, 240)); 
    JLabel label = new JLabel(); 
    label.setText("Το ποσοστό κρουσμάτων Covid ανα εργαζόμενο είναι: " 
                           + Statistics.totalCovid() + "%");
    label.setFont(new Font("", Font.BOLD, 15));
    label.setVerticalAlignment(JLabel.CENTER); 
    label.setHorizontalAlignment(JLabel.CENTER); 
    frame.add(label);
  }
    
}
