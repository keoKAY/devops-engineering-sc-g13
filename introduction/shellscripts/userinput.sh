#!/bin/bash 

echo -n "Enter Service name: " 
read service_name 

read -p "Enter the port: " port 

echo -e "\n-----------[OUTPUT]--------"
echo "Service name is : $service_name"
echo "Service Port is : $port"