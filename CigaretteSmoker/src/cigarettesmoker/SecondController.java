/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;
import javax.swing.SwingUtilities;
import java.util.concurrent.TimeUnit;

/**
 * FXML Controller class
 *
 * @author HanWang
 */
public class SecondController implements Initializable {
    
    int Pass=0;
    /**
     * Initializes the controller class.
     */
    @FXML private Pane smokerA;
    @FXML private Pane smokerB;
    @FXML private Pane smokerC;
    @FXML private Pane ma_1;
    @FXML private Pane ma_2;
    @FXML private Pane ma_3;
    @FXML private Label time_label;
    @FXML private Label pass_label;
    @FXML private Pane smokerA_status;
    @FXML private Pane smokerB_status;
    @FXML private Pane smokerC_status;
    @FXML private Label smokerA_status_label;
    @FXML private Label smokerB_status_label;
    @FXML private Label smokerC_status_label;
    @FXML private Label startbtn;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
    public void clicke(MouseEvent event){
        startbtn.setText("Table");
        new Thread(task).start();
//        ArrayList <Integer> arr = new ArrayList();
//        arr.add(2);
//        arr.add(3);
//        runpass(arr,1,980);
    }
    
   
    
    Task task = new Task<Void>() {
    @Override public Void call() throws InterruptedException {
        System.out.println("task");
        //System.out.println(Integer.valueOf(pass_label.getText()));
        int zz=0;
        while(true){
 //           System.out.println("inwhile");
 /*
            if(zz==1){
   //             TimeUnit.SECONDS.sleep(1);
                System.out.println("return");
                   
                zz=0;

    //            TimeUnit.SECONDS.sleep(1);
            }
*/
 //           while(Pass==CigaretteSmoker.pass){
            
 //               System.out.println("stillwaiting");
 //           }
            if(CigaretteSmoker.material.size()==2&&CigaretteSmoker.smokerid!=0&&CigaretteSmoker.smoketime!=0)
            {
                ArrayList arr = CigaretteSmoker.material;
                int id = CigaretteSmoker.smokerid;
                int time = CigaretteSmoker.smoketime;
                
                System.out.println("Enter in if" + "  "+Pass);
             //   runpass(CigaretteSmoker.material,CigaretteSmoker.smokerid,CigaretteSmoker.smoketime);
                runpass(arr,id,time);
            Platform.runLater(new Runnable() {
                 @Override public void run() {
//                     //pass_label.setText(String.valueOf(Integer.valueOf(pass_label.getText())+1));
////                     Pass++;
                    System.out.println("before timelable");
                     time_label.setText(String.valueOf(CigaretteSmoker.smoketime));
                     pass_label.setText(String.valueOf(Pass));
                     
                     System.out.println("after timelable");             
                 }
        });
            
        CigaretteSmoker.Table.wakeup();
        TimeUnit.MILLISECONDS.sleep(CigaretteSmoker.smoketime+2700);
 //       zz=1;

        //this.wait(500);
        }
            else{
                continue;
            }
        }
        //return null ;
    }
    };
    
    public void runpass(ArrayList <Integer> m_id, int smoker,int time) throws InterruptedException{
        Pass++;
        System.out.println("test"+" Pass: "+Pass);
        System.out.println("arr = "+m_id+"id = "+smoker+"time = "+time);
       int m_id_1=m_id.get(0);
        int m_id_2=m_id.get(1);
        if(m_id_1>m_id_2){
            int swp;
            swp=m_id_1;
            m_id_1=m_id_2;
            m_id_2=swp;
        }        
        movematerial(m_id_1,m_id_2,time);
        movesmoker(smoker,m_id_1,m_id_2);
        System.out.println("runpass over");
        //this.wait(50);
        
       
    }
    
   
   
   public void changeStatus(int smoker,int m_id_1,int m_id_2) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1800), ev -> {
           switch(smoker){
                    case 1:
                        smokerA_status.setStyle("-fx-background-color: #EA7484");
                        smokerA_status_label.setText("Smoking...");
                        break;
                    case 2:
                        smokerB_status.setStyle("-fx-background-color: #EA7484");
                        smokerB_status_label.setText("Smoking...");
                        break;
                    default:
                        smokerC_status.setStyle("-fx-background-color: #EA7484");
                        smokerC_status_label.setText("Smoking...");
                        break;
            }
            countdown(smoker,m_id_1,m_id_2);
            
        }));
        timeline.play();
    }
    
    public void countdown(int smoke,int m_id_1,int m_id_2){
        int time = Integer.valueOf(time_label.getText());
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1), ev -> {
            time_label.setText(String.valueOf(Integer.valueOf(time_label.getText())-1));
        }));
        timeline.setCycleCount(time);
       
        timeline.setOnFinished(e -> {
             switch(smoke){
                    case 1:
                        smokerA_status.setStyle("-fx-background-color: #566856");
                        smokerA_status_label.setText("Waiting...");
                        break;
                    case 2:
                        smokerB_status.setStyle("-fx-background-color: #566856");
                        smokerB_status_label.setText("Waiting...");
                        break;
                    default:
                        smokerC_status.setStyle("-fx-background-color: #566856");
                        smokerC_status_label.setText("Waiting...");
                        break;
            }
            switch(m_id_1){
                    case 1:
                        ma_1.setTranslateX(8);
                        ma_1.setTranslateY(9);
                        break;
                    case 2:
                        ma_2.setTranslateX(8);
                        ma_2.setTranslateY(121);
                        break;
                    default:
                        ma_3.setTranslateX(8);
                        ma_3.setTranslateY(231);
                        break;
            }
            switch(m_id_2){
                    case 1:
                        ma_1.setTranslateX(8);
                        ma_1.setTranslateY(9);
                        break;
                    case 2:
                        ma_2.setTranslateX(8);
                        ma_2.setTranslateY(121);
                        break;
                    default:
                        ma_3.setTranslateX(8);
                        ma_3.setTranslateY(9);
                        break;
            }
            backsmoker(smoke);
        });
        timeline.play();      
    }
   
    public void movematerial(int id1,int id2,int time){
        //time_label.setText(String.valueOf(time));
        //pass_label.setText(String.valueOf(Integer.valueOf(pass_label.getText())+1));
        Polyline line1 = new Polyline();
        Polyline line2 = new Polyline();
        PathTransition transition = new PathTransition();
        switch(id1){
            case 1:
                transition.setNode(ma_1);
                line1.getPoints().addAll(new Double[]{
                    153.0 , 30.0 ,
                    555.0 , 30.0 ,
                    555.0 , 452.0
                });
                break;
            case 2:
                transition.setNode(ma_2);
                line1.getPoints().addAll(new Double[]{
                    153.0 , 30.0 ,
                    555.0 , 30.0 ,
                    555.0 , 340.0
                });
                break;
            default:
                transition.setNode(ma_3);
                line1.getPoints().addAll(new Double[]{
                    153.0 , 30.0 ,
                    555.0 , 30.0 ,
                    555.0 , 228.0
                });
                break;
        }
        transition.setDuration(Duration.millis(1800));
        transition.setPath(line1);
        PathTransition transition1 = new PathTransition();
        switch(id2){
            case 1:
                transition1.setNode(ma_1);
                line2.getPoints().addAll(new Double[]{
                    153.0 , 30.0 ,
                    555.0 , 30.0 ,
                    555.0 , 515.0
                });
                break;
            case 2:
                transition1.setNode(ma_2);
                line2.getPoints().addAll(new Double[]{
                    153.0 , 30.0 ,
                    555.0 , 30.0 ,
                    555.0 , 401.0
                });
                break;
            default:
                transition1.setNode(ma_3);
                line2.getPoints().addAll(new Double[]{
                    153.0 , 30.0 ,
                    555.0 , 30.0 ,
                    555.0 , 291.0
                });
                break;
        }
        transition1.setDuration(Duration.millis(1800));
        transition1.setPath(line2);
        
        transition.play();
        transition1.play();
    }
    
    public void backsmoker(int id){
         Timer timer = new Timer();
        switch (id) {
            case 1:
                Line line1 = new Line(593, 145, 153, 145);
                Line line2 = new Line(591, 145, 153, 145);
                Line line3 = new Line(591, 145, 153, 145);
                PathTransition transition = new PathTransition();
                transition.setNode(smokerA);
                transition.setDuration(Duration.millis(800));
                transition.setPath(line1);
                transition.play();
                PathTransition transition2 = new PathTransition();
                transition2.setNode(smokerB);
                transition2.setDuration(Duration.millis(800));
                transition2.setPath(line2);
                transition2.play();
                PathTransition transition3 = new PathTransition();
                transition3.setNode(smokerC);
                transition3.setDuration(Duration.millis(800));
                transition3.setPath(line3);
                transition3.play();
                break;
            case 3:
                Line line1r = new Line(-287, 145, 153, 145);
                Line line2r = new Line(-285, 145, 153, 145);
                Line line3r = new Line(-285, 145, 153, 145);
                PathTransition transitionr = new PathTransition();
                transitionr.setNode(smokerA);
                transitionr.setDuration(Duration.millis(800));
                transitionr.setPath(line1r);
                transitionr.play();
                PathTransition transition2r = new PathTransition();
                transition2r.setNode(smokerB);
                transition2r.setDuration(Duration.millis(800));
                transition2r.setPath(line2r);
                transition2r.play();
                PathTransition transition3r = new PathTransition();
                transition3r.setNode(smokerC);
                transition3r.setDuration(Duration.millis(800));
                transition3r.setPath(line3r);
                transition3r.play();
                
                break;
            default:
                
                break;
        }
        
    }

    public void movesmoker(int id,int m_id_1,int m_id_2){
         Timer timer = new Timer();
         System.out.println("movesmoker");
        switch (id) {
            case 1:
                                        System.out.println("run case1");

                Line line1 = new Line(153, 145, 593, 145);
                Line line2 = new Line(153, 145, 591, 145);
                Line line3 = new Line(153, 145, 591, 145);
                PathTransition transition = new PathTransition();
                transition.setNode(smokerA);
                transition.setDuration(Duration.millis(800));
                transition.setPath(line1);
                transition.play();
                PathTransition transition2 = new PathTransition();
                transition2.setNode(smokerB);
                transition2.setDuration(Duration.millis(800));
                transition2.setPath(line2);
                transition2.play();
                PathTransition transition3 = new PathTransition();
                transition3.setNode(smokerC);
                transition3.setDuration(Duration.millis(800));
                transition3.setPath(line3);
                transition3.play();
                System.out.println("case1 over");
                changeStatus(1,m_id_1,m_id_2);
                break;
            case 3:
                                        System.out.println("run case3");

                Line line1r = new Line(153, 145, -287, 145);
                Line line2r = new Line(153, 145, -285, 145);
                Line line3r = new Line(153, 145, -285, 145);
                PathTransition transitionr = new PathTransition();
                transitionr.setNode(smokerA);
                transitionr.setDuration(Duration.millis(800));
                transitionr.setPath(line1r);
                transitionr.play();
                PathTransition transition2r = new PathTransition();
                transition2r.setNode(smokerB);
                transition2r.setDuration(Duration.millis(800));
                transition2r.setPath(line2r);
                transition2r.play();
                PathTransition transition3r = new PathTransition();
                transition3r.setNode(smokerC);
                transition3r.setDuration(Duration.millis(800));
                transition3r.setPath(line3r);
                transition3r.play();
                TimerTask task1 = new TimerTask() {   
                    public void run() {  
                        System.out.println("run task1");
                        smokerC_status.setStyle("-fx-background-color: #EA7484");
                        smokerC_status_label.setText("Smoking...");
                    }   
                };   
                changeStatus(3,m_id_1,m_id_2);
                break;
            default:
                TimerTask task2 = new TimerTask() {   
                    public void run() {   
                        smokerB_status.setStyle("-fx-background-color: #EA7484");
                        smokerB_status_label.setText("Smoking...");
                    }   
                };   
                changeStatus(2,m_id_1,m_id_2) ; 
                break;
        }
        
    }
}
