package br.inatel.cdg.algebra.scene;

import br.inatel.cdg.algebra.Ponto;
import br.inatel.cdg.algebra.Reta;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ScenePrincipal {

    private Button btnTeste, btnCalcCoefLinear, btnCalcCoefAngular; //Button representa botoes
    private Label labelp1x, labelp1y, labelp2x, labelp2y; //Label representam rótulos
    private TextField doubleField2,doublep1x, doublep1y, doublep2x, doublep2y, coeficienteAngular, coeficienteLinear; //TextField Representam áreas de texto
    Reta reta = new Reta();
    public void criaScenePrincipal(Stage stage){

        //Criando os labels para os pontos e os campos de texto para os dados
        labelp1x = new Label("Digite a coordenada x do ponto 1"); //rótulos
        doublep1x = new TextField(); //área de texto onde vc digitara alguma coisa
        labelp1y = new Label("Digite a coordenada y do ponto 1"); //rótulos
        doublep1y = new TextField(); //área de texto onde vc digitara alguma coisa
        labelp2x = new Label("Digite a coordenada x do ponto 2"); //rótulos
        doublep2x = new TextField(); //área de texto onde vc digitara alguma coisa
        labelp2y = new Label("Digite a coordenada y do ponto 2"); //rótulos
        doublep2y = new TextField(); //área de texto onde vc digitara alguma coisa


        //HBox é usado para agrupar elementos horizontalmente
        HBox grupoHorizontal = new HBox(labelp1x, doublep1x); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal2 = new HBox(labelp1y, doublep1y); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal3 = new HBox(labelp2x, doublep2x); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais
        HBox grupoHorizontal4 = new HBox(labelp2y, doublep2y); //Passamos no construtor todos os elementos. Você poderá criar vários grupos horizontais

        //Passando os dados para a classe Reta
        reta.p1.x = Double.parseDouble(doublep1x.getText());
        reta.p1.y = Double.parseDouble(doublep1y.getText());
        reta.p2.x = Double.parseDouble(doublep2x.getText());
        reta.p2.y = Double.parseDouble(doublep2y.getText());

        //Agora vamos criar a area que mostrará o que foi digitado
        coeficienteAngular = new TextField();
        coeficienteAngular.setEditable(false);//vamos deixar false para apenas mostrar texto
        coeficienteAngular.setText("Coeficiente angular");
        coeficienteLinear = new TextField();
        coeficienteLinear.setEditable(false);//vamos deixar false para apenas mostrar texto
        coeficienteLinear.setText("Coeficiente linear");

        //Criamos o botão
        btnCalcCoefAngular = new Button("Executar Ação");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefAngular.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            coeficienteLinear.setText(String.valueOf(reta.coeficienteAngular()));//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });
        btnCalcCoefLinear = new Button("Executar Ação");
        //Criamos a ação que o botão responderá as ser pressionado
        btnCalcCoefLinear.setOnAction(evento -> {
            //Aqui dentro é a ação que será executado ao pressionar o botão
            coeficienteLinear.setText(String.valueOf(reta.coeficienteLinear()));//Acessamos o componente textField1, pegamos o texto e colocaos em textField2
        });

        //VBox é usada para agrupar elementos verticalmente
        //No construtor passamos todos os elementos que serão agrupados, que podem ser outros grupos
        VBox layoutFinal = new VBox(grupoHorizontal, grupoHorizontal2,grupoHorizontal3,grupoHorizontal4,btnCalcCoefAngular, btnCalcCoefLinear);//Aqui vamos agrupar verticalmente o grupo (Label + Texto) o Botao e A area que aparecer o texto digitado
        //Criamos a Scene
        Scene scene = new Scene(layoutFinal, 300 , 200);

        stage.setTitle("Software Para Calculos de Álgebra Linear");
        stage.setScene(scene);
        stage.show();
    }

}
