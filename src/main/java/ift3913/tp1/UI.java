package ift3913.tp1;

import ift3913.tp1.metrics.MetricsBuilder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import ift3913.tp1.parser.ModelParser;
import ift3913.tp1.parser.ast.Aggregation;
import ift3913.tp1.parser.ast.Association;
import ift3913.tp1.parser.ast.Generalization;
import ift3913.tp1.parser.ast.Klass;
import ift3913.tp1.parser.ast.Model;

public class UI {
    private JList<String> jListClasses;
    private JList<String> jListAttributes;
    private JList<String> jListMethods;
    private JList<String> jListSubclasses;
    private JList<String> jListAssociationsAndAggregations;
    private JTextArea jTextAreaDetails;
    private Model m;
    private ArrayList<Klass> klassArray = new ArrayList<Klass>();

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
        jTextAreaDetails = new JTextArea();
        appPanel.add(jTextAreaDetails);
        jTextAreaDetails.setEditable(true);
        jTextAreaDetails.setSize(355, 110);
        jTextAreaDetails.setLocation(215, 430);
        jTextAreaDetails.setText("");
        jTextAreaDetails.setVisible(true);
        jTextAreaDetails.setEditable(false);

        JScrollPane jTextAreaDetailsScrollPane = new JScrollPane(jTextAreaDetails, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jTextAreaDetailsScrollPane.setSize(355, 110);
        jTextAreaDetailsScrollPane.setLocation(215, 430);
        appPanel.add(jTextAreaDetailsScrollPane);
        jTextAreaDetailsScrollPane.setVisible(true);

        /*JLists Initialization*/
        //JList Classes
        jListClasses = new JList<String>();
        appPanel.add(jListClasses);
        jListClasses.setSize(140, 400);
        jListClasses.setLocation(25, 140);
        jListClasses.setVisible(true);

        jListClasses.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (m != null) {
                    jTextAreaDetails.setText("");
                    String selectedClass = jListClasses.getSelectedValue();
                    MetricsBuilder.computeMetrics(m, selectedClass).print();
                    fillAttributes(selectedClass);
                    fillMethods(selectedClass);
                    fillGeneralization(selectedClass);
                    fillAssociationAndAggregations(selectedClass);
                }
            }
        });

        //jListClasses ScrollPane
        JScrollPane jListClassesScrollPane = new JScrollPane(jListClasses, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListClassesScrollPane.setSize(160, 400);
        jListClassesScrollPane.setLocation(25, 140);
        appPanel.add(jListClassesScrollPane);
        jListClassesScrollPane.setVisible(true);

        //JList Attributes
        jListAttributes = new JList<String>();
        appPanel.add(jListAttributes);
        jListAttributes.setSize(160, 110);
        jListAttributes.setLocation(215, 140);
        jListAttributes.setVisible(true);

        //jListClasses ScrollPane
        JScrollPane jListAttributesScrollPane = new JScrollPane(jListAttributes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListAttributesScrollPane.setSize(160, 110);
        jListAttributesScrollPane.setLocation(215, 140);
        appPanel.add(jListAttributesScrollPane);
        jListAttributesScrollPane.setVisible(true);

        //JList Methods
        jListMethods = new JList<String>();
        appPanel.add(jListMethods);
        jListMethods.setSize(160, 110);
        jListMethods.setLocation(410, 140);
        jListMethods.setVisible(true);

        //jListMethods ScrollPane
        JScrollPane jListMethodsScrollPane = new JScrollPane(jListMethods, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListMethodsScrollPane.setSize(160, 110);
        jListMethodsScrollPane.setLocation(410, 140);
        appPanel.add(jListMethodsScrollPane);
        jListMethodsScrollPane.setVisible(true);

        //JList Subclasses
        jListSubclasses = new JList<String>();
        appPanel.add(jListSubclasses);
        jListSubclasses.setSize(160, 80);
        jListSubclasses.setLocation(215, 300);
        jListSubclasses.setVisible(true);

        //jListClasses ScrollPane
        JScrollPane jListSubclassesScrollPane = new JScrollPane(jListSubclasses, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListSubclassesScrollPane.setSize(160, 80);
        jListSubclassesScrollPane.setLocation(215, 300);
        appPanel.add(jListSubclassesScrollPane);
        jListSubclassesScrollPane.setVisible(true);

        //JList Associations/Aggregations
        jListAssociationsAndAggregations = new JList<String>();
        appPanel.add(jListAssociationsAndAggregations);
        jListAssociationsAndAggregations.setSize(160, 80);
        jListAssociationsAndAggregations.setLocation(410, 300);
        jListAssociationsAndAggregations.setVisible(true);

        jListAssociationsAndAggregations.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (m != null && jListAssociationsAndAggregations.getModel().getSize() != 0) {
                    String selection = jListAssociationsAndAggregations.getSelectedValue();
                    String selectedClass = jListClasses.getSelectedValue();
                    fillDetailsAggregationsAndAssociations(selectedClass, selection);
                }
            }
        });

        //jListAssociationsAndAggregations ScrollPane
        JScrollPane jListAssociationsAndAggregationsScrollPane = new JScrollPane(jListAssociationsAndAggregations, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jListAssociationsAndAggregationsScrollPane.setSize(160, 80);
        jListAssociationsAndAggregationsScrollPane.setLocation(410, 300);
        appPanel.add(jListAssociationsAndAggregationsScrollPane);
        jListAssociationsAndAggregationsScrollPane.setVisible(true);

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
                JFileChooser openFileFileChooser = new JFileChooser(".");
                FileNameExtensionFilter openFileFileNameExtensionFilter = new FileNameExtensionFilter("UML files only (.ucd)", "ucd");

                //Limits the imported files to uml files only (.ucd)
                openFileFileChooser.addChoosableFileFilter(openFileFileNameExtensionFilter);
                openFileFileChooser.setFileFilter(openFileFileNameExtensionFilter);
                openFileFileChooser.setAcceptAllFileFilterUsed(false);
                openFileFileChooser.setDialogTitle("Importation d'un fichier uml");

                if (openFileFileChooser.showOpenDialog(appFrame) == JFileChooser.APPROVE_OPTION) {
                    //If the user chose a file, write the absolute path unto openFileTextField
                    String path = openFileFileChooser.getSelectedFile().getAbsolutePath();
                    textFieldPath.setText(path);
                    m = null;
                    String data = "";
                    try {
                    	erasePrevious();
                        data = new String(Files.readAllBytes(Paths.get(path)), "UTF-8");
                        m = ModelParser.parseModel(data);
                        fillClasses();
                    } catch (Exception ex) {
                    	JOptionPane.showMessageDialog(appFrame, "Error! The input file might be corrupted.");
                    }
                }
            }
        });
    }

    private void erasePrevious(){
    	//Empty the klassArray and jTextAreaDetails
    	klassArray = new ArrayList<Klass>();
    	jListClasses.setListData(new String[0]);
    	jListAttributes.setListData(new String[0]);
    	jListMethods.setListData(new String[0]);
    	jListSubclasses.setListData(new String[0]);
    	jListAssociationsAndAggregations.setListData(new String[0]);
    	jTextAreaDetails.setText("");
    }
    
    private void fillClasses() {
        /*Classes filler*/
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (int i = 0; i < m.declarations.size(); i++) {
            if (m.declarations.get(i) instanceof Klass) {
                Klass k = (Klass) m.declarations.get(i);
                klassArray.add(k);
                listModel.addElement(k.name);
            }
        }
        this.jListClasses.setModel(listModel);
    }

    private void fillAttributes(String selectedClass) {
        //Attributes filler
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (int i = 0; i < klassArray.size(); i++) {
            Klass k = klassArray.get(i);
            if (selectedClass.equals(k.name)) {
                for (int j = 0; j < k.attributes.size(); j++) {
                    listModel.addElement(k.attributes.get(j).type + " " + k.attributes.get(j).ident);
                }
            }
        }
        this.jListAttributes.setModel(listModel);
    }

    private void fillMethods(String selectedClass) {
        //Methods filler
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (int i = 0; i < klassArray.size(); i++) {
            Klass k = klassArray.get(i);
            if (selectedClass.equals(k.name)) {
                for (int j = 0; j < k.operations.size(); j++) {
                    String s = "";
                    for (int h = 0; h < k.operations.get(j).args.size(); h++) {
                        if (h == 0) {
                            s = k.operations.get(j).args.get(h).type;
                        } else {
                            s = s + ", " + k.operations.get(j).args.get(h).type;
                        }
                    }
                    listModel.addElement(k.operations.get(j).type + " " + k.operations.get(j).name + "(" + s + ")");
                }
            }
        }
        this.jListMethods.setModel(listModel);
    }

    private void fillGeneralization(String selectedClass) {
        //Generalization filler
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (int i = 0; i < m.declarations.size(); i++) {
            if (m.declarations.get(i) instanceof Generalization) {
                Generalization g = (Generalization) m.declarations.get(i);
                if (selectedClass.equals(g.name)) {
                    for (int j = 0; j < g.subclasses.size(); j++) {
                        listModel.addElement(g.subclasses.get(j));
                    }
                }
            }
        }
        this.jListSubclasses.setModel(listModel);
    }

    private void fillAssociationAndAggregations(String selectedClass) {
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (int i = 0; i < m.declarations.size(); i++) {
            if (m.declarations.get(i) instanceof Association) {
                //Association filler
                Association a = (Association) m.declarations.get(i);
                if (selectedClass.equals(a.role_1.name) || selectedClass.equals(a.role_2.name)) {
                    listModel.addElement("(R) " + a.name);
                }
            } else if (m.declarations.get(i) instanceof Aggregation) {
                //Aggregation filler
                Aggregation a = (Aggregation) m.declarations.get(i);
                if (selectedClass.equals(a.single.name)) {
                    //Then the roles are part
                    for (int j = 0; j < a.roles.size(); j++) {
                        listModel.addElement("(A) P_" + a.roles.get(j).name);
                    }
                } else {
                    //Then there are none or they are containers
                    for (int j = 0; j < a.roles.size(); j++) {
                        if (selectedClass.equals(a.roles.get(j).name)) {
                            listModel.addElement("(A) C_" + a.single.name);
                        }
                    }
                }
            }
        }
        this.jListAssociationsAndAggregations.setModel(listModel);
    }

    private void fillDetailsAggregationsAndAssociations(String selectedClass, String selection) {
        try {
            String detailedString = "";
            switch (selection.charAt(1)) {
                case 'A':
                    //S'il s'agit d'une aggregation
                    for (int i = 0; i < m.declarations.size(); i++) {
                        if (m.declarations.get(i) instanceof Aggregation) {
                            Aggregation a = (Aggregation) m.declarations.get(i);
                            switch (selection.charAt(4)) {
                                case 'C':
                                    detailedString = aggregationDetails(selectedClass, selection.substring(6), a);
                                    break;
                                case 'P':
                                    detailedString = aggregationDetails(selection.substring(6), selectedClass, a);
                                    break;
                            }
                        }
                    }
                    break;
                case 'R':
                    //S'il s'agit d'une relation
                    Association association = new Association();
                    for (int i = 0; i < m.declarations.size(); i++) {
                        if (m.declarations.get(i) instanceof Association) {
                            Association a = (Association) m.declarations.get(i);
                            if (selection.substring(4).equals(a.name)) {
                                association = a;
                            }
                        }
                    }

                    detailedString = detailedString + "RELATION\n   ROLES\n     CLASS " + association.role_1.name + " " + association.role_1.multiplicity
                            + "\n     CLASS " + association.role_2.name + " " + association.role_2.multiplicity;
                    break;
            }
            jTextAreaDetails.setText(detailedString);
        } catch (Exception e) {
            System.out.println("An error occured trying to read the details for Association/Aggregations List.");
        }

    }

    private String aggregationDetails(String s1, String s2, Aggregation a) {
        //Uses the correct aggregation form
        boolean roleFound = false;
        String detailedString = "";
        for (int j = 0; j < a.roles.size(); j++) {
            if (s1.equals(a.roles.get(j).name)) {
                roleFound = true;
            }
        }
        if (s2.equals(a.single.name)
                && roleFound) {
            detailedString = detailedString + "AGGREGATION\n   CONTAINER\n"
                    + "     CLASS " + a.single.name + " " + a.single.multiplicity
                    + "\n   PARTS\n";
            for (int j = 0; j < a.roles.size(); j++) {
                detailedString = detailedString + "     CLASS " + a.roles.get(j).name + " " + a.roles.get(j).multiplicity + "\n";
            }
        }
        return detailedString;
    }
}
