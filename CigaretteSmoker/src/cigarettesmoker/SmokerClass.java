package cigarettesmoker;

import cigarettesmoker.AgentClass;
import java.util.ArrayList;
import java.util.*;
import java.util.function.Predicate;
/**
 *
 * @author joseph
 */

public class SmokerClass extends Thread{

    //static table Table = new table();
    private String element;
    private ArrayList<String> Items = new ArrayList();
    public TableClass Table;


    public SmokerClass(String Element,TableClass table)
    {
        element = Element;
        Table=table;
  //      Items = a;
  //      System.out.println(element+"   smoker");
    }


    @Override
    public void run()
    {
        while(true)
        {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {}
            
            if(Table.Getitems().size()==2 && !Table.Isempty() && !Table.hasElement(element)){                
                System.out.println(element+" "+Table.Getitems());
                try {
                    if(element=="CigarettePaper"){
                        CigaretteSmoker.smokerid=2;
                    }
                    else if(element=="Tobacco"){
                        CigaretteSmoker.smokerid=1;
                    }
                    else{
                        CigaretteSmoker.smokerid=3;
                    }
//                    System.out.println("id: "+CigaretteSmoker.smokerid);
                    doSmoke();
 //                   System.out.println("time: "+CigaretteSmoker.smoketime);

                    //System.out.println(CigaretteSmoker.smokerid);
                    System.out.println(element+ " tells the agent to start the next round.");
  //                  Items = Table.Getitems();
                    //Table.Awake = true;
                } catch (Exception e) {}

            }
        }
    }
    public void awake(){
        Table.Awake = true;
    }

    public synchronized void doSmoke() throws Exception
    {
        System.out.println(element + " rolls the cigarette.");
        double time = getNext();
        Thread.sleep((long) time);
        CigaretteSmoker.smoketime=(int)((time+1.5)*1000);
        System.out.println(element + " has finished.");
    }
    
    public void getItems(){
        System.out.println("haha"+Table.Getitems());
    //    System.out.println(Items);
    }
    public static double getNext() {
	Random rand =new Random();
	return  Math.log(1-rand.nextDouble())/(-0.8);
    }

}
