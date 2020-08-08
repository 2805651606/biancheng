package com.atguigu.linkedlist;

public class DoubleLikedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表");
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();

        HeroNode2 newHerNode = new HeroNode2(4,"公孙胜","入云龙");
        doubleLinkedList.update(newHerNode);
        System.out.println("修改以后");
        doubleLinkedList.list();

        System.out.println("删除");
        doubleLinkedList.del(3);
        doubleLinkedList.list();
    }
}
class DoubleLinkedList{
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead(){
        return head;
    }
    //遍历
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true){
            //判断是否到链表最后
            if(temp==null){
                break;
            }
            //输出节点信息
            System.out.println(temp);
            temp = temp.next;
        }
    }
    //添加节点
    public  void add(HeroNode2 heroNode){
        HeroNode2 temp = head;
        while (true){
            //找到最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改节点的信息
    public void update(HeroNode2 newHeroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true){
            if (temp==null){
                break;
            }
            if(temp.no == newHeroNode.no){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else {
            System.out.printf("没有找到编号%d的节点，不能修改\n",newHeroNode.no);
        }
    }
    //删除节点
    public void del(int no){
        if(head.next==null){
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head;
        boolean flag = false;//标记是否找到待删节点
        while (true){
            if(temp ==null){//已经到链表的最后
                break;
            }
            if (temp.no==no){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = temp.next;
            if(temp.next!=null){
                temp.next.pre = temp.pre;
            }
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }
}

class HeroNode2{
    public int no;
    public  String name;
    public String nickname;
    public HeroNode2 next;
    public HeroNode2 pre;
    public HeroNode2(int hNo,String hName,String hNickname){
        this.no = hNo;
        this.name = hName;
        this.nickname = hNickname;
    }
    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name=" + name +
                ", nickname=" + nickname +
                '}';
    }
}
