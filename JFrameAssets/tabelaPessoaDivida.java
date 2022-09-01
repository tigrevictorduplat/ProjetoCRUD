package JFrameAssets;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class tabelaPessoaDivida extends JFrame {

	private JPanel contentPane;
	private JTable tabelaPessoaDivida;
	private DefaultTableModel modeloTabela;
	private JScrollPane painelTabela;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabelaPessoaDivida frame = new tabelaPessoaDivida();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tabelaPessoaDivida() {
		setTitle("Histórico dos Devedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 496);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		painelTabela = new JScrollPane();
		painelTabela.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelTabela.setBounds(31, 18, 463, 349);
		contentPane.add(painelTabela);
		
		//Criando a Tabela
		tabelaPessoaDivida = new JTable();
		painelTabela.setViewportView(tabelaPessoaDivida);
		tabelaPessoaDivida.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "R$", "Filia\u00E7\u00E3o", "Prazo de Devolu\u00E7\u00E3o", "Data da Opera\u00E7\u00E3o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Double.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabelaPessoaDivida.getColumnModel().getColumn(0).setResizable(false);
		tabelaPessoaDivida.getColumnModel().getColumn(0).setPreferredWidth(24);
		tabelaPessoaDivida.getColumnModel().getColumn(2).setResizable(false);
		tabelaPessoaDivida.getColumnModel().getColumn(2).setPreferredWidth(43);
		tabelaPessoaDivida.getColumnModel().getColumn(3).setPreferredWidth(50);
		tabelaPessoaDivida.getColumnModel().getColumn(4).setResizable(false);
		tabelaPessoaDivida.getColumnModel().getColumn(4).setPreferredWidth(101);
		tabelaPessoaDivida.getColumnModel().getColumn(5).setResizable(false);
		tabelaPessoaDivida.getColumnModel().getColumn(5).setPreferredWidth(110);
		tabelaPessoaDivida.getColumnModel().getColumn(5).setMaxWidth(250);
		tabelaPessoaDivida.setForeground(Color.BLACK);
		tabelaPessoaDivida.setFont(new Font("Georgia", Font.PLAIN, 12));
		tabelaPessoaDivida.setRowSelectionAllowed(false);
		tabelaPessoaDivida.setBackground(Color.GRAY);
		tabelaPessoaDivida.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setFont(new Font("Georgia", Font.BOLD, 16));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelainicial menuPrincipal = new janelainicial();
				menuPrincipal.retornarMenu(menuPrincipal);
			}
		});
		botaoRetornar.setBounds(23, 378, 482, 49);
		contentPane.add(botaoRetornar);
	}
}
