import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JToolBar;import javax.swing.KeyStroke;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;

public class Lottery extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JPanel panel_1;
	public ArrayList<Integer> al=new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> al2 = new ArrayList<ArrayList<Integer>>();
	public ArrayList<Integer> alopen=new ArrayList<Integer>();
	private JButton[] button = new JButton[49];
	private DefaultListModel<String> listbox;
	private JScrollPane scrollPane;
	private JList list;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lottery frame = new Lottery();

					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
					frame.addWindowListener(new WindowAdapter(){
						public void windowClosing(WindowEvent e){
							//JOptionPane.showMessageDialog(frame,"系統即將關閉");
							 int result=JOptionPane.showConfirmDialog(frame,   //或用 (Component)e.getSource() 亦可
					                   "確定要結束程式嗎?",
					                   "確認訊息",
					                   JOptionPane.YES_NO_OPTION,
					                   JOptionPane.WARNING_MESSAGE);
							 if (result==JOptionPane.YES_OPTION) {System.exit(0);}

							
						
						}
						
						
					});
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
				
	}

	/**
	 * Create the frame.
	 */
	public Lottery() {
		setBackground(new Color(72, 209, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 491);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u95DC\u65BC");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5927\u6A02\u900F\u73A9\u6CD5");
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		mntmNewMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showOptionDialog(null,"大樂透是一種樂透型遊戲。您必須從01~49中任選6個號碼進行投注。\n開獎時，開獎單位將隨機開出六個號碼加一個特別號，\n這一組號碼就是該期大樂透的中獎號碼，也稱為「獎號」。\n您的六個選號中，如果有三個以上（含三個號碼）對中當期開出之六個號碼（特別號只適用於貳獎、肆獎、陸獎和柒獎），即為中獎，\n並可依規定兌領獎金。","玩法介紹", JOptionPane.DEFAULT_OPTION
						,JOptionPane.INFORMATION_MESSAGE,null,null,null);
				}
			});
	
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBounds(10, 0, 673, 135);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u624B\u52D5\u8F38\u5165\u865F\u78BC");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblNewLabel.setBounds(27, 10, 101, 26);
		panel.add(lblNewLabel);
		//新增enter事件
		
		
		textField = new JTextField();
		textField.setBounds(161, 15, 96, 21);
		panel.add(textField);
		textField.setColumns(10);
       textField.addActionListener(new ActionListener() //當enter時發生事件
    		   {
    	   public void actionPerformed(ActionEvent ev)
    	   {
    		   if(textField.getText().length()>0)
      	     { Boolean b=true;
      		  int num=(int) Math.round(Double.parseDouble(textField.getText()));
  			   //四捨五入
      		   
      			  
      			   if(num >=1 && num <=49)
      			   {
      				  
         				  //每次輸入的值都拿去跟陣列元素比較
      				   for(int j=0;j<al.size();j++){
      					   if(al.get(j) ==num ){
      						   al.remove(j);//判斷輸入的數值有無重複
      						   button[num-1].setBackground(new Color(127, 255, 0));
      						 Collections.sort(al);
      						  // System.out.println(al.toString()+al.size());
      					   b=false;
      					   }//重複的話就移除掉
      					   
      				   }
      				 
          			   if(b){
          			   if(al.size()<6){
          				   al.add(new Integer(num));
          				 button[num-1].setBackground(new Color(255, 105, 180));
          				 Collections.sort(al);
          				 //System.out.println(al.toString()+al.size());
          				   }
      		    		  else{ JOptionPane.showMessageDialog(null,"最多輸入6個數字");}      
          			   }

       				                        
      		        }
      			   else{ JOptionPane.showMessageDialog(null,"請輸入1~49的正整數");
      			 textField.setText(""); }
      			  
      		   
  		          for(int i=0;i<al.size();i++){
      			   switch(i){
      			   case 0:
      				textField_1.setText(al.get(0).toString());
      				textField_2.setText("");
      				textField_3.setText("");
      				textField_4.setText("");
      				textField_5.setText("");
      				textField_6.setText("");
      				   break;
      			   case 1:
      				textField_2.setText(al.get(1).toString());
      				textField_3.setText("");
      				textField_4.setText("");
      				textField_5.setText("");
      				textField_6.setText("");
      				   break;
      			   case 2:
      				textField_3.setText(al.get(2).toString());
      				textField_4.setText("");
       				textField_5.setText("");
       				textField_6.setText("");
      				   break;
      			   case 3:
      				 textField_4.setText(al.get(3).toString());
      				 textField_5.setText("");
        			textField_6.setText("");
      				   
      				   break;
      			   case 4:
      				   textField_5.setText(al.get(4).toString());
      				 textField_6.setText("");
      				   break;
      			   case 5:
      				   textField_6.setText(al.get(5).toString());
      				   break;
      			   	      }
      			     }
      		 textField.setText("");
      		   
      		   }

    	   }
    	   });

		
		
		
		
		JLabel lblenter = new JLabel("\u8ACB\u6309Enter\u8F38\u51651-49\u7684\u6B63\u6574\u6578");
		lblenter.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblenter.setBounds(311, 10, 194, 26);
		panel.add(lblenter);
		
		JLabel label = new JLabel("\u60A8\u7684\u865F\u78BC");
		label.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		label.setBounds(27, 46, 76, 26);
		panel.add(label);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setColumns(10);
		textField_1.setBounds(113, 46, 60, 21);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setColumns(10);
		textField_2.setBounds(197, 46, 60, 21);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setColumns(10);
		textField_3.setBounds(278, 46, 60, 21);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setColumns(10);
		textField_4.setBounds(365, 46, 60, 21);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setColumns(10);
		textField_5.setBounds(445, 46, 60, 21);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setColumns(10);
		textField_6.setBounds(527, 46, 60, 21);
		panel.add(textField_6);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOpaque(false);
		toolBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		toolBar.setAlignmentX(Component.RIGHT_ALIGNMENT);
		toolBar.setBounds(10, 82, 681, 53);
		panel.add(toolBar);
		//電腦選號
		JButton btnNewButton = new JButton("\u96FB\u8166\u9078\u865F");
		btnNewButton.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 10, 5, 10)));
		btnNewButton.setBackground(new Color(144, 238, 144));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(al.size()==6){
					button[(Integer)al.get(0)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(1)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(2)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(3)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(4)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(5)-1].setBackground(new Color(127, 255, 0));
					al.clear();
				}
				
				
				
				
				int num1=0;
				for(int i=0;i<6;i++){
					
					num1=(int)(Math.random()*49)+1;
					for(int j=0;j<i;j++){
						if(al.get(j)==num1){
							num1=(int)(Math.random()*49)+1;
							continue;
						}
						
					}
					al.add(new Integer(num1));
					button[num1-1].setBackground(new Color(255, 105, 180));
					 Collections.sort(al);
					//System.out.println(al.toString()+al.size());//test
				}
				
				
				
				
	    		   for(int i=0;i<6;i++){
	    			   switch(i){
	    			   case 0:
	    				   textField_1.setText(al.get(0).toString());
	    				   break;
	    			   case 1:
	    				   textField_2.setText(al.get(1).toString());
	    				   break;
	    			   case 2:
	    				   textField_3.setText(al.get(2).toString());
	    				   break;
	    			   case 3:
	    				   textField_4.setText(al.get(3).toString());
	    				   break;
	    			   case 4:
	    				   textField_5.setText(al.get(4).toString());
	    				   break;
	    			   case 5:
	    				   textField_6.setText(al.get(5).toString());
	    				   break;
	    			   	      }
	    			     }

			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setBounds(10, 267, 673, 186);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		listbox= new DefaultListModel();
		
		 scrollPane = new JScrollPane();
			scrollPane.setBounds(325, 10, 338, 166);
			panel_2.add(scrollPane);
			
			 list = new JList();
			list.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
			list.setBackground(new Color(255, 140, 0));
			scrollPane.setViewportView(list);
		
		
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		toolBar.add(btnNewButton);
		
		JButton button = new JButton("\u78BA\u5B9A");
		button.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 10, 5, 10)));
		button.setBackground(new Color(144, 238, 144));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(al.size()<6){JOptionPane.showMessageDialog(null, "請選擇6個號碼再按確定");}
				else{
					ArrayList<Integer> al3 =new ArrayList<Integer>();
					al3.add(al.get(0));
					al3.add(al.get(1));
					al3.add(al.get(2));
					al3.add(al.get(3));
					al3.add(al.get(4));
					al3.add(al.get(5));
					
					
					
					
					al2.add(al3);//加到群組裡
					//System.out.println(al2.toString());
					
					Object[] obj=new Object[6];
					obj[0]=textField_1.getText();
					obj[1]=textField_2.getText();
					obj[2]=textField_3.getText();
					obj[3]=textField_4.getText();
					obj[4]=textField_5.getText();
					obj[5]=textField_6.getText();
					
					String output =String.format("%s %s %s %s %s %s",obj[0],obj[1],obj[2],obj[3],obj[4],obj[5]);
					listbox.addElement(output);
				    
				    list.setModel(listbox);
					
					
					
					
					
					
				}
				
				
				
				
				
			}
		});
		button.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		toolBar.add(button);
		
		JButton button_1 = new JButton("\u6E05\u9664");
		
		button_1.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 10, 5, 10)));
		button_1.setBackground(new Color(144, 238, 144));
		button_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		button_1.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		toolBar.add(button_1);
		
	 panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel_1.setBounds(10, 145, 673, 121);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		
		//製造按鈕   用原先設定好的
		for(int num=0;num<this.button.length;num++){
			this.button[num]=new JButton(String.format("%02d", new Object[] { Integer.valueOf(num + 1) }));
			this.button[num].setBackground(new Color(127, 255, 0));
			this.button[num].setFont(new Font("微軟正黑體", Font.PLAIN, 12));
			this.panel_1.add(this.button[num]);
			this.button[num].addActionListener(this);
			}
		//刪除所有欄位的事件
		button_1.addActionListener(new clearActionListener());
		
		
		
		
		
				
		
		
		
		JButton button_51 = new JButton("\u958B\u734E");
		
			
		
			
		button_51.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		button_51.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 10, 5, 10)));
		button_51.setBackground(new Color(50, 205, 50));
		button_51.setAlignmentX(0.5f);
		button_51.setBounds(10, 10, 85, 35);
		panel_2.add(button_51);
		//開獎事件
		button_51.addActionListener(new playActionListener());
		
		
		
		//刪除listbox的號碼
		JButton button_52 = new JButton("\u522A\u9664\u865F\u78BC");
		button_52.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (list.getSelectedIndex() == -1)
		        {
		          JOptionPane.showMessageDialog(null, "選擇要刪除的項目");
		        }
		        else
		        {
		        	//可以同時選取好幾個刪除
		          ArrayList<String> listitem = new ArrayList();
		          for (int a = 0; a < list.getModel().getSize(); a++) {
		            listitem.add((String)list.getModel().getElementAt(a));
		          }
		          int[] num = list.getSelectedIndices();//把選擇的索引變成整數陣列
		          for (int o = num.length - 1; o >= 0; o--) {
		            listitem.remove(num[o]);
		            al2.remove(num[o]);
		          }
		          ((DefaultListModel)list.getModel()).clear();
		          for (int c = 0; c < listitem.size(); c++)
		          {
		            listbox.addElement((String)listitem.get(c));
		           list.setModel(listbox);
		          }
		        }
				
			}	});
		button_52.setFont(new Font("微軟正黑體", Font.PLAIN, 15));
		button_52.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EmptyBorder(5, 10, 5, 10)));
		button_52.setBackground(new Color(50, 205, 50));
		button_52.setAlignmentX(0.5f);
		button_52.setBounds(10, 121, 85, 35);
		panel_2.add(button_52);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(255, 182, 193));
		textArea.setText("6\u500B\u865F\u78BC\u5B8C\u5168\u76F8\u540C:\u982D\u734E\r\n\u4EFB5\u500B\u865F\u78BC\u76F8\u540C+\u7279\u5225\u865F:\u8CB3\u734E\r\n\u4EFB5\u500B\u865F\u78BC\u78BC\u76F8\u540C:\u53C3\u734E\r\n\u4EFB4\u500B\u865F\u78BC\u76F8\u540C+\u7279\u5225\u865F:\u8086\u734E\r\n\u4EFB4\u500B\u865F\u78BC\u76F8\u540C:\u4F0D\u734E\r\n\u4EFB3\u500B\u865F\u78BC\u76F8\u540C+\u7279\u5225\u865F:\u9678\u734E\r\n\u4EFB2\u500B\u865F\u78BC\u76F8\u540C+\u7279\u5225\u865F:\u67D2\u734E\r\n\u4EFB3\u500B\u865F\u78BC\u76F8\u540C:\u666E\u734E\r\n\r\n");
		textArea.setBounds(126, 10, 189, 172);
		panel_2.add(textArea);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	//按鈕新增數字的事件
		Boolean b=true;
		  int num=Integer.parseInt(((JButton)e.getSource()).getText());
			   //四捨五入
		   
			  
			   if(num >=1 && num <=49)
			   {
				  
   				  //每次輸入的值都拿去跟陣列元素比較
				   for(int j=0;j<al.size();j++){
					   if(al.get(j) ==num ){
						   al.remove(j);//判斷輸入的數值有無重複
						 ((JButton)e.getSource()).setBackground(new Color(127, 255, 0));
						 Collections.sort(al);
						   //System.out.println(al.toString()+al.size());
					   b=false;
					   }//重複的話就移除掉
					   
				   }
				 
    			   if(b){
    			   if(al.size()<6){
    				   al.add(new Integer(num));
    				 ((JButton)e.getSource()).setBackground(new Color(255, 105, 180));
    				 Collections.sort(al);
    				 //System.out.println(al.toString()+al.size());
    				   }
		    		  else{ JOptionPane.showMessageDialog(null,"最多輸入6個數字");}      
    			   }

 				                        
		        }
			   else{ JOptionPane.showMessageDialog(null,"請輸入1~49的正整數");
			 textField.setText(""); }
			  
		   
		          for(int i=0;i<al.size();i++){
			   switch(i){
			   case 0:
				textField_1.setText(al.get(0).toString());
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				   break;
			   case 1:
				textField_2.setText(al.get(1).toString());
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				   break;
			   case 2:
				textField_3.setText(al.get(2).toString());
				textField_4.setText("");
 				textField_5.setText("");
 				textField_6.setText("");
				   break;
			   case 3:
				 textField_4.setText(al.get(3).toString());
				 textField_5.setText("");
  			     textField_6.setText("");
				   
				   break;
			   case 4:
				   textField_5.setText(al.get(4).toString());
				   textField_6.setText("");
				   break;
			   case 5:
				   textField_6.setText(al.get(5).toString());
				   break;
			   	      }
			     }
		 textField.setText("");

		
	}
	 class playActionListener implements ActionListener{
//開獎的事件
			@Override
			//內部類別 可以直接使用外部類別的成員(變數或方法)
			public void actionPerformed(ActionEvent arg0) {
				
				String str="開獎號碼:";
				alopen.clear();
				
	if(al2.size()>0){
		//開獎號碼
		int num2=0;
		for(int i=0;i<7;i++){
			
			num2=(int)(Math.random()*49)+1;
			for(int j=0;j<i;j++){
				if(alopen.get(j)==num2){
					num2=(int)(Math.random()*49)+1;
					continue;
				}
				
			}
			alopen.add(new Integer(num2));
			
			 Collections.sort(alopen);
			
		}
		str += String.format("[%d %d %d %d %d %d] 特別號[%d]\n",alopen.get(0),alopen.get(1),
				alopen.get(2),alopen.get(3),alopen.get(4),alopen.get(5),
				alopen.get(6));
		
		//System.out.printf(al2.get(0).toString());
		//System.out.print(al2.get(0).get(0));
		//System.out.printf(alopen.toString());
		
		
		for(int i=0;i<al2.size();i++)//比對群組內的每個陣列元素
		{  str+=String.format("您的第 %d 組號碼 %s",i+1,al2.get(i).toString());
			int count=0;//中獎號碼數
			int spec=0;//特別號中獎數
			
			for(int j=0;j<6;j++)//比對6個號碼
			{
				for(int w=0;w<6;w++){
					if(alopen.get(j).equals(al2.get(i).get(w)))
					{
						
						count+=1;
						
				    }
				                     }
				
		     }
			for(int a=0;a<6;a++)//比對特別號
			{
				if(alopen.get(6).equals(al2.get(i).get(a)))
				{
					spec+=1;
				}
			}
			
			//看中獎結果
			if(count==6){str+="恭喜對中頭獎\n";}
			else if(count==5 && spec==1){str+="恭喜對中貳獎\n";}
			else if(count==5){str+="恭喜對中參獎\n";}
			else if(count==4 && spec==1){str+="恭喜對中肆獎\n";}
			else if(count ==4){str+="恭喜對中伍獎\n";}
			else if(count==3 && spec==1){str+="恭喜對中陸獎\n";}
			else if(count==3){str+="恭喜對中普獎\n";}
			else if(count==2 && spec==1){str+="恭喜對中普獎\n";}
			else{str+="挖 都沒中   再接再厲!!\n";}
			//System.out.printf("%d-%d",count,spec);
			//System.out.println(alopen.toString());
			
			
					}
	JOptionPane.showMessageDialog(null, str);
	}
	else{JOptionPane.showMessageDialog(null, "請至少選擇一組號碼");}
				
				
				
				
				
				
				
				
				
			}
	    	
	    	
	    }
	 class clearActionListener implements ActionListener{

			@Override
			//內部類別 可以直接使用外部類別的成員(變數或方法)
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				((DefaultListModel)list.getModel()).clear();
				//button[0].setBackground(new Color(127, 255, 0));
				if(al.size()==6){
					button[(Integer)al.get(0)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(1)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(2)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(3)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(4)-1].setBackground(new Color(127, 255, 0));
					button[(Integer)al.get(5)-1].setBackground(new Color(127, 255, 0));
					
				}
				al.clear();
				al2.clear();

				
			}
	    	
	    	
	    }
}

