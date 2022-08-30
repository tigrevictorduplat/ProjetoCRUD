package JFrameAssets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public  class JanelaPrincipal extends JFrame{
    GerenciadorEventos evento = new GerenciadorEventos();
    //Dimensões Iniciais
    private int alturaJanela = 260;
    private int larguraJanela = (int) Math.round(alturaJanela*1.777);
    private int alturaJanelaMin = (int) Math.round(alturaJanela*0.8);
    private int larguraJanelaMin = (int) Math.round(larguraJanela*0.8);

    //Textos Painel
    private static JLabel textoBemVindo = new JLabel("Bem vindo(a)!");
    private static JLabel operacoesMenu = new JLabel("Qual operação executar?");
    private static JButton botaoListar = new JButton("Listar");

    //Font Textos
    private static Font fonteTitulo = new Font("Arial", Font.BOLD, 36);
    private static Font fontOperacoes = new Font("Arial",Font.PLAIN,16);

    
   

    public void inicializarPainel(){
         
        setTitle("Histórico de Dívidas");
        setSize(larguraJanela,alturaJanela);
        setMinimumSize(new Dimension(larguraJanelaMin,alturaJanelaMin));

        //Textos e Botões
            setLayout(new FlowLayout());
            //Titulo
            textoBemVindo.setFont(fonteTitulo);
            getContentPane().add(textoBemVindo);
            getContentPane().add(new JLabel(""));
            //Texto Operações
            operacoesMenu.setFont(fontOperacoes);
            getContentPane().add(operacoesMenu);
            // Botão Listar
            getContentPane().add(botaoListar);
            // getContentPane().add(botaoNovo);
        setLocationRelativeTo(null);
         
        setVisible(true);

        //Adicionando Eventos
        botaoListar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                evento.Listar();
            }
        });
        /*
        botaoNovo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                evento.OutraCoisa();
            }
        });
         */

         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
