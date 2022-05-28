package org.zerock.domain;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

@Data
public class TodoDTO {
  private String title;

  @DateTimeFormat(pattern = "yyyy/MM/dd") //이 애노테이션을 사용하면 controller의 binding이 필요 없음
  private Date dueDate;
}
