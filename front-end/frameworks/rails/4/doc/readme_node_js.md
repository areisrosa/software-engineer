
## Table of Contents


- [How to install Node.js on Debian 9](#how-to-install-node.js-on-debian-9)
  - [Introduction](#introduction)
    - [How to install using a PPA](#how-to-install-using-a-ppa)
    - [How to install using nvm](#how-to-install-using-nvm)

How To Install Node.js on Debian 9
==================================

Introduction
------------

Node.js is a JavaScript platform for general-purpose programming that allows users to build network application quickly. By leveraging JavaScript on both the front-end and the back-end, development can be more consistent and be designed within the same system.

In this guide, you'll install Node.js on a Debian 9. Debian 9 contains a version of Node.js in its default repositories, but this version is outdated, so you'll explore two methods to install the latest version of Node.js on your system.

How To Install Using a PPA
--------------------------

The quickest and easiest way to get the most recent version of Node.js on your server is to add the PPA (personal package archive) maintained by NodeSource. This will have more up-to-date versions of Node.js than the official Debian repositories. It also lets you choose between Node.js v4.x (the older long-term support version, supported until April of 2017), v8.x (the more recent LTS version, which will be supported until June of 2018), and Node.js v10.x (the current actively developed version).

First, install the PPA in order to get access to its contents. Make sure you're in your home directory, and use curl to retrieve the installation script for your preferred version, making sure to replace 8.x with the correct version string:

```sh
$ cd ~

$ sudo apt-get install curl python-software-properties
```
```sh
$ curl -sL https://deb.nodesource.com/setup_8.x -o nodesource_setup.sh
```
You can inspect the contents of this script with nano (or your preferred text editor):
```sh
$ vim nodesource_setup.sh
```
And run the script under sudo:

```sh
$ sudo bash nodesource_setup.sh
```

The PPA will be added to your configuration and your local package cache will be updated automatically. After running the setup script from nodesource, you can install the Node.js package in the same way that you did above:

```sh
$ sudo apt-get install -y nodejs
```

The nodejs package contains the nodejs binary as well as npm, so you don't need to install npm separately. However, in order for some npm packages to work (such as those that require compiling code from source), you will need to install the build-essential package:

```sh
$ sudo apt-get install -y build-essential
```
How To Install Using nvm
------------------------

An alternative to installing Node.js through apt is to use a specially designed tool called nvm, which stands for "Node.js version manager". Using nvm, you can install multiple, self-contained versions of Node.js which will allow you to control your environment easier. Itwill give you on-demand access to the newest versions of Node.js, but will also allow you to target previous releases that your app may depend on.

To start off, we'll need to get the software packages from our Debian repositories that will allow us to build source packages. The nvm command will leverage these tools to build the necessary components:

```sh
$ sudo apt update or sudo apt-get update
...
$ sudo apt install build-essential libssl-dev 
```
Once the prerequisite packages are installed, you can pull down the nvm installation script from the [project's GitHub page](https://github.com/creationix/nvm). The version number may be different, but in general, you can download it with curl:

```sh
$ curl -o- https://raw.githubusercontent.com/creationix/nvm/v0.33.11/install.sh | bash
...
```
The script clones the nvm repository to `~/.nvm` and adds the source line to your profile (`~/.bash_profile`, `~/.zshrc`, `~/.profile`, or `~/.bashrc`).

```sh
  export NVM_DIR="$HOME/.nvm"
  [ -s "$NVM_DIR/nvm.sh" ] && \. "$NVM_DIR/nvm.sh" # This loads nvm
```

You can customize the install source, directory, profile, and version using the `NVM_SOURCE`, `NVM_DIR`, `PROFILE`, and `NODE_VERSION` variables. Eg: `curl ... | NVM_DIR="path/to/nvm"`. Ensure that the `NVM_DIR` does not contain a trailing slash.

NB. The installer can use `git`, `curl` or `wget` to download `nvm`, whatever is available.

**Note:** On Linux, after running the install script, if you get `nvm: command not found` or see no feedback from your terminal after you type:

```sh
$ command -v nvm
```

Now that you have nvm installed, you can install isolated Node.js versions.

To find out the versions of Node.js that are available for installation, you can type:

```sh
$ nvm ls-remote
```




