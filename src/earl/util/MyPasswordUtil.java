package earl.util;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 密码加密工具
 * @author Earl    
 * @date 2015年9月20日
 *
 */
public class MyPasswordUtil extends JFrame implements ActionListener {
	// TextGui继承了JFrame，他自己本身就是一个容器，然后实现了一个ActionListener，让他本身也带有监听功能
	private Container container;// 定义容器
	private JLabel plainText, cipherText, keyText;// 明文，密文，密钥
	private JTextField plainTextField, cipherTextField, keyTextField;// 明文，密文，密钥输入框
	private JButton encrypt, decrypt;// 加密，解密按钮
	private JPanel p1, p2, p3, p4;// p1放明文，明文输入框；p2放密文，密文输入框；p3放加密，解密按钮；p4放密钥


	// 构造方法
	public MyPasswordUtil() {
		container = this.getContentPane();// 取得container中间的那一块
		plainText = new JLabel("明文");
		plainTextField = new JTextField(30);
		p1 = new JPanel();
		p1.add(plainText);
		p1.add(plainTextField);

		cipherText = new JLabel("密文");
		cipherTextField = new JTextField(30);
		p2 = new JPanel();
		p2.add(cipherText);
		p2.add(cipherTextField);

		encrypt = new JButton("加密");
		decrypt = new JButton("解密");
		keyText = new JLabel("密钥");
		keyTextField = new JTextField(5);
		p3 = new JPanel();
		p3.add(keyText);
		p3.add(keyTextField);
		p3.add(encrypt);
		p3.add(decrypt);

		container.add(p1, BorderLayout.NORTH);
		container.add(p2, BorderLayout.CENTER);
		container.add(p3, BorderLayout.SOUTH);
		this.setVisible(true);
		this.pack();// 设置大小正好把所有的组件全部放下
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		encrypt.addActionListener(this);
		decrypt.addActionListener(this);
		this.setLocation(500, 150);

	}

	public static void main(String[] args) {
		new MyPasswordUtil();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("加密")) {
			CipherCoder.getCipherText(plainTextField, keyTextField, cipherTextField);
		}
		if (e.getActionCommand().equals("解密")) {
			CipherCoder.getPlainText(plainTextField, keyTextField, cipherTextField);
		}
	}

}
