package model;

import controller.ControleTelaPrincipal;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ThreadCarro extends Thread {
  public int id;
  public int velocidade = 8;
  public int velocidadePainel = 10;
  public ImageView imgvCarro;
  public ImageView imgvPercurso;
  public int posicao_X_Atual;
  public int posicao_Y_Atual;
  public Label painelVelocidade;
  public boolean isParado = false;
  public boolean isInterrompido = false;
  public ControleTelaPrincipal controleTela;
  public Cidade cidade;

  public ThreadCarro(int id, ControleTelaPrincipal controleTela, Cidade cidade) {
    super("ThreadCarro " + id);
   

    this.id = id;
    this.controleTela = controleTela;
    this.cidade = cidade;
    this.imgvCarro = controleTela.getImageView_Carro(id);
    this.imgvPercurso = controleTela.getImageView_Percurso(id);
    this.painelVelocidade = controleTela.getLabel_PainelDeVelocidade(id);

    System.out.println(this.getName() + " chegou na cidade!");
  }// fim do Construtor

  public void parar() {
    exibirVelocidadeNoPainel(true);
    isParado = true;
    suspend();
    System.out.println(this.getName() + " pausada com sucesso!");
  }

  public void retomar() {
    exibirVelocidadeNoPainel(false);
    isParado = false;
    resume();
    System.out.println(this.getName() + " retomada com sucesso!");
  }

  public void aumentarVelocidade() {
    if (velocidade > 2) {// quanto menor a velocidade, maior a velocidade do carro
      velocidade -= 1;// diminui a espera da thread para o carro se mover mais rapido
      velocidadePainel++;
    } // fim do if
    exibirVelocidadeNoPainel(false);
  }

  public void diminuirVelocidade() {
    if (velocidade <= 16) {// quanto maior a velocidade, menor a velocidade do carro
      velocidade += 1;// aumenta a espera da thread para o carro se mover mais devagar
      velocidadePainel--;
    } // fim do if
    exibirVelocidadeNoPainel(false);
  }

  public void interromper() {
    if (isParado) {
      retomar();
    }
    interrupt();
    System.out.println(this.getName() + "  tentando interromper...");
  }

  public void reiniciar() {
    exibirVelocidadeNoPainel(true);
    ocultarPercurso();
    velocidade = 8;
    velocidadePainel = 10;
    mudarParaPosicaoInicial();

    if (id == 0 || id == 7) {
      girar(-90);
    } else if (id == 2) {
      girar(90);
    } else {
      girar(0);
    }
  }

  public void subir(int novaPosY) throws InterruptedException {// novaPosY eh o nova coordenada do carro na tela
    while (posicao_Y_Atual != novaPosY) {// anda no eixo Y decrementando o seu valor ate atingir a nova posicao
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException exc) {// se a thread for interrompida, captura a excecao
        throw exc;// relanca a excecao
      } // fim do bloco try-catch
      posicao_Y_Atual--;// atualiza o Y atual
      Platform.runLater(() -> this.imgvCarro.setLayoutY(posicao_Y_Atual));// atualiza a pos do carro na tela
    } // fim do while
  }// fim do metodo subir

  public void descer(int novaPosY) throws InterruptedException {// novaPosY eh o nova coordenada do carro na tela
    while (posicao_Y_Atual != novaPosY) {// anda no eixo Y incrementando o seu valor ate atingir a nova posicao
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException exc) {// se a thread for interrompida, captura a excecao
        throw exc;// relanca a excecao
      } // fim do bloco try-catch
      posicao_Y_Atual++;// incrementa Y atual
      Platform.runLater(() -> this.imgvCarro.setLayoutY(posicao_Y_Atual));// atualiza a pos do carro na tela
    } // fim do while
  }// fim do metodo descer

  public void moverParaDireita(int novaPosX) throws InterruptedException {// novaPosX eh o nova coordenada do carro na
                                                                          // tela
    while (posicao_X_Atual != novaPosX) {// anda no eixo X incrementando o seu valor ate atingir a nova posicao
      // verificarSeEstaParado();// verifica se o carro parou em movimento
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException exc) {// se a thread for interrompida, captura a excecao
        throw exc;// relanca a excecao
      } // fim do bloco try-catch
      posicao_X_Atual++;// aumenta o X atual
      Platform.runLater(() -> imgvCarro.setLayoutX(posicao_X_Atual));// atualiza a pos do carro na tela
    } // fim do while
  }// fim do metodo moverParaDireita

  public void moverParaEsquerda(int novaPosX) throws InterruptedException {// novaPosX eh o nova coordenada do carro na
                                                                           // tela
    while (posicao_X_Atual != novaPosX) {// anda no eixo X decrementando o seu valor ate atingir a nova posicao
      // verificarSeEstaParado();// verifica se o carro parou em movimento
      try {
        Thread.sleep(velocidade);
      } catch (InterruptedException exc) {// se a thread for interrompida, captura a excecao
        throw exc;// relanca a excecao
      } // fim do bloco try-catch
      posicao_X_Atual--;// decrementa o X atual
      Platform.runLater(() -> imgvCarro.setLayoutX(posicao_X_Atual));// atualiza a pos do carro na tela
    } // fim do while
  }// fim do metodo moverParaEsquerda

  public void girar(int angulo) {
    Platform.runLater(() -> imgvCarro.setRotate(angulo));
  }

  public void exibirPercurso() {
    Platform.runLater(() -> {
      this.imgvPercurso.setDisable(false);
      this.imgvPercurso.setVisible(true);
    });
  }

  public void ocultarPercurso() {
    Platform.runLater(() -> {
      this.imgvPercurso.setDisable(true);
      this.imgvPercurso.setVisible(false);
    });
  }

  public void exibirVelocidadeNoPainel(boolean exibirMensagemParado) {
    if (exibirMensagemParado) {
      Platform.runLater(() -> this.painelVelocidade.setText("Parado."));
    } else {
      Platform.runLater(() -> this.painelVelocidade.setText("Se movendo a " + this.velocidadePainel + " km/h."));
    }
  }

  public boolean isParado() {
    return isParado;
  }

  public void mudarParaPosicaoInicial() {

    switch (this.id) {// muda o carro para sua posicao inicial na tela

      case 0: {// posicao inicial do carro VERMELHO
        Platform.runLater(() -> {
          this.posicao_X_Atual = 458;
          this.posicao_Y_Atual = 386;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro VERMELHO)

      case 1: {// posicao inicial do carro AMARELO
        Platform.runLater(() -> {
          this.posicao_X_Atual = 276;
          this.posicao_Y_Atual = 568;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro AMARELO)

      case 2: {// posicao inicial do carro LARANJA
        Platform.runLater(() -> {
          this.posicao_X_Atual = 640;
          this.posicao_Y_Atual = 386;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro LARANJA)

      case 3: {// posicao inicial do carro AZUL
        Platform.runLater(() -> {
          this.posicao_X_Atual = 960;
          this.posicao_Y_Atual = 160;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro AZUL)

      case 4: {// posicao inicial do carro MARROM
        Platform.runLater(() -> {
          this.posicao_X_Atual = 689;
          this.posicao_Y_Atual = 568;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro MARROM)

      case 5: {// posicao inicial do carro ROXO
        Platform.runLater(() -> {
          this.posicao_X_Atual = 960;
          this.posicao_Y_Atual = 568;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro ROXO)

      case 6: {// posicao inicial do carro ROSA
        Platform.runLater(() -> {
          this.posicao_X_Atual = 823;
          this.posicao_Y_Atual = 160;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro ROSA)

      case 7: {// posicao inicial do carro CIANO
        Platform.runLater(() -> {
          this.posicao_X_Atual = 318;
          this.posicao_Y_Atual = 252;
          this.imgvCarro.setLayoutX(posicao_X_Atual);
          this.imgvCarro.setLayoutY(posicao_Y_Atual);
        });
        break;
      } // fim do case (carro CIANO)

    }// fim do switch(id)

  }// fim do metodo mudarParaPosicaoInicial

}// fim da classe ThreadCarro