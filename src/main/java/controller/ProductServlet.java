package controller;

import model.Product;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                search(request, response);
                break;
            case "search-by-price":
                searchByPrice(request, response);
                break;
            default:
                showList(request, response);
        }
    }

    private void searchByPrice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int begin = Integer.parseInt(request.getParameter("begin"));
        int end = Integer.parseInt(request.getParameter("end"));
        List<Product> products = productService.findByPrice(begin, end);
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/search-by-price.jsp").forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> products = productService.findByName(name);
        request.setAttribute("products", products);
        request.getRequestDispatcher("product/search.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("products", products);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
