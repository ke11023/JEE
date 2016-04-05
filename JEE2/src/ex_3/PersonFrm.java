package ex_3;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PersonFrm extends JFrame{
	PersonDao dao=new PersonDao();
	private JTable table = null;
	static String[] cols={"ID","姓名","性别","电话","住址","邮箱"};
	JLabel Jbl1=new JLabel("编号：");
	JLabel Jbl2=new JLabel("姓名：");
	JLabel Jbl3=new JLabel("性别：");
	JLabel Jbl4=new JLabel("电话：");
	JLabel Jbl5=new JLabel("住址：");
	JLabel Jbl6=new JLabel("邮箱：");
	JTextField txt1=new JTextField();
	JTextField txt2=new JTextField();
	JTextField txt3=new JTextField();
	JTextField txt4=new JTextField();
	JTextField txt5=new JTextField();
	JTextField txt6=new JTextField();
	private JButton searchBtn = new JButton("查看");
	private JButton addBtn = new JButton("增加");
	private JButton deleteBtn = new JButton("删除");
	private JButton allBtn = new JButton("查询所有");
	public PersonFrm(){
		String[][] rows=new String[10][6];
		JPanel jp = (JPanel) this.getContentPane();
		table = new JTable(rows, cols);
		JScrollPane jsp_table = new JScrollPane(table);
		jp.add(jsp_table);

		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4,4));
		jp1.add(Jbl1);jp1.add(txt1);		jp1.add(Jbl2);jp1.add(txt2);
		jp1.add(Jbl3);jp1.add(txt3);		jp1.add(Jbl4);jp1.add(txt4);
		jp1.add(Jbl5);jp1.add(txt5);		jp1.add(Jbl6);jp1.add(txt6);
		jp1.add(searchBtn);jp1.add(addBtn);jp1.add(deleteBtn);jp1.add(allBtn);
		jp.add(jp1, BorderLayout.NORTH);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Person> list=dao.queryPersonByName(txt2.getText());
				updateTable(list);
			}
		});
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Person per=new Person();
				per.setPid(Integer.parseInt(txt1.getText()));
				per.setName(txt2.getText());
				per.setSex(txt3.getText());
				per.setTel(txt4.getText());
				per.setAddress(txt5.getText());
				per.setEmail(txt6.getText());
				dao.addPerson(per);
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dao.deletePersonByID(Integer.parseInt(txt1.getText()));
			}
		});
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Person> list=dao.allPerson();
				updateTable(list);
			}
		});
		this.setSize(600, 600);
		this.setVisible(true);
	}
	
	public  void updateTable(ArrayList<Person> list) {
		String[][] rows =new String[list.size()][6];
		for(int i=0;i<list.size();i++){
			Person per=list.get(i);
			rows[i][0]=String.valueOf(per.getPid());
			rows[i][1]=per.getName();
			rows[i][2]=per.getSex();
			rows[i][3]=per.getTel();
			rows[i][4]=per.getAddress();
			rows[i][5]=per.getEmail();
		}
		table.setModel(new DefaultTableModel(rows, cols));
	}
	
	public static void main(String[] args){
		new PersonFrm();
	}

}
