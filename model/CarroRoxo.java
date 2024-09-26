package model;

import controller.ControleTelaPrincipal;

public class CarroRoxo extends ThreadCarro {

  public CarroRoxo(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);
  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        // subir(560);// RV_01
        subir(425);// rv 06
        subir(290);// rv 12

        subir(250);// curva cruzamento
        girar(-90);
        moverParaEsquerda(850);// rh 03

        moverParaEsquerda(725);// rh 09
        moverParaEsquerda(598);// rh 15

        moverParaEsquerda(553);// curva cruzamento
        girar(180);

        descer(345);// rv 15
        descer(475);// rv 19
        descer(615);// rv 03

        descer(655);// curva cruzamento
        girar(90);
        moverParaDireita(650);// rh 12

        moverParaDireita(790);// rh 06
        moverParaDireita(910);// rh 00

        moverParaDireita(960);// curva cruzamento volta ao inicio
        girar(360);
        subir(615);// rv 00

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run

}// fim da classe CarroRoxo