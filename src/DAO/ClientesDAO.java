package DAO;

import JDBC.ConnectionFactory;
import Model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import java.sql.ResultSet; 
import java.util.List;
import java.util.ArrayList;

public class ClientesDAO {
    private Connection conecta;
    
    //Contructor
    public ClientesDAO(){
        this.conecta= new ConnectionFactory().conecta();
    }
    
    //metodo cadastrar cliente
    
    public void cadastrarCliente(Clientes obj){
        try {
            //criar comando sql
            String cmdsql= "insert into clientes(Nome, Cpf, Telefone, Email, Placa, Servico) values(?, ?, ?, ?, ?, ?)";
            //Organizar comando SQL
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
            
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getTelefone());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getPlaca());
            stmt.setString(6, obj.getServico());
            
            //executa o comando
            
            stmt.execute();
            
            //fecha conexao
            
            stmt.close();
            
        } catch (SQLException erro) {
            throw new RuntimeException(erro);
        }
    }

    //Listar TODOS os Clientes
       public List<Clientes> ListarClientes(){
           try {
               //criar vetor de armazenamento para os registros do banco
               List<Clientes> lista = new ArrayList<Clientes>();
               //comando sql
               String cmdsql= "select * from clientes";
               
               PreparedStatement stmt = conecta.prepareStatement(cmdsql);
               //Enquanto houver Registros ele os guardará na lista (resultado do select)
               ResultSet rs = stmt.executeQuery();
               
               while(rs.next()){
                   Clientes v = new Clientes();
                   v.setId(rs.getInt("id"));
                   v.setNome(rs.getString("Nome"));
                   v.setCpf(rs.getString("Cpf"));
                   v.setTelefone(rs.getString("Telefone"));
                   v.setEmail(rs.getString("Email"));
                   v.setPlaca(rs.getString("Placa"));
                   v.setServico(rs.getString("Servico"));
                   
                   
                   lista.add(v);
               }
               return lista;
           } catch (SQLException erro) {
               throw new RuntimeException(erro);
           }
       }
       
       //Alterar Cliente
       public void alterarCliente(Clientes obj){
    try {
        //criar comando sql CORRIGIDO
        String cmdsql= "update clientes set Nome=?, Cpf=? , Telefone=? , Email=? , Placa= ?, Servico =?  where id = ?";
        
        //Organizar comando SQL
        PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getCpf());
        stmt.setString(3, obj.getTelefone());
        stmt.setString(4, obj.getEmail());
        stmt.setString(5, obj.getPlaca());
        stmt.setString(6, obj.getServico());
        stmt.setInt(7, obj.getId());
        
        //executa o comando
        stmt.execute();
        
        //fecha conexao
        stmt.close();
        
    } catch (SQLException erro) {
        throw new RuntimeException(erro);
    }
}
       
       //Excluir Cliente
        public void excluirCliente(Clientes obj){
        try {
            //criar comando sql CORRIGIDO (alterado "cliente" para "clientes")
            String cmdsql = "delete from clientes where id = ?";
        
            //Organizar comando SQL
            PreparedStatement stmt = conecta.prepareStatement(cmdsql);
        
            stmt.setInt(1, obj.getId());
        
            //executa o comando
            stmt.execute();
        
             //fecha conexao
            stmt.close();
        
    } catch (SQLException erro) {
        throw new RuntimeException(erro);
    }
}
        

        
}