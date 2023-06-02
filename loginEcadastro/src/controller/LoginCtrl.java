package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.ConexaoBd;

public class LoginCtrl {

    public void cadastrar(String login, String senha) throws Exception {
        String sql = "insert into info (nomeUsuario, senhaUsuario)values (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBd.criarConexaoBd();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, login);
            pstm.setString(2, senha);

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

    public ResultSet autenticacaoUsuario(String login, String senha) throws Exception {

        String sql = ("select * from info where nomeUsuario = ? and senhaUsuario = ?");

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            // criando conexao
            conn = ConexaoBd.criarConexaoBd();
            // preparando a conexao para executar a query
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, login);
            pstm.setString(2, senha);

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
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

        return rs;
    }

    public void excluirCadastro(int id) throws Exception {

        String sql = "delete from info where id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConexaoBd.criarConexaoBd();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

            JOptionPane.showMessageDialog(null, "Seu login foi excluido!");

        } catch (SQLException erro) {
            System.out.println("Erro na classe loginCtrl");
        } finally {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }

        }

    }

}
