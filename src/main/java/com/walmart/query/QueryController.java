package com.walmart.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    @Autowired
    private IQueryServiceSQL queryServiceSql;

    @Autowired
    private IQueryServiceDB2 queryServiceDb2;

    @GetMapping(value = "/sql")
    public DatabaseInfo getCountSqlServer() {

        DatabaseInfo info = queryServiceSql.getInfo();

        return info;
    }

    @GetMapping(value = "/db2")
    public DatabaseInfo getCountDB2() {

        DatabaseInfo info = queryServiceDb2.getInfo();

        return info;
    }
}
