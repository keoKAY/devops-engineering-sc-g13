
#!/bin/bash

users=("koko" "bona" "vipha"  "piseth" "pisey")
echo "Filename is : $0" 
set -x # turn on debug mode 
for item in "${users[@]}"
do 
    echo "+ Creating Account for  : $item" 
    sudo useradd -m -s /bin/bash $item
    echo "${item}:qwer123" | sudo chpasswd
    sudo chage -d 0 $item 
done 
# turn off debug mode 
set +x