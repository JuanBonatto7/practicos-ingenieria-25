package ejercicio2;

// Authors: Paul Ammann & Jeff Offutt
// Programmable Thermostat
// Chapter 8
// See ThermostatTest.java for JUnit tests


// Programmable Thermostat
public class Thermostat
{
   private int curTemp;          // current temperature reading
   private int thresholdDiff;    // temp difference until we turn heater on
   private int timeSinceLastRun; // time since heater stopped
   private int minLag;           // how long I need to wait
   private boolean override;     // has user overridden the program
   private int overTemp;         // overriding temperature
   private int runTime;          // output of turnHeaterOn - how long to run
   private boolean heaterOn;     // output of turnHeaterOn - whether to run
   private Period period;        // morning, day, evening, or night
   private DayType day;          // week day or weekend day

   // Decide whether to turn the heater on, and for how long.
   public boolean turnHeaterOn (ProgrammedSettings pSet)
   {
      //i1
      int dTemp = pSet.getSetting(period, day);

      //D1
      if (((curTemp < dTemp - thresholdDiff) ||
           (override && curTemp < overTemp - thresholdDiff)) &&
           (timeSinceLastRun > minLag))
      {  
         //----- D1 True -------
         
         // Turn on the heater
         // How long? Assume 1 minute per degree (Fahrenheit)
         //i2
         int timeNeeded = Math.abs(dTemp - curTemp); // abs() added May 2020
         
         //D2
         if (override)
            //----------D2 True----------
            //i3
            timeNeeded = Math.abs(overTemp - curTemp); // abs() added May 2020
         //i4
         setRunTime(timeNeeded);
         //i5
         setHeaterOn(true);
         //i6
         return(true);
      }
      else
      {
         //------- D1 False ------------
         //i7
         setHeaterOn(false);
         //i8
         return(false);
      }
   } // End turnHeaterOn

   public void setCurrentTemp(int temperature)  { curTemp = temperature; }
   public void setThresholdDiff(int delta)      { thresholdDiff = delta; }
   public void setTimeSinceLastRun(int minutes) { timeSinceLastRun = minutes; }
   public void setMinLag(int minutes)           { minLag = minutes; }
   public void setOverride(boolean value)       { override = value; }
   public void setOverTemp(int temperature)     { overTemp = temperature; }

   // for the ProgrammedSettings
   public void setDay(DayType curDay)      { day = curDay; }
   public void setPeriod(Period curPeriod) { period = curPeriod; }

   // outputs from turnHeaterOn
   void    setRunTime(int minutes)    { runTime = minutes; }
   public int     getRunTime()               { return runTime; }
   void    setHeaterOn(boolean value) { heaterOn = value; }
   public boolean getHeaterOn()              { return heaterOn; }
} // End Thermostat class
