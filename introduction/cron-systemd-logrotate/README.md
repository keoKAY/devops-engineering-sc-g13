## NOTE 

1. **Contab**: Used to set schedule to automate specific tasks 

```bash 
# to create a cronjob
crontab -e 
demo-script.sh 
echo "Running at : $(date)" >> crondemo.log

chmod +x demo-script.sh 
crontab -e # create 
crontab -l # list 
crontab -i -r # remove 
* * * * * /home/vagrant/demo-script.sh 

# run cat command every 2secs 
watch cat crondemo.log

# check the status of cronservice
sudo systemctl status cron.service
sudo systemctl status cron
```


## Log Rotations 
```bash

sudo apt install nginx -y 

curl localhost:80 # x5 times 
# /var/log/nginx/access.log 
# access.log.1 
# access.log.2.gz ... 

```
- Sample logrotate configurations 

Filename: `/etc/logrotate.d/dailylog`
```conf
/var/log/logrotate-demo.log {
    daily
    rotate 7
    compress
    missingok
    notifempty
    create 0644 root root
    extension log 
    dateext
    dateformat  %Y-%m-%d-%H%M%S.
    su root root
}
```

- Force the rotation
```bash
sudo logrotate -f /etc/logrotate.d/dailylog
```


## SystemD Service 

- Unit files: configuration for 
    - .service : a service definition 
    - .target : group of service 
    - .socket : used to start the service 
    - .mount : disk mount 
    - .timer : like cront
```bash

sudo service nginx status 
sudo systemctl status nginx 

sudo systemctl daemon-reload
sudo systemctl start|stop|enable|disable|reload nginx 

# enable (autostart) -> config to service to join the .target , which will auto start after machine boot 

# nginx 
sudo systemctl cat nginx 
sudo systemctl edit nginx 
```


- In order to write the service configuration 
```bash
cd /etc/systemd/system
sudo vim app.service 

sudo systemctl start app.service
sudo systemctl status app.service

sudo cat /opt/myapp.log 
```