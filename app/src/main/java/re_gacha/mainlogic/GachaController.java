package re_gacha.mainlogic;

import re_gacha.mainlogic.Gacha;

public class GachaController {
    
    private Item item;
    private Target target;

    public void setItem(Item item){
        this.item = item;
    }

    public int getItem(String name){
        return item.getItemValue(name);
    }

    public void setTarget(Target target){
        this.target = target;
    }

    public Target getTarget(){
        return target;
    }

    public void doGacha(int n){

        for (int i = 0; i<n; i++){

            innerGacha(item,target);
        }
    }

    public LinkedList<Integer> innerGacha(Map<String,Integer> wantItem, Map<String,Double>targetValue,
    int userItem, )
}

/*
 * return data
 * 
 * getAns()
 * 
 * Item소비가 적은 순
 * 
 * 0 ~ n/10 : [해당 구간 평균 소비 item 수, 해당 구간 평균 획득 item 수, 해당 구간 평균 추가 필요 item 수]
 * 
 * [[20,3,4],[35,3,10]...[ , , ]]
 * 
 */