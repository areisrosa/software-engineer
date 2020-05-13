#!/bin/bash
file="/etc/passwd"

if [ -f $file ]
then
    echo "the file $file exist"
else
    echo "the file $file not exist"
fi
