#!/bin/bash

rm ./lib/images.zip ./lib/images.zip.*

wget https://www.dropbox.com/s/i37yo43w2nmvfvy/images.zip -P ./lib/

unzip ./lib/images.zip -d ./lib
