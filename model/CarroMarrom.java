package model;

import controller.ControleTelaPrincipal;

public class CarroMarrom extends ThreadCarro {

  public CarroMarrom(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);

  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        // subir(560);// RV_02
        subir(425);// rv 08
        subir(290);// rv 14

        subir(250);// curva cruzamento
        girar(-90);

        moverParaEsquerda(584);// Rh 15
        moverParaEsquerda(440);// rh 21
        moverParaEsquerda(316);// rh 27

        moverParaEsquerda(275);// curva cruzamento
        girar(180);

        descer(355);// rv 17
        descer(480);// rv 11
        descer(615);// rv 05

        descer(655);// curva cruzamento
        girar(90);

        moverParaDireita(380);// rh 24
        moverParaDireita(524);// rh 18
        moverParaDireita(668);// rh 12

        moverParaDireita(689);
        girar(360);
        subir(615);// rv 02 fim volta ao inicio

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run

}// fim da classe CarroMarrom