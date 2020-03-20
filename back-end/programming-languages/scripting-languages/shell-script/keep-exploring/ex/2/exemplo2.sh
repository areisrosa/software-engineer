#!/bin/bash
echo -n "Type a number "
read number
if [ -z $number ]
then
    echo "You must enter a number"
elif [ $number -lt 10 ]
then
    echo "The number you enter $number is less than 10"
elif [ $number -eq 10 ]
then
    echo "The number type $number is equal than 10"
elif [ $number -gt 10 ]
then
    echo "The number type $number is more than 10"
fi
