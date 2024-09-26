package model;

import controller.ControleTelaPrincipal;

public class CarroAzul extends ThreadCarro {

  public CarroAzul(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);
  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        subir(116);// cruzamento
        girar(-90);
        moverParaEsquerda(865);// rh 04

        moverParaEsquerda(730);// rh 10
        moverParaEsquerda(595);// rh 16
        moverParaEsquerda(460);// rh 22
        moverParaEsquerda(325);// rh 28

        moverParaEsquerda(276);// curva cruzamento
        girar(180);
        descer(215);// rv 23

        descer(350);// rv 17

        descer(386);// curva cruzamento
        girar(90);
        moverParaDireita(375);// rh 26

        moverParaDireita(500);// rh 20
        moverParaDireita(640);// rh 14
        moverParaDireita(785);// rh 08
        moverParaDireita(928);// rh 02

        moverParaDireita(960);// curva cruzamento
        girar(360);
        subir(280);// rv 12

        subir(160);// rv 18 volta ao inicio

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run
}// fim da classe CarroAzul