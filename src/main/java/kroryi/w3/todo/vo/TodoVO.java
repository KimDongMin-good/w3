package kroryi.w3.todo.vo;

import lombok.*;

import java.time.LocalDate;


// vo는 getter만 넣는다.
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {

    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;

}
