package model;
import java.awt.*;

import javax.swing.*;

public class LoginInterface extends JFrame {


    public LoginInterface() {
        // Configurações da janela
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        getContentPane().setBackground(Color.BLACK);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(3, 2));
        painel.setBackground(Color.BLACK);

        JLabel lblLogin = new JLabel();
        lblLogin.setText("Login:");
        lblLogin.setForeground(Color.WHITE);

        JLabel lblSenha = new JLabel();
        lblLogin.setText("Senha:");
        lblLogin.setForeground(Color.WHITE);

        //adicionar os componetes no painel
        painel.add(lblLogin);
        painel.add(lblSenha);



        add(painel);



    }


}
