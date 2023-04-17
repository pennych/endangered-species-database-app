package main;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;


/**
 * Separate JPanel that allows consistent and smooth navigation across all JPanels 
 */
@SuppressWarnings("serial")
public class NavBar extends JPanel {

	private JButton speciesBtn;
	private JButton consEffortsBtn;
	private JButton regionBtn;
	private JButton homeBtn;
	private JButton addSpeciesBtn;
	private JLabel titleLbl;
	private JButton addConservationBtn;

	/**
	 * Create the panel.
	 */
	public NavBar() {
		setLayout(null);
		setBounds(0, 0, 1100, 263);
		
		titleLbl = new JLabel("Home");
		titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
		titleLbl.setFont(new Font("Georgia", Font.BOLD, 55));
		titleLbl.setBounds(6, 26, 1088, 100);
		titleLbl.setFocusable(false);
		add(titleLbl);
		
		speciesBtn = new JButton("All Species");
		speciesBtn.setBounds(294, 138, 228, 40);
		speciesBtn.setFocusable(false);
		add(speciesBtn);

		consEffortsBtn = new JButton("Conservation Efforts");
		consEffortsBtn.setBounds(546, 138, 229, 40);
		consEffortsBtn.setFocusable(false);
		add(consEffortsBtn);

		regionBtn = new JButton("Regions");
		regionBtn.setBounds(797, 138, 229, 40);
		regionBtn.setFocusable(false);
		add(regionBtn);

		homeBtn = new JButton("Home");
		homeBtn.setBounds(53, 138, 229, 40);
		homeBtn.setFocusable(false);
		add(homeBtn);

		addSpeciesBtn = new JButton("Add Species");
		addSpeciesBtn.setBounds(294, 190, 229, 40);
		addSpeciesBtn.setFocusable(false);
		add(addSpeciesBtn);
		
		addConservationBtn = new JButton("Add Conservation Effort");
		addConservationBtn.setBounds(546, 190, 228, 40);
		addConservationBtn.setFocusable(false);
		add(addConservationBtn);
	}
	
	public JLabel getTitleLabel() {
		return titleLbl;
	}

	public void setTitleLabel(String titleLabel) {
		titleLbl.setText(titleLabel);
	}

	public JButton getHomeButton() {
		return homeBtn;
	}

	public JButton getRegionButton() {
		return regionBtn;
	}
	
	public JButton getConsEffortsButton() {
		return consEffortsBtn;
	}
	
	public JButton getSpeciesQueryButton() {
		return speciesBtn;
	}

	public JButton getAddSpeciesButton() {
		return addSpeciesBtn;
	}
	
	public JButton getAddConservationButton() {
		return addConservationBtn;
	}
}
