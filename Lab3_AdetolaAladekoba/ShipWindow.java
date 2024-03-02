/*
 * Name: Adetola Aladekoba
 * Last Modified: 02/21/2024
 * purpose: Third lab: Creating a GUI which displays ship information on each 
   ship selected, practice using listeners and applying inheritance
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class ShipWindow extends JFrame 
{
    private int win_wid = 650;
    private int win_hei = 240;
    private int gridRows = 3;
    private int gridCols = 2;
    
    ArrayList<Ship> flotilla;
    
    JTextField nameText, nationText, yearText, lenText, drafText, beamText;
   
    JComboBox selectShipBox;
    
    public ShipWindow()
    {
        this.setTitle("Shipping News         Adetola Aladekoba");
        this.setSize(win_wid, win_hei) ;
        this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        
        initializeShips("Tia_RosasFleet.csv") ;
        initInfoPanel();
        initSelectPanel();
        initButtonPan();
        initClearButton();
       
        this.setVisible(true);
    }
    
    private void initAddNewShip() 
    {
        String shipName = nameText.getText();
        String nation = nationText.getText();
        int year = Integer.parseInt(yearText.getText());
        int length = Integer.parseInt(lenText.getText());
        int draft = Integer.parseInt(drafText.getText());
        int beam = Integer.parseInt(beamText.getText());

        String fileName = "Tia_RosasFleet.csv";
        File file = new File (fileName);

        try 
        {
            FileWriter fileWriter = new FileWriter(file,true);
            
            fileWriter.write("\n"+shipName+",");
            fileWriter.write(nation+",");
            fileWriter.write(year+",");
            fileWriter.write(length+",");
            fileWriter.write(draft+",");
            fileWriter.write(beam+"");
            fileWriter.close();
            
            selectShipBox.addItem(shipName);
            flotilla.add(new Ship(shipName, nation, year,
                    length, draft, beam));
        } 

        catch (IOException ioe) 
        {
            System.err.println("Error writing to the file");
        }
    }

    private void initSelectedShip(String shipPicked)
    {
        for( int dex = 0; dex<flotilla.size();dex++)
        {
           if(shipPicked.equals(flotilla.get(dex).getName()))
           {
               nameText.setText(flotilla.get(dex).getName());
               nationText.setText(flotilla.get(dex).getNation());
               yearText.setText(String.valueOf(flotilla.get(dex).
                       getYearBuilt()));
               lenText.setText(String.valueOf(flotilla.get(dex).
                       getLength()));
               drafText.setText(String.valueOf(flotilla.get(dex).
                       getDraft()));
               beamText.setText(String.valueOf(flotilla.get(dex).
                       getBeam()));   
           }
        }
    }
    
    private void initializeShips(String filePath)
    {
        flotilla = new ArrayList<>();
        File inFile = new File (filePath);
        
        try 
        {
            Scanner inScan = new Scanner(inFile).useDelimiter(
                     "[,\n]");
            while (inScan.hasNext())
            {   
                String name = inScan.next();
                String nation = inScan.next();
                int year = inScan.nextInt();
                int length = inScan.nextInt();
                int draft = inScan.nextInt();
                int beam = inScan.nextInt();

                Ship ship = new Ship(name, nation, year, 
                            length, draft, beam);
                flotilla.add(ship);
             }
         }
        
        catch (IOException ioe) 
        {
            String error_message = "###########################################"
                   + "####" +"Trouble reading data from:" + filePath + "\n" +
                    "This program is ending" +
                    "###############################################";
            System.err.print(error_message);
            System.exit(0);
        }
    }
         
    private void initClearButton()
    {
        nameText.setText("");
        nationText.setText("");
        yearText.setText("");
        lenText.setText("");
        drafText.setText("");
        beamText.setText("");
    }
    
    public void initButtonPan()
    {
        JPanel south_panel = new JPanel();
        JButton clear_button = new JButton("Clear");
        JButton quit_button = new JButton("Quit");
        JButton add_ship_button = new JButton("Add Ship"); 

        clear_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                initClearButton();
            }
        });
         
        quit_button.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
             }
        });
        
        add_ship_button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                initAddNewShip();
            }
        });
         
        south_panel.add(clear_button);
        south_panel.add(quit_button);
        south_panel.add (add_ship_button);

        this.add (south_panel,BorderLayout.SOUTH) ;
        
    }
   
    private void initInfoPanel()
    {
        JPanel center_pan = new JPanel(new GridLayout(gridRows,
                gridCols));
        
        JLabel ship_label = new JLabel("Ship Name: ");
        JLabel country_label = new JLabel("Country of Registration: ");
        JLabel year_construct_label = new JLabel("Year of Construction: ");
        JLabel length_label = new JLabel ("Length at waterline: ");
        JLabel draft_label = new JLabel("Draft at waterline: ");
        JLabel beam_label = new JLabel("Beam at waterline ");
        
        nameText = new JTextField();
        nationText = new JTextField();
        yearText = new JTextField();
        lenText = new JTextField();
        drafText = new JTextField();
        beamText = new JTextField();
        
        center_pan.add (ship_label); 
        center_pan.add (nameText);
        center_pan.add (length_label);
        center_pan.add (lenText);
        center_pan.add (country_label);
        center_pan.add (nationText);
        center_pan.add (draft_label) ;
        center_pan.add (drafText); 
        center_pan.add (year_construct_label);
        center_pan.add (yearText);
        center_pan.add (beam_label);
        center_pan.add (beamText); 
        
        ship_label. setHorizontalAlignment (JLabel.RIGHT); 
        draft_label.setHorizontalAlignment (JLabel.RIGHT);
        year_construct_label.setHorizontalAlignment (JLabel.RIGHT); 
        length_label.setHorizontalAlignment (JLabel.RIGHT); 
        country_label.setHorizontalAlignment (JLabel.RIGHT) ;
        beam_label.setHorizontalAlignment (JLabel.RIGHT) ;
        
        this.add (center_pan, BorderLayout.CENTER);
    }
    
    private void initSelectPanel()
    {
        int font_Size = 26;
        Font bigFont = new Font ("Arial", 1, font_Size);
        JLabel lab = new JLabel("Select a ship");
        lab.setFont (bigFont);
        
        selectShipBox = new JComboBox();
        selectShipBox.addItemListener(new ItemListener(){
            public void itemStateChanged (ItemEvent ie)  
            {
                String shipPicked = (String)ie.getItem();
                initSelectedShip( shipPicked);
            }
        });
        String[] shipList = new String [flotilla.size()];
        
        for( int dex = 0; dex<flotilla.size();dex++)
        {
            shipList[dex] = flotilla.get(dex).getName();
        }
        selectShipBox.setModel(new javax.swing.DefaultComboBoxModel<>
        (shipList)) ;
        
        ImageIcon icon = new ImageIcon ("Yacht_big.png");
        
        int scalex = 164, scaley = 82;
        
        JLabel iconLab = new JLabel(){
            public void paintComponent (Graphics g)
            {
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, scalex, scaley, 
                        this);
            }
        };
        
        iconLab. setPreferredSize(new Dimension (scalex, scaley));
        iconLab.setIcon(icon);
        
        JPanel northPan = new JPanel();
        
        northPan. add (iconLab);
        
        northPan.add (lab);
        northPan.add ( selectShipBox);
        this. add (northPan, BorderLayout. NORTH) ;
    }
    
    public static void main (String[] args)
    {
        ShipWindow aw = new ShipWindow();
    }
}
