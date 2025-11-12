package mocks.teoria;

import static org.easymock.EasyMock.anyString;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.eq;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mocks.ejercicio2.IPBlacklist;
import mocks.ejercicio2.LoginService;

public class IPBlacklistTest {
    private IPBlacklist ipBlack;
    private LoginService mockService;

    private String validPass = "password123";
    private String invalidPass = "wrongpass";


    @BeforeEach
    public void setUp(){
        mockService = createMock(LoginService.class);
        ipBlack = new IPBlacklist();

        ipBlack.setService(mockService);
    }

    @Test
    public void loginSecondTryTest(){
        String ip = "77777";
        String user = "sex0";

        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(false);
        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(true);

        replay(mockService);

        boolean firstTry = ipBlack.login(ip,user, invalidPass);
        boolean secondTry = ipBlack.login(ip, user, validPass);

        verify(mockService);
        assertFalse(firstTry);
        assertTrue(secondTry);
    }

    @Test
    public void blackList(){
        String ip = "4321";
        String user = "mateo";

        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(false);
        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(false);
        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(false);

        replay(mockService);

        ipBlack.login(ip,user, invalidPass);
        ipBlack.login(ip,user, invalidPass);
        ipBlack.login(ip,user, invalidPass);

        verify(mockService);
        assertTrue(ipBlack.blacklisted(ip));
    }

    @Test
    public void noBlackList(){
        String ip = "2727";
        String user = "juan";
        
        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(false);
        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(false);
        replay(mockService);

        ipBlack.login(ip,user, invalidPass);
        ipBlack.login(ip,user, invalidPass);

        verify(mockService);
        assertFalse(ipBlack.blacklisted(ip));
    }

    //Rama 1: el usario ya esta en la blacklist
    @Test
    public void rama1(){
        String ip = "blacklist";
        String user = "asd";

        replay(mockService);
        
        ipBlack.blacklistIP(ip);

        verify(mockService);
        assertFalse(ipBlack.login(ip, user, validPass));
    }


    //Rama 2: no esta en la blacklist y se pudo logear con una contraseña valida
    @Test
    public void rama2(){
        String ip = "baaaghaa";
        String user = "gordo";

        expect(mockService.login(eq(ip), eq(user), anyString())).andReturn(true);

        replay(mockService);

        boolean log = ipBlack.login(ip, user, validPass);

        verify(mockService);
        assertTrue(log);
    }

    //Rama 3: no esta en la blackList, no se pudo logear por primera vez
    @Test
    public void rama3(){
        String ip = "aaaaa";
        String user = "aSdad";

        expect(mockService.login(eq(ip),eq(user),anyString())).andReturn(false);

        replay(mockService);

        boolean nope = ipBlack.login(ip,user, invalidPass);

        verify(mockService);
        assertEquals(ip, ipBlack.lastip);
        assertFalse(nope);
    }

    //Rama 4 y 5: ya estan cubiertas
}
