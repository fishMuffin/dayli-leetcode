package edu.klein.common;

/**
 * java实现链表
 * 链表节点的2个属性：当前值，下一节点
 * 4个方法：遍历，获取长度，新增节点，删除节点
 */
public class LinkNodeTem {
    public int val;
    public LinkNodeTem next;

    /**
     * 构造方法1
     * @param val
     * @param next
     */
    public LinkNodeTem(int val, LinkNodeTem next) {
        this.val = val;
        this.next = next;
    }

    /**
     * 构造方法2
     * @param val
     */
    public LinkNodeTem(int val) {
        this.val = val;
    }

    /**
     * 遍历
     */
    public void travel(){
        LinkNodeTem cur = this;
        while(cur != null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }

    /**
     * 链表长度
     * @return
     */
    public int getSize(){
        LinkNodeTem cur = this;
        int size = 0;
        while (cur != null){
            size ++;
            cur = cur.next;
        }
        return size;
    }

    /**
     * 新增节点
     * 找到最后一个节点，把新增的节点加载后面即可
     * @param node
     */
    public void add(LinkNodeTem node){
        LinkNodeTem cur = this;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = node;
        this.travel();
    }

    /**
     * 删除节点
     * 把要删除的节点变成下一节点即可
     * 还有另一种方法是将此节点的上一节点的next指向此节点的next，本文并没采用
     * @param node
     */
    public void delete(LinkNodeTem node){
        node.val = node.next.val;
        node.next = node.next.next;
        this.travel();
    }
}