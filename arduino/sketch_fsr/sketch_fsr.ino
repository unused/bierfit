/* Bierfit -> Beermat with Force Sensitive Resistor


For more information see www.ladyada.net/learn/sensors/fsr.html 
Keypad http://www.instructables.com/id/Keypad-With-Arduino-Without-USing-Keypad-library-F/
*/
int fsrPin = 0;     // the FSR and 10K pulldown are connected to a0
int fsrReading;     // the analog reading from the FSR resistor divider
int fsrVoltage;     // the analog reading converted to voltage
unsigned long fsrResistance;  // The voltage converted to resistance, can be very big so make "long"
unsigned long fsrConductance; 
long fsrForce;       // Finally, the resistance converted to force
const unsigned long sendPeriod=1000; 
unsigned long sendKdelay=0;

byte h=0,v=0;    //variables used in for loops
const unsigned long period=50;  //little period used to prevent error
unsigned long kdelay=0;        // variable used in non-blocking delay 
const byte rows=4;             //number of rows of keypad
const byte columns=4;            //number of columnss of keypad
const byte Output[rows]={2,3,4,5}; //array of pins used as output for rows of keypad
const byte Input[columns]={6,7,8,9}; //array of pins used as input for columnss of keypad

String actUserId = "0";
String newUserId = "";

byte keypad() // function used to detect which button is used 
{
 static bool no_press_flag=0;  //static flag used to ensure no button is pressed 
  for(byte x=0;x<columns;x++)   // for loop used to read all inputs of keypad to ensure no button is pressed 
  {
     if (digitalRead(Input[x])==HIGH);   //read evry input if high continue else break;
     else
     break;
     if(x==(columns-1))   //if no button is pressed 
     {
      no_press_flag=1;
      h=0;
      v=0;
     }
  }
  if(no_press_flag==1) //if no button is pressed 
  {
    for(byte r=0;r<rows;r++) //for loop used to make all output as low
    digitalWrite(Output[r],LOW);
    for(h=0;h<columns;h++)  // for loop to check if one of inputs is low
    {
      if(digitalRead(Input[h])==HIGH) //if specific input is remain high (no press on it) continue
      continue;
      else    //if one of inputs is low
      {
          for (v=0;v<rows;v++)   //for loop used to specify the number of row
          {
          digitalWrite(Output[v],HIGH);   //make specified output as HIGH
          if(digitalRead(Input[h])==HIGH)  //if the input that selected from first sor loop is change to high
          {
            no_press_flag=0;                //reset the no press flag;
            for(byte w=0;w<rows;w++) // make all outputs as low
            digitalWrite(Output[w],LOW);
            return v*4+h;  //return number of button 
          }
          }
      }
    }
  }
 return 50;
}

void setup(void) {

  for(byte i=0;i<rows;i++)  //for loop used to make pin mode of outputs as output
  {
  pinMode(Output[i],OUTPUT);
  }
  for(byte s=0;s<columns;s++)  //for loop used to makk pin mode of inputs as inputpullup
  {
    pinMode(Input[s],INPUT_PULLUP);
  }
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

   if(millis()-kdelay>period) //used to make non-blocking delay
   {
      kdelay=millis();  //capture time from millis function
      switch (keypad())  //switch used to specify which button
      {  
          case 0:
              newUserId += "1";
              break;  
          case 1:
              newUserId += "2";
              break;
          case 2:
              newUserId += "3";
              break;
          case 3:
              //Serial.println("F1");
              break;
          case 4:
              newUserId += "4";
              break;
          case 5:
              newUserId += "5";
              break;
          case 6:
              newUserId += "6";
              break;
          case 7:
             // Serial.println("F2");
              break;
          case 8:
              newUserId += "7";
              break;
          case 9:
              newUserId += "8";
              break;
          case 10:
              newUserId += "9";
              break;
          case 11:
              //Serial.println("F3");
              break;
          case 12:
              // new user id
              newUserId = "";
              break;
          case 13:
              newUserId += "0";
              break;
          case 14:
              //Serial.println("Cancel");
              break;
          case 15:
              actUserId = newUserId;
              newUserId = "";
              break;
          default:
              ;
      }
    }

    // CSV values 
    //user ID, Analog reading, Voltage reading in mV, FSR resistance in ohms, Conductance in microMhos, Force in Newtons
    if(millis()-sendKdelay>sendPeriod)
    {
      sendKdelay = millis();
      Serial.print(actUserId);
      Serial.print(",");

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
  }
}
