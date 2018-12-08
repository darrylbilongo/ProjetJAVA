package view;

import java.awt.Color;
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
import javax.swing.border.EmptyBorder;

import controller.PartieController;
import model.Mot;
import model.Partie;

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
	
	
	private Object[][] data;

	/**
	 * Constructeur de la frame
	 */
	public PartieVueGUI(Partie model, PartieController controller) {
		
		super(model, controller);
		initGUI();
	}
	
	
	public void initGUI() {
		frame = new JFrame("Partie");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\manue\\OneDrive\\GOMAND\\EPHEC\\Cours\\2TI\\D\u00E9v. informatique avanc\u00E9 application_Th\u00E9orie\\TP\\TP_Java\\ProjetJAVA2018\\ProjetAPP\\motus-france-2-pourquoi-les-emissions-du-samedi-sont-elles-des-rediffusions.jpg"));
		frame.setTitle("Motus");
		frame.setForeground(new Color(224, 255, 255));
		frame.setFont(new Font("Castellar", Font.PLAIN, 12));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 640, 362);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		nbJoueurs = new JLabel("Nombre de joueurs:");
		GridBagConstraints gbc_nbJoueurs = new GridBagConstraints();
		gbc_nbJoueurs.anchor = GridBagConstraints.EAST;
		gbc_nbJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_nbJoueurs.gridx = 1;
		gbc_nbJoueurs.gridy = 0;
		contentPane.add(nbJoueurs, gbc_nbJoueurs);
		
		fieldNbJoueurs = new JTextField();
		fieldNbJoueurs.setBackground(Color.WHITE);
		GridBagConstraints gbc_fieldNbJoueurs = new GridBagConstraints();
		gbc_fieldNbJoueurs.gridwidth = 4;
		gbc_fieldNbJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_fieldNbJoueurs.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldNbJoueurs.gridx = 2;
		gbc_fieldNbJoueurs.gridy = 0;
		contentPane.add(fieldNbJoueurs, gbc_fieldNbJoueurs);
		fieldNbJoueurs.setColumns(10);
		
		essaiRest = new JLabel("Essais restants: ");
		GridBagConstraints gbc_essaiRest = new GridBagConstraints();
		gbc_essaiRest.anchor = GridBagConstraints.EAST;
		gbc_essaiRest.insets = new Insets(0, 0, 5, 5);
		gbc_essaiRest.gridx = 8;
		gbc_essaiRest.gridy = 0;
		contentPane.add(essaiRest, gbc_essaiRest);
		
		fieldEssaiRest = new JTextField();
		fieldEssaiRest.setBackground(Color.WHITE);
		fieldEssaiRest.setEditable(false);
		GridBagConstraints gbc_fieldEssaiRest = new GridBagConstraints();
		gbc_fieldEssaiRest.gridwidth = 2;
		gbc_fieldEssaiRest.insets = new Insets(0, 0, 5, 5);
		gbc_fieldEssaiRest.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldEssaiRest.gridx = 9;
		gbc_fieldEssaiRest.gridy = 0;
		contentPane.add(fieldEssaiRest, gbc_fieldEssaiRest);
		fieldEssaiRest.setColumns(10);
		
		nbLettres = new JLabel("Nombre de lettres:");
		GridBagConstraints gbc_nbLettres = new GridBagConstraints();
		gbc_nbLettres.insets = new Insets(0, 0, 5, 5);
		gbc_nbLettres.gridx = 1;
		gbc_nbLettres.gridy = 1;
		contentPane.add(nbLettres, gbc_nbLettres);
		
		fieldNbLettres = new JTextField();
		fieldNbLettres.setBackground(Color.WHITE);
		fieldNbLettres.setEditable(false);
		GridBagConstraints gbc_fieldNbLettres = new GridBagConstraints();
		gbc_fieldNbLettres.gridwidth = 4;
		gbc_fieldNbLettres.insets = new Insets(0, 0, 5, 5);
		gbc_fieldNbLettres.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldNbLettres.gridx = 2;
		gbc_fieldNbLettres.gridy = 1;
		contentPane.add(fieldNbLettres, gbc_fieldNbLettres);
		fieldNbLettres.setColumns(10);
		
		joueurActuel = new JLabel("Joueur Actuel:");
		GridBagConstraints gbc_joueurActuel = new GridBagConstraints();
		gbc_joueurActuel.anchor = GridBagConstraints.EAST;
		gbc_joueurActuel.insets = new Insets(0, 0, 5, 5);
		gbc_joueurActuel.gridx = 8;
		gbc_joueurActuel.gridy = 1;
		contentPane.add(joueurActuel, gbc_joueurActuel);
		
		fieldJoueurAct = new JTextField();
		fieldJoueurAct.setBackground(Color.WHITE);
		fieldJoueurAct.setEditable(false);
		GridBagConstraints gbc_fieldJoueurAct = new GridBagConstraints();
		gbc_fieldJoueurAct.gridwidth = 2;
		gbc_fieldJoueurAct.insets = new Insets(0, 0, 5, 5);
		gbc_fieldJoueurAct.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldJoueurAct.gridx = 9;
		gbc_fieldJoueurAct.gridy = 1;
		contentPane.add(fieldJoueurAct, gbc_fieldJoueurAct);
		fieldJoueurAct.setColumns(10);
		
		joueur1 = new JLabel("Joueur1: ");
		GridBagConstraints gbc_joueur1 = new GridBagConstraints();
		gbc_joueur1.anchor = GridBagConstraints.EAST;
		gbc_joueur1.insets = new Insets(0, 0, 5, 5);
		gbc_joueur1.gridx = 1;
		gbc_joueur1.gridy = 2;
		contentPane.add(joueur1, gbc_joueur1);
		
		pseudo1 = new JTextField();
		pseudo1.setFont(new Font("Century", Font.PLAIN, 13));
		pseudo1.setBackground(Color.WHITE);
		GridBagConstraints gbc_pseudo1 = new GridBagConstraints();
		gbc_pseudo1.gridwidth = 4;
		gbc_pseudo1.insets = new Insets(0, 0, 5, 5);
		gbc_pseudo1.fill = GridBagConstraints.HORIZONTAL;
		gbc_pseudo1.gridx = 2;
		gbc_pseudo1.gridy = 2;
		contentPane.add(pseudo1, gbc_pseudo1);
		pseudo1.setColumns(10);
		
		points1 = new JLabel("Points:");
		GridBagConstraints gbc_points1 = new GridBagConstraints();
		gbc_points1.anchor = GridBagConstraints.EAST;
		gbc_points1.insets = new Insets(0, 0, 5, 5);
		gbc_points1.gridx = 8;
		gbc_points1.gridy = 2;
		contentPane.add(points1, gbc_points1);
		
		fieldPoints1 = new JTextField();
		fieldPoints1.setBackground(Color.WHITE);
		fieldPoints1.setEditable(false);
		GridBagConstraints gbc_fieldPoints1 = new GridBagConstraints();
		gbc_fieldPoints1.gridwidth = 2;
		gbc_fieldPoints1.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPoints1.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPoints1.gridx = 9;
		gbc_fieldPoints1.gridy = 2;
		contentPane.add(fieldPoints1, gbc_fieldPoints1);
		fieldPoints1.setColumns(10);
		
		joueur2 = new JLabel("Joueur2:");
		GridBagConstraints gbc_joueur2 = new GridBagConstraints();
		gbc_joueur2.anchor = GridBagConstraints.EAST;
		gbc_joueur2.insets = new Insets(0, 0, 5, 5);
		gbc_joueur2.gridx = 1;
		gbc_joueur2.gridy = 3;
		contentPane.add(joueur2, gbc_joueur2);
		
		pseudo2 = new JTextField();
		pseudo2.setBackground(Color.WHITE);
		pseudo2.setEditable(false);
		GridBagConstraints gbc_pseudo2 = new GridBagConstraints();
		gbc_pseudo2.gridwidth = 4;
		gbc_pseudo2.insets = new Insets(0, 0, 5, 5);
		gbc_pseudo2.fill = GridBagConstraints.HORIZONTAL;
		gbc_pseudo2.gridx = 2;
		gbc_pseudo2.gridy = 3;
		contentPane.add(pseudo2, gbc_pseudo2);
		pseudo2.setColumns(10);
		
		points2 = new JLabel("Points: ");
		GridBagConstraints gbc_points2 = new GridBagConstraints();
		gbc_points2.anchor = GridBagConstraints.EAST;
		gbc_points2.insets = new Insets(0, 0, 5, 5);
		gbc_points2.gridx = 8;
		gbc_points2.gridy = 3;
		contentPane.add(points2, gbc_points2);
		
		fieldPoints2 = new JTextField();
		fieldPoints2.setBackground(Color.WHITE);
		fieldPoints2.setEditable(false);
		GridBagConstraints gbc_fieldPoints2 = new GridBagConstraints();
		gbc_fieldPoints2.gridwidth = 2;
		gbc_fieldPoints2.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPoints2.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPoints2.gridx = 9;
		gbc_fieldPoints2.gridy = 3;
		contentPane.add(fieldPoints2, gbc_fieldPoints2);
		fieldPoints2.setColumns(10);
		
		proposition = new JLabel("Proposition: ");
		GridBagConstraints gbc_proposition = new GridBagConstraints();
		gbc_proposition.anchor = GridBagConstraints.EAST;
		gbc_proposition.insets = new Insets(0, 0, 5, 5);
		gbc_proposition.gridx = 1;
		gbc_proposition.gridy = 4;
		contentPane.add(proposition, gbc_proposition);
		
		fieldPropo = new JTextField();
		fieldPropo.setFont(new Font("Century", Font.PLAIN, 13));
		fieldPropo.setBackground(Color.WHITE);
		fieldPropo.setEditable(false);
		GridBagConstraints gbc_fieldPropo = new GridBagConstraints();
		gbc_fieldPropo.gridwidth = 4;
		gbc_fieldPropo.insets = new Insets(0, 0, 5, 5);
		gbc_fieldPropo.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldPropo.gridx = 2;
		gbc_fieldPropo.gridy = 4;
		contentPane.add(fieldPropo, gbc_fieldPropo);
		fieldPropo.setColumns(10);
		
		lblChrono = new JLabel("Chrono:");
		GridBagConstraints gbc_lblChrono = new GridBagConstraints();
		gbc_lblChrono.anchor = GridBagConstraints.EAST;
		gbc_lblChrono.insets = new Insets(0, 0, 5, 5);
		gbc_lblChrono.gridx = 8;
		gbc_lblChrono.gridy = 4;
		contentPane.add(lblChrono, gbc_lblChrono);
		
		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 9;
		gbc_textField.gridy = 4;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		panel = new JPanel();
		panel.setBackground(Color.CYAN);
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
		panel_1.setBackground(Color.CYAN);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.gridwidth = 3;
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
		
		areaMessage = new JLabel("message:");
		areaMessage.setBackground(Color.CYAN);
		GridBagConstraints gbc_areaMessage = new GridBagConstraints();
		gbc_areaMessage.insets = new Insets(0, 0, 5, 0);
		gbc_areaMessage.anchor = GridBagConstraints.NORTHWEST;
		gbc_areaMessage.gridx = 1;
		gbc_areaMessage.gridy = 0;
		panel_1.add(areaMessage, gbc_areaMessage);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Castellar", Font.PLAIN, 12));
		textArea.setBackground(Color.WHITE);
		textArea.setEditable(false);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		panel_1.add(textArea, gbc_textArea);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.CYAN);
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
		
		valider = new JButton("Commen\u00E7ons");
		valider.setBackground(SystemColor.info);
		GridBagConstraints gbc_valider = new GridBagConstraints();
		gbc_valider.anchor = GridBagConstraints.NORTHWEST;
		gbc_valider.gridx = 1;
		gbc_valider.gridy = 1;
		panel_2.add(valider, gbc_valider);
		valider.addActionListener(this);
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initMotus();
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
		table.setBackground(new Color(0, 191, 255));
	}
	
 	public void updateTable() {
 		String[] propo = fieldPropo.getText().split("");
		String[] str = controller.getEtatActuel().split("");
		int n = controller.getNbLettres();
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < n; j++) {
				if(i == (controller.getElem()-1)) {
					data[i][j] = propo[j];
				}
				if(i == controller.getElem()) {
					data[i][j] = str[j];
				}
			}
		}
		
		String[] s = new String[n];
		for(int i = 0; i < n; i++) {
			s[i] = Integer.toString(i);
		}
		
		table = new JTable(data, s);
		table.setBackground(new Color(0, 191, 255));
	}

	//initialise l'interface graphique avec les données possibles issus du model.
	public void initMotus() {
		fieldNbLettres.setText(String.valueOf(controller.getNbLettres()));
		fieldPoints1.setText("0");
		fieldPoints2.setText("0");
		fieldEssaiRest.setText(Integer.toString(controller.getEssaiRest()));
		affiche("Bonjour, \nBienvenu(e) à  Motus!"
							+ "\nVeuillez Entrez le nombre de joueurs et votre pseudo s'il vous plaît");
		
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
	
	public boolean introPseudo() {
		String n = pseudo1.getText();
		if(n.length()==0) {
			pseudo1.setBackground(Color.RED);
			return false;
		}
		
		controller.setPseudoJoueur(n);
		pseudo1.setBackground(Color.WHITE);
		return true;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		updateTable();
		fieldPropo.setText("");
	}

	@Override
	public void affiche(String string) {
		textArea.setText(string);		
	}
	
	public void lancerEtapeUn() {
		affiche("Lancement de l'étape un: \n");
		controller.etapeUn();
	}
	
	public void lancerEtapeDeux() {
		affiche("Lancement de l'étape deux: \n");
		controller.etapeDeux();
	}
	
	public void cacherOnglets() {
		fieldJoueurAct.setVisible(false);
		fieldPoints2.setVisible(false);
		pseudo2.setVisible(false);
		joueur1.setText("Joueur");
		joueur2.setVisible(false);
		points2.setVisible(false);
		joueurActuel.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
			if(n == 1)
				cacherOnglets();
			break;

		case "Prêt!":
			if(controller.getEtape() == 1)
				controller.etapeUn();
			else
				controller.etapeDeux();
			updateTable();
			valider.setText("Valider");
			affiche("");
			break;
			
		case "Valider":
			if(controller.getEssaiRest() == 0)
				valider.setText("Prêt!");
			controller.traitementPropo(fieldPropo.getText());
			if(controller.traitementReponse(fieldPropo.getText())) {
				valider.setText("Prêt!");
				affiche("Bravo! Vous avez donné la bonne réponse!");
			}
			else if(controller.getElem() == 5){
				affiche("Dommage...\nVous avez épuisé votre nombre de tentatives permises...");
				textArea.append("Le mot à trouver était bien : \n" + controller.getMotATrouver().getValeur());
			}
			break;
			
		default:
			break;
		}
		
	}

}
