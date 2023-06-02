package controller;

import javax.swing.JOptionPane;

import model.UsuarioModel;

public class LoginCtrl{

    public void fazerLogin() {
        UsuarioModel info = new UsuarioModel();

        info.setLogin_usuario(JOptionPane.showInputDialog(null, "Digite o seu login"));

        info.setSenha_usuario(JOptionPane.showInputDialog(null, "Digite sua Senha"));
    }

    public void save(UsuarioModel usuario){
        public String sql = "";
    }

}
