/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package 第17章;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class 第17章 extends JFrame{
    public Container c;
    //圖片位置
    public Icon ic;
    public Icon ic2;
    public Icon ic3;
    public Icon ic4;
    public Icon ic5;
    public Icon ic6;
    public Icon ic7;
    public Icon ic8;
    public Icon ic9;
    public Icon ic10;
    
    public JPanel p;
    public JPanel p2;
    public JPanel p3;
    public JPanel p4;
    public JPanel p5;
    public JPanel p6;//p3 p4 p5
    public JPanel p7;//p p2
    //文字
    public JLabel label;
    public JLabel label2;
    public JLabel label3;
    public JLabel label4;
    public JLabel label5;
    public JLabel label6;
    //數字
    public JLabel label7;
    public JLabel label8;
    public JLabel label9;
    public JLabel label10;
    public JLabel label11;
    public JLabel label12;
    //圖片空間
    public JLabel label13;
    public JLabel label14;
    public JLabel label15;
    public JLabel label16;
    public JLabel label17;
    public JLabel label18;
    public JLabel label19;
    public JLabel label20;
    public JLabel label21;
    public JLabel label22;
    
    //按鈕
    public JButton bt;
    public JButton bt2;
    public JButton bt3;
    public int count;
    public int count2;
    public double sum;
    public double sum2;
    
    public int totalcard;
    ArrayList<Icon> cardList;//牌的圖案
    ArrayList<JLabel> cardLabel;//放牌的label
    ArrayList<Integer> exit;//已存在號碼(場上的牌不重複)
    public 第17章(){
        totalcard=52;
        count2=4;
        count=0;
        sum=0;
        this.setLocation(10,10);
        this.setSize(500,400);
        this.setTitle("十點半遊戲，玩加五小雨十點半雙半雙倍，同分莊家贏，每次10元");
        c=getContentPane();
        c.setLayout(new BorderLayout());                     
        
        p=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        p5=new JPanel();
        p6=new JPanel();
        p7=new JPanel();
        
        c.add(p6,BorderLayout.SOUTH);
        c.add(p7);        
        p7.add(p);
        p7.add(p2);
        p7.setLayout(new GridLayout(2,1));
        p6.add(p3);
        p6.add(p4);
        p6.add(p5);
        p6.setLayout(new GridLayout(3,1));
        p5.setLayout(new GridLayout());
        p4.setLayout(new GridLayout());
        p3.setLayout(new GridLayout());
        p2.setLayout(new GridLayout(1,5));
        p.setLayout(new GridLayout(1,5));
        
        label=new JLabel("本金");
        label2=new JLabel("賭注");
        label3=new JLabel("結果");
        label4=new JLabel("倍數");
        label5=new JLabel("玩加點數");
        label6=new JLabel("莊家點數");
        label7=new JLabel("100");
        label8=new JLabel("10");
        label9=new JLabel("");
        label10=new JLabel("");
        label11=new JLabel("");
        label12=new JLabel("");        
        
        bt=new JButton("發牌");
        bt2=new JButton("補牌");
        bt3=new JButton("補牌完畢");
        //玩家牌設定
        label13=new JLabel(ic);
        label14=new JLabel(ic2);
        label15=new JLabel(ic3);
        label16=new JLabel(ic4);
        label17=new JLabel(ic5);

        //莊家牌設定
        label18=new JLabel(ic6);
        label19=new JLabel(ic7);
        label20=new JLabel(ic8);
        label21=new JLabel(ic9);
        label22=new JLabel(ic10);
        
        cardList=new ArrayList();
        cardLabel=new ArrayList();
        exit=new ArrayList();
        
        ic2=new ImageIcon("g1.jpg");
        cardList.add(ic2);
        cardList.add(ic3);
        cardList.add(ic4);
        cardList.add(ic5);
        
        cardList.add(ic6);
        cardList.add(ic7);
        cardList.add(ic8);
        cardList.add(ic9);
        cardList.add(ic10);
        
        cardLabel.add(label14);
        cardLabel.add(label15);
        cardLabel.add(label16);
        cardLabel.add(label17);
        
        cardLabel.add(label18);
        cardLabel.add(label19);
        cardLabel.add(label20);
        cardLabel.add(label21);
        cardLabel.add(label22);
        //發牌功能(按鍵功能)
        bt.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {            
                //亂數發牌
                int random=(int)(Math.random()*totalcard);
                exit.add(random);
                String card="g"+String.valueOf(random)+".jpg";
                double num=random/4+1;
                if(num>10){
                    num=0.5;
                }
                ic=new ImageIcon(card);
                label13.setIcon(ic);
                ic6=new ImageIcon("g52.jpg");
                label18.setIcon(ic6);
                
                bt.setEnabled(false);
                bt2.setEnabled(true);
                bt3.setEnabled(true);
                sum+=num;
                label11.setText(String.valueOf(sum));
            }
        });        
        //補牌功能(按鍵功能)
        bt2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                //不重複卡牌
                int random=(int)(Math.random()*totalcard);
                for(int i=0;i<exit.size();i++){
                    if(random==exit.get(i)){
                        random=(int)(Math.random()*totalcard);
                        i=-1;//跳到迴圈會先加一變成0 如果寫i=0 則迴圈開始為i=1跳過 exit.get(0)的判斷
                    }
                }
                exit.add(random);
                String card="g"+String.valueOf(random)+".jpg";
                double num=random/4+1;
                if(num>10){
                    num=0.5;
                }
                cardList.set(count, new ImageIcon(card));
                cardLabel.get(count).setIcon(cardList.get(count));
                               
                sum+=num;
                label11.setText(String.valueOf(sum));
                count++;               
                if(sum>=10.5||count==4){
                    bt2.setEnabled(false);
                    bt3.setEnabled(false);
                }
                if(sum>10.5){
                    label9.setText("玩家敗");
                    label7.setText("90");
                    label10.setText("-1");
                }
                else if(count==4){
                    label9.setText("玩家勝");
                    label7.setText("120");
                    label10.setText("2");
                }
                else if(sum==10.5){
                    label9.setText("玩家勝");
                    label7.setText("120");
                    label10.setText("2");
                }
            }
        });
        bt3.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                bt2.setEnabled(false);
                bt3.setEnabled(false);
                //莊家牌不能重複功能
                while(true){
                    int random=(int)(Math.random()*totalcard);
                    for(int i=0;i<exit.size();i++){
                        if(random==exit.get(i)){
                            random=(int)(Math.random()*totalcard);
                            i=-1;
                        }
                    }
                    exit.add(random);
                    String card="g"+String.valueOf(random)+".jpg";
                    double num=random/4+1;
                    if(num>10){
                        num=0.5;
                    }                    
                    cardList.set(count2,new ImageIcon(card));
                    cardLabel.get(count2).setIcon(cardList.get(count2));                
                    count2++;
                    sum2+=num;
                    //莊家點數爆炸
                    if(sum2>10.5){
                        label9.setText("玩家勝");
                        label7.setText("110");
                        label10.setText("1");
                        break;
                    }
                    //莊家10點半
                    else if(sum2==10.5){
                        label9.setText("玩家敗");
                        label7.setText("80");
                        label10.setText("-2");
                        break;
                    }
                    //莊家五小
                    else if(count2==9){
                        label9.setText("玩家敗");
                        label7.setText("80");
                        label10.setText("-2");
                        break;
                    }
                    //莊家點數>玩家
                    else if(sum2>=sum){
                        label9.setText("玩家敗");
                        label7.setText("90");
                        label10.setText("-1");
                        break;
                    }                                       
                }           
                label12.setText(String.valueOf(sum2));        
            }
        });
        
        bt2.setEnabled(false);//暫時性不開放功能
        bt3.setEnabled(false);//暫時性不開放功能
        p.add(label13);
        p.add(label14);
        p.add(label15);
        p.add(label16);
        p.add(label17);
        p2.add(label18);
        p2.add(label19);
        p2.add(label20);
        p2.add(label21);
        p2.add(label22);
        
        p3.add(label);
        p3.add(label7);
        p3.add(label2);
        p3.add(label8);
        p3.add(label3);
        p3.add(label9);
        p3.add(label4);
        p3.add(label10);
        p4.add(label5);
        p4.add(label11);
        //-------湊版面----------
        p4.add(new Label());
        p4.add(new Label());
        p4.add(new Label());
        //-------湊版面----------
        p5.add(label6);
        p5.add(label12);
        p5.add(bt);
        p5.add(bt2);
        p5.add(bt3);
    }
    
    public static void main(String[] args) {
        第17章 frm=new 第17章();
        frm.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frm.setVisible(true);
    }    
}
