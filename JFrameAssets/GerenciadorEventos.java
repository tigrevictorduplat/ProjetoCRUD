package JFrameAssets;

import javax.swing.*;
//import java.awt.*;
import java.awt.event.*;
@SuppressWarnings("serial")
public class GerenciadorEventos extends JFrame implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {     
    }
    public void Listar() {
        JOptionPane.showMessageDialog(null, "Listar Clicado!", "Teste de Output", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
