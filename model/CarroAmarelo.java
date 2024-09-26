package model;

import controller.ControleTelaPrincipal;

public class CarroAmarelo extends ThreadCarro {

  public CarroAmarelo(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);
  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        subir(425);// rv 11
        subir(282);// rv 17
        subir(140);// rv 23
        subir(5);// rv 29

        subir(-20);// cruzamento
        girar(90);
        moverParaDireita(380);// rh 29

        moverParaDireita(520);// rh 23
        moverParaDireita(650);// rh 17
        moverParaDireita(785);// rh 11
        moverParaDireita(920);// rh 05

        moverParaDireita(960);// cruzamento
        girar(180);
        descer(75);// rv 24

        descer(215);// rv 18

        descer(250);// curva cruzamento
        girar(-90);
        moverParaEsquerda(850);// rh 03

        moverParaEsquerda(725);// rh 09

        moverParaEsquerda(689);// cruzamento
        girar(180);
        descer(350);// rv 15

        descer(386);// cruzamento
        girar(90);
        moverParaDireita(785);// rh 08

        moverParaDireita(823);// cruzamento
        girar(180);
        descer(485);// rv 07

        descer(520);// cruzamento
        girar(90);
        moverParaDireita(928);// rh 01

        moverParaDireita(960);// cruzamento
        girar(180);
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
        girar(180);
        descer(630);// rv 03

        descer(655);// cruzamento
        girar(-90);
        moverParaEsquerda(440);// rh 18

        moverParaEsquerda(320);// rh 24

        moverParaEsquerda(276);// curva cruzamento
        girar(360);
        subir(568); // rv 05 fim volta ao inicio

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run

}// fim da classe CarroAmarelo