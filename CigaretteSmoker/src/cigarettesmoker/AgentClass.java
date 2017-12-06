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
//                   System.out.println(Material);
                   
                   if(CigaretteSmoker.material.size()!=2){
                       int temp=0;
                       if(Material=="CigarettePaper"){
                           temp=2;
                       }
                       else if(Material=="Tobacco"){
                           temp=1;
                       }
                       else{
                           temp=3;
                       }
                       CigaretteSmoker.material.add(temp);
                   }
                   Random nn =new Random();
                   //sleep(nn.nextInt(10000));
                   //System.out.println("test1111 runpass");
                   System.out.println(CigaretteSmoker.material);
 //                  sleep(3000);
                   System.out.println(CigaretteSmoker.smokerid); 
 
                   pause();
                   Table.Release();
                   sleep(10);
               }catch(Exception e){}
           
               }
       
           }
       public synchronized void wake(){
            try{
                notify();
                //System.out.println(Material+" notify");
                
            } catch(Exception e){}
        }

        public synchronized void pause(){
            try{
                this.wait();
            } catch (InterruptedException e) {}
        }

   
               
       
    }
    


