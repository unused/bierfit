
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
$ sudo apt-get install python3 python3-pyserial
```

[github]: https://github.com/unused/bierfit  "Bierfit Fitness Tracker"
