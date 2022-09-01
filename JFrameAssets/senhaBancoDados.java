package JFrameAssets;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ConexaoSQL.ConexaoBanco;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class senhaBancoDados extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField campoSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			senhaBancoDados popUpSenha = new senhaBancoDados();
			popUpSenha.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			popUpSenha.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public senhaBancoDados() {
		setType(Type.POPUP);
		setTitle("Senha de Acesso");
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
							ConexaoBanco.setSenhaBanco(campoSenha.getPassword().toString());
							tabelaPessoaDivida janelaTabela = new tabelaPessoaDivida();
							if (!(janelaTabela.isActive())){
							janelaTabela.getLocation(null);
							janelaTabela.setVisible(true);
						}
						
					}}
					
					
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
						janelainicial menuPrincipal = new janelainicial();
						dispose();
						if(!menuPrincipal.isActive()){menuPrincipal.setVisible(true);}
						
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
		
		JLabel instrucaoSenha = new JLabel("Digite abaixo a senha de acesso ao Banco de Dados:");
		instrucaoSenha.setHorizontalAlignment(SwingConstants.CENTER);
		instrucaoSenha.setFont(new Font("Georgia", Font.BOLD, 14));
		instrucaoSenha.setBounds(10, 40, 416, 36);
		contentPanel.add(instrucaoSenha);
	}
}
