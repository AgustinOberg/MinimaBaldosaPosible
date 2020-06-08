public class Main {
	public static void main(String[] args) {
		
		System.out.println(calcular(7, 6));

	}





	
	public static int calcular(int n, int m){
		int baldosaNecesaria = (int)(Math.pow(2, (int)(Math.log(m) / Math.log(2))));	//Calculo la baldosa maxima que necesita M

		boolean corte = n==baldosaNecesaria && m==baldosaNecesaria;	//Pregunto si la baldosa maxima de M es igual a la de N

		if(!corte) {
			boolean nMayor = n>m;	//Separo para saber cual es el mayor

			if(nMayor) {
				int dosx= (int)(Math.log(m) / Math.log(2));
				int baldosa=(int)(Math.pow(2, dosx));
				int ret1 = calcular(m,baldosa);
				int ret2 = calcular(m,n-baldosa);
				return ret1+ret2;
			}
			else {
				int dosx=(int)(Math.log(n) / Math.log(2));	//Calculo el logaritmo en base 2 de 100

				int baldosa=(int)(Math.pow(2, dosx));	//Calculo la baldosa mas grande que se puede 

				int ret1 = calcular(n,baldosa);	//Creo un rectangulo de NxBaldosa

				int ret2 = calcular(n,m-baldosa);	//Creo otro rectangulo de NxRestante
				return  ret1+ret2;
			}
		}
		
		return 1;		
	}
}