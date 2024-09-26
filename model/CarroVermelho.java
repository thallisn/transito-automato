package model;

import controller.ControleTelaPrincipal;

public class CarroVermelho extends ThreadCarro {

  public CarroVermelho(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);
  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        moverParaEsquerda(412);// cruzamento
        girar(180);
        descer(485);// rv 10

        descer(630);// rv 04

        descer(655);// cruzamento
        girar(-90);
        moverParaEsquerda(310);// rh 24

        moverParaEsquerda(276);// cruzamento
        girar(360);
        subir(568);// rv 05

        subir(425);// rv 11
        subir(282);// rv 17
        subir(140);// rv 23
        subir(5);// rv 29

        subir(-20);// cruzamento
        girar(90);
        moverParaDireita(380);// rh 29

        moverParaDireita(520);// rh 23

        moverParaDireita(550);// cruzamento
        girar(180);
        descer(75); // rv 27

        descer(116);// cruzamento
        girar(90);
        moverParaDireita(650);// rh 16

        moverParaDireita(689);// cruzamento
        girar(360);
        subir(15);// rv 26

        subir(-20);// cruzamento
        girar(90);
        moverParaDireita(785);// rh 11

        moverParaDireita(920);// rh 05

        moverParaDireita(960);// cruzamento
        girar(180);
        descer(75);// rv 24

        descer(215);// rv 18
        descer(350);// rv 12
        descer(490);// rv 06
        descer(625);// rv 00

        descer(655);// curva cruzamento
        girar(-90);
        moverParaEsquerda(855);// rh 00

        moverParaEsquerda(823);// curva cruzamento
        girar(360);
        subir(568);// rv 01

        subir(425);// rv 07

        subir(386);// cruzamento
        girar(-90);
        moverParaEsquerda(715);// rh 08

        moverParaEsquerda(689);// cruzamento
        girar(360);
        subir(290);// rv 14

        subir(250);// curva cruzamento
        girar(-90);
        moverParaEsquerda(584);// rh 15

        moverParaEsquerda(550);// cruzamento
        girar(180);
        descer(350);// rv 15

        descer(386);// cruzamento
        girar(-90);
        moverParaEsquerda(458); // rh 20 fim volta ao inicio

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run
}// fim da classe Carro Vermelho