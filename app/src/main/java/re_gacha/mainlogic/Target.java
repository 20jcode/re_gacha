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
    /**
     * 아이템을 조합해 완성된 아이템의 이름
     * @return Target's name
     */
    public String getName(){
        return name;
    }

    /**
     * 해당 Map이 비어있다면, 조합으로 생성할 수 없는 단위 아이템이다.
     * @param key 조합에 필요한 아이템의 이름
     * @param value 조합에 필요한 갯수
     */
    public void setRecipe(String key, int value){

        recipe.put(key,value);
    }

    public Set<String> getRecipe(){
        return recipe.keySet();
    }

    public int getValue(String key){
        return recipe.get(key);
    }

    /**
     * 
     * @param key 조합에 필요한 아이템을 뽑기 위해 소모하는 아이템 이름
     * @param value 갯수
     * @throws IllegalArgumentException '소모'임으로 음수, 착오방지용으로 음수만 받음
     */
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
