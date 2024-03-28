package me.dio.sdw.adapters.out;

import me.dio.sdw.domain.model.Champions;
import me.dio.sdw.domain.ports.ChampionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ChampionsJdbcRepository implements ChampionsRepository {

    @Autowired
    private final JdbcTemplate JdbcTemplate;
    private final RowMapper<Champions> rowMapper;
    public ChampionsJdbcRepository(JdbcTemplate jdbcTemplate) {
        this.JdbcTemplate = jdbcTemplate;
        this.rowMapper = (rs, rowNum) -> new Champions(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getString("lore"),
                rs.getString("image_url")
        );
    }

    @Override
    public List<Champions> findAll() {
        return JdbcTemplate.query("SELECT * FROM CHAMPIONS", rowMapper);
    }

    @Override
    public Optional<Champions> findById(Long id) {
        String sql = "SELECT * FROM CHAMPIONS WHERE id = ?";
        Champions champion =  JdbcTemplate.queryForObject(sql, rowMapper);
        return Optional.ofNullable(champion);
    }
}