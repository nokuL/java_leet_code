package Strings;

public class StackImpl {


        //impl a stack alg
        //take care of pop, peek, show, and push

        int [] array = new int[10];
        int top = 0;



    public void push(int data){

        //addding elements in the array from the top
        //asign data to top index and then increment the top
        if(top == array.length) throw new RuntimeException("Stack is full");
        array[top] = data;
        top++;
    }

    public int pop(){
        //decrement top counter
        //return the value of top
        if(top == 0)throw new RuntimeException("Array is empty");
        top--;
        int value = array[top];
        array[top]= 0;
        return value;
    }

    public void show(){
        for(int num : array){
            System.out.println(num);
        }
    }

    public int peek(){
        //just look at the last element and not change anything
        if(top==0)throw new RuntimeException("Stack is empty");
        return array[top -1];
    }
}
