package ra.demo_session11.controller;

import ra.demo_session11.model.Customer;
import ra.demo_session11.model.CustomerData;
import ra.demo_session11.service.impl.CustomerServiceImpl;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "CustomerController", value = "/customer")
public class CustomerController extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String action = request.getParameter("action");
        if(action==null)
            action="";

        switch (action){
            case "add":
                String fullName = request.getParameter("fullName");
                Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                Date birthday;
                try {
                    birthday = sf.parse(request.getParameter("birthday"));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                String address = request.getParameter("address");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");
                Boolean status = Boolean.parseBoolean(request.getParameter("status"));

                Customer c = new Customer(0, fullName,gender,birthday,address,phone,email,status);

                List<Customer> list = CustomerData.listCus;
                //xu ly id tu tang:
                c.setId(list.isEmpty()?1:list.get(list.size()-1).getId()+1);
                boolean blSave = new CustomerServiceImpl().save(c);
                if(blSave){
                    request.getRequestDispatcher("index.jsp?action=''").forward(request,response);
                }else{
                    request.setAttribute("error","Insert failed!");
                    request.getRequestDispatcher("views/customer/insertCustomer.jsp").forward(request,response);
                }
                break;
            case "edit":
                String cusIdStr = request.getParameter("cusId");
                if(cusIdStr!=null){
                    Integer cusId = Integer.parseInt(cusIdStr);
                    Customer customer = new CustomerServiceImpl().findById(cusId);
                    request.setAttribute("c",customer);
                    request.getRequestDispatcher("/views/customer/updateCustomer.jsp").forward(request,response);
                }else{
                    Integer id = Integer.parseInt(request.getParameter("id"));
                    String fullName1 = request.getParameter("fullName");
                    Boolean gender1 = Boolean.parseBoolean(request.getParameter("gender"));
                    SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
                    Date birthday1;
                    try {
                        birthday1 = sf1.parse(request.getParameter("birthday"));
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                    String address1 = request.getParameter("address");
                    String email1 = request.getParameter("email");
                    String phone1 = request.getParameter("phone");
                    Boolean status1 = Boolean.parseBoolean(request.getParameter("status"));

                    Customer c1 = new Customer(id, fullName1,gender1,birthday1,address1,phone1,email1,status1);


                    boolean blEdit = new CustomerServiceImpl().update(c1);
                    if(blEdit){
                        request.getRequestDispatcher("index.jsp?action=''").forward(request,response);
                    }else{
                        request.setAttribute("error","Update failed!");
                        request.setAttribute("c",c1);
                        request.getRequestDispatcher("/views/customer/updateCustomer.jsp").forward(request,response);
                    }
                }
                break;
            case "detail":
                break;
            case "delete":
                Integer cusId = Integer.parseInt(request.getParameter("cusId"));
                boolean blDelete = new CustomerServiceImpl().delete(cusId);
                if(blDelete){
                    request.setAttribute("success","delete successfully!");
                }else{
                    request.setAttribute("error","delete failed!");
                }

                List<Customer> listCus1 = new CustomerServiceImpl().findAll();
                request.setAttribute("list",listCus1);
                request.getRequestDispatcher("views/customer/listCustomer.jsp").forward(request,response);
                break;
            case "search":
                String name = request.getParameter("fullName");
                if(name==null || name.isEmpty()){
                    request.getRequestDispatcher("index.jsp?action=''").forward(request,response);
                }else{
                    List<Customer> listCus = new CustomerServiceImpl().findByName(name);
                    request.setAttribute("list",listCus);
                    request.getRequestDispatcher("views/customer/listCustomer.jsp").forward(request,response);
                }
                break;
            default:
                List<Customer> listCus = new CustomerServiceImpl().findAll();
                request.setAttribute("list",listCus);
                request.getRequestDispatcher("views/customer/listCustomer.jsp").forward(request,response);
                break;
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        doGet(request,response);
    }

    public void destroy() {
    }
}