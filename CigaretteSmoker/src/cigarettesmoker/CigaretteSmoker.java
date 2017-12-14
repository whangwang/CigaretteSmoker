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
import java.util.Random;
import java.util.concurrent.TimeUnit;


/**
 *
 * @author HanWang
 */
public class CigaretteSmoker extends Application {
    static public int pass=1;
    static public int smokerid=0;
    static public int smoketime=0;
    static public TableClass Table =new TableClass();
    static public ArrayList<Integer> material = new ArrayList();
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

    }
    public static void test() throws InterruptedException{
        int check=0;
        ArrayList<String> elements = new ArrayList();
        elements.add("CigarettePaper");
        elements.add("Tobacco");
        elements.add("Mactches");
        
//        TableClass Table =new TableClass();
     
        
        AgentClass CigarettePaperAgent=new AgentClass ("CigarettePaper",Table);
        AgentClass TobaccoAgent=new AgentClass ("Tobacco",Table);
        AgentClass MatchesAgent=new AgentClass ("Mactches",Table);

        CigarettePaperAgent.start();
        TobaccoAgent.start();
        MatchesAgent.start();
        
        
        for(int a=0;a<3;a++){
            SmokerClass smoker = new SmokerClass(elements.get(a),Table);
            smoker.start();
        }

//        
        System.out.println("Start");
        int i=0;
        
        while(true){
            

            Table.Awake = false;
            
            sleep(600);
            System.out.println(CigarettePaperAgent.Table.Getitems());
            if(CigarettePaperAgent.Table.Getitems().size()==2){
             
                System.out.println("INmain: "+CigarettePaperAgent.Table.Getitems());
                
                while(Table.awake()){
                    material.clear();
                    pass++;
                    
                    if(!CigarettePaperAgent.Table.Getitems().contains("CigarettePaper")){
                        TobaccoAgent.wake();
//                        TimeUnit.MICROSECONDS.sleep((int)(Exponential()*100));
                        MatchesAgent.wake();
 //                       System.out.println("One");
                        System.out.println("---------------");
                        break;
                    }
                    else if(!CigarettePaperAgent.Table.Getitems().contains("Tobacco")){
                        CigarettePaperAgent.wake();
 //                       TimeUnit.MICROSECONDS.sleep((int)(Exponential()*100));
                        MatchesAgent.wake();   
 //                       System.out.println("Two");                    
                        System.out.println("---------------");
                        break;
                    }
                    else{
                        CigarettePaperAgent.wake();
 //                       TimeUnit.MICROSECONDS.sleep((int)(Exponential()*100));
                        TobaccoAgent.wake();
 //                       System.out.println("Three");
                        System.out.println("---------------");
                        break;
                    }

                }
                                    

            }
        
        }
        
        
    }
    public static double Exponential() {
	Random rand =new Random();
        System.out.println(Math.log(1-rand.nextDouble())/(-10));
	return  Math.log(1-rand.nextDouble())/(-10);
    }
    
}
