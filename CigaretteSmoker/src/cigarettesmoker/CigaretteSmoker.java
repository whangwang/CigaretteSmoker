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
import static java.lang.Thread.sleep;

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

    public static void main(String[] args) throws InterruptedException {

        launch(args);
        
        ArrayList<String> elements = new ArrayList();
        elements.add("CigarettePaper");
        elements.add("Tobacco");
        elements.add("Mactches");
        
        TableClass Table =new TableClass();
     
        
        AgentClass CigarettePaperAgent=new AgentClass ("CigarettePaper",Table);
        AgentClass TobaccoAgent=new AgentClass ("Tobacco",Table);
        AgentClass MatchesAgent=new AgentClass ("Mactches",Table);

        CigarettePaperAgent.start();
        TobaccoAgent.start();
        MatchesAgent.start();
        
    /*      
        SmokerClass CigarettePaperSmoker=new SmokerClass ("CigarettePaper",Table);
        SmokerClass TobaccoSmoker=new SmokerClass ("Tobacco",Table);
        SmokerClass MatchesSmoker=new SmokerClass ("Mactches",Table);
        
        CigarettePaperSmoker.start();
        TobaccoSmoker.start();
        MatchesSmoker.start();
        */
        
        for(int a=0;a<3;a++){
            SmokerClass smoker = new SmokerClass(elements.get(a),Table);
            smoker.start();
        }

//        
        System.out.println("Start");
        int i=0;
        while(true){
            
        
            Table.Awake = false;
            
            sleep(3000);
            if(CigarettePaperAgent.Table.Getitems().size()==2){
/*                
                CigarettePaperSmoker.getItems(CigarettePaperAgent.Table.Getitems());
                TobaccoSmoker.getItems(CigarettePaperAgent.Table.Getitems());
                MatchesSmoker.getItems(CigarettePaperAgent.Table.Getitems());
  */              
                System.out.println("INmain: "+CigarettePaperAgent.Table.Getitems());
                
                while(Table.awake()){
                    if(!CigarettePaperAgent.Table.Getitems().contains("CigarettePaper")){
                        TobaccoAgent.wake();
                        MatchesAgent.wake();
                        System.out.println("One");
                        System.out.println("---------------");
                        break;
                    }
                    else if(!CigarettePaperAgent.Table.Getitems().contains("Tobacco")){
                        CigarettePaperAgent.wake();
                        MatchesAgent.wake();   
                        System.out.println("Two");                    
                        System.out.println("---------------");
                        break;
                    }
                    else{
                        CigarettePaperAgent.wake();
                        TobaccoAgent.wake();
                        System.out.println("Three");
                        System.out.println("---------------");
                        break;
                    }  
                }
            }
        }
        
        
    }
    
}
