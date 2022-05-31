package com.kosta.controller2;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.util.UploadFileHelper;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadTestServlet
 */
@WebServlet("/UploadTestServlet")
public class UploadTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIR = "uploads"; //���� �̸��� �˾Ƽ� �����ص���
	/**
	MultipartRequest mrequest = new MultipartRequest(
  request       //MultipartRequest�� ����� ���� request
, saveDirectory //���� ��ġ (File��ü)
, maxPostSize   //�ִ�ũ�� (int)
, encoding      //���ڵ� Ÿ�� ("utf-8")
, policy        //���� ��å (FileRenamePolicy��ü)
); 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getServletContext().getRealPath(UPLOAD_DIR);
		System.out.println("�������� ���� ��� : "+dir);
		//upload�߰�
		 Map<String,Object> map = UploadFileHelper.uploadFile(UPLOAD_DIR, request);
		 List<String> photos = (List<String>)map.get("photos");
		 System.out.println(photos);
		 
		 Map<String, String> params = (Map<String, String>)map.get("params");
		 for(String key:params.keySet()) {
			 System.out.println(key+"---"+params.get(key));
		 }
	}

}
