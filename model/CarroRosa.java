package model;

import controller.ControleTelaPrincipal;

public class CarroRosa extends ThreadCarro {

  public CarroRosa(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);
  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        subir(115);// cruzamento
        girar(-90);
        moverParaEsquerda(730);// rh 10

        moverParaEsquerda(689);// cruzamento
        girar(360);
        subir(5);// rv 26

        subir(-20);// cruzamento
        girar(-90);
        moverParaEsquerda(595);// rh 17

        moverParaEsquerda(550);// cruzamento
        girar(180);
        descer(75); // rv 27

        descer(116);// cruzamento
        girar(-90);
        moverParaEsquerda(440);// rh 22

        moverParaEsquerda(412);// cruzamento
        girar(180);
        descer(225);// rv 22

        descer(252);// cruzamento
        girar(-90);
        moverParaEsquerda(318);// rh 27

        moverParaEsquerda(276);// cruzamento
        girar(180);
        descer(350);// rv 17

        descer(386);// curva cruzamento
        girar(90);
        moverParaDireita(375);// rh 26

        moverParaDireita(412);// cruzamento
        girar(180);
        descer(485);// rv 10

        descer(520);/// cruzamento
        girar(90);
        moverParaDireita(500);// rh 19

        moverParaDireita(550);// cruzamento
        girar(180);
        descer(630);// rv 03

        descer(655);// curva cruzamento
        girar(90);
        moverParaDireita(650);// rh 12

        moverParaDireita(689);// cruzamento
        girar(360);
        subir(615);// rv 02

        subir(520);// curva cruzamento
        girar(90);
        moverParaDireita(785);// rh 07

        moverParaDireita(823);// cruzamento
        girar(360);
        subir(425);// rv 07

        subir(386);// curva
        girar(90);
        moverParaDireita(928);// rh 02

        moverParaDireita(960);// cruzamento
        girar(360);
        subir(290);// rv 12

        subir(250);// curva cruzamento
        girar(-90);
        moverParaEsquerda(850);// rh 03

        moverParaEsquerda(823);// cruzamento
        girar(360);
        subir(160);// volta a posicao inicial fim

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run
}// fim da classe CarroRosa