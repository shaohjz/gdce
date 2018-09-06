package com.isscollege.gdce.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import com.isscollege.gdce.domain.User;
import com.isscollege.gdce.domain.Company;
import com.isscollege.gdce.model.IRegisterModel;
import com.isscollege.gdce.model.impl.RegisterModelImpl;


@WebServlet("/register")
public class RegisterController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private IRegisterModel model;
	private static final String ADDMANAGER = "ADDMANAGER";
	private static final String QUERYMANAGER = "QUERYMANAGER";
	private static final String DELETEMANAGER = "DELETEMANAGER";
	
	private static final String ADDUSER ="regist";
	//资质信息管理，常量定义
	private static final String QUALIFICATION ="qualification";
	private static final String UPDATE_COMPANY ="update_company";
	private static final String FILE_PATH = "/imgs/openLicense/";

	public RegisterController()
	{
		model = new RegisterModelImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doPost(request, response);
	}   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String usestate = request.getParameter("forward");
		System.out.println("forward ：" + usestate);//////////
		if (ADDUSER.equalsIgnoreCase(usestate))
		{
			doRegist(request,response);
		}
		//企业资质信息查看-shaohjz
		else if (QUALIFICATION.equalsIgnoreCase(usestate))
		{
			try {
				doQualification(request,response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//企业资质信息修改-shaohjz
		else if (UPDATE_COMPANY.equalsIgnoreCase(usestate))
		{
			System.out.println("修改操作");
			try {
				doupdate_Company(request,response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else
		{
			doManager(request,response);
		}
				
	}
	
	//用户注册
	protected void doRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String resultMessage = "";
		User user = new User();
		Company company = new Company();
		
		String name = StringUtils.defaultString(request.getParameter("loginname"), "未填 ");
		String password = StringUtils.defaultString(request.getParameter("loginpass"), "未填 ");
		String password1 = StringUtils.defaultString(request.getParameter("reloginpass"), "未填 ");
		String permission = StringUtils.defaultString(request.getParameter("permission"), "未填 ");
		String companyId = StringUtils.defaultString(request.getParameter("companyId"), "未填 ");
		
		String companyName = StringUtils.defaultString(request.getParameter("companyName"), "未填 ");
		String legalPerson = StringUtils.defaultString(request.getParameter("legalPerson"), "未填 ");
		String phoneNumber = StringUtils.defaultString(request.getParameter("phoneNumber"), "未填 ");
		String bankAccount = StringUtils.defaultString(request.getParameter("bankAccount"), "未填 ");
		String openLicenseId = StringUtils.defaultString(request.getParameter("openLicenseId"), "未填 ");
		String openLicensePath = StringUtils.defaultString(request.getParameter("openLicensePath"), "未填 ");
		String taxRegisterId = StringUtils.defaultString(request.getParameter("taxRegisterId"), "未填 ");
		
		String verifyCode = StringUtils.defaultString(request.getParameter("verifyCode"));;
	
		System.out.println(" 姓名： " + name + " 密码：" + password +"  " + password1 + " CompanyId：" + companyId
				+ " permission：" + permission+ " verifyCode：" + verifyCode
				);//////////////
		
		//validateRegist(request,response, request.getSession()) ;////////
		Map<String,String> errors = validateRegist(request, request.getSession());
		Map<String,String> form = new HashMap<String,String>();
		if(errors.size() > 0) {
			form.put("loginname", name);
			form.put("loginpass", password);
			form.put("reloginpass", password1);
			form.put("companyName",	companyName);
			form.put("companyId", companyId);
			form.put("legalPerson", legalPerson);
			form.put("phoneNumber", phoneNumber);
			form.put("bankAccount", bankAccount);
			form.put("openLicenseId", openLicenseId);
			form.put("taxRegisterId", taxRegisterId);
			request.setAttribute("form", form);
			request.setAttribute("errors", errors);
			request.getRequestDispatcher("/jsp/user/register.jsp").forward(request, response);
		}
		else
		{
			
			user.setName(name);
			user.setPassword(password);
			user.setPermission(permission);
			user.setCompanyId(companyId);
			System.out.println("name ：" + user.getName() );//////////
			
			company.setCompanyId(companyId);
			company.setCompanyName(companyName);
			company.setLegalPerson(legalPerson);
			company.setPhoneNumber(phoneNumber);
			company.setBankAccount(bankAccount);
			company.setOpenLicenseId(openLicenseId);
			company.setOpenLicensePath(openLicensePath);
			company.setTaxRegisterId(taxRegisterId);
			
			model.addUser(user);
			model.addCompany(company);
		
			//跳转
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print("<script language='javascript'>alert('恭喜您，注册成功,请登录！')</script>");
			response.setHeader("refresh", "1;"+request.getContextPath() + "/jsp/user/login.jsp");
		}
	}
	
	//管理员方法
	protected void doManager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String forward = request.getParameter("forward");

		if (StringUtils.equals(forward, ADDMANAGER))// 增加管理员
		{
			String msg = "";
			String name = (String) request.getParameter("name");
			String password = (String) request.getParameter("password");
			if (StringUtils.isEmpty(name) || StringUtils.isEmpty(password))
			{
				msg += "创建失败";
				request.setAttribute("msg", msg);
				request.getRequestDispatcher("/register?forward=QUERYMANAGER").forward(request, response);
				return;
			}
			String[] permissions = request.getParameterValues("permission");
			String permission = "";
			if (permissions != null && permissions.length > 0)
			{
				for (String p : permissions)
					permission += p + ',';
				permission = permission.substring(0, permission.length() - 1);
			}
			User manager = new User();
			manager.setName(name);
			manager.setPassword(password);
			manager.setPermission(permission);

			try
			{
				boolean result = model.addManager(manager);
				if (result)
					msg += "成功创建";
				else
					msg += "创建失败";

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/register?forward=QUERYMANAGER").forward(request, response);
			return;
		}

		if (StringUtils.equals(forward, QUERYMANAGER))// 查询管理员
		{

			List<User> users = null;
			try
			{
				users = model.queryManager();
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("users", users);
			request.getRequestDispatcher("/jsp/user/superManager.jsp").forward(request, response);
			return;
		}

		if (StringUtils.equals(forward, DELETEMANAGER))// 删除管理员
		{
			String id = request.getParameter("id");
			String msg = "";
			try
			{
				boolean result = model.deleteManager(id);
				if (result)
					msg += "成功删除";
				else
					msg += "删除失败";

			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("/register?forward=QUERYMANAGER").forward(request, response);
			return;
		}
	}

	
	
	
	
	/*
	 * 注册校验
	 * 对表单的字段进行逐个校验，如果有错误，使用当前字段名称为key，错误信息为value，保存到map中
	 * 返回map
	 */
	private Map<String,String>  validateRegist(HttpServletRequest req, HttpSession session) throws ServletException, IOException 
	{
		Map<String,String> errors = new HashMap<String,String>();
		/*
		 * 1. 校验登录名
		 */
		String loginname =  StringUtils.defaultString(req.getParameter("loginname"));
		if(loginname == null || loginname.trim().isEmpty()) 
		{
			errors.put("loginname", "户名不能为空！");
		} else if(loginname.length() < 3 || loginname.length() > 20) 
		{
			errors.put("loginname", "用户名长度必须在3~20之间！");
		} else if(!model.ajaxValidateLoginname(loginname)) 
		{
			errors.put("loginname", "用户名已被注册！");
		}
		
	
		/*
		 * 2. 校验登录密码
		 */
		String loginpass = StringUtils.defaultString(req.getParameter("loginpass"));
		if(loginpass == null || loginpass.trim().isEmpty()) 
		{
			errors.put("loginpass", "密码不能为空！");
		} else if(loginpass.length() < 3 || loginpass.length() > 20)
		{
			errors.put("loginpass", "密码长度必须在3~20之间！");
		}
		
		/*
		 * 3. 确认密码校验
		 */
		String reloginpass = StringUtils.defaultString(req.getParameter("reloginpass"));
		if(reloginpass == null || reloginpass.trim().isEmpty()) 
		{
			errors.put("reloginpass", "确认密码不能为空！");
		} else if(!reloginpass.equals(loginpass))
		{
			errors.put("reloginpass", "两次输入不一致！");
		}
	
		/*
		 * 4. 校验企业机构代码
		*/
		String companyId = StringUtils.defaultString(req.getParameter("companyId"));
		if(companyId == null || companyId.trim().isEmpty())
		{
			errors.put("companyId", "企业机构代码不能为空！");
		} else if(companyId.length()!=18) {
			errors.put("companyId", "企业机构代码格式错误！");
		} else if(!model.ajaxValidateCompanyId(companyId)) 
		{
			errors.put("companyId", "企业机构代码已被注册！");
		}
		
		/*
		 * 5. 校验企业名称
		*/
		String companyName = StringUtils.defaultString(req.getParameter("companyName"));
		if(companyName == null || companyName.trim().isEmpty()) {
			errors.put("companyName", "企业机构代码不能为空！");
		} else if(companyName.length() < 3 || companyName.length() > 20) {
			errors.put("companyName", "企业名称长度必须在3 ~ 20之间！");
		} 
		
		/*
		 * 6. 校验法人
		*/
		String legalPerson = StringUtils.defaultString(req.getParameter("legalPerson"));
		if(legalPerson == null || legalPerson.trim().isEmpty()) 
		{
			errors.put("legalPerson", "企业机构代码不能为空！");
		} else if(legalPerson.length() < 2 || legalPerson.length() > 10) 
		{
			errors.put("legalPerson", "法人长度必须在2 ~ 10之间！");
		} 
		
		/*
		 * 7. 校验联系方式
		*/
		String phoneNumber = StringUtils.defaultString(req.getParameter("phoneNumber"));
		if((phoneNumber != null)&&(!phoneNumber.trim().isEmpty())&&(phoneNumber.length()!=11)) 
		{
			errors.put("phoneNumber", "联系方式必须为11位手机号！");
		} 
		
		/*
		 * 8. 校验银行账户
		*/
		String bankAccount = StringUtils.defaultString(req.getParameter("bankAccount"));
		if((bankAccount != null)&&(!bankAccount.trim().isEmpty())&&((bankAccount.length()<18)||(bankAccount.length()>21))) 
		{
			errors.put("bankAccount", "银行账号长度必须在18 ~ 21之间！");
		} 
		
		/* 
		 * 9. 校验营业执照
		*/
		String openLicenseId = StringUtils.defaultString(req.getParameter("openLicenseId"));
		if((openLicenseId != null)&&(!openLicenseId.trim().isEmpty())&&(openLicenseId.length() !=13)) 
		{
			errors.put("openLicenseId", "营业执照长度必须为13位！");
		} 
		
		/*
		 * 10. 校验税务登记号
		*/
		String taxRegisterId = StringUtils.defaultString(req.getParameter("taxRegisterId"));
		if((taxRegisterId != null)&&(!taxRegisterId.trim().isEmpty())&&((taxRegisterId.length()<15)||(taxRegisterId.length()>20)))
		{
			errors.put("taxRegisterId", "税务登记号长度长度必须在15 ~ 20之间！");
		} 
		
		/*
		 * 11. 验证码校验
		 */
		String verifyCode = StringUtils.defaultString(req.getParameter("verifyCode"));
		String vcode = (String) session.getAttribute("vCode");
		if(verifyCode == null || verifyCode.trim().isEmpty()) 
		{
			errors.put("verifyCode", "验证码不能为空！");
		} else if(!verifyCode.equalsIgnoreCase(vcode)) 
		{
			errors.put("verifyCode", "验证码错误！");
		}
		return errors;
		
	}
	
	
	//上传文件的命名方法 文件命名要求有一个时间戳，此为得到yyyyMMddHHmmss时间的方法。
	protected static String getDate()
	{
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
		long now = System.currentTimeMillis();
		return date.format(now);
	}

	protected void doQualification(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
	{
		// 项目运行后从session中获得user对象的CompanyId，开发过程中直接设置测试的CompanyId为
		HttpSession session = request.getSession();
		User user = session.getAttribute("currentUser") == null ? new User()
				: (User) session.getAttribute("currentUser");
		String CompanyId = user.getCompanyId();
		Company company = model.queryCompanyByCompanyID(CompanyId);
		session.setAttribute("company", company);
		request.getRequestDispatcher("/jsp/user/com_qualification.jsp").forward(request, response);
	}

	
	
	// 胡济洲story 企业资质信息修改
	protected void doupdate_Company(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException
	{
		HttpSession session = request.getSession();
		Company company = (Company) session.getAttribute("company");
		// 文件上传部分
		try
		{
			// 得到上传文件的保存目录。 将上传的文件存放于/imgs/open_liscense/目录下
			String realPath = this.getServletContext().getRealPath(FILE_PATH);
			// 设置临时目录。 上传文件大于缓冲区则先放于临时目录中
			// String tempPath = TEMP_DIR;

			// 判断存放上传文件的目录是否存在（不存在则创建）
			File f = new File(realPath);
			if (!f.exists() && !f.isDirectory())
			{
				System.out.println("目录或文件不存在! 创建目标目录。");
				f.mkdir();
			}
			// 判断临时目录是否存在（不存在则创建）
			// File f1 = new File(tempPath);
			// if(!f1.isDirectory()){
			// System.out.println("临时文件目录不存在! 创建临时文件目录");
			// f1.mkdir();
			// }

			/**
			 * 使用Apache文件上传组件处理文件上传步骤：
			 * 
			 */
			// 1、设置环境:创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();

			// 设置上传文件的临时目录
			// factory.setRepository(f1);

			// 2、核心操作类:创建一个文件上传解析器。
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传"文件名"的中文乱码
			upload.setHeaderEncoding("UTF-8");

			// 3、判断enctype:判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request))
			{
				System.out.println("不是上传文件，终止");
				// 按照传统方式获取数据
				return;
			}

			// ==获取输入项==
			// //限制单个上传文件大小(5M)
			// upload.setFileSizeMax(1024*1024*4);
			// //限制总上传文件大小(10M)
			// upload.setSizeMax(1024*1024*6);

			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> items = upload.parseRequest(request);
			// 把获取到的表单信息存储在list_company中
			List<String> list_company = new ArrayList<>();

			for (FileItem item : items)
			{
				// 如果fileitem中封装的是普通输入项的数据（输出名、值）
				if (item.isFormField())
				{
					// String filedName = item.getFieldName();//普通输入项数据的名
					// 解决普通输入项的数据的中文乱码问题
					String filedValue = item.getString("UTF-8");// 普通输入项的值

					list_company.add(filedValue);
				} else
				{
					// 如果fileitem中封装的是上传文件，得到上传的文件名称，
					// String fileName = item.getName();//上传文件的名
					// 处理上传文件的文件名的路径，截取字符串只保留文件名部分。//截取留最后一个"\"之后，+1截取向右移一位（"\a.txt"-->"a.txt"）
					// public int indexOf(String
					// str)返回指定子字符串在此字符串中第一次出现处的索引。返回的整数是
					// substring
					// 返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾。
					// suffix为后缀名，初始值设置为上传的文件名。
					String suffix = item.getContentType();

					// 获取文件名
					String fileName = item.getName();
					// application/octet-stream是二进制流,不知道下载文件类型，即用户未上床文件时的文件类型
					if (suffix.equals("application/octet-stream"))
					{
					// 用户未上传文件，不执行操作
					} else
					//上传文件，读写操作
					{
						fileName = company.getCompanyId() + getDate() + "."
								+ suffix.substring(suffix.lastIndexOf("/") + 1);
						// 处理上传文件的文件名的路径，截取字符串只保留文件名部分。//截取留最后一个"\"之后，+1截取向右移一位（"\a.txt"-->"a.txt"）
						// 拼接上传路径。存放路径+上传的文件名
						String filePath = realPath + "/"
								  + fileName;
						// 构建输入输出流
						InputStream in = item.getInputStream(); // 获取item中的上传文件的输入流
						System.out.println("filePath:" + filePath);
						OutputStream out = new FileOutputStream(filePath); // 创建一个文件输出流

						// 设置相对路径，按照格式要求，存在数据库中

						// 将相对路径存入company对象
						String relative_path = FILE_PATH + fileName;
						company.setOpenLicensePath(relative_path);

						// 创建一个缓冲区
						byte b[] = new byte[1024];
						// 判断输入流中的数据是否已经读完的标识
						int len = -1;
						// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))！=-1就表示in里面还有数据
						while ((len = in.read(b)) != -1)
						{ // 没数据了返回-1
							// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath+"/"+filename)当中
							out.write(b, 0, len);
						}
						// 关闭流
						out.close();
						in.close(); 
						// 删除临时文件
						try
						{
							Thread.sleep(3000);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
						item.delete();// 删除处理文件上传时生成的临时文件
						System.out.println("文件上传成功");

					}

					// 如果用户没有上传文件，不进行文件操作
					// 将list中的数据存入company对象
					request.setCharacterEncoding("utf-8");
					response.setContentType("text/html;charset=utf-8");

					// 将list_company中的数据，存进company对象中
					company.setCompanyName(list_company.get(1));
					company.setLegalPerson(list_company.get(2));
					company.setPhoneNumber(list_company.get(3));
					company.setBankAccount(list_company.get(4));
					company.setOpenLicenseId(list_company.get(5));
					company.setTaxRegisterId(list_company.get(6));
					company.setReviewState(0);
					try
					{
						// 更新数据库中的数据
						model.updateCompany(company);
					} catch (SQLException e)
					{
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e)
		{
			throw new RuntimeException("服务器繁忙，文件上传失败");
		}
		// 修改完成，执行查询操作，显示查到的信息
		doQualification(request, response);

	}
	
}
