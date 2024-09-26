package model;
import java.util.concurrent.Semaphore;

import controller.ControleTelaPrincipal;
/* ***************************************************************
* Autor............: Thallis Luciano Curcino Nunes
* Matricula........: 202211065
* Inicio...........: 24/11/2023
* Ultima alteracao.: 28/11/2023
* Nome.............: Programacao Concorrente - Trabalho 05.
* Funcao...........: Simular um transito/trafego automato de 
*                    veiculos em percursos variados e, utilizando 
*                    Semaforos, implementar uma solucao que controle
*                    o acesso aos recursos compartihados entre os 
*                    veiculos (as ruas), para que nao ocorram colisoes.
*************************************************************** */
public class Cidade {
 Semaphore[] semaforosRuasVerticais;
 Semaphore[] semaforosRuasHorizontais;

 

}//fim da classe Cidade