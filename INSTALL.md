
# Bierfit - Bier Fitness Tracker - Install Guide

On any problems feel free to [create an issue](github), we are happy to help and eager to improve and extend the instructions.

## Meideckel

Requirements...
- Arduino
- FSR (FSR-400 in example)
- Breatboard, Cables, 10k resistor
- Raspberry Pi or PC (instructions only for linux based)

With the following setup you'll be instructed how to load the script to read data from the FSR (Forse-Sensing Resistor) sensor on the arduino, read it from a raspberry pi and send it to 

```sh
$ sudo dnf install arduino # or apt-get or yum, depending on your linux box :)
$ arduino # load sketch, upload to connected arduino
```

Now... figure sensor setup, 

Raspberry...

```sh
# install required packages to run the script
$ sudo apt-get install python3 python3-pyserial
# fetch the script and the deamon
$ wget https://raw.githubusercontent.com/unused/bierfit/master/raspberry/bierfit-pi
$ wget https://raw.githubusercontent.com/unused/bierfit/master/raspberry/bierfitd
# set (lazy) user rights
$ chmod 755 bierfit-pi bierfitd
# move the script
$ sudo mkdir /opt/bierfit
$ sudo mv bierfit-pi /opt/bierfit/
# mv and configure the service
$ sudo mv bierfitd /etc/init.d/
$ sudo update-rc.d bierfitd defaults
# check startup settings are correctly, you should see some links at...
$ ls -l /etc/rc?.d/*bierfitd
```

[github]: https://github.com/unused/bierfit  "Bierfit Fitness Tracker"
