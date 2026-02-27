package maven.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    private static final String URL = "jdbc:postgresql://localhost:5432/teste";
    private static final String USUARIO = "ti2cc";
    private static final String SENHA = "ti@cc";

    public static void main(String[] args) {
        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("✅ Conexão com o banco 'teste' realizada com sucesso!");

        } catch (SQLException e) {
            System.out.println("❌ Erro ao conectar ao banco de dados 'teste'.");
            System.out.println("Verifique a URL, usuário, senha e se o banco de dados está rodando.");
            e.printStackTrace();
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("Conexão fechada.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}