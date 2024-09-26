package controller;

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
import model.*;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ControleTelaPrincipal implements Initializable {

  @FXML
  private ImageView imgvCarro00, imgvCarro01, imgvCarro02, imgvCarro03, imgvCarro04, imgvCarro05, imgvCarro06,
      imgvCarro07;

  @FXML
  private ImageView imgvPercurso_carro00, imgvPercurso_carro01, imgvPercurso_carro02, imgvPercurso_carro03,
      imgvPercurso_carro04, imgvPercurso_carro05, imgvPercurso_carro06, imgvPercurso_carro07;

  @FXML
  private CheckBox btnExibirPercurso_carro00, btnExibirPercurso_carro01, btnExibirPercurso_carro02,
      btnExibirPercurso_carro03, btnExibirPercurso_carro04, btnExibirPercurso_carro05, btnExibirPercurso_carro06,
      btnExibirPercurso_carro07;

  @FXML
  private Button btn_AumentarVel_carro00, btn_AumentarVel_carro01, btn_AumentarVel_carro02, btn_AumentarVel_carro03,
      btn_AumentarVel_carro04, btn_AumentarVel_carro05, btn_AumentarVel_carro06, btn_AumentarVel_carro07;

  @FXML
  private Button btn_DiminuirVel_carro00, btn_DiminuirVel_carro01, btn_DiminuirVel_carro02, btn_DiminuirVel_carro03,
      btn_DiminuirVel_carro04, btn_DiminuirVel_carro05, btn_DiminuirVel_carro06, btn_DiminuirVel_carro07;

  @FXML
  private Label painelVelocidade_carro00, painelVelocidade_carro01, painelVelocidade_carro02, painelVelocidade_carro03,
      painelVelocidade_carro04, painelVelocidade_carro05, painelVelocidade_carro06, painelVelocidade_carro07;

  @FXML
  private Button btnPararRetomar_carro00, btnPararRetomar_carro01, btnPararRetomar_carro02, btnPararRetomar_carro03,
      btnPararRetomar_carro04, btnPararRetomar_carro05, btnPararRetomar_carro06, btnPararRetomar_carro07;

  @FXML
  private Button btnIniciar, btnReiniciar;

  private CarroVermelho carroVermelho_00;
  private CarroAmarelo carroAmarelo_01;
  private CarroLaranja carroLaranja_02;
  private CarroAzul carroAzul_03;
  private CarroMarrom carroMarrom_04;
  private CarroRoxo carroRoxo_05;
  private CarroRosa carroRosa_06;
  private CarroCiano carroCiano_07;

  // CONTROLE DE ESTADOS DAS THREADS
  private void criarThreads() {
    System.out.println("Criando as threads...");

    Cidade cidade = new Cidade();

    carroVermelho_00 = new CarroVermelho(0, this, cidade);
    carroAmarelo_01 = new CarroAmarelo(1, this, cidade);
    carroLaranja_02 = new CarroLaranja(2, this, cidade);
    carroAzul_03 = new CarroAzul(3, this, cidade);
    carroMarrom_04 = new CarroMarrom(4, this, cidade);
    carroRoxo_05 = new CarroRoxo(5, this, cidade);
    carroRosa_06 = new CarroRosa(6, this, cidade);
    carroCiano_07 = new CarroCiano(7, this, cidade);

    System.out.println("Threads criadas com sucesso!");
  }// fim do metodo criarThreads

  private void iniciarThreads() {
    System.out.println("Iniciando as Threads...");

    carroVermelho_00.start();
    carroAmarelo_01.start();
    carroLaranja_02.start();
    carroAzul_03.start();
    carroMarrom_04.start();
    carroRoxo_05.start();
    carroRosa_06.start();
    carroCiano_07.start();

    System.out.println("Threads iniciadas com sucesso!");
  }// fim do metodo iniciarThreads

  private void interromperThreads() {
    System.out.println("Interrompendo as Threads...");

    carroVermelho_00.interromper();
    carroAmarelo_01.interromper();
    carroLaranja_02.interromper();
    carroAzul_03.interromper();
    carroMarrom_04.interromper();
    carroRoxo_05.interromper();
    carroRosa_06.interromper();
    carroCiano_07.interromper();

    System.out.println("Threads interrompidas com sucesso!");
  }// fim do metodo interromperThreads

  /*
   * ***************************************************************
   * Metodo: initialize
   * Funcao: definir acoes tomadas ao iniciar aplicacao
   * Parametros: void
   * Retorno: void
   */
  @Override
  public void initialize(URL location, ResourceBundle resources) {
    System.out.println("Executando initialize...");

    Platform.runLater(() -> {
      desabilitarBtn_Reiniciar();
      desabilitarControlesDosCarros();
    });
    System.out.println("Fim do initialize!");
  }// fim do metodo initialize

  // METODOS "OUVINTES" PARA ELEMENTOS DA INTERFACE GRAFICA

  public void acaoBtn_Iniciar() {
    System.out.println("Inciando simulacao...");

    criarThreads();
    iniciarThreads();

    Platform.runLater(() -> {
      desabilitarBtnIniciar();
      habilitarBtn_Reiniciar();
      habilitarControlesDosCarros();
    });

    System.out.println("Simulacao iniciada com sucesso...");
  }

  public void acaoBtn_Reiniciar() {
    System.out.println("Reiniciando simulacao...");

    interromperThreads();

    Platform.runLater(() -> {
      habilitarBtn_Iniciar();
      desabilitarBtn_Reiniciar();
      desabilitarControlesDosCarros();
    });

    System.out.println("Simulacao reiniciada com sucesso!");
  }

  public void acao_Btn_AumentarVel_carro00() {
    this.carroVermelho_00.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro00

  public void acao_Btn_AumentarVel_carro01() {
    this.carroAmarelo_01.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro01

  public void acao_Btn_AumentarVel_carro02() {
    this.carroLaranja_02.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro02

  public void acao_Btn_AumentarVel_carro03() {
    this.carroAzul_03.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro03

  public void acao_Btn_AumentarVel_carro04() {
    this.carroMarrom_04.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro04

  public void acao_Btn_AumentarVel_carro05() {
    this.carroRoxo_05.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro05

  public void acao_Btn_AumentarVel_carro06() {
    this.carroRosa_06.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro06

  public void acao_Btn_AumentarVel_carro07() {
    this.carroCiano_07.aumentarVelocidade();// aumenta a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro07

  public void acao_Btn_DiminuirVel_carro00() {
    this.carroVermelho_00.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro00

  public void acao_Btn_DiminuirVel_carro01() {
    this.carroAmarelo_01.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro01

  public void acao_Btn_DiminuirVel_carro02() {
    this.carroLaranja_02.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro02

  public void acao_Btn_DiminuirVel_carro03() {
    this.carroAzul_03.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro03

  public void acao_Btn_DiminuirVel_carro04() {
    this.carroMarrom_04.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro04

  public void acao_Btn_DiminuirVel_carro05() {
    this.carroRoxo_05.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro05

  public void acao_Btn_DiminuirVel_carro06() {
    this.carroRosa_06.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro06

  public void acao_Btn_DiminuirVel_carro07() {
    this.carroCiano_07.diminuirVelocidade();// diminui a velocidade do carro
  }// fim do metodo acao_Btn_AumentarVel_carro07

  public void acaoBtn_Parar_Retomar_Carro00() {
    if (carroVermelho_00.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro00();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro00.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroVermelho_00.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro00();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro00.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroVermelho_00.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro00

  public void acaoBtn_Parar_Retomar_Carro01() {
    if (carroAmarelo_01.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro01();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro01.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroAmarelo_01.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro01();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro01.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroAmarelo_01.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro01

  public void acaoBtn_Parar_Retomar_Carro02() {
    if (carroLaranja_02.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro02();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro02.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroLaranja_02.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro02();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro02.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroLaranja_02.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro02

  public void acaoBtn_Parar_Retomar_Carro03() {
    if (carroAzul_03.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro03();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro03.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroAzul_03.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro03();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro03.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroAzul_03.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro03

  public void acaoBtn_Parar_Retomar_Carro04() {
    if (carroMarrom_04.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro04();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro04.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroMarrom_04.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro04();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro04.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroMarrom_04.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro04

  public void acaoBtn_Parar_Retomar_Carro05() {
    if (carroRoxo_05.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro05();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro05.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroRoxo_05.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro05();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro05.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroRoxo_05.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro05

  public void acaoBtn_Parar_Retomar_Carro06() {
    if (carroRosa_06.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro06();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro06.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroRosa_06.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro06();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro06.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroRosa_06.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro06

  public void acaoBtn_Parar_Retomar_Carro07() {
    if (carroCiano_07.isParado()) {// se a Thread estiver parada
      Platform.runLater(() -> {
        habilitarControlesDeVelocidade_Carro07();// habilita os botoes de velocidade e percurso
        btnPararRetomar_carro07.setText("Parar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroCiano_07.retomar();// retoma a execucao da thread
    } else {// se a Thread estiver executando
      Platform.runLater(() -> {// atualizacoes na interface grafica
        desabilitarControlesDeVelocidade_Carro07();// desabilita os botoes de velocidade e percurso
        btnPararRetomar_carro07.setText("Retomar");// muda o texto do botao "Parar/Retomar"
      });// fim das atualizacoes na interface grafica
      carroCiano_07.parar();// para a execucao da thread
    } // fim do bloco if-else
  }// fim do metodo acaoBtn_Parar_Retomar_Carro07

  public void acaoBtn_ExibirPercurso_Carro00() {
    if (btnExibirPercurso_carro00.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroVermelho_00.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroVermelho_00.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro00

  public void acaoBtn_ExibirPercurso_Carro01() {
    if (btnExibirPercurso_carro01.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroAmarelo_01.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroAmarelo_01.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro01

  public void acaoBtn_ExibirPercurso_Carro02() {
    if (btnExibirPercurso_carro02.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroLaranja_02.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroLaranja_02.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro02

  public void acaoBtn_ExibirPercurso_Carro03() {
    if (btnExibirPercurso_carro03.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroAzul_03.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroAzul_03.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro00

  public void acaoBtn_ExibirPercurso_Carro04() {
    if (btnExibirPercurso_carro04.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroMarrom_04.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroMarrom_04.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro04

  public void acaoBtn_ExibirPercurso_Carro05() {
    if (btnExibirPercurso_carro05.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroRoxo_05.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroRoxo_05.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro05

  public void acaoBtn_ExibirPercurso_Carro06() {
    if (btnExibirPercurso_carro06.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroRosa_06.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroRosa_06.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro06

  public void acaoBtn_ExibirPercurso_Carro07() {
    if (btnExibirPercurso_carro07.isSelected()) {// se a opcao "Exibir percurso" do carro estiver selecionada
      carroCiano_07.exibirPercurso();// exibe o percurso do carro
    } else {// se a opcao nao estiver selecionada
      carroCiano_07.ocultarPercurso();// oculta o percurso do carro
    } // fim do bloco if-else
  }// fim do metodoacaoBtn_ExibirPercurso_Carro07

  // CONTROLES DE ESTADOS PARA ELEMENTOS DA INTERFACE GRAFICA
  private void habilitarBtn_Iniciar() {
    btnIniciar.setDisable(false);// habilita o botao
    btnIniciar.setVisible(true);// exibe o botao
  }// fim do metodo habilitarBtnIniciar

  private void habilitarBtn_Reiniciar() {
    btnReiniciar.setDisable(false);// habilita o botao
    btnReiniciar.setVisible(true);// exibe o botao
  }// fim do metodo habilitarBtnReiniciar

  private void desabilitarBtnIniciar() {
    btnIniciar.setDisable(true);// desabilita o botao
    btnIniciar.setVisible(false);// exibe o botao
  }// fim do metodo desabilitarBtnIniciar

  private void desabilitarBtn_Reiniciar() {
    btnReiniciar.setDisable(true);// desabilita o botao
    btnReiniciar.setVisible(false);// oculta o botao
  }// fim do metodo desabilitarBtnReiniciar

  public void habilitarControlesDeVelocidade_Carro00() {
    btn_AumentarVel_carro00.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro00.setDisable(false);// habilita o botao
    btnExibirPercurso_carro00.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro00

  public void habilitarControlesDeVelocidade_Carro01() {
    btn_AumentarVel_carro01.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro01.setDisable(false);// habilita o botao
    btnExibirPercurso_carro01.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro01

  public void habilitarControlesDeVelocidade_Carro02() {
    btn_AumentarVel_carro02.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro02.setDisable(false);// habilita o botao
    btnExibirPercurso_carro02.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro02

  public void habilitarControlesDeVelocidade_Carro03() {
    btn_AumentarVel_carro03.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro03.setDisable(false);// habilita o botao
    btnExibirPercurso_carro03.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro03

  public void habilitarControlesDeVelocidade_Carro04() {
    btn_AumentarVel_carro04.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro04.setDisable(false);// habilita o botao
    btnExibirPercurso_carro04.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro04

  public void habilitarControlesDeVelocidade_Carro05() {
    btn_AumentarVel_carro05.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro05.setDisable(false);// habilita o botao
    btnExibirPercurso_carro05.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro05

  public void habilitarControlesDeVelocidade_Carro06() {
    btn_AumentarVel_carro06.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro06.setDisable(false);// habilita o botao
    btnExibirPercurso_carro06.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro06

  public void habilitarControlesDeVelocidade_Carro07() {
    btn_AumentarVel_carro07.setDisable(false);// habilita o botao
    btn_DiminuirVel_carro07.setDisable(false);// habilita o botao
    btnExibirPercurso_carro07.setDisable(false);// habilita o botao
  }// fim do metodo habilitarControlesDeVelocidade_Carro07

  public void desabilitarControlesDeVelocidade_Carro00() {
    btn_AumentarVel_carro00.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro00.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro00.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro00

  public void desabilitarControlesDeVelocidade_Carro01() {
    btn_AumentarVel_carro01.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro01.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro01.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro01

  public void desabilitarControlesDeVelocidade_Carro02() {
    btn_AumentarVel_carro02.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro02.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro02.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro02

  public void desabilitarControlesDeVelocidade_Carro03() {
    btn_AumentarVel_carro03.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro03.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro03.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro03

  public void desabilitarControlesDeVelocidade_Carro04() {
    btn_AumentarVel_carro04.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro04.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro04.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro04

  public void desabilitarControlesDeVelocidade_Carro05() {
    btn_AumentarVel_carro05.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro05.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro05.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro05

  public void desabilitarControlesDeVelocidade_Carro06() {
    btn_AumentarVel_carro06.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro06.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro06.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro06

  public void desabilitarControlesDeVelocidade_Carro07() {
    btn_AumentarVel_carro07.setDisable(true);// desabilita o botao
    btn_DiminuirVel_carro07.setDisable(true);// desabilita o botao
    btnExibirPercurso_carro07.setDisable(true);// desabilita o botao
  }// fim do metodo desabilitarControlesDeVelocidade_Carro07

  private void habilitarControlesDosCarros() {

    habilitarControlesDeVelocidade_Carro00();
    habilitarControlesDeVelocidade_Carro01();
    habilitarControlesDeVelocidade_Carro02();
    habilitarControlesDeVelocidade_Carro03();
    habilitarControlesDeVelocidade_Carro04();
    habilitarControlesDeVelocidade_Carro05();
    habilitarControlesDeVelocidade_Carro06();
    habilitarControlesDeVelocidade_Carro07();

    btnPararRetomar_carro00.setDisable(false);
    btnPararRetomar_carro01.setDisable(false);
    btnPararRetomar_carro02.setDisable(false);
    btnPararRetomar_carro03.setDisable(false);
    btnPararRetomar_carro04.setDisable(false);
    btnPararRetomar_carro05.setDisable(false);
    btnPararRetomar_carro06.setDisable(false);
    btnPararRetomar_carro07.setDisable(false);
  }

  private void desabilitarControlesDosCarros() {

    desabilitarControlesDeVelocidade_Carro00();
    desabilitarControlesDeVelocidade_Carro01();
    desabilitarControlesDeVelocidade_Carro02();
    desabilitarControlesDeVelocidade_Carro03();
    desabilitarControlesDeVelocidade_Carro04();
    desabilitarControlesDeVelocidade_Carro05();
    desabilitarControlesDeVelocidade_Carro06();
    desabilitarControlesDeVelocidade_Carro07();

    btnPararRetomar_carro00.setDisable(true);
    btnPararRetomar_carro01.setDisable(true);
    btnPararRetomar_carro02.setDisable(true);
    btnPararRetomar_carro03.setDisable(true);
    btnPararRetomar_carro04.setDisable(true);
    btnPararRetomar_carro05.setDisable(true);
    btnPararRetomar_carro06.setDisable(true);
    btnPararRetomar_carro07.setDisable(true);

    btnPararRetomar_carro00.setText("Parar");
    btnPararRetomar_carro01.setText("Parar");
    btnPararRetomar_carro02.setText("Parar");
    btnPararRetomar_carro03.setText("Parar");
    btnPararRetomar_carro04.setText("Parar");
    btnPararRetomar_carro05.setText("Parar");
    btnPararRetomar_carro06.setText("Parar");
    btnPararRetomar_carro07.setText("Parar");

    btnExibirPercurso_carro00.setSelected(false);
    btnExibirPercurso_carro01.setSelected(false);
    btnExibirPercurso_carro02.setSelected(false);
    btnExibirPercurso_carro03.setSelected(false);
    btnExibirPercurso_carro04.setSelected(false);
    btnExibirPercurso_carro05.setSelected(false);
    btnExibirPercurso_carro06.setSelected(false);
    btnExibirPercurso_carro07.setSelected(false);
  }// fim do metodo desabilitarControlesDosCarros

  // GETTERS UTILIZADOS PARA INICIAR AS THREADS

  public ImageView getImageView_Carro(int id) {
    ImageView imgv = null;
    switch (id) {
      case 0: {
        imgv = imgvCarro00;
        break;
      }
      case 1: {
        imgv = imgvCarro01;
        break;
      }
      case 2: {
        imgv = imgvCarro02;
        break;
      }
      case 3: {
        imgv = imgvCarro03;
        break;
      }
      case 4: {
        imgv = imgvCarro04;
        break;
      }
      case 5: {
        imgv = imgvCarro05;
        break;
      }
      case 6: {
        imgv = imgvCarro06;
        break;
      }
      case 7: {
        imgv = imgvCarro07;
        break;
      }
    }// fim do switch (id)

    return imgv;
  }// fim do metodo getImageView_Carro

  public ImageView getImageView_Percurso(int id) {
    ImageView imgv = null;

    switch (id) {
      case 0: {
        imgv = imgvPercurso_carro00;
        break;
      }
      case 1: {
        imgv = imgvPercurso_carro01;
        break;
      }
      case 2: {
        imgv = imgvPercurso_carro02;
        break;
      }
      case 3: {
        imgv = imgvPercurso_carro03;
        break;
      }
      case 4: {
        imgv = imgvPercurso_carro04;
        break;
      }
      case 5: {
        imgv = imgvPercurso_carro05;
        break;
      }
      case 6: {
        imgv = imgvPercurso_carro06;
        break;
      }
      case 7: {
        imgv = imgvPercurso_carro07;
        break;
      }
    }// fim do switch (id)

    return imgv;
  }

  public Label getLabel_PainelDeVelocidade(int id) {
    Label lbl = null;

    switch (id) {
      case 0: {
        lbl = painelVelocidade_carro00;
        break;
      }
      case 1: {
        lbl = painelVelocidade_carro01;
        break;
      }
      case 2: {
        lbl = painelVelocidade_carro02;
        break;
      }
      case 3: {
        lbl = painelVelocidade_carro03;
        break;
      }
      case 4: {
        lbl = painelVelocidade_carro04;
        break;
      }
      case 5: {
        lbl = painelVelocidade_carro05;
        break;
      }
      case 6: {
        lbl = painelVelocidade_carro06;
        break;
      }
      case 7: {
        lbl = painelVelocidade_carro07;
        break;
      }
    }// fim do switch (id)

    return lbl;
  }
}// fim da classe ControleTelaPrincipal