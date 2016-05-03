package com.shuly.web;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by shuly on 16-4-23.
 */
@Controller
@RequestMapping("/down")
public class downerController{
    private String getFileName(String filePath,HttpServletRequest request)
            throws UnsupportedEncodingException {
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        String Agent = request.getHeader("User-Agent");
        if (null != Agent) {
            Agent = Agent.toLowerCase();
            if (Agent.indexOf("firefox") != -1) {
                fileName = new String(fileName.getBytes(), "iso8859-1");
            } else if (Agent.indexOf("msie") != -1) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            }
        }
        return fileName;
    }

    @ResponseBody
    @RequestMapping(value = "download")
    public ResponseEntity<byte[]> download(
            HttpServletRequest request , HttpSession session,
            @RequestParam(value = "path") String path,
            @RequestParam(value = "type", required = false, defaultValue = "application/vnd.ms-excel") String type)
            throws IOException {
        // 确定各个成员变量的值
        String fileName = getFileName(path,request);
        HttpHeaders headers = new HttpHeaders();
        byte[] body = null;
        HttpStatus httpState = HttpStatus.NOT_FOUND;
        File file = new File(path);
        if (file.exists() && file.isFile()) {

            InputStream is = new FileInputStream(file);
            body = new byte[is.available()];
            is.read(body);
            is.close();
            headers.add("Content-Type", type);
            headers.add("Content-Length", "" + body.length);
            headers.add("Content-Disposition", "attachment;filename="
                    + fileName);
            httpState = HttpStatus.OK;

        }


        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers,
                httpState);

        return entity;
    }
}
