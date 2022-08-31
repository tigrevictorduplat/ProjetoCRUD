package JFrameAssets;

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

public class janelainicial extends JFrame {
	GerenciadorEventos evento =  new GerenciadorEventos();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					janelainicial menuPrincipal = new janelainicial();
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
	public janelainicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel textoTitulo = new JLabel("Bem vindo(a) ao Histórico de Dívidas!");
		textoTitulo.setFont(new Font("Georgia", Font.PLAIN, 30));
		textoTitulo.setBounds(10, 10, 510, 79);
		contentPane.add(textoTitulo);
		
		JLabel textoMenu = new JLabel("Selecione a operação desejada:");
		textoMenu.setFont(new Font("Georgia", Font.PLAIN, 16));
		textoMenu.setBounds(153, 143, 224, 31);
		contentPane.add(textoMenu);
		
		JButton botaoLeia = new JButton("Abrir Tabela");

		botaoLeia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dispose();
					tabelaPessoaDivida janelaTabela = new tabelaPessoaDivida();
					if (!(janelaTabela.isActive())){
					janelaTabela.getLocation(null);
					janelaTabela.setVisible(true);
				}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		botaoLeia.setFont(new Font("Monospaced", Font.BOLD, 12));
		botaoLeia.setForeground(Color.DARK_GRAY);
		botaoLeia.setBackground(Color.LIGHT_GRAY);
		botaoLeia.setBounds(163, 184, 197, 31);
		contentPane.add(botaoLeia);
	}
}
