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

## Using Sed and yq 
```bash 
tail /etc/passwd 
head /etc/passwd 

# 17,20 
sed -n '17,20p' /etc/passwd

awk "NR>=17 && NR<=20 {print}" /etc/passwd

awk 'NR>=17 && NR<=20 {print NR,$0}' /etc/passwd  
head -20 /etc/passwd | tail -4 
```

**sed**: text, conf, yaml 
> regex 
```bash
sed 's/pattern/new-value/" compose.yaml
sed 's/8080:80/9090:80/' compose.yaml 
sed -i 's/8080:80/9090:80/' compose.yaml
sed '/image:/a \    environment:\n      - ENV=production' compose.yaml
sed '/volumes:/,/^[^ ]/d' compose.yaml

sudo snap install yq 

yq '.services.nginx-svc' compose.yaml
yq '.services.nginx-svc.image = "nginx:1.19"' compose.yaml 

yq '.services.nginx-svc.ports[1] = "9443:443"' compose.yaml 
# indent with yaml config 
yq '.services.nginx-svc.environment =["ENV=production", "Mode=Live"]' compose.yaml
```
