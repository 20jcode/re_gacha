package re_gacha.mainlogic;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class Target {
    
    private String name;
    private Map<String,Integer> recipe = new HashMap<>();
    private Map<String,Integer> consum = new HashMap<>();

    public Target(){

    }

    public Target(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setRecipe(String key, int value){

        recipe.put(key,value);
    }

    public Set<String> getRecipe(){
        return recipe.keySet();
    }

    public int getValue(String key){
        return recipe.get(key);
    }

    public void setUseItem(String key, int value) throws IllegalArgumentException {

        if (value>0){
            throw new IllegalArgumentException("사용아이템은 양수일 수 없습니다");
        }

        consum.put(key,value);

    }

    public int getUseItem(String key) {
        return consum.get(key);
    }
}
