package kroryi.w3.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Builder
@Data       // getter & setter 포함
@NoArgsConstructor      // 생성자 생략 가능
@AllArgsConstructor     // 매개변수 생성자 생략 가능
public class TodoDTO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
