package mylab.user.di.annot;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import javax.annotation.Resource;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    SecurityService securityService;

    @Autowired
    UserRepository userRepository;

    @Test
    void testUserService() {
        //UserService의 레퍼런스가 Not Null 인지 검증
        assertNotNull(userService);
        //userService.getRepository() 가 Not Null 인지 검증
        assertNotNull(userService.getUserRepository());
        //userService.getRepository().getDbType() 값이 MySQL 인지 값을 비교하기
        assertEquals("MySQL",userService.getUserRepository().getDbType());

        //UserService의 레퍼런스가 Not Null 인지 검증
        assertNotNull(userService.getSecurityService());

        //userService.registerUser() 메서드가 True 인 검증
        boolean result  = userService.registerUser("spring","스프링사용자","1234");
        assertTrue(result);
    }
}
