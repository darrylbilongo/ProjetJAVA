package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.PartieController;
import model.Partie;
import model.Partie;
import javax.swing.JTextArea;

public class PartieVueGUI extends PartieVue implements ActionListener{

	private JPanel contentPane;
	private JFrame PartieFrame;
	private int nbLettres = Partie.getTaillemot();
	private JLabel lblNombreDeJoueurs;
	private JLabel lblEssaisRestants;
	private JLabel lblNombreDeLettres;
	private JLabel lblProposition;
	private JLabel lblJoueur;
	private JLabel lblPoints;
	private JLabel lblJoueur_1;
	private JLabel lblPoints_1;
	private JLabel lblJoueurActuel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel panel;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPanel panel_1;
	private JLabel lblMessage;
	private JTextArea textArea;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JPanel panel_2;
	private JButton btnNewButton;

	/**
	 * Constructeur de la frame
	 */
	public PartieVueGUI(Partie model, PartieController controller) {
		
		super(model, controller);
		PartieFrame = new JFrame("Partie");
		PartieFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PartieFrame.setBounds(100, 100, 450, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		PartieFrame.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNombreDeJoueurs = new JLabel("Nombre de joueurs:");
		GridBagConstraints gbc_lblNombreDeJoueurs = new GridBagConstraints();
		gbc_lblNombreDeJoueurs.anchor = GridBagConstraints.EAST;
		gbc_lblNombreDeJoueurs.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeJoueurs.gridx = 0;
		gbc_lblNombreDeJoueurs.gridy = 0;
		contentPane.add(lblNombreDeJoueurs, gbc_lblNombreDeJoueurs);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 3;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 0;
		contentPane.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		lblEssaisRestants = new JLabel("Essais restants: ");
		GridBagConstraints gbc_lblEssaisRestants = new GridBagConstraints();
		gbc_lblEssaisRestants.anchor = GridBagConstraints.EAST;
		gbc_lblEssaisRestants.insets = new Insets(0, 0, 5, 5);
		gbc_lblEssaisRestants.gridx = 6;
		gbc_lblEssaisRestants.gridy = 0;
		contentPane.add(lblEssaisRestants, gbc_lblEssaisRestants);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 7;
		gbc_textField.gridy = 0;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblNombreDeLettres = new JLabel("Nombre de lettres: ");
		GridBagConstraints gbc_lblNombreDeLettres = new GridBagConstraints();
		gbc_lblNombreDeLettres.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreDeLettres.gridx = 0;
		gbc_lblNombreDeLettres.gridy = 1;
		contentPane.add(lblNombreDeLettres, gbc_lblNombreDeLettres);
		
		textField_5 = new JTextField();
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 3;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 1;
		contentPane.add(textField_5, gbc_textField_5);
		textField_5.setColumns(10);
		
		lblJoueurActuel = new JLabel("Joueur Actuel:");
		GridBagConstraints gbc_lblJoueurActuel = new GridBagConstraints();
		gbc_lblJoueurActuel.anchor = GridBagConstraints.EAST;
		gbc_lblJoueurActuel.insets = new Insets(0, 0, 5, 5);
		gbc_lblJoueurActuel.gridx = 6;
		gbc_lblJoueurActuel.gridy = 1;
		contentPane.add(lblJoueurActuel, gbc_lblJoueurActuel);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 2;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 7;
		gbc_textField_1.gridy = 1;
		contentPane.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblJoueur = new JLabel("Joueur1: ");
		GridBagConstraints gbc_lblJoueur = new GridBagConstraints();
		gbc_lblJoueur.anchor = GridBagConstraints.EAST;
		gbc_lblJoueur.insets = new Insets(0, 0, 5, 5);
		gbc_lblJoueur.gridx = 0;
		gbc_lblJoueur.gridy = 2;
		contentPane.add(lblJoueur, gbc_lblJoueur);
		
		textField_6 = new JTextField();
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.gridwidth = 3;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 2;
		contentPane.add(textField_6, gbc_textField_6);
		textField_6.setColumns(10);
		
		lblPoints = new JLabel("Points:");
		GridBagConstraints gbc_lblPoints = new GridBagConstraints();
		gbc_lblPoints.anchor = GridBagConstraints.EAST;
		gbc_lblPoints.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoints.gridx = 6;
		gbc_lblPoints.gridy = 2;
		contentPane.add(lblPoints, gbc_lblPoints);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 2;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 7;
		gbc_textField_2.gridy = 2;
		contentPane.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		lblJoueur_1 = new JLabel("Joueur2:");
		GridBagConstraints gbc_lblJoueur_1 = new GridBagConstraints();
		gbc_lblJoueur_1.anchor = GridBagConstraints.EAST;
		gbc_lblJoueur_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblJoueur_1.gridx = 0;
		gbc_lblJoueur_1.gridy = 3;
		contentPane.add(lblJoueur_1, gbc_lblJoueur_1);
		
		textField_7 = new JTextField();
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.gridwidth = 3;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 3;
		contentPane.add(textField_7, gbc_textField_7);
		textField_7.setColumns(10);
		
		lblPoints_1 = new JLabel("Points: ");
		GridBagConstraints gbc_lblPoints_1 = new GridBagConstraints();
		gbc_lblPoints_1.anchor = GridBagConstraints.EAST;
		gbc_lblPoints_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPoints_1.gridx = 6;
		gbc_lblPoints_1.gridy = 3;
		contentPane.add(lblPoints_1, gbc_lblPoints_1);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 2;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 7;
		gbc_textField_3.gridy = 3;
		contentPane.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		lblProposition = new JLabel("Proposition: ");
		GridBagConstraints gbc_lblProposition = new GridBagConstraints();
		gbc_lblProposition.anchor = GridBagConstraints.EAST;
		gbc_lblProposition.insets = new Insets(0, 0, 5, 5);
		gbc_lblProposition.gridx = 0;
		gbc_lblProposition.gridy = 4;
		contentPane.add(lblProposition, gbc_lblProposition);
		
		textField_8 = new JTextField();
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.gridwidth = 3;
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 4;
		contentPane.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 7;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 5;
		contentPane.add(panel, gbc_panel);
		
		table = new JTable();
		panel.add(table);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridheight = 4;
		gbc_panel_1.gridwidth = 3;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 7;
		gbc_panel_1.gridy = 5;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{58, 46, 0};
		gbl_panel_1.rowHeights = new int[]{14, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		lblMessage = new JLabel("message:");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 5, 0);
		gbc_lblMessage.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMessage.gridx = 1;
		gbc_lblMessage.gridy = 0;
		panel_1.add(lblMessage, gbc_lblMessage);
		
		textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridheight = 2;
		gbc_textArea.gridwidth = 2;
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 0;
		gbc_textArea.gridy = 1;
		panel_1.add(textArea, gbc_textArea);
		
		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 7;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 9;
		contentPane.add(panel_2, gbc_panel_2);
		
		btnNewButton = new JButton("Commencons");
		panel_2.add(btnNewButton);
		PartieFrame.setVisible(true);

	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void affiche(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
