<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="resources/plugins/bootstrap-4.3.1-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/login.css">
    <link rel="stylesheet" href="resources/plugins/confirm/jquery-confirm.min.css">
    <title>Jokenpo</title>
</head>
<body>
	<input type="hidden" value="${jogadorLogado.jogador}" id="StrSession">
    <div class="mx-auto card" id="box">
        <div class="card-body">           
        <h1 class="card-title">Jokenpo</h1>
        <h3>PLACAR:</h3>
        <form>
            <label>${jogadorLogado.jogador} {<span id="CH">0</span>}</label> <strong>X</strong> <label>{<span id="CM">0</span>} Computador</label>
            <select name=jogada_jogador class="form-control mb-3" id="jogada_jogador">
                <option value="">Selecione...</option>
                <option value="Pedra">Pedra</option>
                <option value="Papel">Papel</option>
                <option value="Tesoura">Tesoura</option>
            </select>
            <p><small><form:errors path="jogada.jogada_jogador" /></small></p>
            <input type="button" value="JOGAR" class="btn btn-dark" id="btnJogar"/>
            <a href="sair" class="btn btn-dark float-right">SAIR</a>
        </form>
        </div>
    </div>
    <script src="resources/plugins/jquery-3.3.1.min.js"></script>
    <script src="resources/plugins/popper.min.js"></script>
    <script src="resources/plugins/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
    <script src="resources/plugins/confirm/jquery-confirm.min.js"></script>
    <script src="resources/js/script.js"></script>
</body>
</html>