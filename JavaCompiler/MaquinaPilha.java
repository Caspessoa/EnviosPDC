
//entrada arquivo com instruções e saída o resultado da final da execução

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;

class MaquinaPilha {
    BufferedReader arquivo;

    MaquinaPilha(String a) throws Exception{
	 	this.arquivo = new BufferedReader(new FileReader(a));
	}

    void delArchive() throws Exception{
	 	this.arquivo.close();
	}

    void executa() throws Exception{
        Deque<Integer> p = new ArrayDeque<Integer>();
        //Stack p = new Stack();
        String linha;

        while((linha = arquivo.readLine()) != null)
            if (linha.length() > 0) {
                String[] partes = linha.split(" ");
                String instrucao = partes[0];

                switch (instrucao) {
                    case "PUSH":
                        if (partes.length != 2) {
                            throw new Exception("Erro: PUSH requer um argumento.");
                        }
                        int valor = Integer.parseInt(partes[1]);
                        p.push(valor);
                        break;

                    case "SUM":
                        if(p.size() < 2 ) {
                            throw new Exception("Erro: Não há elementos suficientes na pilha para SUM.");
                        }
                        int b = p.pop();
                        int a = p.pop();
                        p.push(a + b);
                        break;

                    case "SUB":
                        if(p.size() < 2 ) {
                            throw new Exception("Erro: Não há elementos suficientes na pilha para SUB.");
                        }
                        a = p.pop();
                        b = p.pop();
                        p.push(a - b);
                        break;

                    case "MULT":
                        if(p.size() < 2 ) {
                            throw new Exception("Erro: Não há elementos suficientes na pilha para MULT.");
                        }
                        b = p.pop();
                        a = p.pop();
                        p.push(a * b);
                        break;

                    case "DIV":
                        if(p.size() < 2 ) {
                            throw new Exception("Erro: Não há elementos suficientes na pilha para DIV.");
                        }
                        a = p.pop();
                        b = p.pop();
                        if (b == 0) {
                            throw new Exception("Erro: Divisão por zero.");
                        }
                        p.push(a / b);
                        break;

                    case "PRINT":
                        System.out.println(p.pop());
                        break;

                    default:
                        throw new Exception("Erro: Instrução desconhecida '" + instrucao + "'.");
                }
            }

        if (!p.isEmpty()) {
            throw new Exception("Erro: Pilha não está vazia após a execução.");
        }
        delArchive();
    }
    


}