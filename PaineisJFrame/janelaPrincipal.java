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
		
		JLabel textoTitulo = new JLabel("Sua Agenda PetWalker!");
		textoTitulo.setFont(new Font("Georgia", Font.PLAIN, 30));
		textoTitulo.setBounds(49, 10, 323, 79);
		contentPane.add(textoTitulo);
		
		JButton botaoAbrirAgenda = new JButton("Abrir Agenda");

		botaoAbrirAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					dispose();
					painelDialogoSenha painelSenha = new painelDialogoSenha();
					painelSenha.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});

		botaoAbrirAgenda.setFont(new Font("Monospaced", Font.BOLD, 12));
		botaoAbrirAgenda.setForeground(Color.DARK_GRAY);
		botaoAbrirAgenda.setBackground(new Color(204, 153, 153));
		botaoAbrirAgenda.setBounds(131, 119, 197, 31);
		contentPane.add(botaoAbrirAgenda);
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
