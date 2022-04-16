package com.jdenner.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Classe responsável por abrir a conexão com o banco de dados
 *
 * @author Douglas
 */
public class Conexao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private final String BANCO_DE_DADOS;
    private final String USUARIO = "root";
    private final String SENHA = "Douglas123@";
    private static final String URL = "jdbc:mysql://localhost:3306/dbsistemavenda";
    private Connection conexao;

    public Conexao() throws ClassNotFoundException, SQLException {
        this.BANCO_DE_DADOS = "dbsistemavenda";
        Object connection = null;
       if (connection == null) 
       {
            try 
            {
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USUARIO, SENHA);
            } 
            
            catch (ClassNotFoundException e) 
            {
                JOptionPane.showMessageDialog(null, "Erro ao carregar o driver de conexao\n" + e);
            } 

            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null, "no foi possivel estabalecer conexao com o banco de dados\n" + e);
            }
        }
        JOptionPane.showMessageDialog(null, "conexao realizada com sucesso!");
    }

    public Connection getConexao() 
    {
        return conexao;
    }

    public void confirmar() throws SQLException {
        try 
        {
            conexao.commit();
        } 

        catch (SQLException e) 
        {
            throw new SQLException("Problemas na instrução SQL.\n" + e.getMessage());
        } 

        finally 
        {
            conexao.close();
        }
    }
}
