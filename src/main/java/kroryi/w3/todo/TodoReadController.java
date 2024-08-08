package kroryi.w3.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kroryi.w3.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("/todo/read 실행");

        try{
            Long tno = Long.parseLong(request.getParameter("tno"));

            TodoDTO dto = todoService.get(tno);
            log.info("tno 번호 : ", tno.toString());

            request.setAttribute("dto", dto);
            request.getRequestDispatcher("/todo/read.jsp").forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
            throw new ServletException("읽기 에러 발생");
        }
    }
}
