package com.hackathon.insightcollector;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @author pryadav
 */
@MultipartConfig
@WebServlet("/Process")
public class Process extends HttpServlet {

    public Process() {
        // TODO Auto-generated constructor stub
    }


    private boolean isMultipart;
    private String filePath;
    private int maxFileSize = 50 * 1024;
    private int maxMemSize = 4 * 1024;
    private File file ;

    public void init( ){
        // Get the file location where it would be stored.
        filePath = getServletContext().getInitParameter("file-upload");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {
        System.out.println("------------------- do post request came  ------------");
        // Check that we have a file upload request
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter( );
        System.out.println("isMultipart="+isMultipart);
        out.println("hello there..  ");


        try {
            // Parse the request to get file items.
            System.out.println("request==>content type:"+request.getContentType());
            System.out.println("request==>toString()"+request.toString());
            System.out.println("request==>part="+request.getPart("file"));
            Part filePart = request.getPart("file");
            String fileName = filePart.getSubmittedFileName();
            System.out.println("filename: -------->"+ fileName);
            for (Part part : request.getParts()) {
                part.write("C:\\upload\\" + fileName);
            }
            response.getWriter().print("The file uploaded sucessfully.");

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        throw new ServletException("GET method used with " +
                getClass( ).getName( )+": POST method required.");
    }

}
