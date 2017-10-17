/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import cigarettesmoker.AgentClass.table;


/**
 *
 * @author HanWang
 */
public class CigaretteSmoker extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        launch(args);
        
        ArrayList<String> ConstantMaterial = new ArrayList<String>();
        ConstantMaterial.add("Paper");
        ConstantMaterial.add("Tobacco");
        ConstantMaterial.add("Matches");
        table SmokingTable = new table();
        
        for(int i=0;i<3;i++){
            SmokerClass smoker = new SmokerClass(ConstantMaterial.get(i),SmokingTable);
            smoker.start();
        }
        
    }
    
}
