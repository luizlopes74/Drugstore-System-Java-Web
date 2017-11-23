
package br.com.drogaria.dao;

import br.com.drogaria.conexao.FabricaConexao;
import br.com.drogaria.domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDAO {
    
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;
    Connection conexao;
    
    public Usuario validarLogin(String login, String senha) throws SQLException{
        Usuario usu = null;
        conexao=FabricaConexao.conexaoBanco();
        sql="select * from usuario where usulogin = ? and ususenha = ?";
        pstm=conexao.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, senha);
        rs=pstm.executeQuery();
        if(rs.next()){
            usu = new Usuario();
            usu.setNome(rs.getString("usunome"));
            System.out.println(rs.getString("usunome"));
            usu.setTipoUsuario(rs.getInt("usutipo"));
        }
        return usu;
    }
}
