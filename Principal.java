
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
import view.*;
import model.*;
import controller.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/* ****************************************************************
* Classe: Principal
* Funcao: Configuracao e inicializacao da aplicacao JavaFx
* Descricao: Contem o metodo "main" e "start" responsaveis 
*            configurar e excutar a aplicacao JavaFx.
***************************************************************** */
public class Principal extends Application {
  public static void main(String[] args) throws Exception {
    launch(args);// inicia a aplicacao JavaFX
  }// fim do metodo main

  /*
   * ***************************************************************
   * Metodo: start
   * Funcao: Configurar os elementos contidos na interface grafica
   * e iniciar a aplicacao.
   * Parametros: Stage janelaPrincipal = janela que sera configurada
   * pelo metodo
   * Retorno: void
   */

  @Override
  public void start(Stage janelaPrincipal) throws Exception {
    // instancia o fxmlLoader e define a localizacao do arquivo .fxml que contem os
    // elementos graficos que serao associados a janela
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("view/TelaPrincipal.fxml"));
    // fxmlLoader.setController(controleTelaPrincipal);// define a classe
    // controladora da janela

    Parent root = fxmlLoader.load();// carrega a estrutura grafica da interface
    // cria uma instancia da classe "ControleTelaPrincipal" que sera controladora da
    // janela
    ControleTelaPrincipal controleTelaPrincipal = new ControleTelaPrincipal();
    Scene tela = new Scene(root);// cria a cena e define a estrutura grafica que sera exibida por ela
    janelaPrincipal.setScene(tela);// define a cena que sera exibida na tela

    janelaPrincipal.setResizable(false);// impede que a janela seja redmensionada durante a execucao
    janelaPrincipal.setTitle("Trabalho 05 - Simulacao de Transito Automato");// define o titulo da janela
    //janelaPrincipal.centerOnScreen();// centraliza a exibicao da janela durante a execucao
    janelaPrincipal.getIcons()
        .add(new javafx.scene.image.Image(getClass().getResourceAsStream("img/icone_janela.png")));// define a o icone da janela

    janelaPrincipal.show();// exibe a cena
  }// fim do metodo start

}// fim da classe Principal