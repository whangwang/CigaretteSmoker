/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cigarettesmoker;

/**
 *
 * @author eric
 */
public class AgentClass {
    private String Item1;
    private String Item2;
    public class agent extends Thread{
       private String Material;
       public agent(String material){
           Material = material;
       }
       
       public String Getame(){
           return Material;
       }
       
       public void run(){
           while(true){
 
               
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
}
    

