package PaineisJFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class janelaPrincipal extends JFrame {
	private JPanel contentPane;
	private static int escolhaOperacao;

	public static int getEscolhaOperacao() {
		return escolhaOperacao;
	}

	public static void setEscolhaOperacao(int escolhaOperacao) {
		janelaPrincipal.escolhaOperacao = escolhaOperacao;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelaPrincipal menuPrincipal = new janelaPrincipal();
					menuPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public janelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 232);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoTitulo = new JLabel("Banco Escolar");
		textoTitulo.setFont(new Font("Arial", Font.PLAIN, 30));
		textoTitulo.setBounds(131, 10, 197, 79);
		contentPane.add(textoTitulo);
		
		JButton botaoAbrirAgenda = new JButton("Abrir Tabela");

		botaoAbrirAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dispose();
					painelDialogoSenha painelSenha = new painelDialogoSenha();
					janelaPrincipal.setEscolhaOperacao(1);
					painelSenha.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		botaoAbrirAgenda.setFont(new Font("Monospaced", Font.BOLD, 12));
		botaoAbrirAgenda.setForeground(Color.BLACK);
		botaoAbrirAgenda.setBackground(Color.LIGHT_GRAY);
		botaoAbrirAgenda.setBounds(10, 121, 197, 31);
		contentPane.add(botaoAbrirAgenda);
		
		JButton botaoInserirCadastro = new JButton("Inserir Cadastro");
		botaoInserirCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					painelDialogoSenha painelSenha = new painelDialogoSenha();
					janelaPrincipal.setEscolhaOperacao(2);
					painelSenha.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		botaoInserirCadastro.setForeground(Color.BLACK);
		botaoInserirCadastro.setFont(new Font("Monospaced", Font.BOLD, 12));
		botaoInserirCadastro.setBackground(Color.LIGHT_GRAY);
		botaoInserirCadastro.setBounds(244, 121, 197, 31);
		contentPane.add(botaoInserirCadastro);
	}

	public  void voltarAoMenu(janelaPrincipal menuPrincipal) {
		dispose();
		if (!(menuPrincipal.isActive()))
		{
			menuPrincipal.getLocation(null);
			menuPrincipal.setVisible(true);
		}
	}
}
