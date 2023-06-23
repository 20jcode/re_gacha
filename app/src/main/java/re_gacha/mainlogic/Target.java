package re_gacha.mainlogic;

import java.util.Map;
import java.util.Set;
import java.util.HashMap;


public class Target {
    
    private String name;
    private Map<String,Integer> recipe = new HashMap<>();

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
}
