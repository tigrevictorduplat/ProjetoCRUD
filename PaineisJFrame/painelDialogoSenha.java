package PaineisJFrame;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ConectorMySQL.ConectorBancoDados;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class painelDialogoSenha extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField campoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			painelDialogoSenha painelDialogoSenha = new painelDialogoSenha();
			painelDialogoSenha.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			painelDialogoSenha.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public painelDialogoSenha() {
		setType(Type.POPUP);
		setTitle("Acesso ao Banco");
		setBounds(100, 100, 450, 255);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(10, 144, 397, 47);
			contentPanel.add(buttonPane);
			buttonPane.setLayout(null);
			{
				JButton botaoConfirmar = new JButton("Confirmar");
				botaoConfirmar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
						try {
							String senhaInput = String.valueOf(campoSenha.getPassword());
							if(senhaInput.isEmpty()==false){
								ConectorBancoDados.setSenhaConexao(senhaInput);
								dispose();
								tabelaChecagemAgenda janelaTabela = new tabelaChecagemAgenda();
								if (!(janelaTabela.isActive())){
									janelaTabela.getLocation(null);
									janelaTabela.setVisible(true);
								}
							} else {JOptionPane.showMessageDialog(null, "Digite uma senha!", "Campo Nulo",2);}
						}catch (Exception ex) {
							ex.getStackTrace();
						}
					}
				}
					
				);
				botaoConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				botaoConfirmar.setBounds(10, 9, 149, 34);
				buttonPane.add(botaoConfirmar);
				botaoConfirmar.setActionCommand("OK");
				getRootPane().setDefaultButton(botaoConfirmar);
			}
			{
				JButton botaoCancelar = new JButton("Cancelar");
				botaoCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						janelaPrincipal menuPrincipal = new janelaPrincipal();
						menuPrincipal.voltarAoMenu(menuPrincipal);
						
					}
				});
				botaoCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
				botaoCancelar.setBounds(238, 9, 149, 34);
				buttonPane.add(botaoCancelar);
				botaoCancelar.setActionCommand("Cancel");
			}
		}
		
		campoSenha = new JPasswordField();
		campoSenha.setBounds(75, 86, 251, 36);
		contentPanel.add(campoSenha);
		
		JLabel instrucaoSenha = new JLabel("Escreva abaixo a senha para acessar o Banco");
		instrucaoSenha.setHorizontalAlignment(SwingConstants.CENTER);
		instrucaoSenha.setFont(new Font("Calibri", Font.BOLD, 16));
		instrucaoSenha.setBounds(10, 40, 416, 36);
		contentPanel.add(instrucaoSenha);
	}
}
