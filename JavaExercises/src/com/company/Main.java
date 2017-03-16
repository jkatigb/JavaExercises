package com.company;

import java.util.ArrayList;
import java.util.List;

/*
 * Cons the Magnificent Chapter - The Little Schemer
 *
 * The SECOND COMMANDMENT states to use 'cons' to build lists
 * i.e. remember to add to a list as you recurse, to allow your function to
 * 'remember' the previous values
  * */
public class Main {

    public static void main(String[] args) {

        List<Integer> test = new ArrayList<Integer>();
        test.add(1);
        test.add(2);
        test.add(3);
        test.add(4);

        removeRecursively<Integer> tester = new removeRecursively<Integer>();
        System.out.println(tester.rem(3, test));
    }
}


class removeRecursively<T>{


    private List<T> tList = new ArrayList<T>();

    List<T> rem(T t, List<T> c) {

        //if c is empty then return the null tList
        //base case
        if(c.isEmpty()) {
            return tList;
        }
        //if the first index in this iteration == t (the value to remove)
        //then return continue recursing (but not add to tList)
        //this is the remove step
        else if (c.get(0) == t) {
            return rem(t, c.subList(1, c.size()));
        }
        //continue recursing through the list, adding to tList and passing in
        //smaller and smaller sublists
        else {
            System.out.println("Recursing to find " + t);
            tList.add(c.get(0));
            return rem(t, c.subList(1, c.size()));

        }

    }


}
