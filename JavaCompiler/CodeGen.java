class CodeGen{

////backend interpretador 
 

	/* PARTE 3 DO TRABALHO 1 EM DIANTE*/

	// String geraCodigo (ArvoreSintatica arv)
	// {
	// 	double resultado = avaliarArvore(arv);
	// 	return String.valueOf(resultado);
	// }

	// Double avaliarArvore (ArvoreSintatica arv)
	// {

	// if (arv instanceof Mult) {
	// 	double arg1 = avaliarArvore(((Mult)arv).arg1);
	// 	double arg2 = avaliarArvore(((Mult)arv).arg2);
	// 	return arg1 * arg2;
	// }

	// if (arv instanceof Soma) {
	// 	double arg1 = avaliarArvore(((Soma)arv).arg1);
	// 	double arg2 = avaliarArvore(((Soma)arv).arg2);
	// 	return arg1 + arg2;
	// }
		

	// if (arv instanceof Sub) {
	// 	double arg1 = avaliarArvore(((Sub)arv).arg1);
	// 	double arg2 = avaliarArvore(((Sub)arv).arg2);
	// 	return arg1 - arg2;
	// }
		

	// if (arv instanceof Div){
	// 	double arg1 = avaliarArvore(((Div)arv).arg1);
	// 	double arg2 = avaliarArvore(((Div)arv).arg2);
	// 	return arg1 / arg2;
	// }

	// if (arv instanceof Num){
	// 	return (double) ((Num) arv).num;
	// }

	// throw new IllegalArgumentException("");
	// }


	/* PARTE 1 E 2 DO TRABALHO 1 */
	
	String geraCodigo (ArvoreSintatica arv)
	{
		return (geraCodigo2(arv) + "PRINT");
	}
	String geraCodigo2 (ArvoreSintatica arv)
	{

	if (arv instanceof Mult)
		return (geraCodigo2(((Mult) arv).arg1) + 
			geraCodigo2(((Mult) arv).arg2) +
			"MULT\n");
	if (arv instanceof Div)
		return (geraCodigo2(((Div) arv).arg1) + 
			geraCodigo2(((Div) arv).arg2) +
			"DIV\n");
	if (arv instanceof Sub)
		return (geraCodigo2(((Sub) arv).arg1) + 
			geraCodigo2(((Sub) arv).arg2) +
			"SUB\n");

	if (arv instanceof Soma)
		return (geraCodigo2(((Soma) arv).arg1) + 
			geraCodigo2(((Soma) arv).arg2) +
			"SUM\n");

	if (arv instanceof Num)
		return ("PUSH "  + ((Num) arv).num + "\n");

	return "";
	}
}
