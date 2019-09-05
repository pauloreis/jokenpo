package br.com.fh.jokenpo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import br.com.fh.jokenpo.jdbc.ConnectionFactory;
import br.com.fh.jokenpo.model.Jogada;


public class JogadaDAO {
	private Connection connection;
	
	private void getConexao() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
	}
	
	public void adiciona(Jogada jogada) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		getConexao();
		
		java.sql.Date dataParaGravar = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		
		String sql = "insert into jogada(jogador, data_cadastro, jogada_jogador, jogada_computador, resultado)"
				+ "values(?,?,?,?,?)";
		PreparedStatement stmt;
		
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, jogada.getJogador());
		stmt.setDate(2, dataParaGravar);
		stmt.setString(3, jogada.getJogada_jogador().toString());
		stmt.setString(4, jogada.getJogada_computador().toString());
		stmt.setString(5, jogada.getResultado());
		
		stmt.execute();
		stmt.close();
        System.out.println("Gravado!");
        connection.close();
		
	}
}
