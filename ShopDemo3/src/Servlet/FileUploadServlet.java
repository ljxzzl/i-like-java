package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import DAO.JDBC.DBUtil;


/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String[] arr = new String[3];
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
	        //得到上传文件的保存目录。 将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全                                                                              
	        String realPath = this.getServletContext().getRealPath("/upload");//  /WEB-INF/files                                                
	        System.out.println("文件存放位置:"+realPath);                                                                                             
	        //设置临时目录。 上传文件大于缓冲区则先放于临时目录中                                                                                                        
	        String tempPath = "E:\\tempPath";                                                                                                   
	        System.out.println("临时文件存放位置:"+tempPath);                                                                                           
	                                                                                                                                            
	                                                                                                                                            
	        //判断存放上传文件的目录是否存在（不存在则创建）                                                                                                           
	        File f = new File(realPath);                                                                                                        
	            if(!f.exists()&&!f.isDirectory()){                                                                                              
	                System.out.println("目录或文件不存在! 创建目标目录。");                                                                                    
	                f.mkdir();                                                                                                                  
	            }                                                                                                                               
	        //判断临时目录是否存在（不存在则创建）                                                                                                                
	        File f1 = new File(tempPath);                                                                                                       
	            if(!f1.isDirectory()){                                                                                                          
	                System.out.println("临时文件目录不存在! 创建临时文件目录");                                                                                  
	                f1.mkdir();                                                                                                                 
	            }                                                                                                                               
	                                                                                                                                            
	       /**                                                                                                                                  
	        * 使用Apache文件上传组件处理文件上传步骤：                                                                                                           
	        *                                                                                                                                   
	        * */                                                                                                                                
	        //1、设置环境:创建一个DiskFileItemFactory工厂                                                                                                  
	        DiskFileItemFactory factory = new DiskFileItemFactory();                                                                            
	                                                                                                                                            
	            //设置上传文件的临时目录                                                                                                                   
	        factory.setRepository(f1);                                                                                                          
	                                                                                                                                            
	        //2、核心操作类:创建一个文件上传解析器。                                                                                                              
	        ServletFileUpload upload = new ServletFileUpload(factory);                                                                          
	            //解决上传"文件名"的中文乱码                                                                                                                
	        upload.setHeaderEncoding("UTF-8");                                                                                                  
	                                                                                                                                            
	        //3、判断enctype:判断提交上来的数据是否是上传表单的数据                                                                                                   
	        if(!ServletFileUpload.isMultipartContent(request)){                                                                                     
	            System.out.println("不是上传文件，终止");                                                                                                
	             //按照传统方式获取数据                                                                                                                   
	            return;                                                                                                                         
	        }                                                                                                                                   
	                                                                                                                                            
	        //==获取输入项==                                                                                                                         
	              //限制单个上传文件大小(5M)                                                                                                              
	              upload.setFileSizeMax(1024*1024*4);                                                                                           
	              //限制总上传文件大小(10M)                                                                                                              
	              upload.setSizeMax(1024*1024*6);                                                                                               
	                                                                                                                                            
	        //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项                                               
	            List<FileItem> items =upload.parseRequest(new ServletRequestContext(request));   
	            
	            int i=0;
	            for(FileItem item:items){                                                                                                       
	                //如果fileitem中封装的是普通输入项的数据（输出名、值）                                                                                            
	                if(item.isFormField()){                                                                                                     
	                    String filedName = item.getFieldName();//普通输入项数据的名                                                                      
	                    //解决普通输入项的数据的中文乱码问题                                                                                                     
	                    String filedValue = item.getString("UTF-8");//普通输入项的值                                                                   
	                    System.out.println("普通字段:"+filedName+"=="+filedValue); 
	                    arr[i]=filedValue;
	                    i++;
	                    
	                }
	                
	                
	                else{                                                                                                                      
	                    //如果fileitem中封装的是上传文件，得到上传的文件名称，                                                                                        
	                    String fileName = item.getName();//上传文件的名                                                                               
	                    //多个文件上传输入框有空 的 异常处理                                                                                                    
	                    if(fileName==null||"".equals(fileName.trim())){  //去空格是否为空                                                              
	                        continue;// 为空，跳过当次循环，  第一个没输入则跳过可以继续输入第二个                                                                          
	                    }                                                                                                                       
	                                                                                                                                            
	                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt                                         
	                    //处理上传文件的文件名的路径，截取字符串只保留文件名部分。//截取留最后一个"\"之后，+1截取向右移一位（"\a.txt"-->"a.txt"）                                              
	                    fileName = fileName.substring(fileName.lastIndexOf("\\")+1);                                                            
	                    //拼接上传路径。存放路径+上传的文件名                                                                                                    
	                    String filePath = realPath+"\\"+fileName;                                                                               
	                    //构建输入输出流                                                                                                               
	                    InputStream in = item.getInputStream(); //获取item中的上传文件的输入流                                                              
	                    OutputStream out = new FileOutputStream(filePath); //创建一个文件输出流                                                          
	                                                                                                                                            
	                    //创建一个缓冲区                                                                                                               
	                    byte b[] = new byte[1024];                                                                                              
	                    //判断输入流中的数据是否已经读完的标识                                                                                                    
	                    int len = -1;                                                                                                           
	                     //循环将输入流读入到缓冲区当中，(len=in.read(buffer))！=-1就表示in里面还有数据                                                                  
	                    while((len=in.read(b))!=-1){  //没数据了返回-1                                                                                
	                    //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath+"\\"+filename)当中                                                        
	                        out.write(b, 0, len);                                                                                               
	                    }                                                                                                                       
	                    //关闭流                                                                                                                   
	                    out.close();                                                                                                            
	                    in.close();                                                                                                             
	                    //删除临时文件                                                                                                                
	                    try {                                                                                                                   
	                        Thread.sleep(3000);                                                                                                 
	                    } catch (InterruptedException e) {                                                                                      
	                        e.printStackTrace();                                                                                                
	                    }                                                                                                                       
	                    item.delete();//删除处理文件上传时生成的临时文件                                                                                        
	                    System.out.println("文件上传成功");                                                                                           
	                }                                                                                                                           
	            }                                                                                                                               
	        } catch (FileUploadException e) {                                                                                                   
	            //e.printStackTrace();                                                                                                          
	            throw new RuntimeException("服务器繁忙，文件上传失败");                                                                                     
	        }  

	DBUtil db=new DBUtil();
	db.connect();
	try {
		db.insert(arr[0], arr[1], arr[2]);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		request.getRequestDispatcher("addGoods.jsp").forward(request, response);
		
		
		
		
		
		
		
	    }                                                                                                                                       
	      
	
	}


