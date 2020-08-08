package com.atguigu.linkedlist;

import com.sun.corba.se.impl.orbutil.HexOutputStream;

import java.util.Stack;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建链表
        SingleLinkeList singleLinkeList = new SingleLinkeList();
        singleLinkeList.addByOrder(hero4);
        singleLinkeList.addByOrder(hero1);
        singleLinkeList.addByOrder(hero3);
        singleLinkeList.addByOrder(hero2);


//        //显示一把
//        singleLinkeList.list();
//
//        singleLinkeList.del(1);
//        singleLinkeList.list();
//        //显示个数
//        System.out.println(getLength(singleLinkeList.getHead()));
//
//        HeroNode res = findLastIndexNode(singleLinkeList.getHead(),1);
//        System.out.println("res="+res);
        singleLinkeList.list();
        System.out.println();
        reversePrint(singleLinkeList.getHead());
    }

    //逆序打印
    public  static void reversePrint(HeroNode head){
        if (head.next==null){
            return;
        }
        Stack<HeroNode> heroNodes = new Stack<HeroNode>();
        HeroNode cur = head.next;
        while (cur!=null){
            heroNodes.push(cur);
            cur = cur.next;
        }
        while (heroNodes.size()>0){
            System.out.println(heroNodes.pop());
        }
    }


    //反转
    public static void reversetList(HeroNode head){
        if(head.next==null||head.next.next==null){
            return;
        }
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0,"","");
        while (cur!=null){
            next  = cur.next;
            cur.next =reverseHead.next;
            reverseHead.next=cur;
            cur=next;//让cur后移
        }
        head.next = reverseHead.next;


    }

    public static HeroNode findLastIndexNode(HeroNode heroNode,int index){
        if (heroNode.next==null){
            return null;
        }
        //得到链表的长度
        int size = getLength(heroNode);
        //
        if(index<=0||index>size){
            return null;
        }
        HeroNode cur = heroNode.next;
        for (int i=0;i<size-index;i++){
            cur = cur.next;
        }
        return cur;
    }



    //获取单链表的节点的个数,不同界头节点
    public static int  getLength(HeroNode head){
        if(head.next==null){
            return 0;
        }
        int length=0;
        HeroNode cur = head.next;
        while (cur!=null){
            length++;
            cur = cur.next;
        }
        return length;
    }
}
//定义单链表
class SingleLinkeList{
    private  HeroNode head = new HeroNode(0,"","");
    public  HeroNode getHead(){
        return head;
    }

    //添加节点
    public  void add(HeroNode heroNode){
        HeroNode temp = head;
        while (true){
            //找到最后
            if(temp.next==null){
                break;
            }
            //如果没有找到最后，将temp后移
            temp = temp.next;
        }
        temp.next = heroNode;
    }
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next==null){
                break;
            }
            if (temp.next.no>heroNode.no){//位置已经找到，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.printf("准备插入的英雄的编号%d已经存在，不能加入了\n",heroNode.no);
        }else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }
    //修改节点的信息
    public void update(HeroNode newHeroNode){
        if (head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        boolean flag = false;
        while (true){
            if(temp.next ==null){
                break;
            }
            if (temp.next.no==no){
                flag=true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("要删除的%d节点不存在\n",no);
        }
    }

    //遍历
    public void list(){
        //判断链表是否为空
        if(head.next==null){
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
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

}


class HeroNode{
    public int no;
    public  String name;
    public String nickname;
    public HeroNode next;
    public HeroNode(int hNo,String hName,String hNickname){
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
