#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <windows.h>
#define tam 6


void jogar () {
	
	//declaracao de variaveis
	int x[tam], num[tam];
	int i, j, y, z, t, a, op;
	char buffer [255];
	y=0, t=10, z=0;
	
	//apresentacao do boletim (menu com os nºs de 1 a 49)
	puts("\n========================================\n");
	for(i=1; i<50; i++) {
		
		printf("%d  ", i);
		if(i==10 || i==20 || i==30 || i==40) puts("\n\t\t\t");
		
	}
	
	puts("\n========================================\n");
	
	//loop para introduzir nºs, guardada num vetor
	for(i=0; i<tam; i++) {
		printf("\n\nINTRODUZA OS NUMEROS DA APOSTA:  "); scanf("%d",&x[i]);
	}
	
	//condicao para nao permitir que os numeros introduzidos sejam maior que 49
	for(i=0; i<tam; i++) {			
		if(x[i]==50 || x[i]>50) {
			printf("\n\nALGUNS DOS NUMEROS INTRODUZIDOS E MAIOR OU IGUAL A 50\n"); 
			system("pause");
			system("cls");
			return 0;
		}
	}
	
	system ("cls");
	
	//apresentar os nºs escolhidos
	printf("NUMEROS ESCOLHIDOS: \n"); 
	for(i=0; i<6; i++) printf("%d\t", x[i]);
	
	//apresentar os nºs extraidos gerada aleatoriamente
	puts("\n\n\nNUMEROS EXTRAIDOS: \n\t");
	
	//condicao para nao permitir que os nºs aleatorios sejam sempre os mesmos
	//semente criada em funcao da hora de execucao do programa
	
	srand(time(NULL));
	
	for(j=0; j<6; j++) {
		//sortear um nº e guardar na variavel z
		z=1+rand()%49;
		
		//guardar cada valor de z em uma posicao do vetor num
		num[j]=z;
		
		//condicao para não repetir os nºs sorteados
		for(i=0; i<6; i++)
			if(i!=j && z!=num[i])
				num[j]=z;
			
	}
		
	//organizar os numeros sorteados por ordem crescente
	for (i = 0; i < tam; ++i) {
		for (j = i + 1; j < tam; ++j) {
		    if (num[i] > num[j]) {
		        a =  num[i];
		        num[i] = num[j];
		        num[j] = a;
		    }
		}
	}
	
	for (i = 0; i < tam; ++i) printf("%d\t", num[i]);
	
	puts("\n\n");
	system ("pause");
	system ("cls");
	
	printf(" %c----------------------------------------------------------------------------%c\n",201,187);
	printf(" |\t\t\t\tPREMIOS\n");
	printf(" %c----------------------------------------------------------------------------%c\n",200,188);
	for(i=0; i<6; i++) {
		for (j=0; j<6; j++) {
			if(x[i] == num[j]) {					
				printf("\n\n\n\nNUMERO ACERTADO >> %d\nPONTOS >> %d", x[i], t);
				y+=t;
			}	
		}
	}
	
	printf("\n\n\n\nPonto total: %d pontos", y);
	
}	

int gerar(){
	
	int a = 0, i, j, k, z = 0, num[6];
	system("cls");
	
	for(k = 0; k < 10; k++){
		
		printf("\n[%d/10]NUMEROS EXTRAIDOS: \t", (k+1));
		
		srand(time(NULL));
		
		for(j = 0; j < 6; j++) {
		
			z = 1 + rand() % 49; 
			
			//condicao para não repetir os nºs sorteados
			for(i = 0; i <= j; i++) {
				if(z == num[i]){
					j--;
					break;
				} else if(i == j){
					num[j] = z;
				}
			}
			
		}
			
		//organizar os numeros sorteados por ordem crescente
		for (i = 0; i < 6; i++) {
			for (j = i + 1; j < 6; ++j) {
			    if (num[i] > num[j]) {
			        a =  num[i];
			        num[i] = num[j];
			        num[j] = a;
			    }
			}
		}
		
		for (i = 0; i < 6; i++) {
			Sleep(1000);
			printf("%d\t", num[i]);
		}
		
		puts("\n"); 
		
		for(i = 0; i < 6; i++) num[i] = 0;
		z = 0;
		
	}

}

main() {
	
	char opcao;
	
	while(opcao != 's') {  
	
		printf(" %c----------%c\n",201,187);
		printf(" |   MENU   |\n");
		printf(" %c----------%c\n",200,188);
		printf(" %c-----------------------------------%c\n",201,187);
		printf(" | <A>  Jogar                        |\n");     
		printf(" |-----------------------------------|\n");
		printf(" | <B>  Gerar Numeros                |\n");     
		printf(" |-----------------------------------|\n");
		printf(" | <S>  Sair                         |\n");
		printf(" %c-----------------------------------%c",200,188);
		printf("\n\n\n\n");
		printf("Opcao >>>> ");
		
		//Lendo a opcao do menu 
		opcao = getch(); 
		
	 switch (opcao){
		 case 'A':   
         case 'a':   
			
			//JOGAR
			
			system("cls");
			printf(" %c----------------------------------------------------------------------------%c\n",201,187);
			printf(" |\t\t\t\tVAMOS JOGAR\t\t\t              |\n");
			printf(" %c----------------------------------------------------------------------------%c\n",200,188);
			
			jogar ();
			
			getch();
			system("cls");
		    
			break;
			
		case 'B':   
        case 'b':
        	gerar();
        	break;
		
		case 'S':   
		case 's':       
			//Artifício para sair do programa.
			opcao='s';
			break;
		
		default:     
			//Artifício que previne a situação de um usuário qualquer, digitar uma opcão inexistente no menu.
	        puts("\nOPCAO INVALIDA!!!\nENTRE COM UMA OPCAO VALIDA\n");
			system ("pause");
			system("cls");	
		}
	}
}
