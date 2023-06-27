package re_gacha.mainlogic;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class TargetV2 extends Target {

    private Map<String,String> connecter;
    private Map<String,Array> percent;
    
    public TargetV2(String name) {
        super(name);

        connecter = new HashMap<>();
    }

    public void recipeConnet(String recipe,String consum){ //레시피이름과 소비아이템 연결시켜줌

        connecter.put(recipe,consum);


    }

    /**
     * 
     * @param recipe  얻으려고 하는 item 이름
     * @return 소비해야하는 item 이름
     */
    public String getUseItemName(String recipe){

        return connecter.get(recipe);

    }

    public void setPer(String consum,Array percent){

        this.percent.put(consum,percent);
    }

    public double[] getPer(String consum){

        return this.percent.
    }

    
}
