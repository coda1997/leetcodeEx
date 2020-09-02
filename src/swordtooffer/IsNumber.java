package swordtooffer;

import java.util.HashMap;
import java.util.Map;

public class IsNumber {
    public boolean isNumber(String s) {
         //这题使用有限自动状态机来做
         Map<State,Map<CharType, State>> transferMap = new HashMap<>();

         //Init
         Map<CharType, State> s0 = new HashMap<>(){{
             put(CharType.CHAR_SPACE, State.STATE_START);
             put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
             put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
             put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
         }};
         transferMap.put(State.STATE_START, s0);
         
         Map<CharType, State> s1 = new HashMap<>(){{
             put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
             put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
         }};
         transferMap.put(State.STATE_INT_SIGN, s1);
         
         Map<CharType, State> s2 = new HashMap<>(){{
             put(CharType.CHAR_SPACE, State.STATE_END);
             put(CharType.CHAR_EXP, State.STATE_EXP);
             put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
             put(CharType.CHAR_POINT, State.STATE_POINT);
         }};
         transferMap.put(State.STATE_INTEGER, s2);
         
         Map<CharType, State> s3 = new HashMap<>(){{
             put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
         }};
         transferMap.put(State.STATE_POINT_WITHOUT_INT, s3);
         
         Map<CharType, State> s4 = new HashMap<>(){{
             put(CharType.CHAR_SPACE, State.STATE_END);
             put(CharType.CHAR_EXP, State.STATE_EXP);
             put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
         }};
         transferMap.put(State.STATE_POINT, s4);
         
         Map<CharType, State> s5 = new HashMap<>(){{
             put(CharType.CHAR_SPACE, State.STATE_END);
             put(CharType.CHAR_EXP, State.STATE_EXP);
             put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
         }};
         transferMap.put(State.STATE_FRACTION, s5);
         
         Map<CharType, State> s6 = new HashMap<>(){{
             put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
             put(CharType.CHAR_NUMBER, State.STATE_EXP_NUM);
         }};
         transferMap.put(State.STATE_EXP, s6);
 
         Map<CharType, State> s7 = new HashMap<>(){{
             put(CharType.CHAR_NUMBER, State.STATE_EXP_NUM);
         }};
         transferMap.put(State.STATE_EXP_SIGN, s7);
         
         Map<CharType, State> s8 = new HashMap<>(){{
             put(CharType.CHAR_SPACE, State.STATE_END);
             put(CharType.CHAR_NUMBER, State.STATE_EXP_NUM);
         }};
         transferMap.put(State.STATE_EXP_NUM, s8);
         
         Map<CharType, State> s9 = new HashMap<>(){{
             put(CharType.CHAR_SPACE, State.STATE_END);
         }};
         transferMap.put(State.STATE_END, s9);
         
         var state = State.STATE_START;
         var cc = s.toCharArray();

         for (int i = 0; i < cc.length; i++) {
             var t = helper(cc[i]);
             if(!transferMap.get(state).containsKey(t)){
                 return false;
             }
             state = transferMap.get(state).get(t);
         }
         return state==State.STATE_END||state==State.STATE_INTEGER||state==State.STATE_POINT||state==State.STATE_EXP_NUM||state==State.STATE_FRACTION;

    }
    private CharType helper(char ch){
        if(ch>='0'&&ch<='9'){
            return CharType.CHAR_NUMBER;
        }else if(ch=='e'||ch=='E'){
            return CharType.CHAR_EXP;
        }else if(ch=='.'){
            return CharType.CHAR_POINT;
        }else if(ch=='+'||ch=='-'){
            return CharType.CHAR_SIGN;
        }else if(ch==' '){
            return CharType.CHAR_SPACE;
        }else{
            return CharType.CHAR_ILLEGAL;
        }
    }

    enum State{
        STATE_START,
        STATE_INT_SIGN,
        STATE_INTEGER,
        STATE_POINT,
        STATE_POINT_WITHOUT_INT,
        STATE_FRACTION,
        STATE_EXP,
        STATE_EXP_SIGN,
        STATE_EXP_NUM,
        STATE_END
    }

    enum CharType{
        CHAR_NUMBER,
        CHAR_EXP,
        CHAR_POINT,
        CHAR_SIGN,
        CHAR_SPACE,
        CHAR_ILLEGAL
    }

    public static void main(String[] args) {
        var o = new IsNumber();
        o.isNumber("e");
    }
    
}