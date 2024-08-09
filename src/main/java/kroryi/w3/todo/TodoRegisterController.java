package kroryi.w3.todo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kroryi.w3.todo.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Log4j2
@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Todo doGet Register 실행");

        HttpSession session = request.getSession();

        if(session.isNew()){
            log.info("세션을 발급 받아야 합니다.");
            response.sendRedirect("/login");
            return;
        }
        request.getRequestDispatcher("/todo/register.jsp").forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("title 값은 : {}", request.getParameter("title"));
        log.info("dueDate 값은 : {}", request.getParameter("dueDate"));

        TodoDTO todoDTO = TodoDTO.builder()
                        .title(request.getParameter("title"))
                        .dueDate(LocalDate.parse(request.getParameter("dueDate"),DATEFORMATTER))
                        .build();
        try{
            todoService.register(todoDTO);
        }catch(Exception e){
            e.printStackTrace();
        }

        response.sendRedirect("/todo/list");        // todoListController를 통해 list.jsp로 이동
    }
}
