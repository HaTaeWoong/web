package kr.mjc.kwanghyun.web.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Slf4j
public class SubscribeDao {

    String LIST_SUBSCRIBE = """
            select subId, userId, name, price, pdate from subscribe
            order by subId desc limit ?,?""";

    String ADD_SUBSCRIBE =
            "insert subscribe(userId, name, price, pdate) values (:userId, :name, :price, :pdate)";

    String DELETE_SUBSCRIBE = "delete from subscribe where subId=? and userId=?";

    private final JdbcTemplate jdbcTemplate;

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     * resultSet을 subscription object로 매핑하는 매퍼
     */
    private final RowMapper<Subscribe> subscribeRowMapper =
            new BeanPropertyRowMapper<>(Subscribe.class);

    /**
     * namedParameterJdbcTemplate을 주입하는 컨스트럭터
     */
    public SubscribeDao(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
        log.info("{} constructed", getClass().getSimpleName());
    }

    /**
     * 구독 목록
     */
    public List<Subscribe> listSubscribe(int count, int page) {
        int offset = (page - 1) * count;
        return jdbcTemplate.query(LIST_SUBSCRIBE, subscribeRowMapper, offset, count);
    }

    

    /**
     * 구독물 등록
     */
    public void addSubscribe(Subscribe subscribe) {
        namedParameterJdbcTemplate.update(ADD_SUBSCRIBE,
                new BeanPropertySqlParameterSource(subscribe));
    }
    

    /**
     * 구독물 삭제
     */
    public int deleteSubscribe(int subId, int userId) {
        return jdbcTemplate.update(DELETE_SUBSCRIBE, subId, userId);
    }

}
