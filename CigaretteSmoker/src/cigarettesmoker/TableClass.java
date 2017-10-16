package cigarettesmoker;

/**
 *
 * @author joseph
 */

import java.util.ArrayList;

public class TableClass {

    private ArrayList<String> Elements = new ArrayList<String>();

    public TableClass()
    {
        while(!Elements.isEmpty()){
            Elements.remove(0);
        }
    }
    
    public void SetTable( String Material1 , String Material2 )
    {
        Elements.add( Material1 );
        Elements.add( Material2 );
    }
}
