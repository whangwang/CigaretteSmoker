/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;
/*
import cigarettesmoker.CigaretteSmoker.material;
import cigarettesmoker.CigaretteSmoker.smokerid;
*/
import cigarettesmoker.SecondController;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author eric
 */
public class AgentClass extends Thread {
       int tmp=0;
       private String Item1;
       private String Item2;
       private String Material;
       public TableClass Table;
 //      public static TableClass Table =new TableClass();
       AgentClass(String material ,TableClass table){
           Material = material;
           Table=table;
 //          System.out.println("Build: "+Material);
       }

       public String Getame(){
           return Material;
       }
       @Override
       public void run(){
           //System.out.println(Material+" runing");
           while(true){
               //System.out.println(Material+" inwhile runing");
               try{
                   Table.run(Material);
                   
                   if(CigaretteSmoker.material.size()!=2){
                       int temp=0;
                       if(Material=="CigarettePaper"){
                           temp=2;
//                        System.out.println("bbbbb");

                       }
                       else if(Material=="Tobacco"){
                           temp=1;
                       }
                       else{
                           temp=3;
 //                           System.out.println("aaaaa");
                       }
                       CigaretteSmoker.material.add(temp);
                   }
                   Random nn =new Random();

 
                   pause();
                   Table.Release();
                   sleep((int)Exponential()*100);
               }catch(Exception e){}
           
               }
       
           }
       public synchronized void wake(){

            try{
                notify();
                System.out.println(this.Material);
            } catch(Exception e){}
        }

        public synchronized void pause(){
            try{
                this.wait();
            } catch (InterruptedException e) {}
        }

       public static double Exponential() {
	Random rand =new Random();
        System.out.println(Math.log(1-rand.nextDouble())/(-10));
	return  Math.log(1-rand.nextDouble())/(-10);
    }
               
       
    }
    


