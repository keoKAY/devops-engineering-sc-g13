#!/bin/bash 
# command1 ; command2 ; 
date ; whoamiiii ; docker --version


# || pipe , run 2nd command when 1st command failed 

echo -e "\n[+] Using Pipe || " 
# dated || docker --version 
#nginx -v || echo "Install NGINX ......"
nginx -v &> /dev/null || {
    echo "1. Installing nginx ..... " 
    sudo apt update 
    sudo apt install nginx -y 
}



echo -e "\n[+] Using AND && " 
# 2nd run after 1st success 
docker --version && docker run hello-world 