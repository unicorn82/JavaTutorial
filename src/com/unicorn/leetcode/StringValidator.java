package com.unicorn.leetcode;

import java.util.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringValidator {

    class myStack<T> {

        private List<T> myStack = new ArrayList<T>();

        public void push(T ele){
            myStack.add(ele);
        }

        public T pop(){
            T last = null;
            if(myStack.size()> 0) {
                last = myStack.get(myStack.size() - 1);
                myStack.remove(myStack.size() - 1);
            }
            return last;
        }

        public int getSize(){
            return myStack.size();
        }


    }

    public boolean validateString(String str){
        boolean isValid = true;
        Map<String, String> bracketMap = new HashMap();
        bracketMap.put(")", "(" );
        bracketMap.put("]", "[");
        bracketMap.put("}", "{");
        Set<String> keys = bracketMap.keySet();
        Collection<String> values = bracketMap.values();

        myStack<String> stacks = new myStack<String>();

        for(int i=0;i<str.length();i++){
//            System.out.println(str.charAt(i));
            String c = str.charAt(i)+"";
            if (values.contains(c)) {
                stacks.push(str.charAt(i)+"");
            }else if (keys.contains(c)){

                isValid = stacks.getSize()>0 && stacks.pop().equalsIgnoreCase(bracketMap.get(c));
                if(!isValid){
                    return isValid;
                }
            }



        }


        return stacks.getSize() == 0;
    }

    public boolean validStrwithStar(String str){

        Map<String, String> bracketMap = new HashMap();
        bracketMap.put(")", "(" );
        Set<String> keys = bracketMap.keySet();
        Collection<String> values = bracketMap.values();

        List<String> stacks = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            System.out.println(i+"->"+str.charAt(i));
            String c = str.charAt(i)+"";
            if (values.contains(c) || c.equalsIgnoreCase("*")) {
                stacks.add(str.charAt(i)+"");
            }else if (keys.contains(c)){
                int star = -1;
                for(int j=stacks.size()-1; j>=0; j--){
                    String elem = stacks.get(j);
                    if(star<0 && !elem.equalsIgnoreCase("*") && !elem.equalsIgnoreCase(bracketMap.get(c))){
                        return false;
                    }else if (elem.equalsIgnoreCase("*")&& star<0){
                        star = j;

                    }else if (elem.equalsIgnoreCase(bracketMap.get(c))){
                        stacks.remove(j);
                        System.out.println("action: remove="+j+" element="+elem);
                        star = -1;
                        break;
                    }
                }
                if(star >0){
                    System.out.println("action: popup="+star+ " element="+stacks.get(star));
                    stacks.remove(star);
                }
            }
            printList(stacks);

        }
        if(stacks.size()>0 ){
            if(!stacks.get(0).equalsIgnoreCase("*")|| !stacks.get(stacks.size()-1).equalsIgnoreCase("*")){
                return false;
            }

        }
        return true;


    }

    private void printList(List<String> list){
        for (String str: list
             ) {
            System.out.print(str);


        }
        System.out.println("");
    }



    public static void main(String[] args) {
        System.out.println("start");

        StringValidator validator = new StringValidator();
        System.out.println(validator.validateString("([(h) ] {w})"));
//        String str = str = "((((()(()()()*";
          String str = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";

//        String str = str = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(validator.validStrwithStar(str));
    }
}
