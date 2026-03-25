import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ejercicio2.DayType;
import ejercicio2.Period;
import ejercicio2.ProgrammedSettings;
import ejercicio2.Thermostat;

public class ThermostatTest {
    private Thermostat thermostat;
    private ProgrammedSettings settings;
    
    
    /*
     * Coberturas a cubrir con los test:
     * C1 = (D1 = false) -> {i7, i8}
     * 
     * C2 = (D1 = True) -> (D2 = false) -> {i2,i4,i5,i6} 
     * 
     * C3 = (D1 = True) -> (D2 = true) -> {i3}
    */

    @Test 
    public void testC1(){
        thermostat = new Thermostat();
        settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKDAY);

        // La temperatura es baja (60), por lo que C1 sería verdadera...
        thermostat.setCurrentTemp(60);
        thermostat.setThresholdDiff(5); // (dTemp - threshold = 65)

        // ...pero C3 (lag) es falsa, forzando D1 a ser FALSO.
        thermostat.setTimeSinceLastRun(5); // 5 minutos
        thermostat.setMinLag(10);          // 10 minutos
        
        // 2. Act (Actuar)
        boolean heaterState = thermostat.turnHeaterOn(settings);

        // 3. Assert (Verificar)
        assertFalse(heaterState);
        assertFalse(thermostat.getHeaterOn());
    }

    // --- Test 2: Heater ON - Modo Normal (Cubre D1-True, D2-False, I-2, 4, 5, 6) ---
    @Test
    public void testHeaterOnNormalMode() {
        // 1. Arrange (Preparar)
        thermostat = new Thermostat();
        settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 70);
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKDAY);

        // D2-False
        thermostat.setOverride(false); 
        
        // C3 = true
        thermostat.setTimeSinceLastRun(15);
        thermostat.setMinLag(10);

        // C1 = true (60 < 70 - 5)
        thermostat.setCurrentTemp(60);
        thermostat.setThresholdDiff(5);
        
        // D1 = ((C1=true || C2=false) && C3=true) => TRUE

        // 2. Act (Actuar)
        boolean heaterState = thermostat.turnHeaterOn(settings);

        // 3. Assert (Verificar)
        assertTrue(heaterState);
        assertTrue(thermostat.getHeaterOn());
    }

    // --- Test 3: Heater ON - Modo Override (Cubre D1-True, D2-True, I-3) ---
    @Test
    public void testHeaterOnOverrideMode() {
        // 1. Arrange (Preparar)
        thermostat = new Thermostat();
        settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 70); // dTemp
        thermostat.setPeriod(Period.MORNING);
        thermostat.setDay(DayType.WEEKDAY);
        
        // D2-True
        thermostat.setOverride(true);
        thermostat.setOverTemp(68); // Temperatura de override
        
        // C3 = true
        thermostat.setTimeSinceLastRun(15);
        thermostat.setMinLag(10);

        // C1 y C2 son verdaderas
        thermostat.setCurrentTemp(60);
        thermostat.setThresholdDiff(5);
        
        // D1 = ((C1=true || C2=true) && C3=true) => TRUE

        // 2. Act (Actuar)
        boolean heaterState = thermostat.turnHeaterOn(settings);

        // 3. Assert (Verificar)
        assertTrue(heaterState);
        assertTrue(thermostat.getHeaterOn());
        
        // Verificamos que se usó la temp de override (I-3)
        // timeNeeded = abs(overTemp - curTemp) = abs(68 - 60) = 8
        assertEquals(8, thermostat.getRunTime());
    }
}
