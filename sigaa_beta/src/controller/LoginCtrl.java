package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.swing.JOptionPane;

import model.ConexaoBd;
import model.UsuarioModel;

public class LoginCtrl{

    UsuarioModel info = new UsuarioModel();

    public void fazerLogin() throws Exception {

        info.setLogin_usuario(JOptionPane.showInputDialog(null, "Digite o seu login"));

        info.setSenha_usuario(JOptionPane.showInputDialog(null, "Digite sua Senha"));

        save(info);
    }

    public void save(UsuarioModel usuario) throws Exception{
        String sql = "insert into info(nomeUsuario, senhaUsuario)values (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBd.criarConexaoBd();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, info.getLogin_usuario());
            pstm.setString(2, info.getSenha_usuario());

            pstm.execute();

        } catch (Exception erro) {
            // Lidar com a exceção
            throw erro;
        }finally{
            // Fechar a conexão e os recursos
            if(pstm != null){
                pstm.close();
            }
            if(conn != null){
                conn.close();
            }
        }

    }

}
