package br.com.fh.jokenpo.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fh.jokenpo.jdbc.ConnectionFactory;

@Controller
public class CriaInfraController {
	@RequestMapping("/tabelas")
	public String criaBanco() throws ClassNotFoundException, SQLException{
		Connection c = new ConnectionFactory().getConnection();
		PreparedStatement st1 = c.prepareStatement("drop table if exists jogada");
		st1.execute();
		
		PreparedStatement st11 = c.prepareStatement("CREATE TABLE `jogada`(\r\n" + 
				"`identificador` int(10) AUTO_INCREMENT,\r\n" + 
				"`jogador` varchar(400) NOT NULL,\r\n" + 
				"`data_cadastro` date,\r\n" + 
				"`jogada_jogador` varchar(7),\r\n" + 
				"`jogada_computador` varchar(7),\r\n" + 
				"`resultado` varchar(255),\r\n" + 
				"PRIMARY KEY (`identificador`)\r\n" + 
				");");
		st11.execute();
		c.close();
		return "infra-ok";
	}
}
