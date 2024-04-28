package com.java.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;


/**
 * @classname HttpResponseServlet
 * @description
 * @Auther d3Lap1ace
 * @Time 2024/04/27  15:15:15
 * @Version 1.0
 * From the Laplace Demon
 */
@WebServlet("/response1")
public class HttpResponseServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/imgs/hlx.jpg");
        FileInputStream fileInputStream = new FileInputStream(realPath);


//        resp.setHeader("content-disposition","attachment;filename=hlx.jpg");
        ServletOutputStream outputStream = resp.getOutputStream();

        int len = -1;
        byte[] data = new byte[8 * 1024];
        while ((len = fileInputStream.read(data))!= -1){
            outputStream.write(data,0,len);
        }


        fileInputStream.close();
        outputStream.close();

    }
}