package kroryi.w3.login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kroryi.w3.member.MemberService;
import kroryi.w3.member.dto.MemberDTO;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "Login", urlPatterns = "/login")
public class LoginController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("로그인 페이지 열기");
        request.getRequestDispatcher("/login/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        // DB에서 조회한 자료
        try{
            MemberDTO memberDTO = MemberService.INSTANCE.login(id, password);
            HttpSession session = request.getSession();
            if(id.equals(memberDTO.getMid()) && password.equals(memberDTO.getMpw())){
                session.setAttribute("loginInfo", memberDTO);
                response.sendRedirect("/todo/list");
            }else {
                throw new ServletException("아이디, 비밀번호를 확인 해주세요");
            }

        }catch(Exception e){
            e.printStackTrace();
            response.sendRedirect("/login?result=error");
        }
    }
}
