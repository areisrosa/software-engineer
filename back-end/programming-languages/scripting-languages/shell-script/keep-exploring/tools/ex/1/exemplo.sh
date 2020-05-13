#!/bin/bash
echo -n "Which distro |GNI/Linux| are you using? "
read string
if [ -z $string ]
then
    echo "type the name your distro |GNU/Linux|"
elif [ $string = "Debian" ] || [ $string = "debian" ]
then
    echo "Yours distro |GNU/Linux| is Debian"
else
    echo "Yours distro |GNU/Linux| not is Debian"
fi
