GFG QUESTION LINK : https://practice.geeksforgeeks.org/problems/sort-a-stack/1

//Ditto same as array 
//even the explanation is same

class GfG{
    
    void Sort(Stack<Integer> s)
    {
        if(s.size() == 1)
        {return;}
        
        int temp = s.pop();
        
        Sort(s);
        insert(s, temp);
    }
    
    void insert(Stack<Integer> s, int temp)
    {
        if(s.size() == 0 || s.peek() <= temp)
        {
            s.push(temp);
            return;
        }
        
        int val = s.pop();
        
        insert(s, temp);
        
        s.push(val);
        
    }
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    Sort(s);
	    
	    return s;
		
	}
}
