#!/bin/bash 

# comment 

username="james"
age=18
echo "Welcome to shellscript" 
echo "Your name is : ${username}" 
echo "Your name in uppercase: ${username^^}"
echo "Your name in lowercase: ${username,,}"
echo "Number of letter: ${#username}"
echo "Your age is : $age" 
echo "Code executed at:  $(date)"
echo "Owner of this script : $(whoami)" 
