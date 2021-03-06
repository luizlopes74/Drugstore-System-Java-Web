package br.com.drogaria.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {

    private static final String URL = "jdbc:mysql://localhost:3306/drogaria";
    private static final String USUARIO = "root";
    private static final String SENHA = "1234";
    static Connection conecta = null;
    public static Connection conexaoBanco() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conecta = DriverManager.getConnection(URL, USUARIO, SENHA);
            System.out.println("Legal");
        } //fim
        catch (ClassNotFoundException ex) {
            System.out.println("Arquivo não encontrado " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o mysql " + ex.getMessage());
        }
        return conecta;

    }//fim do metodo
    public static void fecharConexao(){
        try {
            conecta.close();
        } catch (SQLException ex) {
            Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
