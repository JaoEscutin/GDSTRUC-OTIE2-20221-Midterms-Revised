package com.gdstruc.midterms;

import java.util.EmptyStackException;

public class CardStack {
    private Card [] stack;
    private int top;

    public CardStack (int capacity){
        stack = new Card[capacity];
    }

    public void placeCard (Card card){
        stack [top++] = card;
    }

    public Card removeCard (){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        Card removedCard = stack[--top];
        stack[top] = null;

        return removedCard;
    }

    public boolean isEmpty(){
        return top == 0;
    }

    public int size (){
        return top;
    }

    public void printCards (){
        for (int i = top -1; i >= 0; i--){
            System.out.println(stack[i].getName());
        }
    }
}
