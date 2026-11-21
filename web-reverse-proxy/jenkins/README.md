## NOTE FOR JENKINS 


```bash

sudo add-apt-repository universe
sudo apt update
sudo apt install openjdk-25-jdk

```
- Installing Jenkins 
```bash
sudo wget -O /etc/apt/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2026.key
echo "deb [signed-by=/etc/apt/keyrings/jenkins-keyring.asc]" \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt update
sudo apt install jenkins
```

# Adding domain name and https 
```bash
curl ifconfig.me 
nslookup jenkins-sc.akasdev.com

# reload the nginx cofigureation 
sudo nginx -s reload 
sudo systemctl reload nginx 

sudo certbot --nginx -d jenkins-sc.akasdev.com 
```

/home/vagrant ... 
jenkins 

/var/lib/jenkins = home of jenkins user 
/var/lib/jenkins/jobs
/var/lib/jenkins/workspace