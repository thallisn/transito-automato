package model;

import controller.ControleTelaPrincipal;

public class CarroLaranja extends ThreadCarro {

  public CarroLaranja(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super(id, controleTela, cidade);

  }

  @Override
  public void run() {
    while (!isInterrompido) {
      exibirVelocidadeNoPainel(false);
      try {
        mudarParaPosicaoInicial();

        moverParaDireita(785);// rh 08
        moverParaDireita(928);// rh 02

        moverParaDireita(960);// curva cruzamento
        girar(180);
        descer(490);// rv 06

        descer(625);// rv 00

        descer(655);// sobe 
        girar(-90);
        moverParaEsquerda(855);// rh 00

        moverParaEsquerda(720);// rh 06
        moverParaEsquerda(580);// rh 12
        moverParaEsquerda(440);// rh 18
        moverParaEsquerda(320);// rh 24

        moverParaEsquerda(276);// curva cruzamento
        girar(360);
        subir(560); // rv 05

        subir(425);// rv 11

        subir(386);// curva cruzamento
        girar(90);
        moverParaDireita(380);// rh 26

        moverParaDireita(500);// rh 20
        moverParaDireita(640);// rh 14 fim volta ao inicio

      } catch (InterruptedException exc) {
        System.out.println(this.getName() + " interrompida com sucesso!");
        isInterrompido = true;
        reiniciar();
      } // fim do bloco try - catch
    } // fim do while
    System.out.println(this.getName() + " saiu do run()");
  }// fim do metodo run

}// fim da classe CarroLaranja