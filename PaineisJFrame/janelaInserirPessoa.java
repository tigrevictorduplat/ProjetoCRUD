package PaineisJFrame;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ClassesPrincipais.Pessoa;
import ConectorMySQL.TradutorJavaMySQL;

public class janelaInserirPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoCPF;
	private JTextField campoEndereco;
	private static int idFuncaoInserir;

	public static int getIdFuncaoInserir() {
		return idFuncaoInserir;
	}

	public static void setIdFuncaoInserir(int idFuncaoInserir) {
		janelaInserirPessoa.idFuncaoInserir = idFuncaoInserir;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaInserirPessoa frame = new janelaInserirPessoa();
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
	public janelaInserirPessoa() {
		TradutorJavaMySQL crudSql = new TradutorJavaMySQL();
		setResizable(false);
		setTitle("Inserir Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelNome = new JLabel("Nome");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNome.setBounds(10, 30, 50, 36);
		contentPane.add(labelNome);
		
		JLabel labelNome_1 = new JLabel("CPF");
		labelNome_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNome_1.setBounds(10, 76, 50, 36);
		contentPane.add(labelNome_1);
		
		JLabel labelNome_2 = new JLabel("Endereço");
		labelNome_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNome_2.setBounds(10, 122, 66, 36);
		contentPane.add(labelNome_2);
		
		JLabel labelNome_2_1 = new JLabel("Função");
		labelNome_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		labelNome_2_1.setBounds(10, 205, 66, 36);
		contentPane.add(labelNome_2_1);
		
		JRadioButton radioProfessor = new JRadioButton("Professor");
		JRadioButton radioAluno = new JRadioButton("Aluno");
		
		//Criando Botão Professor
		radioProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioAluno.isSelected()){radioAluno.setSelected(false);}
				janelaInserirPessoa.setIdFuncaoInserir(2);
			}
		});
		
		radioProfessor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioProfessor.setBounds(82, 220, 103, 21);
		contentPane.add(radioProfessor);
		
		//Criando Botão Aluno
		radioAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (radioProfessor.isSelected()){radioProfessor.setSelected(false);}
				janelaInserirPessoa.setIdFuncaoInserir(1);
			
			}
		});
		radioAluno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		radioAluno.setBounds(187, 220, 103, 21);
		contentPane.add(radioAluno);
		
		campoNome = new JTextField();
		campoNome.setBounds(78, 40, 302, 21);
		contentPane.add(campoNome);
		campoNome.setColumns(10);
		
		campoCPF = new JTextField();
		campoCPF.setColumns(10);
		campoCPF.setBounds(78, 87, 302, 21);
		contentPane.add(campoCPF);
		
		campoEndereco = new JTextField();
		campoEndereco.setColumns(10);
		campoEndereco.setBounds(88, 127, 324, 80);
		contentPane.add(campoEndereco);
		
		JButton botaoAdd = new JButton("Adicionar");
		botaoAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa(campoCPF.getText(), campoNome.getText(), campoEndereco.getText());
				crudSql.inserirPessoa(pessoa, janelaInserirPessoa.getIdFuncaoInserir());	
				campoNome.setText("");
				campoCPF.setText("");
				campoEndereco.setText("");

			}
		});
		botaoAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAdd.setBounds(10, 263, 176, 35);
		contentPane.add(botaoAdd);
		
		JButton botaoAbrirTabela = new JButton("Abrir Tabela");
		botaoAbrirTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaFuncaoPessoa janelaTabela = new tabelaFuncaoPessoa();
				if (!janelaTabela.isActive()){
					dispose();
					janelaTabela.getLocation(null);
					janelaTabela.setVisible(true);
				}
			}
		});
		botaoAbrirTabela.setFont(new Font("Tahoma", Font.PLAIN, 14));
		botaoAbrirTabela.setBounds(250, 265, 176, 35);
		contentPane.add(botaoAbrirTabela);
	}
}
