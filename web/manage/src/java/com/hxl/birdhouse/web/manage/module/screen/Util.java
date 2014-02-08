package com.hxl.birdhouse.web.manage.module.screen;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
/**
 * ������
 * 1�������ݵĲ�������
 * 2��ģ��post���󣬴��ݲ������õ����ؽ��
 * 3���ӻص�URL�Ĳ����л��visitor_nickֵ����nick
 * @author TOP
 *
 */
public class Util {
    /*
     * ������ת�ַ���
     */
    private static String byte2hex(byte[] b) {

        StringBuffer hs = new StringBuffer();
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1)
                hs.append("0").append(stmp);
            else
                hs.append(stmp);
        }
        return hs.toString().toUpperCase();
    }

    /*
     * �Ѿ���BASE64������ַ���ת��ΪMap����
     */
    public static Map<String, String> convertBase64StringtoMap(String str) {

//        if (str == null)
//            return null;
//        BASE64Decoder decoder = new BASE64Decoder();
//        String keyvalues = null;
//        try {
//            keyvalues = new String(decoder.decodeBuffer(str));
//        } catch (IOException e) {
//            return null;
//        }
//        if (keyvalues == null || keyvalues.length() == 0)
//            return null;
//        String[] keyvalueArray = keyvalues.split("&");
//        Map<String, String> map = new HashMap<String, String>();
//        for (String keyvalue : keyvalueArray) {
//            String[] s = keyvalue.split("=");
//            if (s == null || s.length != 2)
//                return null;
//            map.put(s[0], s[1]);
//        }
//        return map;
        return null;
    }

    /*
     * ǩ����������������ǩ����
     * 
     * @param params �����������Ĳ���
     * 
     * @param secret ���������APP_SECRET
     */
    public static String sign(TreeMap<String, String> params, String secret) {

        String result = null;
        if (params == null)
            return result;
        Iterator<String> iter = params.keySet().iterator();
        StringBuffer orgin = new StringBuffer(secret);
        while (iter.hasNext()) {
            String name = (String) iter.next();
            orgin.append(name).append(params.get(name));
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            result = byte2hex(md.digest(orgin.toString().getBytes("utf-8")));
        } catch (Exception ex) {
            throw new java.lang.RuntimeException("sign error !");
        }
        return result;
    }

    /**
     * ģ��post���󣬵���api�����ݲ�������ý��
     * @param urlStr �����url
     * @param content ���ݵĲ���
     * @return ����api��÷��ؽ��
     */
    public static String getResult(String urlStr, String content) {
        URL url = null;
        HttpURLConnection connection = null;

        try {
            //��������
            url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.connect();

            //���ݲ���
            DataOutputStream out = new DataOutputStream(connection.getOutputStream());
            //��utf-8�ı��뷽ʽ���ݲ������������Ļ��������
            out.write(content.getBytes("utf-8"));
            out.flush();
            out.close();

            //��÷��ؽ��
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection
                    .getInputStream(), "utf-8"));
            StringBuffer buffer = new StringBuffer();
            String line = "";
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            reader.close();
            return buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
        return null;
    }
    
    /**
     * ���ݻص�url�е�top_parameters���nick
     * @param top_parameters �ص�url�еĲ���
     * @return nick
     */
    public static String ParametersName(String top_parameters){

        String nick=null; 
        Map<String, String> map= convertBase64StringtoMap(top_parameters); 
        Iterator keyValuePairs = map.entrySet().iterator(); 
        for (int i = 0; i < map.size(); i++) 
        { 
            Map.Entry entry = (Map.Entry) keyValuePairs.next(); 
            Object key = entry.getKey(); 
            Object value = entry.getValue(); 
            if(key.equals("visitor_nick")){
    
                nick=(String) value; 
            } 
        } 

        return nick; 

    }
}
