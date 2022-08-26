LEETCODE QUESTION LINK : https://leetcode.com/problems/sort-an-array/submissions/
GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/sort-the-array0055/1

class Solution {
    
    //IF THE SIZE OF THE LIST IS 0 RETURN
    //IF NOT COPY THE LAST ELEMENT OF THE LIST
    //          --THEN REMOVE THAT ELEMENT
    //THEN AGAIN CALL SORT UNTILL IT'S LAST ELEMENT
    
    //THEN INSERT THAT TEMP VALUE
    
    void sort(ArrayList<Integer> list)
    {
        if(list.size() == 1)
        {
            return;
        }
        
        int temp = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        sort(list);
        
        insert(list, temp);
    }
    
    
    //IF THE SIZE OF THE LIST IS 0
    //          OR
    //IF THE TEMP VALUE IF BIGGER OR EQUALS TO THE LAST ELEMENT 
    //          --ADD TEMP TO LAST OF THE LIST ADDLAST
    //
    //IF NOT COPY THE LAST ELEMENT OF THE LIST
    //          --THEN REMOVE THAT ELEMENT
    //
    //CALL INSERT TO ADD THE ELEMENT IN THE LIST
    //
    //THEN ADD THE VALUE TO THE LAST
    
    
    //EXAMPLE
    //          ARR = 0 1 5 2
    //FOR BIGGER SIZE ARRAY TEMP WILL ADD 
    //THE ELEMENT TO THE APROPEATE POSTION
    
    //ARR = 0 1 5       ADD      TEMP = 2 TO IT
    //
    //FIRST WE COPY THE LAST ELEMENT ARR = 0 1 5     INTO     TEMP = 5
    // THEN WE REMOVE THE LAST ELEMENT  ARR = 0 1 5
    //                                            X
    //THEN  ARR = 0 1 
    
    //THEN THIS WILL BE TRUE
    /*if(list.size() == 0 || list.get(list.size()-1) <= temp)
        {
            list.add(temp);
            return;
        }
    */
    //REMOVE THE LAST ELEMENT UNTILL THE TEMP FITS 
    // AND THEN ADD LAST 
    
    //THIS PROCESS CONTINUES
            
    void insert(ArrayList<Integer> list, int temp)
    {
        if(list.size() == 0 || list.get(list.size()-1) <= temp)
        {
            list.add(temp);
            return;
        }
        
        int val = list.get(list.size()-1);
        list.remove(list.size()-1);
        
        insert(list, temp);
        
        list.add(val);
    }
   
    
    //COPY THE ARRAY TO ARRAYLIST TO FUNCTION PROPERLY 
    //THEN CALL SORT FUNCTION
    //THE COPY ARRAYLIST ELEMENTS TO THE ARRAY
    public int[] sortArray(int[] nums) {
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i =0; i<nums.length; i++)
        {
            list.add(nums[i]);
        }
        
        //CALL
        sort(list);
        
        int arr[] = new int[list.size()];
    
        for(int i =0; i<nums.length; i++)
        {
            arr[i] = list.get(i);
        }
        
        return arr;
        
    }
}
