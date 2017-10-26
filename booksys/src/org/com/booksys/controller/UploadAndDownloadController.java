/**
 * 
 */
package org.com.booksys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.com.common.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@RequestMapping("/file")
public class UploadAndDownloadController {
	@Autowired
	CommonsMultipartResolver multipartResolver;

	@RequestMapping("/upload")
	public String upload2(HttpServletRequest request, HttpServletResponse response)
			throws IllegalStateException, IOException {
		// 创建一个通用的多部分解析器
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						System.out.println(myFileName);
						// 重命名上传后的文件名
						String fileName = file.getOriginalFilename();
						// 定义上传路径
						File localFile = new File(request.getSession().getServletContext().getRealPath("/upload") + "\\" + fileName);
						System.out.println(request.getSession().getServletContext().getRealPath("/upload") + "\\" + fileName);
						file.transferTo(localFile);
					}
				}
			}

		}
		return "redirect:/file/toDownload";
	}

	@RequestMapping("/toUpload")
	public String toUpload() {

		return "/uploadFile";
	}

	@RequestMapping("/toDownload")
	public String toDownload(HttpServletRequest request) {
		List<String> files = FileUtil.getAllFiles(request.getSession().getServletContext().getRealPath("/upload"));
		request.setAttribute("files", files);
		return "/download";
	}
	
	@RequestMapping("/doDownload")
	public void download(String file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		FileUtil.downloadFile(file, request, response);
	}
}
