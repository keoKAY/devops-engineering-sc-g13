#!/bin/bash
function greeting(){
    local username="$1"
    echo "Welcome ${username^^} to the system! " 
    echo "Current Date is : $(date)" 
    
}

check_service(){
    local service_name="$1"
    #port="$2"
    echo "Checking Service: $service_name"
    #echo "Service Port: $port"

    if systemctl is-active --quiet $service_name ; then 
        echo "${service_name^^} is running ✅" 
    else 
        echo "${service_name^^} is NOT RUNNING ❌"
    fi 
}



user_util(){
    local username="$1"
    local option="$2" # create|delete
    # validate the option here 
    if [ -z "$username" ]; then 
        echo "Username is required ! "
        exit 1  
    fi 
    if [ -z "$option" ]; then 
        echo "option required! " 
        exit 1 
    fi 

    case "$option" in 
        "create")
            echo "---------[Create User: $username ]--------"
            sudo useradd -m -s /bin/bash $username
            echo "${username}:qwer123" | sudo chpasswd
            sudo chage -d 0 $username
            ;;
        "delete")
            echo "---------[Delete User]-----------"
            sudo deluser --remove-home $username
            ;; 
        *)
            echo "Invalid option! only create|delete"
            ;;  
    esac 

}

# user_util "james" "delete"


