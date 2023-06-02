package controller;

import javax.swing.JOptionPane;

import model.CadastroModel;

public class InterfaceCtrl{

    public void fazerLogin() {
        CadastroModel info = new CadastroModel();

        info.setLogin_usuario(JOptionPane.showInputDialog(null, "Digite o seu login"));

        info.setSenha_usuario(JOptionPane.showInputDialog(null, "Digite sua Senha"));
    }

}
