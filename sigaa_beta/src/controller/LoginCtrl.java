package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.ConexaoBd;
import model.UsuarioModel;

public class LoginCtrl {

    UsuarioModel info = new UsuarioModel();

    public void fazerLogin() throws Exception {

        info.setLogin_usuario(JOptionPane.showInputDialog(null, "Digite o seu login"));

        info.setSenha_usuario(JOptionPane.showInputDialog(null, "Digite sua Senha"));

        save(info);
    }

    public void save(UsuarioModel usuario) throws Exception {
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
        } finally {
            // Fechar a conexão e os recursos
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }

    public ResultSet autenticacaoUsuario(UsuarioModel usuario) throws Exception {

        String sql = ("select * from info where nomeUsuario = ? and senhaUsuario = ?");

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            // criando conexao
            conn = ConexaoBd.criarConexaoBd();
            // preparando a conexao para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, usuario.getLogin_usuario());
            pstm.setString(2, usuario.getSenha_usuario());

            // execultando a query e retornando ese valor pra variavel rs
            rs = pstm.executeQuery();

            if (rs.next()) {
                // Usuário autenticado com sucesso
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
            } else {
                // Usuário não encontrado ou senha incorreta
                JOptionPane.showMessageDialog(null, "Login falhou. Verifique o nome de usuário e senha.");
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null){
                pstm.close();
            }
            if(conn != null){
                conn.close();
            }
                
        }

        return rs;
    }
}
