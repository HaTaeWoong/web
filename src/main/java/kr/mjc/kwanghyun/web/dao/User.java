package kr.mjc.kwanghyun.web.dao;

import lombok.Data;
import lombok.ToString;

@Data
public class User {
  int userId;
  String email;
  @ToString.Exclude
  String password;
  String name;
}
