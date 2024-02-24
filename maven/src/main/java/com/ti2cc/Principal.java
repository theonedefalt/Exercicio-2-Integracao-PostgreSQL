package com.ti2cc;
import java.util.Scanner;
public class Principal {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		Scanner scn = new Scanner(System.in);
		
		int x;
		
		 do {
	            System.out.println("1) Listar");
	            System.out.println("2) Inserir");
	            System.out.println("3) Excluir");
	            System.out.println("4) Atualizar");
	            System.out.println("5) Sair");
	            
	            x = scn.nextInt();
	            
	            switch(x) {
	                case 1:
	                    //Mostrar usuários
	                    Pessoa[] usuarios = dao.getUsuariosMasculinos();
	                    usuarios = dao.getUsuarios();
	                    System.out.println("==== Mostrar usuários === ");      
	                    for(int i = 0; i < usuarios.length; i++) {
	                        System.out.println(usuarios[i].toString());
	                    }
	                    break;
	                case 2:
	                    //Inserir um elemento na tabela
	                    Pessoa usuario = new Pessoa(11, "pablo", "pablo",'M');
	                    if(dao.inserirUsuario(usuario)) {
	                        System.out.println("Inserção com sucesso -> " + usuario.toString());
	                    }
	                    break;
	                case 3:
	                    //Excluir usuário
	                    // Definindo o usuário dentro do case 3
	                    Pessoa usuarioExcluir = new Pessoa(/* atributos do usuário */);
	                    dao.excluirUsuario(usuarioExcluir.getCodigo());
	                    break;
	                case 4:
	                    //Atualizar usuário
	                    // Definindo o usuário dentro do case 4
	                    Pessoa usuarioAtualizar = new Pessoa(/* atributos do usuário */);
	                    usuarioAtualizar.setSenha("nova senha");
	                    dao.atualizarUsuario(usuarioAtualizar);
	                    break;
	                case 5:
	                    break; // Não é necessário fazer nada no caso 5, pois o loop será encerrado
	                default:
	                    System.out.println("Opção inválida. Escolha uma opção válida.");
	                    break;
	            }
	        } while (x != 5);
		
		scn.close();
		dao.close();
	}
}