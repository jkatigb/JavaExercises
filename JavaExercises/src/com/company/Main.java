package com.company;
import java.util.ArrayList;
import java.util.Arrays;
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

        removeRecursively<Integer> tester2 = new removeRecursively<Integer>();
        Integer[][] ints = new Integer[][]{{123, 456, 9182}, {}, {112, 568, 1120}, {2391}};
        System.out.println(tester2.firsts(ints));


        removeRecursively<Integer> tester3 = new removeRecursively<Integer>();
        Integer[][] ints2 = new Integer[][]{{1, 5519, 9182}, {}, {3, 568, 2}, {2391}, {33}, {91}, {1245}, {1, 4, 6, 7, 9}};
        System.out.println(tester3.genericFirsts(ints2, 2));  //[9182, 2, 6]

    }


    static class removeRecursively<T> {


        private List<T> tList = new ArrayList<T>();

        List<T> rem(T t, List<T> c) {

            //if c is empty then return the null tList
            //base case
            if (c.isEmpty()) {
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
                tList.add(c.get(0));
                return rem(t, c.subList(1, c.size()));

            }

        }

        List<T> firsts(T[][] arrayOfArrays) {

            //base case
            if (arrayOfArrays.length == 0) {
                //returning a null list in the list of lists
                return tList;
            }


            //if we hit an empty list in a list we
            //continue the recursion without adding
            //to tList
            else if (arrayOfArrays[0].length == 0 ) {

                return firsts(Arrays.copyOfRange(arrayOfArrays, 1, arrayOfArrays.length));

            }

            //add the first value of the list
            //continue the recursion
            else {

                tList.add(arrayOfArrays[0][0]);
                return firsts(Arrays.copyOfRange(arrayOfArrays, 1, arrayOfArrays.length));

            }


        }

        List<T> genericFirsts(T[][] arrayOfArrays, int indexInList){
            //base case
            if (arrayOfArrays.length == 0) {
                //returning a null list in the list of lists
                return tList;
            }


            //if we hit an empty list in a list
            // or if the length of the current list
            // is < the index specified, we
            //continue the recursion without adding to tList
            else if (arrayOfArrays[0].length == 0 || arrayOfArrays[0].length <= indexInList) {


                //ex. genericFirsts(([1, 3, 4, 5],[1], [3],[4]),0) -> genericFirsts([1],[3],[4])...
                // tList = {1}
                return genericFirsts(Arrays.copyOfRange(arrayOfArrays, 1, arrayOfArrays.length), indexInList);

            }

            else {

                tList.add(arrayOfArrays[0][indexInList]);
                return genericFirsts(Arrays.copyOfRange(arrayOfArrays, 1, arrayOfArrays.length), indexInList);

            }




        }


    }
}

