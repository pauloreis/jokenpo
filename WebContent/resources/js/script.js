$(function(){
	if (location.href.indexOf("?") >= 0) {
		$.confirm({
			title: "Atenção!",
			content: "Para acessar essa tela primeiramente o jogador deve ser identificado",
			buttons:{
				Entendi: function () {}
		    }
		});
	}
	
	var CH=1, CM=1 ;
	$("#btnJogar").click(function(){
		var H;
		var jogada_jogador = $("#jogada_jogador").val();
		var jogada_computador="";
		var resultado = "";
		var jogador=$("#StrSession").val();
		
		
		if(jogada_jogador == ''){
			$.confirm({
				title: "Atenção!",
				content: "Uma jogada deverá ser selecionada.",
				buttons:{
					Entendi: function () {}
			    }
			});
		}else{
		
			if(jogada_jogador == 'Pedra'){H = '1';}
			if(jogada_jogador == 'Papel'){H = '2' ;}
			if(jogada_jogador == 'Tesoura'){H = '3';}
			
			M = Math.floor(Math.random() * (3 - 1)) + 1;
			
			if(M == 1){jogada_computador = 'Pedra'};
			if(M == 2){jogada_computador = 'Papel'};
			if(M == 3){jogada_computador = 'Tesoura'};
			
			if((H==1 && M==3) || (H==2 && M==1) || (H==3 && M==2)){
				$.confirm({
					title: "Atenção!",
					content: "Parabéns! {"+jogada_jogador+"} ganha de {"+jogada_computador+"}.",
					buttons:{
						Entendi: function () {}
				    }
				});
				$("#CH").html(CH++);
				resultado = "Humano";
			}
			
			if((H==1 && M==2) || (H==1 && M==2) || (H==3 && M==1)){
				$.confirm({
					title: "Atenção!",
					content: "Não foi dessa vez. {"+jogada_jogador+"} perde de {"+jogada_computador+"}.",
					buttons:{
						Entendi: function () {}
				    }
				});
				$("#CM").html(CM++);
				resultado = "Maquina";
			}
			
			if((H==1 && M==1) ||(H==2 && M==2) ||(H==3 && M==3)){
				$.confirm({
					title: "Atenção!",
					content: 'Empatou. Tente novamente',
					buttons:{
						Entendi: function () {}
				    }
				});
				resultado = "Empate";
			}
			
			var d = new Date();
			dataHora = (d.toLocaleString()); 
			var data = dataHora.split(" ")[0];
			
			
			Vjogador= "jogador="+jogador;
			Vdata_cadastro = "data_cadastro="+data;
			Vjogada_jogador= "jogada_jogador="+jogada_jogador;
			Vjogada_computador= "jogada_computador="+jogada_computador;
			Vresultado="resultado="+resultado;
			campos = Vjogador+"&"+Vdata_cadastro+"&"+Vjogada_jogador+"&"+Vjogada_computador+"&"+Vresultado;
			$.post("gravar?"+campos, function(msg){
				return;
			});
		}
	});
	
	
})