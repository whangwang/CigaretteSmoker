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
        
        
        
        
        
//        ArrayList<String> ConstantMaterial = new ArrayList<String>();
//        ConstantMaterial.add("Paper");
//        ConstantMaterial.add("Tobacco");
//        ConstantMaterial.add("Matches");
//        FXMLDocumentController a = new FXMLDocumentController();
//        //TableClass Table = new TableClass();
//        AgentClass CigarettePaperAgent=new AgentClass ("CigarettePaper");
//        AgentClass TobaccoAgent=new AgentClass ("Tobacco");
//        AgentClass MatchesAgent=new AgentClass ("Mactches");
////        Thread z=new Thread(CigarettePaperAgent);
////        Thread b=new Thread(TobaccoAgent);
////        Thread c=new Thread(MatchesAgent);
////        z.start();
////        b.start();
////        c.start();
//        CigarettePaperAgent.start();
//        TobaccoAgent.start();
//        MatchesAgent.start();
//        
//        System.out.println("Start");
//        int i=0;
//        while(i<1000){
//            i++;
//            sleep(3000);
//            System.out.println(i);
//            System.out.println("Size: "+CigarettePaperAgent.Table.Getitems().size());
//            System.out.println(CigarettePaperAgent.isAlive());
//            System.out.println(TobaccoAgent.isAlive());
//            System.out.println(MatchesAgent.isAlive());
//            System.out.println(CigarettePaperAgent.Table.Getitems().size());
//            System.out.println(TobaccoAgent.Table.Getitems().size());
//            System.out.println(MatchesAgent.Table.Getitems().size());
//
//            if(CigarettePaperAgent.Table.Getitems().size()==2){
//                
//                System.out.println("INmain: "+CigarettePaperAgent.Table.Getitems());
//                if(!CigarettePaperAgent.Table.Getitems().contains("CigarettePaper")){
//                    TobaccoAgent.wake();
//                    MatchesAgent.wake();
//                    System.out.println("One");
//                }
//                else if(!CigarettePaperAgent.Table.Getitems().contains("Tobacco")){
//                    CigarettePaperAgent.wake();
//                    MatchesAgent.wake();   
//                    System.out.println("Two");
//                }
//                else{
//                    CigarettePaperAgent.wake();
//                    TobaccoAgent.wake();
//                    System.out.println("Three");
//                }  
//            }
//        }
//        
        
        
        
        
        
        stage.setScene(scene);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws InterruptedException {
        
        launch(args);
        
//        ArrayList<String> ConstantMaterial = new ArrayList<String>();
//        ConstantMaterial.add("Paper");
//        ConstantMaterial.add("Tobacco");
//        ConstantMaterial.add("Matches");
//        FXMLDocumentController a = new FXMLDocumentController();
//        TableClass Table = new TableClass();
//        AgentClass CigarettePaperAgent=new AgentClass ("CigarettePaper");
//        AgentClass TobaccoAgent=new AgentClass ("Tobacco");
//        AgentClass MatchesAgent=new AgentClass ("Mactches");
//        while(true){
//            sleep(3000);
//            
//            if(Table.Getitems().size()==2){
//                
//                System.out.println("INmain: "+Table.Getitems());
//                if(!Table.Getitems().contains("Paper")){
//                    TobaccoAgent.wake();
//                    MatchesAgent.wake();
//                    System.out.println("One");
//                }
//                else if(!Table.Getitems().contains("Tobacco")){
//                    CigarettePaperAgent.wake();
//                    MatchesAgent.wake();   
//                    System.out.println("Two");
//                }
//                else{
//                    CigarettePaperAgent.wake();
//                    TobaccoAgent.wake();
//                    System.out.println("Three");
//                }  
//            }
//        }
//        
        
       // for(int i=0;3>=i;i++){
           // SmokerClass smoker = new SmokerClass(ConstantMaterial.get(i),SmokingTable);
            //smoker.start();
       //}
        
    }
    
}
