package org.infosec.ismp.agent.winsensor.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.infosec.ismp.agent.winsensor.WinsensorConstant;
import org.infosec.ismp.agent.winsensor.exception.ContentLengthOverLimitException;

/**
 * @author Rocky
 * @version create time：Oct 26, 2010 10:24:28 AM
 * 
 */
public class FileUploadUtil {

	@SuppressWarnings("unchecked")
	public List<FileItem> parseUploadFile(HttpServletRequest req) {
		List<FileItem> value = new ArrayList<FileItem>();
		
		if (ServletFileUpload.isMultipartContent(req)) {
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
			try {
				value = servletFileUpload.parseRequest(req);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
		}
		
		return value;
	}
	
	public InputStream getCompleteInputStream(HttpServletRequest req) throws IOException {
		int contentLength = req.getContentLength();
		InputStream inputStream = null;
		InputStream completeInputStream = null;
		
		if (contentLength > WinsensorConstant.UPLOAD_FILE_SIZE_LIMIT ) {
			throw new ContentLengthOverLimitException("Request Content length is over limit, size: " + contentLength 
					+ " limit size is: " + WinsensorConstant.UPLOAD_FILE_SIZE_LIMIT);
		} 
		
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(WinsensorConstant.UPLOAD_FILE_BUFFER_SIZE);
		byte[] buffer = new byte[WinsensorConstant.UPLOAD_FILE_BUFFER_SIZE];
		int bufferRead;
		
		try {
			inputStream = req.getInputStream();
			
			while((bufferRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bufferRead);
			}
			
			completeInputStream = new ByteArrayInputStream(outputStream.toByteArray());
		} catch (IOException e) {
			throw new IOException(e.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					throw new IOException(e.getMessage());
				}
			}
			
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					throw new IOException(e.getMessage());
				}
			} 
		}
		
		return completeInputStream;
	}
}
