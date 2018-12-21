package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import controller.PartieController;
import model.Mot;
import model.Partie;
import javax.swing.border.LineBorder;

public class PartieVueGUI extends PartieVue implements ActionListener{

	private JPanel contentPane;
	private JFrame frame;
	private JLabel nbJoueurs;
	private JLabel essaiRest;
	private JLabel nbLettres;
	private JLabel proposition;
	private JLabel joueur1;
	private JLabel points1;
	private JLabel joueur2;
	private JLabel points2;
	private JLabel joueurActuel;
	private JTextField fieldEssaiRest;
	private JTextField fieldJoueurAct;
	private JTextField fieldPoints1;
	private JTextField fieldPoints2;
	private JPanel panel;
	private JTable table;
	private JTextField fieldNbJoueurs;
	private JTextField fieldNbLettres;
	private JPanel panel_1;
	private JLabel areaMessage;
	private JTextArea textArea;
	private JTextField pseudo1;
	private JTextField pseudo2;
	private JTextField fieldPropo;
	private JPanel panel_2;
	private JButton valider;
	private JLabel lblChrono;
	private JTextField textField;
	
	private Timer timer = new Timer(1000, this); 
	protected int timerCount = 0;
	
	private Object[][] data;
	private JPanel panel_3;

	/**
	 * Constructeur de la frame
	 */
	public PartieVueGUI(Partie model, PartieController controller) {
		
		super(model, controller);
		initGUI();
	}
	
	
	public void initGUI() {
		frame = new JFrame("Partie");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manue\\Documents\\GitHub\\ProjetJAVA2018\\ProjetAPP\\motus-france-2-pourquoi-les-emissions-du-samedi-sont-elles-des-rediffusions.jpg"));
		frame.setTitle("Motus");
		frame.setForeground(new Color(224, 255, 255));
		frame.setFont(new Font("Castellar", Font.PLAIN, 12));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 640, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setForeground(Color.BLACK);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 15;
		gbc_panel_3.gridheight = 5;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		contentPane.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{35, 128, 136, 89, 26, 110, 49, 87, 44, 87, 44, 11, 56, 59, 17, 92, 45, 136, 52, 0};
		gbl_panel_3.rowHeights = new int[]{26, 26, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		nbLettres = new JLabel("Nombre de lettres:");
		GridBagConstraints gbc_nbLettres = new GridBagConstraints();
		gbc_nbLettres.anchor = GridBagConstraints.WEST;
		gbc_nbLettres.insets = new Insets(0, 0, 5, 5);
		gbc_nbLettres.gridx = 1;
		gbc_nbLettres.gridy = 0;
		panel_3.add(nbLettres, gbc_nbLettres);
		nbLettres.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldNbLettres = new JTextField();
		GridBagConstraints gbc_fieldNbLettres = new GridBagConstraints();
		gbc_fieldNbLettres.anchor = GridBagConstraints.NORTHWEST;
		gbc_fieldNbLettres.insets = new Insets(0, 0, 5, 5);
		gbc_fieldNbLettres.gridwidth = 2;
		gbc_fieldNbLettres.gridx = 2;
		gbc_fieldNbLettres.gridy = 0;
		panel_3.add(fieldNbLettres, gbc_fieldNbLettres);
		fieldNbLettres.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldNbLettres.setBackground(Color.WHITE);
		fieldNbLettres.setEditable(false);
		fieldNbLettres.setColumns(10);
		
		essaiRest = new JLabel("Essais restants: ");
		GridBagConstraints gbc_essaiRest = new GridBagConstraints();
		gbc_essaiRest.anchor = GridBagConstraints.WEST;
		gbc_essaiRest.insets = new Insets(0, 0, 5, 5);
		gbc_essaiRest.gridx = 5;
		gbc_essaiRest.gridy = 0;
		panel_3.add(essaiRest, gbc_essaiRest);
		essaiRest.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldEssaiRest = new JTextField();
		GridBagConstraints gbc_fieldEssaiRest = new GridBagConstraints();
		gbc_fieldEssaiRest.anchor = GridBagConstraints.NORTHEAST;
		gbc_fieldEssaiRest.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEssaiRest.gridwidth = 2;
		gbc_fieldEssaiRest.gridx = 6;
		gbc_fieldEssaiRest.gridy = 0;
		panel_3.add(fieldEssaiRest, gbc_fieldEssaiRest);
		fieldEssaiRest.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldEssaiRest.setBackground(Color.WHITE);
		fieldEssaiRest.setEditable(false);
		fieldEssaiRest.setColumns(10);
		
		nbJoueurs = new JLabel("Nombre de joueurs:");
		GridBagConstraints gbc_nbJoueurs = new GridBagConstraints();
		gbc_nbJoueurs.anchor = GridBagConstraints.WEST;
		gbc_nbJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_nbJoueurs.gridx = 1;
		gbc_nbJoueurs.gridy = 1;
		panel_3.add(nbJoueurs, gbc_nbJoueurs);
		nbJoueurs.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldNbJoueurs = new JTextField();
		GridBagConstraints gbc_fieldNbJoueurs = new GridBagConstraints();
		gbc_fieldNbJoueurs.anchor = GridBagConstraints.NORTHWEST;
		gbc_fieldNbJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_fieldNbJoueurs.gridx = 2;
		gbc_fieldNbJoueurs.gridy = 1;
		panel_3.add(fieldNbJoueurs, gbc_fieldNbJoueurs);
		fieldNbJoueurs.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldNbJoueurs.setBackground(Color.WHITE);
		fieldNbJoueurs.setColumns(10);
		
		joueurActuel = new JLabel("Joueur Actuel:");
		GridBagConstraints gbc_joueurActuel = new GridBagConstraints();
		gbc_joueurActuel.anchor = GridBagConstraints.WEST;
		gbc_joueurActuel.insets = new Insets(0, 0, 5, 5);
		gbc_joueurActuel.gridx = 5;
		gbc_joueurActuel.gridy = 1;
		panel_3.add(joueurActuel, gbc_joueurActuel);
		joueurActuel.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldJoueurAct = new JTextField();
		GridBagConstraints gbc_fieldJoueurAct = new GridBagConstraints();
		gbc_fieldJoueurAct.gridwidth = 2;
		gbc_fieldJoueurAct.anchor = GridBagConstraints.NORTHWEST;
		gbc_fieldJoueurAct.insets = new Insets(0, 0, 5, 5);
		gbc_fieldJoueurAct.gridx = 6;
		gbc_fieldJoueurAct.gridy = 1;
		panel_3.add(fieldJoueurAct, gbc_fieldJoueurAct);
		fieldJoueurAct.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldJoueurAct.setBackground(Color.WHITE);
		fieldJoueurAct.setEditable(false);
		fieldJoueurAct.setColumns(10);
		
		joueur1 = new JLabel("Joueur1: ");
		GridBagConstraints gbc_joueur1 = new GridBagConstraints();
		gbc_joueur1.anchor = GridBagConstraints.WEST;
		gbc_joueur1.insets = new Insets(0, 0, 5, 5);
		gbc_joueur1.gridx = 1;
		gbc_joueur1.gridy = 2;
		panel_3.add(joueur1, gbc_joueur1);
		joueur1.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		pseudo1 = new JTextField();
		GridBagConstraints gbc_pseudo1 = new GridBagConstraints();
		gbc_pseudo1.anchor = GridBagConstraints.NORTHWEST;
		gbc_pseudo1.insets = new Insets(0, 0, 5, 5);
		gbc_pseudo1.gridwidth = 3;
		gbc_pseudo1.gridx = 2;
		gbc_pseudo1.gridy = 2;
		panel_3.add(pseudo1, gbc_pseudo1);
		pseudo1.setFont(new Font("Dialog", Font.PLAIN, 15));
		pseudo1.setBackground(Color.WHITE);
		pseudo1.setColumns(10);
		
		points1 = new JLabel("Points:");
		GridBagConstraints gbc_points1 = new GridBagConstraints();
		gbc_points1.anchor = GridBagConstraints.WEST;
		gbc_points1.insets = new Insets(0, 0, 5, 5);
		gbc_points1.gridx = 5;
		gbc_points1.gridy = 2;
		panel_3.add(points1, gbc_points1);
		points1.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldPoints1 = new JTextField();
		GridBagConstraints gbc_fieldPoints1 = new GridBagConstraints();
		gbc_fieldPoints1.anchor = GridBagConstraints.NORTHWEST;
		gbc_fieldPoints1.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPoints1.gridwidth = 2;
		gbc_fieldPoints1.gridx = 6;
		gbc_fieldPoints1.gridy = 2;
		panel_3.add(fieldPoints1, gbc_fieldPoints1);
		fieldPoints1.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldPoints1.setBackground(Color.WHITE);
		fieldPoints1.setEditable(false);
		fieldPoints1.setColumns(10);
		
		joueur2 = new JLabel("Joueur2:");
		GridBagConstraints gbc_joueur2 = new GridBagConstraints();
		gbc_joueur2.anchor = GridBagConstraints.WEST;
		gbc_joueur2.insets = new Insets(0, 0, 5, 5);
		gbc_joueur2.gridx = 1;
		gbc_joueur2.gridy = 3;
		panel_3.add(joueur2, gbc_joueur2);
		joueur2.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		pseudo2 = new JTextField();
		GridBagConstraints gbc_pseudo2 = new GridBagConstraints();
		gbc_pseudo2.anchor = GridBagConstraints.NORTHWEST;
		gbc_pseudo2.insets = new Insets(0, 0, 5, 5);
		gbc_pseudo2.gridwidth = 3;
		gbc_pseudo2.gridx = 2;
		gbc_pseudo2.gridy = 3;
		panel_3.add(pseudo2, gbc_pseudo2);
		pseudo2.setFont(new Font("Dialog", Font.PLAIN, 15));
		pseudo2.setBackground(Color.WHITE);
		pseudo2.setEditable(false);
		pseudo2.setColumns(10);
		
		points2 = new JLabel("Points: ");
		GridBagConstraints gbc_points2 = new GridBagConstraints();
		gbc_points2.anchor = GridBagConstraints.WEST;
		gbc_points2.insets = new Insets(0, 0, 5, 5);
		gbc_points2.gridx = 5;
		gbc_points2.gridy = 3;
		panel_3.add(points2, gbc_points2);
		points2.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldPoints2 = new JTextField();
		GridBagConstraints gbc_fieldPoints2 = new GridBagConstraints();
		gbc_fieldPoints2.anchor = GridBagConstraints.NORTHWEST;
		gbc_fieldPoints2.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPoints2.gridwidth = 2;
		gbc_fieldPoints2.gridx = 6;
		gbc_fieldPoints2.gridy = 3;
		panel_3.add(fieldPoints2, gbc_fieldPoints2);
		fieldPoints2.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldPoints2.setBackground(Color.WHITE);
		fieldPoints2.setEditable(false);
		fieldPoints2.setColumns(10);
		
		proposition = new JLabel("Proposition: ");
		GridBagConstraints gbc_proposition = new GridBagConstraints();
		gbc_proposition.anchor = GridBagConstraints.WEST;
		gbc_proposition.insets = new Insets(0, 0, 0, 5);
		gbc_proposition.gridx = 1;
		gbc_proposition.gridy = 5;
		panel_3.add(proposition, gbc_proposition);
		proposition.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		fieldPropo = new JTextField();
		GridBagConstraints gbc_fieldPropo = new GridBagConstraints();
		gbc_fieldPropo.anchor = GridBagConstraints.NORTHWEST;
		gbc_fieldPropo.insets = new Insets(0, 0, 0, 5);
		gbc_fieldPropo.gridx = 2;
		gbc_fieldPropo.gridy = 5;
		panel_3.add(fieldPropo, gbc_fieldPropo);
		fieldPropo.setFont(new Font("Dialog", Font.PLAIN, 15));
		fieldPropo.setBackground(Color.WHITE);
		fieldPropo.setEditable(false);
		fieldPropo.setColumns(10);
		
		lblChrono = new JLabel("Chrono:");
		GridBagConstraints gbc_lblChrono = new GridBagConstraints();
		gbc_lblChrono.anchor = GridBagConstraints.WEST;
		gbc_lblChrono.insets = new Insets(0, 0, 0, 5);
		gbc_lblChrono.gridx = 5;
		gbc_lblChrono.gridy = 5;
		panel_3.add(lblChrono, gbc_lblChrono);
		lblChrono.setFont(new Font("Dialog", Font.PLAIN, 15));
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTHEAST;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridwidth = 2;
		gbc_textField.gridx = 6;
		gbc_textField.gridy = 5;
		panel_3.add(textField, gbc_textField);
		textField.setFont(new Font("Dialog", Font.PLAIN, 15));
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		textField.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 12;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		
		initTable();
		panel.add(table);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 12;
		gbc_panel_1.gridy = 5;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{58, 46, 0};
		gbl_panel_1.rowHeights = new int[]{14, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		areaMessage = new JLabel("Message:");
		areaMessage.setFont(new Font("Dialog", Font.PLAIN, 17));
		areaMessage.setBackground(Color.CYAN);
		GridBagConstraints gbc_areaMessage = new GridBagConstraints();
		gbc_areaMessage.insets = new Insets(0, 0, 5, 0);
		gbc_areaMessage.anchor = GridBagConstraints.NORTHWEST;
		gbc_areaMessage.gridx = 1;
		gbc_areaMessage.gridy = 0;
		panel_1.add(areaMessage, gbc_areaMessage);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Dialog", Font.PLAIN, 22));
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		panel_1.add(textArea, gbc_textArea);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 12;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 9;
		contentPane.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{182, 109, 0};
		gbl_panel_2.rowHeights = new int[]{25, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		valider = new JButton("Commençons");
		valider.setFont(new Font("Dialog", Font.PLAIN, 15));
		valider.setForeground(Color.BLACK);
		valider.setBackground(new Color(255, 153, 0));
		GridBagConstraints gbc_valider = new GridBagConstraints();
		gbc_valider.anchor = GridBagConstraints.NORTHWEST;
		gbc_valider.gridx = 1;
		gbc_valider.gridy = 1;
		panel_2.add(valider, gbc_valider);
		valider.addActionListener(this);
		frame.setVisible(true);
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight();
		int width = (int)dimension.getWidth();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initMotus();
		frame.setSize(4*width/5, height/2);
		frame.setResizable(false);
	}
	
	public void initTable() {
		int n = controller.getNbLettres();
		data = new Object[6][n];
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < n; j++) {
				data[i][j] = "";
			}
		}
		
		String[] s = new String[n];
		for(int i = 0; i < n; i++) {
			s[i] = Integer.toString(i);
		}
		
		table = new JTable(data, s);
		table.setFont(new Font("Century", Font.PLAIN, 20));
		table.setBackground(new Color(0, 191, 255));
		table.setDefaultRenderer(Object.class, new JTableRender());/*pour mettre certains fonts de couleurs sur certaines
		cellules du tableau*/
	}
	
 	public void updateTable(boolean b) {
		int n = controller.getNbLettres();
 		String[] propo = Mot.formatMot(fieldPropo.getText()).split("");
 		if(b) {
 			traiterData(propo, n);
 		}
 		else {
 			traiterData(controller.getModel().getLettresActuelles(), n);
 		}
		String[] s = new String[n];
		for(int i = 0; i < n; i++) {
			s[i] = Integer.toString(i);
		}
		table = new JTable(data, s);
		table.setBackground(new Color(0, 191, 255));	
		frame.repaint();
	}
 	
 	/**
 	 * ordonne les lettres dans le tableau.
 	 * @param propo
 	 * @param n
 	 */
 	public void traiterData(String propo[], int n) {
 		String[] str = controller.getEtatActuel().split("");
		
		if(controller.getElem() == 0) {
			for(int i = 0 ; i < data[0].length ; i ++) {
				data[0][i] = str[i];
			}
		}
		else {
			if(controller.traitementReponse(fieldPropo.getText())) {
				for(int i = 0 ; i < controller.getNbLettres() ; i ++) {
					data[controller.getElem()][i] = str[i];
				}
			}
			else {
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < n; j++) {
						if(i == controller.getElem()) {
							data[i][j] = str[j];
						}
						if(controller.getElem() == 0 && i != controller.getElem()) {
							data[i][j] = "";
						}
					}	
				}
			}
		}
 	}
 	
	//initialise l'interface graphique avec les données possibles issus du model.
 	@Override
	public void initMotus() {
		fieldNbLettres.setText(String.valueOf(controller.getNbLettres()));
		fieldPoints1.setText("0");
		fieldPoints2.setText("0");
		fieldEssaiRest.setText(Integer.toString(controller.getEssaiRest()));
		affiche("Bonjour, \nBienvenu(e) a Motus!"
							+ "\nVeuillez Entrez le nombre de joueurs et votre pseudo s'il vous plaît");

		timerCount = 0;
		timer = new Timer(1000, this);
		
	}
	
	public boolean introNbJoueurs() {
		String n = fieldNbJoueurs.getText();
		if(!(n.equals("1") || n.equals("2"))){
			fieldNbJoueurs.setBackground(Color.RED);
			return false;
		}
		controller.setNbJoueurs(Integer.parseInt(n));
		fieldNbJoueurs.setBackground(Color.WHITE);
		return true;
	}
	
	/**
	 * Cette methode teste si le joueur a ecrit un pseudo dans le fieldText qui lui est dedie
	 * @return true si le joueur a ecrit son pseudo et false sinon.
	 */
	public boolean introPseudo() {
		String n = pseudo1.getText();
		if(n.length()==0) {
			pseudo1.setBackground(Color.RED);
			return false;
		}
		
		controller.setPseudoJoueur1(n);
		pseudo1.setBackground(Color.WHITE);
		return true;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		updateTable(fieldPropo.getText().length() == controller.getNbLettres());
		fieldPropo.setText("");
		fieldEssaiRest.setText(String.valueOf(controller.getEssaiRest()));
		fieldPoints1.setText(String.valueOf(controller.getJoueurActuel().getPoints()));
		
	}

	/**
	 * cette methode alerte le joueur sur l'volution du jeu
	 */
	@Override
	public void affiche(String string) {
		textArea.setText(string);		
	}
	
	/**
	 * Cette methode lance l'etape 1
	 */
	@Override
	public void lancerEtapeUn() {
		controller.etapeUn();
	}
	
	/**
	 * Cette methode lance l'etape 2
	 */
	@Override
	public void lancerEtapeDeux() {
		affiche("Lancement de l'étape deux: \n");
		controller.etapeDeux();
	}
	
	/**
	 * cacher les conglets aux cas ou le nombre de joueurs est égales à un
	 */
	public void cacherOnglets() {
		fieldJoueurAct.setVisible(false);
		fieldPoints2.setVisible(false);
		pseudo2.setVisible(false);
		joueur1.setText("Joueur");
		joueur2.setVisible(false);
		points2.setVisible(false);
		joueurActuel.setVisible(false);
	}

	/**
	 * les actions sur les buttons
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() != null) {
			switch (e.getActionCommand()) {
			case "Commençons":
				if(!(introNbJoueurs() && introPseudo())) {
					affiche("Veuillez introduire des données correctes!");
					break;
				}
				affiche("Etes-vous prêts?");
				valider.setText("Prêt!");
				pseudo1.setEditable(false);
				fieldNbJoueurs.setEditable(false);
				fieldPropo.setEditable(true);
				int n = Integer.parseInt(fieldNbJoueurs.getText());
				controller.initPartie(n);
				controller.setPseudoJoueur1(pseudo1.getText());
				if(n == 1)
					cacherOnglets();
				break;
	
			case "Prêt!":
				for(int i = 0; i < 6; i++) {
					for(int j = 0; j < data[i].length; j++) {
						data[i][j] = "";
					}
				}
				if(controller.getEtape() == 1) {
					controller.etapeUn();
					affiche("Lancement de l'étape 1: \n");
				}
				else {
					affiche("\nBravo vous y êtes presque!!!\nLancement de l'étape 2: \n");
					controller.etapeDeux();
				}
				updateTable(true);
				textArea.append("Le mot à trouver est :\n" + controller.getMotATrouver().getValeur());
				valider.setText("Valider");
				
				break;
				
			case "Valider":
				controller.traitementPropo(fieldPropo.getText());
				controller.updatePartie();
				if(controller.getModel().estTrouve(fieldPropo.getText())) {
					valider.setText("Prêt!");
					affiche("Bravo! Vous avez donné la bonne réponse!\n\n");
					textArea.append("Le mot à trouver était bien : \n" + controller.getMotATrouver().getValeur());
					updateTable(true);
					fieldPropo.setText("");
				}
				else if(controller.getElem() == 6){
					affiche("Dommage...\nVous avez epuise votre nombre\n de tentatives permises...");
					textArea.append("Le mot a trouver était bien : \n" + controller.getMotATrouver().getValeur());
					valider.setText("Prêt!");
				}
				if(controller.getModel().getEtape() == 2 && controller.getEssaiRest() == 0) {
					affiche("Félicitation! \n" + controller.getModel().toString());
					valider.setText("FIN");
					controller.supprimerFichiers();
				}
				update(null, null);
				break;	
				
			default:
				break;
		}
			
		}
		else if(timer.isRunning()){
			timerCount++;
			textField.setText(String.valueOf(timerCount));
		}
	}
	


}

