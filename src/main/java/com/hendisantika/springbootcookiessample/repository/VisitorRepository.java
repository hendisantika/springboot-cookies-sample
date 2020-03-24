package com.hendisantika.springbootcookiessample.repository;

import com.hendisantika.springbootcookiessample.entity.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : springboot-cookies-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/03/20
 * Time: 11.13
 */
public interface VisitorRepository extends JpaRepository<Visitor, String> {
}
