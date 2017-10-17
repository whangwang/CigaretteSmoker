package cigarettesmoker;

import cigarettesmoker.AgentClass.table;
import java.util.ArrayList;

/**
 *
 * @author joseph
 */

public class SmokerClass extends Thread{

    static table Table = new table();
    private String element;
    private ArrayList<String> Items = new ArrayList();

    public SmokerClass(String Element , table SmokingTable)
    {
        this.Table = SmokingTable;
        element = Element;
        Items = Table.Getitems();
    }

    @Override
    public void run()
    {
        while(true)
        {
            
        }
    }

    public synchronized void doSmoke() throws Exception
    {
     
    }


}
