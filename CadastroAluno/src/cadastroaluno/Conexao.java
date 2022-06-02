/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroaluno;
import java.sql.*;
/**
 * @author Arthur
 */
public class Conexao {
    
     
    String driver = "com.mysql.jdbc.Driver";
    String banco = "cadaluno" ;
    String host = "localhost";
    String stringDeConexao = "jdbc:mysql://"+host+":3306/"+banco+"?serverTimezone=UTC";
    String usuario= "root";
    String senha = "SENHA@123";
    
    public Connection conexao;
   
   
    public Connection getConexao(){
        try{
            Class.forName(driver);
            return DriverManager.getConnection(this.stringDeConexao,usuario,senha);
        }catch(ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            return conexao;
        }
    }
    
    public ResultSet getResultSet(String sentenca){               
        try{
            Statement stm = ConexaoBanco.getInstanceStatement();
            ResultSet rs = stm.executeQuery(sentenca);
            return rs;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public String atualizarBanco(String sentenca)
    {
        try{
            var stm = ConexaoBanco.getInstanceStatement();
            stm.executeQuery(sentenca);
            return "1";
        }catch(SQLException e){
            return e.getMessage();
        }catch(Exception ex){
            return ex.getMessage();
        }        
    }  
    
}
