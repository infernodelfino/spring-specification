# spring-specification
Spring data JPA specification query training

1, First run without #spring.sql.init.mode=always <br>
2, Second run with spring.sql.init.mode=always then you will be good

Some notes:
  Infinitive recursion: 
  - Thêm @JsonBackReference vào attribute bên có mappedBy
  - Thêm @JsonManagedReference vào còn lại
