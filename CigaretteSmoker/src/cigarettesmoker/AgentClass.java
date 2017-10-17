/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;

import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author eric
 */
public class AgentClass {
   public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        AgentClass go =new AgentClass();
        go.run();
    }
    public void run() throws InterruptedException{
        agent A=new agent("Paper");
        agent B=new agent("Tobacco");
        agent C=new agent("Matches");
        Thread a=new Thread(A);
        Thread b=new Thread(B);
        Thread c=new Thread(C);
        a.start();
        b.start();
        c.start();
        //new Thread(new agent("Paper")).start();
        //new Thread(new agent("Tabocco")).start();
        //new Thread(new agent("Matches")).start();
        while(true){
            sleep(3000);
            
            if(Table.Getitems().size()==2){
                
                System.out.println("INmain: "+Table.Getitems());
                if(!Table.Getitems().contains("Paper")){
                    B.wake();
                    C.wake();
                    System.out.println("One");
                }
                else if(!Table.Getitems().contains("Tobacco")){
                    A.wake();
                    C.wake();   
                    System.out.println("Two");
                }
                else{
                    A.wake();
                    B.wake();
                    System.out.println("Three");
                }  
                    //sleep(5000);
                    //Table.wake();
                               }
        }
        //agent CP = new agent("Paper");
        //agent T = new agent("Tobacco");
        //agent M = new agent("Matches");
        //CP.start();
        //T.start();
        //M.start();
        
    }
    public synchronized void wake(){
            try{
                notify();
            } catch(Exception e){}
        }
    static table Table = new table();
    
    class agent extends Thread{
       private String Item1;
       private String Item2;
       private String Material; 
       
       public agent(String material){
           Material = material;
       }
       
       public String Getame(){
           return Material;
       }
       
       public void run(){
           while(true){
               try{
                   Table.run(Material);
                   System.out.println(Material);
                   pause();
                   Table.Release();
                   sleep(1000);
               }catch(Exception e){}
           
       }
           }
       public synchronized void wake(){
            try{
                notify();
            } catch(Exception e){}
        }

        public synchronized void pause(){
            try{
                this.wait();
            } catch (InterruptedException e) {}
        }
               
       
    }
    static class table {
        final Semaphore Notfull = new Semaphore(2);
        final Semaphore Using = new Semaphore(1);
        final ArrayList Items = new ArrayList();
        public void run(String Material) throws InterruptedException{
            Notfull.acquire();
            Using.acquire();
            Items.add(Material);
            Using.release();
            sleep(1000);
                
        }
            
        public void Release(){
            Items.clear();
            Notfull.release();
        }
        public boolean Isempty(){
            return (Items.isEmpty());
        }
        public ArrayList Getitems(){
            return (Items);
        }
        public synchronized void wake(){
            try{
                notify();
            } catch(Exception e){}
        }

        public synchronized void pause(){
            try{
                this.wait();
            } catch (InterruptedException e) {}
        }
            
        }
        
}
    

