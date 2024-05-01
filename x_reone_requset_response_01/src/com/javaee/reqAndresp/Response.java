package com.javaee.reqAndresp;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 21:10 周二
 * @description 响应字符数据
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/response")
public class Response extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //响应数据: 状态行 [协议版本 状态码] 默认设置 响应头[key:value]  响应空行 响应体 [ 字符串(json)|字节(图片 文件)| xxx.html ]
        //状态行问题
        //协议版本不需要设置,请求来的是啥返回就是啥!
        //状态不需要主动设置,会根据tomcat处理结果自动判断 200 500 404 | 如果要[[重定向]]需要额外设置
        resp.setStatus(200);

        //设置响应头
        resp.setHeader("key","value");

        //响应体 [字符 | 字节] 你想响应数据,需要获取字符或者字节输出流! 把数据写到流中即可! 就代表写到前端!
        //todo: 两个流二选一 (字符串resp.getWriter(); | 字节resp.getOutputStream(); | 字符串+字节  resp.getOutputStream();)
        //hello servlet!!
        PrintWriter writer = resp.getWriter();

        //todo:我们返回的字符串,其实浏览器也是生成一个html进行展示,只不过他忘了设置meta charset=utf-8标签了 所以乱码了!
        //text/html -> 返回的内容其实是html展示 [文件类型的规范: mimetype 前面是大类型/小类型]
        //charset=utf-8 html展示的时候,使用meta charset=utf-8
        resp.setContentType("text/html;charset=utf-8");
        writer.print("你好,中国!!!");
//        writer.print("<html><head><meta charset='utf-8'> <title>xxx</title></head><body>hello servlet!!<br>你好,蛇窝类特!!</body>");

        //ServletOutputStream outputStream = resp.getOutputStream();



        //1. 使用文件输入流读取字节文件
        //ServletContext |  getRealPath(/)
        ServletContext servletContext = getServletContext();
        String realPath = servletContext.getRealPath("/imgs/ynh.jpg");
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //2. 保密
        //  content-disposition 文件定位
        //  attachment 附件 下载
        resp.setHeader("content-disposition","attachment;filename=ynh.jpg");

        //3. 将字节数据写到响应的字节输出流即可
        ServletOutputStream outputStream = resp.getOutputStream();

        int len = -1;
        byte[] buffer = new byte[8*1024];
        while( (len = fileInputStream.read(buffer)) != -1 ){
            outputStream.write(buffer,0,len);
        }

        if (fileInputStream != null) {
            fileInputStream.close();
        }
        if (outputStream != null){
            outputStream.close();
        }

    }

}
