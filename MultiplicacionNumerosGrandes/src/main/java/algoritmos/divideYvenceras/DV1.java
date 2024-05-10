package algoritmos.divideYvenceras;

public class DV1
{

	//Con el siguiente metodo evaluamos
	//que tamaño deberia tener el arreglo
	//en terminos de multiplos de dos (2^n)
	//para garantizar que los vectores en las 
	//llamadas recursivas del metodo fueran
	//siempre pares.
	public static int evaluar(int a,int b)	{
		int k,aux,cifras=0,aux2=2;
		if(a>b)
		{ aux=a;
		}
		else{ if(b>a){aux=b;
		}
		else{aux=a;
		}
		}
		cifras=aux;

		aux=1;
		for(int i=1;i<=10;i++)
		{ for(k=0;k<i;k++)
		{ aux=aux*aux2;
		}
			if(aux>=cifras)
			{
				return aux;
			}

			else{
				aux=1;
			}
		}
		return 0;
	}

	//En el siguiente metodo llenamos un vector 
	//con los numeros obtenidos en el campo texto
	public static int[] convertir(String cadena){

		String s;
		char cad[];

		cad= cadena.toCharArray();

		int n[]=new int[cad.length];


		cad= cadena.toCharArray();


		for(int i=0;i<(cad.length);i++){
			s=""+cad[i];
			n[i]=Integer.parseInt(s);
			//System.out.print(""+n[i]);		
		}

		return n;

	}


	//Este es el algoritmo clasico de la multiplicacion		
	public static int[] Alg(int Num[],int tam1,int Num2[],int tam2){


		int  l=tam1+tam2-1,pos=tam1+tam2-1;;
		int res[]= new int[tam1+tam2];


		for(int y=0;y<=tam1+tam2-1;y++){
			res[y]=0;
		}


		//---------------------Algoritmo clasico de la multiplicacion---Inicio--------------------
		for( int  i=tam1-1;i>=0;i--){

			for( int  j=tam2-1;j>=0;j--){

				res[l]+=Num[i]*Num2[j];  //Multiplica cada posicion de los dos vectores
				if(res[l]>9){			   //teniendo en cuenta el orden.
					res[l-1]+=res[l]/10;
					res[l]=res[l]%10;
				}
				l--;
			}
			l=pos;
			pos--;
			l--;
		}
		//---------------------Algoritmo clasico de la multiplicacion--fin--------------------
		return res;

	}

	//-----------------------------------Algoritmo DV#1---------------------------------------		

	public static int[] multiplicar(int arreglo1[],int arreglo2[],int n)
	{
		int x[],y[],z[],w[],s[],t[],u[],resultado1[],resultado2[],resultado3[],respuesta[],auxr[],auxs[],auxt[],auxu[], r[];


		if(n==2)  //Caso trivial, donde llamamos el algoritmo clasico
		{
			respuesta = new int[n+1];
			respuesta = Alg(arreglo1,n,arreglo2,n);
			return respuesta;
		}
		else
		{
			x=new int[n/2];
			y=new int[n/2];
			z=new int[n/2];
			w=new int[n/2];

			for(int i=0; i<n/2; i++)
			{
				w[i] = arreglo1[i];        //w[0]=1				     
				x[i] = arreglo1[i+(n/2)];  //x[0]=3	
				y[i] = arreglo2[i];        //y[0]=3
				z[i] = arreglo2[i+(n/2)];  //z[0]=2
			}
			r = new int [2*n];
			auxr = new int [n];
			iniceros(r,2*n);
			auxr = multiplicar(w,y,n/2);

			for(int i=0;i<n;i++)
			{
				r[i]=auxr[i];
			}

			s = new int[n+(n/2)];//s guarda la multiplicacion de los vectores "w" y "z"
			auxs = new int[n+(n/2)];
			iniceros(s,n+(n/2));//inicializamos s con ceros garantizando los ceros de
			auxs = multiplicar(w,z,n/2);  //la formula

			for(int i=0; i<n; i++)
			{
				s[i] = auxs[i];
			}

			t = new int[(n/2)+n]; //t guarda la multiplicacion de los vectores "x" y "y"
			auxt = new int[n];
			iniceros(t,(n/2)+n);
			auxt = multiplicar(x,y,n/2);

			for(int i=0; i<n; i++)
			{
				t[i] = auxt[i];
			}

			u = new int[n];//u guarda la multiplicacion de los vectores "x" y "z"
			iniceros(u,n);
			u = multiplicar(x,z,n/2);

			resultado1 = new int[2*n];
			iniceros(resultado1,2*n);
			resultado1 = suma(r,2*n,s,n+(n/2));//el vector res guarda la suma de "r" y "s"

			resultado2 = new int[(n/2)+n];
			iniceros(resultado2,(n/2)+n);
			resultado2 = suma(t,n+(n/2),u,n);//el vector res2 guarda la suma de "t" y "u"

			resultado3 = new int[2*n];
			iniceros(resultado3,2*n);
			resultado3 = suma(resultado1,2*n,resultado2,(n/2)+n);
			//el vector res3 guarda la suma de "res" y "res2"
			return resultado3;
		}
	}




	//----------------------------------------------------------------------------------------			
	//Algoritmo que suma dos vectores de diferente tamaño y retorna un vector con el 
	//tamaño del vector recibido como parametro mas grande (necesitada principalmente en DV#1)
	public static int[] suma(int vec1[],int n,int vec2[],int m ){
		int resu[];
		int k,p,r,s,i,j,l,aux,aux2,tam;

		if(n>m||n==m)
		{ aux=m;
			aux2=n;
		}
		else{ aux=n;
			aux2=m;
		}

		resu=new int[aux2];
		iniceros(resu,aux2);
		k=aux2-1;
		for(i=aux-1,l=aux2-1;i>=0;i--,l--)
		{ p=vec1[l]+vec2[i];
			if(p>9)
			{ r=p%10;
				s=p/10;
				resu[k]+=r;

				resu[k-1]+=s;
			}
			else{
				resu[k]+=p;
				if(resu[k]>9)
				{
					r=resu[k]%10;
					s=resu[k]/10;
					resu[k]=r;
					resu[k-1]+=s;
				}

			}
			k--;
		}
		if(n!=m)
			for(i=l;i>=0&&l>=0;i--,l--)
			{
				if(n>m) resu[i]+=vec1[l];
				else resu[i]+=vec2[l];
			}


		return resu;
	}

	//Algoritmo que suma dos vectores de igual tamaño y retorna un vector con el 
	//tamaño  recibido como parametro mas uno (necesitada principalmente en DV#2)
	public int[] suma2(int vec1[],int vec2[],int n){
		int resu[];
		int k,p,r,i,j;

		resu=new int [n+1];

		iniceros(resu,n+1);
		j=n;
		for(i=n-1;i>=0;i--){
			k=vec1[i]+vec2[i];
			if(k>9){
				p=k%10;
				r=k/10;
				resu[j]=resu[j]+p;
				resu[j-1]=r;
			}
			else{
				resu[j]=resu[j]+k;
			}
			j--;
		}


		return resu;
	}

	//Este metodo incializa los arreglos con ceros
	static void iniceros(int arre[],int tam)
	{

		for(int i=0; i<tam; i++)
		{
			arre[i]=0;
		}
	}

	//Este metodo resta dos vectores de diferente tamaño y retorna otro con el tamaño del mas
	//grande recibido por parametro
	int[] resta(int Num[],int tam,int Num2[],int tam2){
		int r,j,carry=0,i;
		int resu[];


		resu=new int[tam];

		for(i=0;i<tam;i++){
			resu[i]=0;
		}

		for(i=tam-1,j=tam2-1;j>=0;i--,j--){
			if(Num[i]>=Num2[j]){
				if((Num[i]+carry)>=Num2[j]){
					resu[i]=resu[i]+(Num[i]+carry)-Num2[j];
					carry=0;
				}
				else{  	r=Num[i]+carry+10;
					resu[i]=resu[i]+(r-Num2[j]);
					carry=-1;

				}
			}
			else
			{
				r=Num[i]+10;
				resu[i]=resu[i]+(r-Num2[j]+carry);
				carry=-1;
			}
		}
		resu[i]+=carry;

		for(j=i;j>=0;j--){
			resu[j]+=Num[j];
		}


		return resu;
	}

}