package kr.mjc.kwanghyun.web.dao;

import lombok.Data;

@Data
public class Subscribe {
    int subId;
    int userId;
    String name;
    int price;
    String pdate;
}
