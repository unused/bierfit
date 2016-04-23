/* Bierfit -> Beermat with Force Sensitive Resistor


For more information see www.ladyada.net/learn/sensors/fsr.html */
 
int fsrPin = 0;     // the FSR and 10K pulldown are connected to a0
int fsrReading;     // the analog reading from the FSR resistor divider
int fsrVoltage;     // the analog reading converted to voltage
unsigned long fsrResistance;  // The voltage converted to resistance, can be very big so make "long"
unsigned long fsrConductance; 
long fsrForce;       // Finally, the resistance converted to force
 
void setup(void) {
  Serial.begin(9600);   // We'll send debugging information via the Serial monitor
}
 
void loop(void) {
  fsrReading = analogRead(fsrPin);  
  
  // analog voltage reading ranges from about 0 to 1023 which maps to 0V to 5V (= 5000mV)
  fsrVoltage = map(fsrReading, 0, 1023, 0, 5000);
   
  if (fsrVoltage == 0) {
    //Serial.println("No pressure");  
    // TODO: something usefull (maybe have a beer)
  } else {
    // The voltage = Vcc * R / (R + FSR) where R = 10K and Vcc = 5V
    // so FSR = ((Vcc - V) * R) / V        yay math!
    fsrResistance = 5000 - fsrVoltage;     // fsrVoltage is in millivolts so 5V = 5000mV
    fsrResistance *= 10000;                // 10K resistor
    fsrResistance /= fsrVoltage;
   
    fsrConductance = 1000000;           // we measure in micromhos so 
    fsrConductance /= fsrResistance;

    // Use the two FSR guide graphs to approximate the force
    if (fsrConductance <= 1000) {
      fsrForce = fsrConductance / 80;
    } else {
      fsrForce = fsrConductance - 1000;
      fsrForce /= 30;        
    }


    // CSV values 
    //Analog reading, Voltage reading in mV, FSR resistance in ohms, Conductance in microMhos, Force in Newtons
    Serial.print(fsrReading);
    Serial.print(",");
    
    Serial.print(fsrVoltage);
    Serial.print(",");  
    
    Serial.print(fsrResistance);
    Serial.print(",");
    
    Serial.print(fsrConductance);
    Serial.print(",");
    
    Serial.println(fsrForce);      
    
  }
  delay(1000);
}
