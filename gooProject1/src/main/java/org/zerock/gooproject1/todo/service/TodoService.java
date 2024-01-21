package org.zerock.gooproject1.todo.service;

import org.zerock.gooproject1.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum TodoService {
    INSTANCE;

    /**
     * 원래 Service에는 System.out.println() 을 쓰면 안돼요.
    * */

    //등록
    public void register(TodoDTO todoDTO){
        System.out.println("DEBUG ... ... ..." + todoDTO);
        System.out.println("새로운 TodoDTO 객체를 받아서 확인할 수 있는 것을 목적으로 작성됨");
    }

    //목록
    public List<TodoDTO> getList(){
        System.out.println("getList()실행 : 10개의 TodoDTO 객체를 만들어서 반환하도록 구성됨");

        List<TodoDTO> todoDTOS = IntStream.range(0,10).mapToObj(i -> {
            TodoDTO dto = new TodoDTO();
            dto.setTno((long) i);
            dto.setTitle("TodoDTO 객체_" + i);
            dto.setDueDate(LocalDate.now());

            return dto;

        }).collect(Collectors.toList());

        return todoDTOS;
    }

    //특정 번호 조회
    public TodoDTO getOne(Long tno){

        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);

        return dto;
    }

}
