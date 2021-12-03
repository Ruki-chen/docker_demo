package com.example.docker_demo.config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class MyPhysicalNamingStrategy extends SpringPhysicalNamingStrategy {
    //
    public static final String REFERRAL = "test_";

    //
    @Override
    public Identifier toPhysicalTableName(final Identifier name, final JdbcEnvironment jdbcEnvironment) {
        final Identifier identifier = super.toPhysicalTableName(name, jdbcEnvironment);
        return new Identifier(REFERRAL + identifier.getText(), identifier.isQuoted());
    }
}
