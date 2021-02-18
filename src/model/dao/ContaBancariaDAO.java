package model.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.ContaBancaria;



public class ContaBancariaDAO {
	public void create(ContaBancaria c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("INSERT INTO `conta_bancaria`(`agencia`, `conta`, `nome`, `corrente_Poupaça`, `saldo`) VALUES (?,?,?,?,?)");
			stmt.setString(1,c.getAgencia());
			stmt.setString(2,c.getNome());
			stmt.setString(3,c.getConta());
			stmt.setBoolean(4,c.isCorrente_Poupaça());
			stmt.setDouble(5,c.getSaldo());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cadastro na tabela concluido!");
		}
		catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro no salvar no banco: " + e);
			
	}
	finally {
		ConnectionFactory.closeConnection(con, stmt);
	}
		
}

	public List<ContaBancaria> read() {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null; 
		ResultSet rs = null;
		List<ContaBancaria> cs = new ArrayList<>();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM conta_bancaria;");
			rs = stmt.executeQuery();
			while(rs.next()) {
				ContaBancaria c = new ContaBancaria();
				c.setId(rs.getInt("id"));
				c.setAgencia(rs.getString("agencia"));
				c.setNome(rs.getString("nome"));
				c.setConta(rs.getString("conta"));
				c.setCorrente_Poupaça(rs.getBoolean("corrente_Poupaça"));
				c.setSaldo(rs.getDouble("saldo"));
				cs.add(c);
			}
		}
		
		catch(SQLException e){
			JOptionPane.showMessageDialog(null, "erro ao buscar os informaçoes no banco:" + e);
			e.printStackTrace();	
		}
		
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return cs;
	}
	
	
	public ContaBancaria read(int id){
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		ContaBancaria c = new ContaBancaria();
		
		try {
			stmt = con.prepareStatement("SELECT * FROM conta_bancaria WHERE id=? Limit 1");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if(rs != null && rs.next()) {
				c.setId(rs.getInt("id"));
				c.setAgencia(rs.getString("agencia"));
				c.setNome(rs.getString("nome"));
				c.setConta(rs.getString("conta"));
				c.setCorrente_Poupaça(rs.getBoolean("corrente_Poupaça"));
				c.setSaldo(rs.getDouble("saldo"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return c;
	}

	public void  update(ContaBancaria c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		
		try {
			stmt = con.prepareStatement("UPDATE `conta_bancaria` SET `agencia`=?,`conta`=?,`nome`=?,`corrente_Poupaça`=?,`saldo`=? WHERE `id`=? LIMIT 1");
			stmt.setString(1, c.getAgencia());
			stmt.setString(2, c.getConta());
			stmt.setString(3, c.getNome());
			stmt.setBoolean(4, c.isCorrente_Poupaça());
			stmt.setDouble(5, c.getSaldo());
			stmt.setInt(6, c.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null,"Banco de dado atualizado com sucesso!");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro ao Atualizar o Banco de Dados " + e);
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}
	
	public void delete(ContaBancaria c) {
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM conta_bancaria WHERE id =?");
			stmt.setInt(1, c.getId());
			stmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "ContaBancaria deletado com sucesso!");
			
		} catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Erro ao delatar: " + e);
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(con);	
		}
	}
	
}
	
	