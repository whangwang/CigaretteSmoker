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

public class TableClass {
    
        public boolean Awake = false;

        private Semaphore Notfull = new Semaphore(2);
        private Semaphore Using = new Semaphore(1);
        private ArrayList Items = new ArrayList();
        public TableClass(){
            System.out.println("Table class build success");
            
        }    
        
        
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
        
        public boolean hasElement(String elementName)
    {
        return (Items.contains(elementName));
    }
        public void wakeup(){
            Awake=true;
        }
        public boolean awake(){
            return Awake;
        }

}
