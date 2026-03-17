package br.com.allysoncsc.rest_with_java_spring_erudio.repository.query;


import br.com.allysoncsc.rest_with_java_spring_erudio.dto.ClienteResumoDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteQueryRepository {

    private final JdbcTemplate jdbcTemplate;

    public ClienteQueryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
//
    public List<String> listarNomes() {
        String sql = "SELECT first_name FROM person;";

        return jdbcTemplate.query(
                sql,
                (rs, rowNum) -> rs.getString("nome")
        );
    }

    public ClienteResumoDto retornarUsu(){
        String sql =  "SELECT id,first_name,last_name FROM person where id = 13;";

        return jdbcTemplate.queryForObject(sql,
                (rs,rowNumber)->new ClienteResumoDto(rs.getLong("id"),rs.getString("first_name"),
                        rs.getString("last_name")));
    }
}
