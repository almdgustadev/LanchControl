package org.example;




import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.persistence.VendaDao;
import org.example.service.VendaService;



import static javafx.application.Application.launch;


public class Main extends Application {

    private final static VendaDao vendaDao =  new VendaDao();
    private final static VendaService vendaService =  new VendaService(vendaDao);
    
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/telaInicial.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }



}