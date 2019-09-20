
Spring Boot with TLS and HTTP/2 on localhost

КАК ЗАЮЗАТЬ HTTPS НА LOCALHOST

Installing mkcert

Install Certutil
As a prerequisite, you are required to install certutil, a command-line utility that can create and modify certificate
 and key databases before you can install mkcert utility.

# apt install libnss3-tools -y

Install mkcert

Once the installation of certutil is done, download the mkcert binary from Github and install it as shown below

#  wget https://github.com/FiloSottile/mkcert/releases/download/v1.1.2/mkcert-v1.1.2-linux-amd64
# mv mkcert-v1.1.2-linux-amd64 mkcert
# chmod +x mkcert
# cp mkcert /usr/local/bin/

Generate Local CA
Now that the mkcert utility is installed, run the command below to generate your local CA.

$ mkcert -install

Created a new local CA at "/home/amos/.local/share/mkcert" ?
The local CA is now installed in the system trust store! ⚡️
The local CA is now installed in the Firefox and/or Chrome/Chromium trust store (requires browser restart)! ?
As shown in the output, the root CA is stored under /home/amos/.local/share/mkcert. You can as well find the root CA path by running the command below.

--------------------------------------------------------------------------------------

find the root CA path

* windows : **mkcert-v1.4.0-windows-amd64.exe -CAROOT
* linux :   ** mkcert -CAROOT

 -----------------
 Generate Local SSL Certificates

 This creates a new file localhost+2.p12 in the current directory. The PKCS#12 bundle is secured with the password changeit.

 ---------------
* windows :
** mkcert-v1.4.0-windows-amd64.exe -pkcs12 localhost 127.0.0.1 ::1

* linux :
** mkcert -pkcs12 localhost 127.0.0.1 ::1


---------------------------------------------------------------------------------------
sudo lsof -i tcp:8443



