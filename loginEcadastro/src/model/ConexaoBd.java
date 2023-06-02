package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBd {

    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/cadastro";

    public static Connection criarConexaoBd() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

    }

    public static void main(String[] args) {
        Connection con = null;

        try {
            con = criarConexaoBd();
            System.out.println("Conexão obtida com sucesso");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL não encontrado.");
        } catch (SQLException e) {
            System.err.println("Erro ao conectar com o MySQL: " + e.getMessage());
        } finally {
            if (con != null) {
                try {
                    con.close();
                    System.out.println("Conexão fechada com sucesso");
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão com o MySQL: " + e.getMessage());
                }
            }
        }

    }
}
