package PaineisJFrame;

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

import ClassesPrincipais.FuncaoPessoa;
import ConectorMySQL.TradutorJavaMySQL;
import java.awt.SystemColor;

public class tabelaFuncaoPessoa extends JFrame {

	private JPanel contentPane;
	private JTable tabelaChecagemAgenda;
	private JScrollPane painelTabela;
	private JButton botaoInserir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tabelaFuncaoPessoa frame = new tabelaFuncaoPessoa();
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
	public tabelaFuncaoPessoa() {
		TradutorJavaMySQL crudSql = new TradutorJavaMySQL();
		setTitle("Função por Pessoa");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 745, 496);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		painelTabela = new JScrollPane();
		painelTabela.setBackground(new Color(102, 153, 255));
		painelTabela.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		painelTabela.setBounds(21, 10, 684, 349);
		contentPane.add(painelTabela);
		
		
		//Criando a Tabela
		String nomeColunas[] = {"Nome", "CPF", "Função", "Endereço", "Salário"};
		DefaultTableModel modelo = new DefaultTableModel(nomeColunas,0);
		tabelaChecagemAgenda = new JTable();
		painelTabela.setViewportView(tabelaChecagemAgenda);
		tabelaChecagemAgenda.setModel(modelo);
		tabelaChecagemAgenda.getColumnModel().getColumn(0).setResizable(false);
		tabelaChecagemAgenda.getColumnModel().getColumn(0).setPreferredWidth(68);
		tabelaChecagemAgenda.getColumnModel().getColumn(1).setResizable(false);
		tabelaChecagemAgenda.getColumnModel().getColumn(2).setResizable(false);
		tabelaChecagemAgenda.getColumnModel().getColumn(2).setPreferredWidth(43);
		tabelaChecagemAgenda.getColumnModel().getColumn(3).setResizable(false);
		tabelaChecagemAgenda.getColumnModel().getColumn(3).setPreferredWidth(94);
		tabelaChecagemAgenda.getColumnModel().getColumn(4).setResizable(false);
		tabelaChecagemAgenda.getColumnModel().getColumn(4).setPreferredWidth(101);

		//Chamando a View Checagem de Dados - For each
		for (FuncaoPessoa FP : crudSql.chamarFuncaoPessoa() ) {
			String Nome = FP.getNomeFP();
			String CPF = FP.getCPFFP();
			String Funcao = FP.getNomeFuncaoFP();
			String Endereco = FP.getEnderecoFP();
			Double Salario = FP.getSalarioFuncaoFP();
			Object[] infosLinha ={
				Nome,
				CPF,
				Funcao,
				Endereco,
				Salario
			};

			modelo.addRow(infosLinha);
		}
		tabelaChecagemAgenda.setForeground(new Color(51, 0, 51));
		tabelaChecagemAgenda.setFont(new Font("Georgia", Font.PLAIN, 12));
		tabelaChecagemAgenda.setRowSelectionAllowed(false);
		tabelaChecagemAgenda.setBackground(new Color(255, 255, 204));
		tabelaChecagemAgenda.setBorder(new LineBorder(Color.WHITE));
		
		JButton botaoRetornar = new JButton("Retornar");
		botaoRetornar.setFont(new Font("Monospaced", Font.ITALIC, 20));
		botaoRetornar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				janelaPrincipal menuPrincipal = new janelaPrincipal();
				menuPrincipal.voltarAoMenu(menuPrincipal);
			}
		});
		botaoRetornar.setBounds(21, 379, 310, 49);
		contentPane.add(botaoRetornar);
		
		botaoInserir = new JButton("Inserir");
		botaoInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				janelaInserirPessoa inserirPessoa = new janelaInserirPessoa();
				if (!inserirPessoa.isActive()){
					dispose();
					inserirPessoa.getLocation(null);
					inserirPessoa.setVisible(true);
				}
			}
		});
		botaoInserir.setFont(new Font("Monospaced", Font.ITALIC, 20));
		botaoInserir.setBounds(375, 379, 310, 49);
		contentPane.add(botaoInserir);
	}
}
