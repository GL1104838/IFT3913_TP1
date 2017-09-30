package ift3913.tp1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class UI {

    public void buildUI() {
		/*
		 * Swing initialization
		 */

        //JFrame Initialization
        JFrame appFrame = new JFrame();
        appFrame.setTitle("UML Parser");
        appFrame.setSize(600, 600);
        appFrame.setLocationRelativeTo(null);
        appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appFrame.setResizable(false);
        appFrame.setVisible(true);

        //JPanel Initialization
        JPanel appPanel = new JPanel();
        appFrame.add(appPanel);
        appPanel.setLayout(null);
        appPanel.setSize(600, 600);
        appPanel.setVisible(true);

        //JTextField Initialization
        JTextField textFieldPath = new JTextField();
        appPanel.add(textFieldPath);
        textFieldPath.setText("");
        textFieldPath.setEnabled(false);
        textFieldPath.setSize(400, 25);
        textFieldPath.setLocation(25, 60);
        textFieldPath.setVisible(true);

		/*JLabel Initialization*/

        JLabel jlabelClasses = new JLabel();
        appPanel.add(jlabelClasses);
        jlabelClasses.setSize(150, 50);
        jlabelClasses.setLocation(25, 100);
        jlabelClasses.setText("Classes");
        jlabelClasses.setVisible(true);

        JLabel jlabelAttributes = new JLabel();
        appPanel.add(jlabelAttributes);
        jlabelAttributes.setSize(150, 50);
        jlabelAttributes.setLocation(215, 100);
        jlabelAttributes.setText("Attributes");
        jlabelAttributes.setVisible(true);

        JLabel jlabelMethods = new JLabel();
        appPanel.add(jlabelMethods);
        jlabelMethods.setSize(150, 50);
        jlabelMethods.setLocation(410, 100);
        jlabelMethods.setText("Methods");
        jlabelMethods.setVisible(true);

        JLabel jlabelSubclasses = new JLabel();
        appPanel.add(jlabelSubclasses);
        jlabelSubclasses.setSize(150, 50);
        jlabelSubclasses.setLocation(215, 260);
        jlabelSubclasses.setText("Subclasses");
        jlabelSubclasses.setVisible(true);

        JLabel jlabelAssociationsAndAggregations = new JLabel();
        appPanel.add(jlabelAssociationsAndAggregations);
        jlabelAssociationsAndAggregations.setSize(180, 50);
        jlabelAssociationsAndAggregations.setLocation(410, 260);
        jlabelAssociationsAndAggregations.setText("Associations/Aggregations");
        jlabelAssociationsAndAggregations.setVisible(true);

        JLabel jlabelTextAreaDetails = new JLabel();
        appPanel.add(jlabelTextAreaDetails);
        jlabelTextAreaDetails.setSize(150, 50);
        jlabelTextAreaDetails.setLocation(215, 390);
        jlabelTextAreaDetails.setText("Details");
        jlabelTextAreaDetails.setVisible(true);

		/*JTextArea Initialization*/
        JTextArea jTextAreaDetails = new JTextArea();
        appPanel.add(jTextAreaDetails);
        jTextAreaDetails.setEditable(true);
        jTextAreaDetails.setSize(355, 110);
        jTextAreaDetails.setLocation(215, 430);
        jTextAreaDetails.setText("");
        jTextAreaDetails.setVisible(true);
        jTextAreaDetails.setEditable(false);

        JScrollPane jTextAreaDetailsScrollPane = new JScrollPane (jTextAreaDetails, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTextAreaDetailsScrollPane.setSize(355, 110);
        jTextAreaDetailsScrollPane.setLocation(215, 430);
        appPanel.add(jTextAreaDetailsScrollPane);
        jTextAreaDetailsScrollPane.setVisible (true);

		/*JLists Initialization*/

        //JList Classes
        JList<String> jListClasses = new JList<String>();
        appPanel.add(jListClasses);
        jListClasses.setSize(140, 400);
        jListClasses.setLocation(25, 140);
        jListClasses.setVisible(true);

        //jListClasses ScrollPane
        JScrollPane jListClassesScrollPane = new JScrollPane (jListClasses, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListClassesScrollPane.setSize(160, 400);
        jListClassesScrollPane.setLocation(25, 140);
        appPanel.add(jListClassesScrollPane);
        jListClassesScrollPane.setVisible (true);

        //JList Attributes
        JList<String> jListAttributes = new JList<String>();
        appPanel.add(jListAttributes);
        jListAttributes.setSize(160, 110);
        jListAttributes.setLocation(215, 140);
        jListAttributes.setVisible(true);

        //jListClasses ScrollPane
        JScrollPane jListAttributesScrollPane = new JScrollPane (jListAttributes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListAttributesScrollPane.setSize(160, 110);
        jListAttributesScrollPane.setLocation(215, 140);
        appPanel.add(jListAttributesScrollPane);
        jListAttributesScrollPane.setVisible (true);

        //JList Methods
        JList<String> jListMethods = new JList<String>();
        appPanel.add(jListMethods);
        jListMethods.setSize(160, 110);
        jListMethods.setLocation(410, 140);
        jListMethods.setVisible(true);

        //jListMethods ScrollPane
        JScrollPane jListMethodsScrollPane = new JScrollPane (jListMethods, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListMethodsScrollPane.setSize(160, 110);
        jListMethodsScrollPane.setLocation(410, 140);
        appPanel.add(jListMethodsScrollPane);
        jListMethodsScrollPane.setVisible (true);

        //JList Subclasses
        JList<String> jListSubclasses = new JList<String>();
        appPanel.add(jListSubclasses);
        jListSubclasses.setSize(160, 80);
        jListSubclasses.setLocation(215, 300);
        jListSubclasses.setVisible(true);

        //jListClasses ScrollPane
        JScrollPane jListSubclassesScrollPane = new JScrollPane (jListSubclasses, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListSubclassesScrollPane.setSize(160, 80);
        jListSubclassesScrollPane.setLocation(215, 300);
        appPanel.add(jListSubclassesScrollPane);
        jListSubclassesScrollPane.setVisible (true);

        //JList Associations/Aggregations
        JList<String> jListAssociationsAndAggregations = new JList<String>();
        appPanel.add(jListAssociationsAndAggregations);
        jListAssociationsAndAggregations.setSize(160, 80);
        jListAssociationsAndAggregations.setLocation(410, 300);
        jListAssociationsAndAggregations.setVisible(true);

        //jListAssociationsAndAggregations ScrollPane
        JScrollPane jListAssociationsAndAggregationsScrollPane = new JScrollPane (jListAssociationsAndAggregations, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListAssociationsAndAggregationsScrollPane.setSize(160, 80);
        jListAssociationsAndAggregationsScrollPane.setLocation(410, 300);
        appPanel.add(jListAssociationsAndAggregationsScrollPane);
        jListAssociationsAndAggregationsScrollPane.setVisible (true);

        //JButton Initialization
        JButton btnOpenFile = new JButton();
        appPanel.add(btnOpenFile);
        btnOpenFile.setSize(120, 25);
        btnOpenFile.setLocation(450, 60);
        btnOpenFile.setText("Open File...");
        btnOpenFile.setVisible(true);
        btnOpenFile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //Initialize JFileChooser and FileNameExtensionFilter
                JFileChooser openFileFileChooser = new JFileChooser();
                FileNameExtensionFilter openFileFileNameExtensionFilter = new FileNameExtensionFilter("UML files only (.ucd)", "ucd");

                //Limits the imported files to uml files only (.ucd)
                openFileFileChooser.addChoosableFileFilter(openFileFileNameExtensionFilter);
                openFileFileChooser.setFileFilter(openFileFileNameExtensionFilter);
                openFileFileChooser.setAcceptAllFileFilterUsed(false);
                openFileFileChooser.setDialogTitle("Importation d'un fichier uml");

                if(openFileFileChooser.showOpenDialog(appFrame) == JFileChooser.APPROVE_OPTION){
                    //If the user chose a file, write the absolute path unto openFileTextField
                    textFieldPath.setText(openFileFileChooser.getSelectedFile().getAbsolutePath());
                }
            }
        });



		/*Temporary Form Filler*/
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for(int i=0;i<50;i++){
            String s = "Class " + i;
            listModel.addElement(s);
        }
        jListClasses.setModel(listModel);

        listModel = new DefaultListModel<String>();
        for(int i=0;i<20;i++){
            String s = "Attribute " + i;
            listModel.addElement(s);
        }
        jListAttributes.setModel(listModel);

        listModel = new DefaultListModel<String>();
        for(int i=0;i<20;i++){
            String s = "Method " + i;
            listModel.addElement(s);
        }
        jListMethods.setModel(listModel);

        listModel = new DefaultListModel<String>();
        for(int i=0;i<20;i++){
            String s = "Subclass " + i;
            listModel.addElement(s);
        }
        jListSubclasses.setModel(listModel);

        listModel = new DefaultListModel<String>();
        for(int i=0;i<20;i++){
            String s = "Association " + i;
            listModel.addElement(s);
            s = "Aggregation " + i;
            listModel.addElement(s);
        }
        jListAssociationsAndAggregations.setModel(listModel);

        jTextAreaDetails.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\nDuis at rutrum risus. Donec nec aliquam justo, ac faucibus orci.\nDonec urna velit, vestibulum vitae mauris eu, lobortis efficitur odio. Vestibulum id ante vel nisi porta viverra eget vitae nibh.\nUt blandit placerat turpis nec euismod.");
		/*End Temporary Form filler*/
    }

}
