package mocks.teoria;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mocks.ejercicio1.IEmailService;
import mocks.ejercicio1.IWebService;
import mocks.ejercicio1.LogAnalyzer;

public class LogAnalyzerTest {
    private LogAnalyzer analyzer;
    private IWebService mockService;
    private IEmailService mockEmail;

    @BeforeEach
    void setUp(){
        mockService = createMock(IWebService.class);
        mockEmail = createMock(IEmailService.class);

        analyzer = new LogAnalyzer();
        analyzer.setWebService(mockService);
        analyzer.setEmailService(mockEmail);   
    }

    @Test
    public void testValidName(){
        //Rama if false
        String valid = "stringvalidoo";

        replay(mockService, mockEmail);
        
        analyzer.analyze(valid);
        
        verify(mockService, mockEmail);
    }

    @Test
    public void testSmartName(){

        String fileName = "short";
        
        mockService.logError("Filename too short:" + fileName);
        expectLastCall();

        replay(mockService, mockEmail);
        
        analyzer.analyze(fileName);
        
        verify(mockService, mockEmail);
    }

    @Test
    public void testException(){
        String fileName = "seven";
        
        mockService.logError("Filename too short:" + fileName);
        expectLastCall().andThrow(new RuntimeException("ERROR 100"));

        mockEmail.sendEmail("a", "subject", "ERROR 100");
        expectLastCall();
        
        replay(mockService, mockEmail);
        
        analyzer.analyze(fileName);
        
        verify(mockService, mockEmail);
    }


}
