#!/bin/bash

file="/usr/bin/passwd"

if [ -u "$file" ]
then
    echo "the file $file has the SUID active"
    ls -l $file
elif [ -g $file ]
then
    echo "the file $file has the GUID active"
elif [ -k $file ]
then
    echo "the file $file has the bit sticky active"
    ls -l $file
else
    echo "the file $file does not have the SUID, GUID and Bit Sticky actives"
    ls -l $file
fi
