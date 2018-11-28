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

public class PartieVueGUI extends PartieVue implements ActionListener{

	private JPanel contentPane;
	private JFrame PartieFrame;
	private int nbLettres = Partie.getTaillemot();
	private JTextField pseudoJoueur;
	private JLabel points;
	private JTextField nbPoints;
	private JPanel textContent;
	private JLabel pseudo;
	private JTable table;
	private JLabel lblProposition;
	private JTextField textField;
	private JPanel panel;
	private JLabel lblEtape;
	private JButton btnCommenons;
	private JButton btnDisposer;

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
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		pseudo = new JLabel("Pseudo Du Joueur: ");
		GridBagConstraints gbc_pseudo = new GridBagConstraints();
		gbc_pseudo.insets = new Insets(0, 0, 5, 5);
		gbc_pseudo.anchor = GridBagConstraints.EAST;
		gbc_pseudo.gridx = 0;
		gbc_pseudo.gridy = 0;
		contentPane.add(pseudo, gbc_pseudo);
		
		pseudoJoueur = new JTextField();
		GridBagConstraints gbc_pseudoJoueur = new GridBagConstraints();
		gbc_pseudoJoueur.insets = new Insets(0, 0, 5, 0);
		gbc_pseudoJoueur.fill = GridBagConstraints.HORIZONTAL;
		gbc_pseudoJoueur.gridx = 1;
		gbc_pseudoJoueur.gridy = 0;
		contentPane.add(pseudoJoueur, gbc_pseudoJoueur);
		pseudoJoueur.setColumns(10);
		
		points = new JLabel("nombre de Points: ");
		GridBagConstraints gbc_points = new GridBagConstraints();
		gbc_points.anchor = GridBagConstraints.EAST;
		gbc_points.insets = new Insets(0, 0, 5, 5);
		gbc_points.gridx = 0;
		gbc_points.gridy = 1;
		contentPane.add(points, gbc_points);
		
		nbPoints = new JTextField();
		GridBagConstraints gbc_nbPoints = new GridBagConstraints();
		gbc_nbPoints.insets = new Insets(0, 0, 5, 0);
		gbc_nbPoints.fill = GridBagConstraints.HORIZONTAL;
		gbc_nbPoints.gridx = 1;
		gbc_nbPoints.gridy = 1;
		contentPane.add(nbPoints, gbc_nbPoints);
		nbPoints.setColumns(10);
		
		lblProposition = new JLabel("proposition: ");
		GridBagConstraints gbc_lblProposition = new GridBagConstraints();
		gbc_lblProposition.anchor = GridBagConstraints.EAST;
		gbc_lblProposition.insets = new Insets(0, 0, 5, 5);
		gbc_lblProposition.gridx = 0;
		gbc_lblProposition.gridy = 2;
		contentPane.add(lblProposition, gbc_lblProposition);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 3;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblEtape = new JLabel("Choisissez une option...");
		GridBagConstraints gbc_lblEtape = new GridBagConstraints();
		gbc_lblEtape.insets = new Insets(0, 0, 5, 0);
		gbc_lblEtape.gridx = 3;
		gbc_lblEtape.gridy = 0;
		panel.add(lblEtape, gbc_lblEtape);
		
		btnCommenons = new JButton("Commen\u00E7ons");
		GridBagConstraints gbc_btnCommenons = new GridBagConstraints();
		gbc_btnCommenons.insets = new Insets(0, 0, 5, 0);
		gbc_btnCommenons.gridx = 3;
		gbc_btnCommenons.gridy = 1;
		panel.add(btnCommenons, gbc_btnCommenons);
		
		btnDisposer = new JButton("Quitter");
		GridBagConstraints gbc_btnDisposer = new GridBagConstraints();
		gbc_btnDisposer.insets = new Insets(0, 0, 5, 0);
		gbc_btnDisposer.gridx = 3;
		gbc_btnDisposer.gridy = 2;
		panel.add(btnDisposer, gbc_btnDisposer);
		
		textContent = new JPanel();
		GridBagConstraints gbc_textContent = new GridBagConstraints();
		gbc_textContent.fill = GridBagConstraints.BOTH;
		gbc_textContent.gridx = 1;
		gbc_textContent.gridy = 3;
		contentPane.add(textContent, gbc_textContent);
		textContent.setLayout(new BoxLayout(textContent, BoxLayout.X_AXIS));
		
		table = new JTable();
		textContent.add(table.getTableHeader());
		textContent.add(table);
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
