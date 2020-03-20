
## Table of Contents


- [About RVM](#about-rvm)
- [Insyalling RVM](#installing-rvm)
  - [Security](#secutity)
  - [Basic install](#basic-install)
- [Installation explained](#installation-explained)
- [Installation](#installation)
- [Gemsets](#gemsets)

Abaut RVM
=========

Ruby Environment (Version) Manager (RVM) was originally started in October of 2007. Back then I had the idea and enthusiastically gave it a shot. I became discouraged as it is a very difficult problem space.

Since then, I have gained considerable experience programming in Bash, Ruby, and other languages. I, at last, found myself having the proper need, skill, and desire to make RVM happen. As you can see, I did!

RVM started as a personal project, however it very quickly ballooned into a feature rich application thanks to the awesome Ruby community giving constant feedback!


Installing RVM
==============

RVM supports most UNIX like systems and Windows (with [Cygwin](https://cygwin.com/) or [Bash on Ubuntu on Windows](https://docs.microsoft.com/en-us/windows/wsl/about)). The basic requirements are bash, curl, gpg2 and overall GNU version of tools - but RVM tries to autodetect it and install anything that is needed.

Security
--------


As a first step install [mpapis](https://rvm.io/authors/mpapi) [public](https://keybase.io/mpapis) key used to verify installation package to ensure [security](https://rvm.io/rvm/security).

RVM 1.26.0 signs and verifies all releases and the rvm-installer script. In most cases it's all automated and the installer will check if the downloaded releases signature matches the public key imported by user. But there is the first step that would need to be done manually - verifying the rvm-installer was signed by the given key:

```sh
# Install mpapis public key (might need `gpg2` and or `sudo`)

$ gpg --keyserver hkp://keys.gnupg.net --recv-keys 409B6B1796C275462A1703113804BB82D39DC0E3 7D2BAF1CF37B13E2069D6956105BD0E739499BDB


# Download the installer

$ \curl -O https://raw.githubusercontent.com/rvm/rvm/master/binscripts/rvm-installer
$ \curl -O https://raw.githubusercontent.com/rvm/rvm/master/binscripts/rvm-installer.asc

# Verify the installer signature (might need `gpg2`), and if it validates...

$ gpg --verify rvm-installer.asc &&

# Run the installer

$ bash rvm-installer stable

```
In rare cases the gpg --keyserver is failing, use this instead:

```sh
$ curl -sSL https://rvm.io/mpapis.asc | gpg --import -
```
Identity of [mpapis](https://rvm.io/authors/mpapis) can be confirmed with [mpapis public key on keybase.io](https://keybase.io/mpapis).

**Note:** hkp://keys.gnupg.net can sometimes timeout you may want to use different keyserver, for example: hkp://pgp.mit.edu

Basic install
-------------

## Ubuntu ##

RVM have dedicated Ubuntu package, so please follow instructions posted here: [https://github.com/rvm/ubuntu_rvm](https://github.com/rvm/ubuntu_rvm)

If you need a different (newer) version of RVM, after installing base version of RVM check the [Upgrading](https://rvm.io/rvm/upgrading) section.

## Any other system ##

Install RVM (development version):

```sh
$ \curl -sSL https://get.rvm.io | bash
```
Install RVM stable with ruby:

```sh
$ \curl -sSL https://get.rvm.io | bash -s stable --ruby
```

Additionally with rails (poor man's [railsinstaller](https://rvm.io/rvm/install)):

```sh
$ \curl -sSL https://get.rvm.io | bash -s stable --rails
```

Or with jruby, rails and puma:

```sh
$ \curl -sSL https://get.rvm.io | bash -s stable --ruby=jruby --gems=rails,puma
```

To install without rubygems-bundler and rvm gems (and also remove those gems from both global.gems and default.gems):

```sh
$ \curl -sSL https://get.rvm.io | bash -s stable --without-gems="rvm rubygems-bundler"
```

To install with hirb gem (and also add it to global.gems):

```sh
\curl -sSL https://get.rvm.io | bash -s stable --with-gems="hirb"
```

To install with rails and haml gems (and also add them to default.gems):

```sh
\curl -sSL https://get.rvm.io | bash -s stable --with-default-gems="rails haml"
```
Without [autolibs](https://rvm.io/rvm/autolibs):

```sh
\curl -sSL https://get.rvm.io | bash -s -- --autolibs=read-fail
```

For a progress bar when downloading RVM / Rubies:

```sh
echo progress-bar >> ~/.curlrc
```

Point to be noted is, there is a backslash before curl. This prevents misbehaving if you have aliased it with configuration in your **~/.curlrc** file.

If you're an existing RVM user and you don't want RVM to attempt to setup your shell to load RVM, you can opt out of this at install time by exporting rvm_ignore_dotfiles=yes, or opt out permanently by setting this in your rvmrc.

## You can also: ##

[1] Read the [installation documentation](https://rvm.io/rvm/install#explained) below.
[2] Watch the most accurate (but not official) [rvm screencast](https://www.youtube.com/watch?v=cQVb7fHFjSM).
[3] Read the most accurate (but not official) [rvm cheat sheet](http://cheat.errtheblog.com/s/rvm).
[4] Starting with Rails? watch the [RailsCasts.com on Getting Started with Rails](http://railscasts.com/episodes/310-getting-started-with-rails).

Installation explained
======================

There are three different ways to install and configure RVM.

    1. Single-User installations (recommended) - For an isolated install within a user's $HOME, not for root.

    2. Multi-User installations - For server administrators - For an installation usable by all users on the system - Please note that Single-User supersedes Multi-User. This also used to be called the S       ystem-Wide Install. Using this type of installation without knowledge how umask works is a big security risk.

    3. Mixed mode installations - For an installation usable by all users on the system - with isolated rubies/gemsets within a user's $HOME. Installation instructions are exactly the same as for Multi-U       ser installations, the difference is in users environment.
    
[get.rvm.io](https://raw.githubusercontent.com/rvm/rvm/master/binscripts/rvm-installer) is a redirect to https://raw.githubusercontent.com/rvm/rvm/master/binscripts/rvm-installer You could also use full path for the installer:

```sh
$ \curl https://raw.githubusercontent.com/rvm/rvm/master/binscripts/rvm-installer | bash -s stable
```

Installation
============

I recommend you [read the installation script](https://github.com/rvm/rvm/blob/master/binscripts/rvm-installer) yourself. This will give you a chance to understand what it is doing before installing, andallow you to feel more comfortable running it if you do so.

## 1. Download and run the RVM installation script ##

Installing the stable release version:

```sh
$ \curl -sSL https://get.rvm.io | bash -s stable
```

To get the latest development state:

```sh
$ \curl -sSL https://get.rvm.io | bash
```

Instruct RVM to not change the shell initializations files `rc` / `profile`:

```sh
$ \curl -sSL https://get.rvm.io | bash -s -- --ignore-dotfiles
```

Please note that from this point it is user responsibility to add sourcing rvm to appropriate files.

## For a Multi-User install you would execute the following: ##

```sh
$ \curl -sSL https://get.rvm.io | sudo bash -s stable
```

## Note: ## 
The Multi-User install instructions must be prefixed with the [sudo command](https://rvm.io/support/troubleshooting#sudo). However, once the install is complete, and the instructions to add users to the `rvm` group is followed, the use of either `sudo` or `rvmsudo` is no longer required. The `sudo` command is only to temporarily elevate privileges so the installer can complete its work. If you need to use `sudo` or `rvmsudo` after the install is complete, some part of the install directions were not properly followed. This usually is because people execute the install as `root`, rather than executing the installation instructions from a non-privileged user account.

Installing a specific version:

```sh
$ \curl -sSL https://get.rvm.io | bash -s -- --version latest
$ \curl -sSL https://get.rvm.io | bash -s -- --branch [owner/][repo]
```

Prefix the 'bash' portion with 'sudo', of course, if you wish to apply this to a Multi_user Install. Please feel free to check out our [upgrading docs](https://rvm.io/rvm/upgrading) for more details on branch format.

Debugging installation process:

```sh
$ \curl -sSL https://get.rvm.io | bash -s -- --trace
```

If the rvm install script complains about certificates you need to follow the displayed instructions.

## Single-User Install Location: ~/.rvm/ ##

If the install script is run as a standard, non-root user, RVM will install into the current users's home directory.

Modification of user configuration files (`*rc` / `*profile`) - RVM by default will modify user startup files, although it is not recommended you can disable automated process and do this manually:

```sh
$ \curl -sSL https://get.rvm.io | bash -s -- --ignore-dotfiles
$ echo "source $HOME/.rvm/scripts/rvm" >> ~/.bash_profile
```


## Multi-User Install Location: /usr/local/rvm ##

If the install script is run prefixed with sudo, RVM will automatically install into `/usr/local/rvm`. Please see the troubleshooting page for an important note regarding [Multi-User Installs](https://rvm.io/support/troubleshooting#sudo).

Please see the FAQ page for an [important note regarding](https://rvm.io/support/faq#root) **root only installs**.

## 2. Load RVM into your shell sessions as a function ##

## Single-User: ##

The rvm function will be automatically configured for every user on the system if you install as single user. Read the output of installer to check which files were modified.


## Multi-User: ##

The rvm function will be automatically configured for every user on the system if you install with sudo. This is accomplished by loading `/etc/profile.d/rvm.sh` on login. Most Linux distributions default to parsing /etc/profile which contains the logic to load all files residing in the `/etc/profile.d/` directory. Once you have added the users you want to be able to use RVM to the rvm group, those users MUST log out and back in to gain rvm group membership because group memberships are only evaluated by the operating system at initial login time. **Zsh not always sources** `/etc/profile` **so you might need to add this in** `/etc/**/zprofile`:

```sh
source /etc/profile
```
## Mixed mode (user gemsets): ##

  * After following above instructions for Multi-User.
  * Select a user as a manager - he will be responsible for installing new rubies. This user should never run the command introduced below. If this happens, remove/rename the **${HOME}/.rvmrc**, logout and then relogin. Otherwise you won't be able to install/upgrade new rubies correctly.
  * For each user that want to use RVM, an additional command needs to be run (once) for each user:
  
  ```sh
    rvm user gemsets
  ```

Gemsets created by these users will be hosted in their HOME directory. It's not possible to use global gemsets from system without using tricks like manually linking directories and they should not be used in mixed-mode. Please bear in mind that 'system' in this context does not refer to your distribution's ruby packages, but to the RVM Multi-User installation.

You have two possibilities to manage RVM. The first one is to add managers to the rvm group. The second one is to use separate managers with rvmsudo and privilege escalation. Note that it is not safe to use `rvmsudo from` mixed mode user. Both can be mixed without any side-effect. It is however very important to not enable mixed-mode gemsets or rubies for the managers. RVM is using a custom `umask` (`umask u=rwx,g=rwx,o=rx`) when installing gemsets, rubies, updating itself, etc. This should not impact your system. But if you prefer to avoid RVM messing around with your umask, you can comment the umask line in `/etc/rvmrc`.

This mode should also works with passenger, please follow [passenger](https://rvm.io/integration/passenger) instructions.

## 3. Reload shell configuration & test ##

Close out your current shell or terminal session and open a new one (preferred). You may load RVM with the following command:

```sh
$ source ~/.rvm/scripts/rvm
```

If installation and configuration were successful, RVM should now load whenever you open a new shell. This can be tested by executing the following command which should output `rvm is a function` as shown below.

```sh
$ type rvm | head -n 1
rvm is a function
```

**NOTE:** Before reporting problems check `rvm notes` as it might contain important information.

## Congratulations! You have successfully installed RVM. ##

Try out your new RVM installation
---------------------------------

Below are some examples of how to install and use a Ruby under RVM.

Display a list of all `known` rubies. NOTE: RVM can install many more Rubies not listed

```sh
$ rvm list known

# MRI Rubies
[ruby-]1.8.6[-p420]
[ruby-]1.8.7[-head] # security released on head
[ruby-]1.9.1[-p431]
[ruby-]1.9.2[-p330]
[ruby-]1.9.3[-p551]
[ruby-]2.0.0[-p648]
[ruby-]2.1[.10]
[ruby-]2.2[.7]
[ruby-]2.3[.4]
[ruby-]2.4[.1]
ruby-head

# for forks use: rvm install ruby-head-<name> --url https://github.com/github/ruby.git --branch 2.2

# JRuby
jruby-1.6[.8]
jruby-1.7[.27]
jruby[-9.1.13.0]
jruby-head

# Rubinius
rbx-1[.4.3]
rbx-2.3[.0]
rbx-2.4[.1]
rbx-2[.5.8]
rbx-3[.84]
rbx-head

# Opal
opal

# Minimalistic ruby implementation - ISO 30170:2012
mruby-1.0.0
mruby-1.1.0
mruby-1.2.0
mruby-1[.3.0]
mruby[-head]

# Ruby Enterprise Edition
ree-1.8.6
ree[-1.8.7][-2012.02]

# Topaz
topaz

# MagLev
maglev[-head]
maglev-1.0.0

# Mac OS X Snow Leopard Or Newer
macruby-0.10
macruby-0.11
macruby[-0.12]
macruby-nightly
macruby-head

# IronRuby
ironruby[-1.1.3]
ironruby-head

```
```sh
$ rvm install 2.4.1

Checking requirements for opensuse.
Requirements installation successful.
Installing Ruby from source to: /home/user/.rvm/rubies/ruby-2.4.1, this may take a while depending on your cpu(s)...
...
Install of ruby-2.4.1 - #complete
Using /home/user/.rvm/gems/ruby-2.4.1
```
Use the newly installed Ruby:
```sh
$ rvm use 2.4.1

Using /home/user/.rvm/gems/ruby-2.4.1
```
Check this worked correctly:

```sh
$ ruby -v

ruby 2.4.1p11 (2017-03-22 revision 58053) [x86_64-linux]

$ which ruby

/home/user/.rvm/rubies/ruby-2.4.1/bin/ruby
```

Optionally, you can set a version of Ruby to use as the default for new shells. Note that this overrides the 'system' ruby:

```sh
$ rvm use 2.4.1 --default
```

Enjoy using RVM!
----------------

## Where to now? ##

If you are new to RVM I recommend that you read the [basics page](https://rvm.io/rvm/basics). At the end of the basics page there are further links for getting started.

Troubleshooting Your Install
----------------------------

* When you run

```sh
$ curl -sSL https://get.rvm.io | bash -s stable
```

and got the notice

```sh
    curl: (60) SSL certificate problem: unable to get local issuer certificate
    More details here: http://curl.haxx.se/docs/sslcerts.html
```

`ca-certificates` need to be installed:

```sh
$  apt-get install ca-certificates 
```

* If you open a new shell and running:
```sh
$ type rvm | head -1
```

does not show `rvm is a function`, RVM isn't being sourced correctly.

* Ensure that RVM is sourced after any path settings as RVM manipulates the path. If you don't do this, RVM may not work as expected.

* If you are using GNOME on Red Hat, CentOS or Fedora, ensure that the Run command as login shell option is checked under the Title and Command tab in Profile Preferences. After changing this setting, you may need to exit your console session and start a new one before the changes take affect.

Gemsets
=======

Basics
------
## Named Gem Sets ##

 RVM gives you compartmentalized independent ruby setups. This means that ruby, gems and irb are all separate and self-contained - from the system, and from each other.

 You may even have separate named gemsets.

 Let's say, for example, that you are testing two versions of a gem, with ruby 2.1.1. You can install one to the default 2.1.1, then create a named gemset for the other version, and switch between them easily. 

## Example: testing gems ##

```sh
$ rvm 2.4.1@testing
```

will use a '2.4.1@testing' GEM_HOME (be sure to create it first), whereas: 

```sh
$ rvm 2.4.1
```
will use the default 2.4.1 GEM_HOME 

## Example: Rails versions & upgrading apps  ##

To illustrate the point, let's talk about a common use case. Assume you are testing out a rails application against a new Rails release. RVM makes such testing very easy, by letting you quickly switch between multiple Rails versions. First, let's set up the environments: 

```sh
$ rvm gemset create rails520
Gemset 'rails520' created.

$ rvm gemset list
=> (default)
  global
  rails520

$ rvm 2.4.1@rails520
$ gem install rails -v 5.2.0
```
Note that, for each of the ruby installs above, you can have completely separate versions!

Now that your environments are set up, you can simply switch between Rails versions and Ruby versions as follows.

```sh
$ rvm 2.4.1@rails520 ; rails --version

Rails 5.2.0

$ rvm gemset list
   (default)
   global
=> rails520
```
## Warning!!! ##

* If you use the bash or zsh terminal. If you open a new terminal tab. Please execute the following command:
```sh
$ /bin/bash --login (Bash Terminal Mode)

or

$ /bin/zsh --login (Zsh Terminal Mode)
```
So you load the new section of the selected gemset.

* If you are deploying to a server, or you do not want to wait around for rdoc and ri to install for each gem, you can disable them for gem installs and updates. Just add the following line to your ~/.gemrc or /etc/gemrc: 

```sh
gem: --no-rdoc --no-ri
```
## Warning!!! ##

* RVM gives you a separate gem directory for each and every Ruby version and gemset. * This means that gems must be explicitly installed for each revision and gemset. RVM helps you manage this process; see the [RVM set documentation](https://rvm.io/set) page. 

NOTE: A little bit about where the default and global gemsets differ. If you don't use a gemset at all, you get the gems in the 'default' set. If you use a specific gemset (say @testing), it will inherit gems from that ruby's @global. The 'global' gemset is to allow you to share gems to all your gemsets. The word 'default' quite literally says it all, eg. the gemset used without selecting one for a specific installed ruby. 

