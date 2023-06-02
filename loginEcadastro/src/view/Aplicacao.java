package view;

import javax.swing.JOptionPane;

import controller.LoginCtrl;

public class Aplicacao {
    public static void main(String[] args) throws Exception {

        LoginCtrl crtl = new LoginCtrl();

        String login;

        String senha;

        String[] opcoes = { "1. Cadastro", "2. Login" };

        int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:",
                "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opcoes, opcoes[0]);

        switch (escolha) {
            case 0:

                login = JOptionPane.showInputDialog(null, "Digite seu login:", "Login", JOptionPane.PLAIN_MESSAGE);
                senha = JOptionPane.showInputDialog(null, "Digite sua senha:", "Senha", JOptionPane.PLAIN_MESSAGE);

                crtl.cadastrar(login, senha);

                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                break;
            case 1:
                login = JOptionPane.showInputDialog(null, "Digite seu login:", "Login", JOptionPane.PLAIN_MESSAGE);
                senha = JOptionPane.showInputDialog(null, "Digite sua senha:", "Senha", JOptionPane.PLAIN_MESSAGE);
                crtl.autenticacaoUsuario(login, senha);
                break;
        }

    }
}
