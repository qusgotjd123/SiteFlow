package hello.hellospring;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import hello.hellospring.repository.JpaMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringConfig {


    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JpaMemberRepository(em);
    }
    
    @Bean
    public InternalResourceViewResolver setupViewResolver() {
 
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
     
        resolver.setPrefix("/templates");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    
    
    
  
    
    
    
}
