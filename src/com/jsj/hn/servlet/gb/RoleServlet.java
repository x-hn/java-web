package com.jsj.hn.servlet.gb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsj.hn.DAO.IroleName;
import com.jsj.hn.DAO.IuserDAO;
import com.jsj.hn.DUBtils.DUBtilsString;
import com.jsj.hn.impel.BaseDAO;
import com.jsj.hn.impel.troleImpel;
import com.jsj.hn.impel.userImpel;
import com.jsj.hn.model.Trole;
import com.jsj.hn.model.User;
@WebServlet("/role")
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = -118660327338658366L;
	private IroleName roleDAO=new troleImpel();
	private BaseDAO baseDAO=new BaseDAO();
	private Trole role=new Trole();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type=request.getParameter("type");
		String rolename=request.getParameter("rolename");

		PrintWriter out=response.getWriter();
		if(type.equals("getAll")) {
			getAll(request, response);
		}else if(type.equals("edit")) {
			edit(request, response,rolename);
		}else if(type.equals("get")) {
			get(request, response);
		}else if(type.equals("addRole")) {
			addRole(request, response,rolename);
		}else if(type.equals("delete")) {
			deleteRole(request, response);
		}
	}
	//删除角色
	private void deleteRole(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id=request.getParameter("id");
		roleDAO.delete(Integer.parseInt(id));
		response.sendRedirect(request.getContextPath()+"/role?type=getAll");
	}
	//增加角色
	private void addRole(HttpServletRequest request, HttpServletResponse response, String rolename)
			throws ServletException, IOException {
		if(DUBtilsString.isNotNullandEmpety(rolename) ) {
			if(roleDAO.repeat(rolename)) {
				request.setAttribute("regInfo", "角色名已存在！！");
				RequestDispatcher rd=request.getRequestDispatcher("/admin/role/addRole.jsp");
				rd.forward(request, response);
			}else {
				role.setRoleName(rolename);
				roleDAO.add(role);
				response.sendRedirect(request.getContextPath()+"/role?type=getAll");
			}
		}
	}
	//通过id编辑角色信息
	private void edit(HttpServletRequest request, HttpServletResponse response, String rolename)
			throws IOException {
		String id=request.getParameter("id");
		role.setId(Integer.parseInt(id));
		role.setRoleName(rolename);
		roleDAO.update(role);
		response.sendRedirect(request.getContextPath()+"/role?type=getAll");
	}
	//通过获取此角色信息
	private void get(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		Trole r=roleDAO.get(Integer.parseInt(id));
		request.setAttribute("role", r);
		RequestDispatcher rd=request.getRequestDispatcher("admin/role/editRole.jsp");
		rd.forward(request, response);
	}
	//角色管理
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//当前页
		String p=request.getParameter("page");
		int page;
		try {
			page=Integer.valueOf(p);
		} catch (Exception e) {
			page=1;
		}
		//每页页数
		int pageSizes=3;
		//开始索引
		int beginIndex=(page-1)*pageSizes;
		
		List<Trole> roleList=roleDAO.getAll(page,pageSizes);
		
		String sql="SELECT COUNT(*) FROM trole where 1=1";
		Object[] obj=new Object[] {};
		//总记录数
		int totalRecords=baseDAO.count(sql,obj);
		//总页数
		int totalPages=totalRecords % pageSizes ==0?totalRecords / pageSizes:totalRecords / pageSizes +1;
		//结束索引
		int endIndex=beginIndex+pageSizes;
		if(endIndex>totalRecords) {
			endIndex=totalRecords;
		}
		request.setAttribute("page", page);
		request.setAttribute("totalRecords", totalRecords);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("beginIndex", beginIndex);
		request.setAttribute("endIndex", endIndex);
		request.setAttribute("pageSizes", pageSizes);
		request.setAttribute("roleList", roleList);
		RequestDispatcher rd=request.getRequestDispatcher("/admin/role/roles.jsp");
		rd.forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
