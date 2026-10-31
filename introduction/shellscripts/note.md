# NOTE for shellscripts 

```bash 
chmod +x script.sh 
./script.sh 

sh sample.sh 
bash sample.sh 



echo "Default Message" > output.log
echo "Default Hello" >> output.log  
more output.log

date 1>success.log 2>error.log
date &> app.log  

# hide the output of command 
# by direct the output to the blackhole
sudo apt update &> /dev/null 


sudo snap install just --classic 
```
