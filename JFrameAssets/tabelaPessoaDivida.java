package JFrameAssets;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import ConexaoSQL.PonteJavaSQL;
import ObjetosPessoas.PessoaDivida;

public class tabelaPessoaDivida extends JFrame {

	private JPanel contentPane;
	private JTable tabelaPessoaDivida;
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
		PonteJavaSQL crudSql = new PonteJavaSQL();
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
		String nomeColunas[] = {"ID", "Nome", "R$", "Filia\u00E7\u00E3o", "Prazo de Devolu\u00E7\u00E3o", "Data da Opera\u00E7\u00E3o"};
		DefaultTableModel modelo = new DefaultTableModel(nomeColunas,0);
		tabelaPessoaDivida = new JTable();
		painelTabela.setViewportView(tabelaPessoaDivida);
		tabelaPessoaDivida.setModel(modelo);

		//Resgatando dados da View DividaPessoa 
		int i= 0;
		for (PessoaDivida pd : crudSql.listarDividasPorPessoa() ) {
			int j =0;
			modelo.setValueAt(pd.getIdPessoaDivida(), i, j);
			j++;
			modelo.setValueAt(pd.getNomePessoaDivida(), i, j);
			j++;
			modelo.setValueAt(pd.getValorPessoaDivida(), i, j);
			j++;
			modelo.setValueAt(pd.getFiliacaoPessoaDivida(), i, j);
			j++;
			modelo.setValueAt(pd.getPrazoDiasPessoaDivida(), i, j);
			j++;
			modelo.setValueAt(pd.getDataOperacaoPessoaDivida().toString(), i, j);
			i++;
		}
		i = 0;

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
		tabelaPessoaDivida.setBorder(new LineBorder(Color.WHITE));
		
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
