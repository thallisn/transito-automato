package model;

import controller.ControleTelaPrincipal;

public class CarroCiano extends ThreadCarro {

  public CarroCiano(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);
  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        moverParaEsquerda(276);// cruzamento
        girar(360);
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
        girar(180);
        descer(225);// rv 20

        descer(250);// cruzamento
        girar(90);
        moverParaDireita(785);// rh 09

        moverParaDireita(823);// cruzamento
        girar(180);
        descer(350);// rv 13

        descer(386);// cruzamento
        girar(90);
        moverParaDireita(928);// rh 02

        moverParaDireita(960);// curva cruzamento
        girar(180);
        descer(490);// rv 06

        descer(625);// rv 00

        descer(655);// curva cruzamento
        girar(-90);
        moverParaEsquerda(855);// rh 00

        moverParaEsquerda(720);// rh 06

        moverParaEsquerda(689);// cruzamento
        girar(360);
        subir(568);// rv 02

        subir(520);// cruzamento
        girar(-90);
        moverParaEsquerda(584);// rh 13

        moverParaEsquerda(550);// cruzamento
        girar(360);
        subir(425);// rv 09

        subir(386);// cruzamento
        girar(-90);
        moverParaEsquerda(458);// rh 20

        moverParaEsquerda(412);// cruzamento
        girar(360);
        subir(290);// rv 16

        subir(252);// cruzamento
        girar(-90);
        moverParaEsquerda(318);// fim volta ao inicio

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run

}// fim da classe CarroCiano