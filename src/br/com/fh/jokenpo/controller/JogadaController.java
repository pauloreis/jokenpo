package br.com.fh.jokenpo.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fh.jokenpo.dao.JogadaDAO;
import br.com.fh.jokenpo.model.Jogada;

@Controller
public class JogadaController {
	@RequestMapping("/")
	public String execute() {
		return "index";
	}
	
	@RequestMapping("/?")
	public String valid() {
		return "index";
	}
	
	@RequestMapping("/jogada")
	public String jogada(@Valid Jogada jogada, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "index";
		}else{
			session.setAttribute("jogadorLogado", jogada);
			return "principal";
		}
	}
	
	@RequestMapping("/jogar")
	public String jogar(HttpSession session) {
		if(session.getAttribute("jogadorLogado")==null){
			return "redirect:/?";
		}else {
			return "principal";
		}
	}
	
	@RequestMapping("/sair")
	public String sair(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/gravar")
	public void gravar(HttpServletResponse response, HttpServletRequest request) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{		
		Jogada jogada = new Jogada();
		jogada.setJogador(request.getParameter("jogador"));
		jogada.setJogada_jogador(request.getParameter("jogada_jogador"));
		jogada.setJogada_computador(request.getParameter("jogada_computador"));
		jogada.setResultado(request.getParameter("resultado"));
		
		JogadaDAO dao = new JogadaDAO();
		dao.adiciona(jogada);
		
		System.out.println("GRAVAR!");
	}
}
