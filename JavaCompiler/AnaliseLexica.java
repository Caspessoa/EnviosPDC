import java.io.FileReader;
import java.io.PushbackReader;

enum TokenType{ NUM,SOMA, MULT,APar,FPar, EOF, SUB, DIV}

class Token{
	String lexema; //passar para string
	TokenType token;

	Token (String l, TokenType t)
 	{ lexema=l;token = t;}

	Token (char l, TokenType t)
 	{ lexema=""+l;token = t;}

	Token (TokenType t)
 	{ lexema="";token = t;}

	Token(){
		lexema="";
		token = null;
	}

	public void addChar(char c){
		lexema = lexema + c;
	}

	public void changeType(TokenType t){
		token = t;
	}
}

class AnaliseLexica {

	PushbackReader arquivo;

	AnaliseLexica(String a) throws Exception{
	 	this.arquivo = new PushbackReader(new FileReader(a));
	}

	void delArchive() throws Exception{
	 	this.arquivo.close();
	}

	Token getNextToken() throws Exception {
		int charCode;
		
		// 1. Pula caracteres de espaço em branco (lixo)
		do {
			charCode = arquivo.read();
		} while (charCode != -1 && Character.isWhitespace((char) charCode));
		
		// 2. Verifica se chegou ao fim do arquivo (EOF)
		if (charCode == -1) {
			// Retorna um token de Fim de Arquivo.
			return (new Token((char)charCode,TokenType.EOF)); 
		}

		char currentChar = (char) charCode;

		// 3. Verifica se é um número
		if (Character.isDigit(currentChar)) {
			Token numToken = new Token(TokenType.NUM);
			while (Character.isDigit(currentChar)) {
				numToken.addChar(currentChar);
				
				// Lê o próximo caractere, mas marca a posição antes
				charCode = arquivo.read();
				if (charCode == -1) {
					break; // Fim do arquivo, sai do loop
				}
				currentChar = (char) charCode;
			}

			// Devolve o último caractere lido se ele não for um dígito e não for EOF
			if (charCode != -1) {
				arquivo.unread(charCode);
			}
			
			return numToken;
		}

		// 4. Verifica operadores e parênteses
		switch (currentChar) {
			case '(':
				return new Token(currentChar, TokenType.APar);
			case ')':
				return new Token(currentChar, TokenType.FPar);
			case '+':
				return new Token(currentChar, TokenType.SOMA);
			case '*':
				return new Token(currentChar, TokenType.MULT);
			case '-':
				return new Token(currentChar, TokenType.SUB);
			case '/':
				return new Token(currentChar, TokenType.DIV);
			default:
				// Se não for nenhum dos tipos conhecidos, é um erro
				throw new Exception("Caractere inválido na entrada: '" + currentChar + "'");			
			}
	}
}
