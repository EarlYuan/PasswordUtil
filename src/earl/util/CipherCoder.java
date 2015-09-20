package earl.util;

import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.swing.JTextField;

/**
 * 加解密工具类
 * @author Earl    
 * @date 2015年9月20日
 *
 */
public class CipherCoder {
	

	/**
	 * 加密，生成密文
	 */
	public static void getCipherText(JTextField plainTextField,JTextField keyTextField,JTextField cipherTextField){
		//明文内容
		StringBuffer plainText=new StringBuffer(plainTextField.getText());
		//密钥内容
		StringBuffer keyText=new StringBuffer(keyTextField.getText());
		//必须设置密钥
		if(keyTextField.getText()==null||"".equals(keyTextField.getText()))
			return;
		
		//将得到的byte数组内容正负颠倒，以得到稍微再安全一点的加密内容
		byte[] cipherData=plainText.append(keyText).toString().getBytes();
		for(int i=0;i<cipherData.length;i++){
    		byte temp=cipherData[i];
    		if(temp<0){
    			temp=(byte) (temp*-1);
    		}else if (temp>0) {
				temp=(byte) (temp*-1);
			}
    		cipherData[i]=temp;
    	}
		
		//将密文内容编码后显示在密文文本框中
		Encoder encoder=java.util.Base64.getEncoder();
		String cipherString=new String(encoder.encode(cipherData));
		cipherTextField.setText(cipherString);
		
	}
	
	/**
	 * 解密，生成明文
	 */
	public static void getPlainText(JTextField plainTextField,JTextField keyTextField,JTextField cipherTextField){
		//密文内容
		String cipherText=cipherTextField.getText();
		//密钥内容
		String keyText=keyTextField.getText();
		//判断密钥必须输入
		if(keyText==null||"".equals(keyText))
			return;
		
		//将密文字符串编码，并根据正负颠倒的规则得到明文加密钥内容的字符串
		Decoder decoder=java.util.Base64.getDecoder();
		byte[] plainData=decoder.decode(cipherText.toString());
		for(int i=0;i<plainData.length;i++){
    		byte temp=plainData[i];
    		if(temp<0){
    			temp=(byte) (temp*-1);
    		}else if (temp>0) {
				temp=(byte) (temp*-1);
			}
    		plainData[i]=temp;
    	}
		
		//将明文内容截去密钥字符串后显示在明文文本框中
		String plainText=new String(plainData);
		String finalPlainText= plainText.substring(0,plainText.length()-keyText.length());
		plainTextField.setText(finalPlainText);
	}
}
