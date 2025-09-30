class CodeGen{

////backend interpretador 

	String geraCodigo (ArvoreSintatica arv)
	{
		double resultado = avaliarArvore(arv);
		return String.valueOf(resultado);
	}

	Double avaliarArvore (ArvoreSintatica arv)
	{

	if (arv instanceof Mult) {
		double arg1 = avaliarArvore(((Mult)arv).arg1);
		double arg2 = avaliarArvore(((Mult)arv).arg2);
		return arg1 * arg2;
	}

	if (arv instanceof Soma) {
		double arg1 = avaliarArvore(((Soma)arv).arg1);
		double arg2 = avaliarArvore(((Soma)arv).arg2);
		return arg1 + arg2;
	}
		

	if (arv instanceof Sub) {
		double arg1 = avaliarArvore(((Sub)arv).arg1);
		double arg2 = avaliarArvore(((Sub)arv).arg2);
		return arg1 - arg2;
	}
		

	if (arv instanceof Div){
		double arg1 = avaliarArvore(((Div)arv).arg1);
		double arg2 = avaliarArvore(((Div)arv).arg2);
		return arg1 / arg2;
	}

	if (arv instanceof Num){
		return (double) ((Num) arv).num;
	}

	throw new IllegalArgumentException("");
	}
}
