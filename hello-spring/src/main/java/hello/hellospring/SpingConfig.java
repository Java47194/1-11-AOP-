package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpingConfig {

    private EntityManager em;

    public SpingConfig(EntityManager em) {
        this.em = em;
    }

    /*  private DataSource dataSource;

    @Autowired
    public SpingConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        // 이게 다형성
        //return  new MemoryMemberRepository();
       //return  new JdbcMemberRepository(dataSource);

        //return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
