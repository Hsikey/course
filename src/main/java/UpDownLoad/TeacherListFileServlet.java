package UpDownLoad;

import bean.Class;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/TeacherListFileServlet.do")
public class TeacherListFileServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cname=null;
        HttpSession session=request.getSession();//获取session
        Class clss=(Class) session.getAttribute("ClsMess");
        //获取上传文件的目录
        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/"+clss.getName());
        //存储要下载的文件名
        Map<String,String> fileNameMap = new HashMap<String,String>();
        //递归遍历filepath目录下的所有文件和目录，将文件的文件名存储到map集合中
        listfile(new File(uploadFilePath),fileNameMap);//File既可以代表一个文件也可以代表一个目录
        //将Map集合发送到listfile.jsp页面进行显示
        request.setAttribute("fileNameMap", fileNameMap);
        request.getRequestDispatcher("/TeacherListAllFile.jsp").forward(request, response);
    }


    public void listfile(File file,Map<String,String> map){

        if(!file.exists()){
           file.mkdir();
        }
        //如果file代表的不是一个文件，而是一个目录
        if(!file.isFile()){
            //列出该目录下的所有文件和目录
            File files[] = file.listFiles();
            //遍历files[]数组
            for(File f : files){
                //递归
                listfile(f,map);
            }
        }else{

            String realName = file.getName().substring(file.getName().indexOf("_")+1);
            //file.getName()得到的是文件的原始名称，这个名称是唯一的，因此可以作为key，realName是处理过后的名称，有可能会重复
            map.put(file.getName(), realName);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}