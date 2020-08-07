package com.atguigu.queue;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

    }
}
class CircleArray{
    private  int maxSize;
    private int front;//指向队列的第一元素，初始值0
    private int rear;//指向队列的最后一个元素的后一个位置，初始值为0
    private int[] arr;

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
//        front = 0;//指向队列头部，分析出front指向队列头的前一个位置
//        rear =0;//指向队列尾的数，即最后一个数据
    }

    public boolean isFull(){
        return (rear+1)%maxSize == front;
    }
    public boolean isEmpty(){
        return rear==front;
    }

}

